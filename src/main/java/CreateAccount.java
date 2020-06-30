
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.*;

public class CreateAccount {
    Scanner scanner = new Scanner(System.in);
    Inventory accID;
    private XSSFSheet sheet;
    private final String filename = "Store Information.xlsx";


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
                System.out.println("***Welcome to " + storeName + "***");
                InvSheet i = new InvSheet();
                i.enterStore(storeName);

            } else {
                System.out.println("Store not Found");
                Menu menu = new Menu();
                menu.mainMenu();
            }
            save();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void storeList () {
        try {
            FileInputStream file = new FileInputStream(filename);
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheet("stores");
            Sheet usersSheet = workbook.getSheetAt(0);

            int rowCount = usersSheet.getLastRowNum() - usersSheet.getFirstRowNum();
            System.out.println("|    Row Number   ||    Store Owner   ||    Store Name    |");
            System.out.println("------------------------------------------------------------");

            for (int i = 1; i < rowCount + 1; i++) {
                Row row = usersSheet.getRow(i);
                System.out.printf("| %-15s  |",row.getRowNum());
                for (int j = 1; j < row.getLastCellNum(); j++) {
                    System.out.printf("| %-15s  |", row.getCell(j).getStringCellValue());
                }
                System.out.println();
            }

            save();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void removeStore(int rowIndex) {
        storeList();
        int lastRowNum=sheet.getLastRowNum();
        if(rowIndex>=0&&rowIndex<lastRowNum){
            sheet.shiftRows(rowIndex+1,lastRowNum, -1);
        }
        if(rowIndex==lastRowNum){
            XSSFRow removingRow=sheet.getRow(rowIndex);
            if(removingRow!=null){
                sheet.removeRow(removingRow);
            }
        }
        save();
    }

    private void save () {
        try {
            FileOutputStream outStream = new FileOutputStream(filename);
            FileInputStream file = new FileInputStream(filename);
            sheet.getWorkbook().write(outStream);
            outStream.close();
            file.close();
            sheet = new XSSFWorkbook(new FileInputStream(new File(filename))).getSheetAt(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}