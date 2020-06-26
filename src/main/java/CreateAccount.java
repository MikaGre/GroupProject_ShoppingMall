
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.*;

public class CreateAccount {
    //Scanner scanner = new Scanner(System.in);
    Inventory accID;
    private XSSFSheet sheet;
    private final String filename = "Account Information.xlsx";


    public CreateAccount () {
        try {
            FileInputStream file = new FileInputStream(new File(filename));
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            sheet = workbook.getSheetAt(0);
        } catch (FileNotFoundException e) {
            createSpreadsheet(); //file didn't exist yet
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void createSpreadsheet () {
        XSSFWorkbook workbook = new XSSFWorkbook();
        sheet = workbook.createSheet();
        XSSFRow row = sheet.createRow(0);
        XSSFCell accountType = row.createCell(0);
        accountType.setCellValue("AccountType");
        XSSFCell fullName = row.createCell(1);
        fullName.setCellValue("StoreOwnerName");
        XSSFCell storeName = row.createCell(2);
        storeName.setCellValue("StoreName");
        save();
    }

    public void addAccount (String accountType, String fullName, String storeName) {
        int newRowIndex = sheet.getPhysicalNumberOfRows();
        XSSFRow newRow = sheet.createRow(newRowIndex);

        XSSFCell accountTypeCell = newRow.createCell(0);
        accountTypeCell.setCellValue(accountType);
        XSSFCell fullNameCell = newRow.createCell(1);
        fullNameCell.setCellValue(fullName);
        XSSFCell storeNameCell = newRow.createCell(2);
        storeNameCell.setCellValue(storeName);
        save();

        accID = new Inventory();
    }

    public void verfiyStore (String storeName) {
        boolean isAStore = false;
        String tempStore = "";
        List<String> storeInfo = new ArrayList<>();
        try {
            FileInputStream file = new FileInputStream(filename);
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheet("stores");
            Sheet usersSheet = workbook.getSheetAt(0);

            int rowCount = usersSheet.getLastRowNum() - usersSheet.getFirstRowNum();

            for (int i = 1; i < rowCount + 1; i++) {
                Row row = usersSheet.getRow(i);
                for (int j = 1; j < row.getLastCellNum(); j++) {
                    storeInfo.add(row.getCell(j).getStringCellValue());
                }
            }
            if (storeInfo.contains(storeName)) {
                System.out.println("***Welcome***");
                isAStore = true;
            } else {
                System.out.println("Store not Found");
                Menu menu = new Menu();
                menu.mainMenu();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (isAStore = true) {
            Scanner s = new Scanner(System.in);
            InvSheet i = new InvSheet();
            System.out.println("****Items in stock*****");
            i.itemList();
            System.out.println("Select an item from list");
            String customerPick = s.next();
            i.verfiyItem(customerPick);
            System.out.println("***Item added to cart***");
        }
    }

    public void storeList () {
        Map<String,String> listOfStores = new HashMap<>();
        //List<String> storeInfo = new ArrayList<>();
        String name = null;
        String store = null;

        try {
            FileInputStream file = new FileInputStream(filename);
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheet("stores");
            Sheet usersSheet = workbook.getSheetAt(0);

            int rowCount = usersSheet.getLastRowNum() - usersSheet.getFirstRowNum();

            for (int i = 1; i < rowCount + 1; i++) {
                Row row = usersSheet.getRow(i);
                for (int j = 1; j < row.getLastCellNum(); j++) {
                    listOfStores.put(row.getCell(1).getStringCellValue(),row.getCell(2).getStringCellValue());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        listOfStores.forEach((k,v) -> System.out.println("\nStore Owner:" + k + " ==> Store Name:" + v));
    }

    private void save() {
        try {
            FileOutputStream outStream = new FileOutputStream(filename);
            sheet.getWorkbook().write(outStream);
            outStream.close();
            sheet = new XSSFWorkbook(new FileInputStream(new File(filename))).getSheetAt(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}