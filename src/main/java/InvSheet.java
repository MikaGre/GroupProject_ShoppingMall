import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.*;

public class InvSheet {

    //Scanner scanner = new Scanner(System.in);
    Inventory accID;
    private XSSFSheet sheet;
    private final String filename = "Item Information.xlsx";


    public InvSheet () {

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
        XSSFCell storeID = row.createCell(0);
        storeID.setCellValue("StoreID");
        XSSFCell storeName = row.createCell(1);
        storeName.setCellValue("StoreName");
        XSSFCell productID = row.createCell(2);
        productID.setCellValue("ProductID");
        XSSFCell productName = row.createCell(3);
        productName.setCellValue("ProductName");
        XSSFCell productPrice = row.createCell(4);
        productPrice.setCellValue("ProductPrice");
        XSSFCell productQTY = row.createCell(5);
        productQTY.setCellValue("ProductQTY");
        save();
    }

    public void addItem (int storeID, String storeName,int productID, String productName, double price, int qty) {
        int newRowIndex = sheet.getPhysicalNumberOfRows();
        XSSFRow newRow = sheet.createRow(newRowIndex);

        String storeid = Integer.toString(StoreOwner.storeID);
        String product = Integer.toString(productID);
        String pPrice = Double.toString(price);
        String pQTY = Integer.toString(qty);

        XSSFCell storeIDCell = newRow.createCell(0);
        storeIDCell.setCellValue(storeid);
        XSSFCell storeNameCell = newRow.createCell(1);
        storeNameCell.setCellValue(storeName);
        XSSFCell productIDCell = newRow.createCell(2);
        productIDCell.setCellValue(product);
        XSSFCell productNameCell = newRow.createCell(3);
        productNameCell.setCellValue(productName);
        XSSFCell productPriceCell = newRow.createCell(4);
        productPriceCell.setCellValue(pPrice);
        XSSFCell qtyCell = newRow.createCell(5);
        qtyCell.setCellValue(pQTY);
        save();

    }

    public boolean verfiyItem (String name) {
        List<String> itemInfo = new ArrayList<>();
        String itemName = null;
        String iprice = null;
        boolean found = false;
        try {
            FileInputStream file = new FileInputStream(filename);
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheet("Items");
            Sheet itemSheet = workbook.getSheetAt(0);

            int rowCount = itemSheet.getLastRowNum() - itemSheet.getFirstRowNum();

            for (int i = 1; i < rowCount + 1; i++) {
                Row row = itemSheet.getRow(i);
                for (int j = 1; j < row.getLastCellNum(); j++) {
                    itemInfo.add(row.getCell(j).getStringCellValue());
                    itemName = row.getCell(j).getStringCellValue();
                }
            }
            if (itemInfo.contains(name)) {
                System.out.println("Item found");
                found = true;
            } else {
                System.out.println("Incorrect login");
                Menu menu = new Menu();
                menu.mainMenu();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return found;
    }

    public void itemList () {
        Map<Integer,String[]>storeInfo = new HashMap<>();
        try {
            FileInputStream file = new FileInputStream(filename);
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheet("stores");
            Sheet usersSheet = workbook.getSheetAt(0);

            int rowCount = usersSheet.getLastRowNum() - usersSheet.getFirstRowNum();

            for (int i = 1; i < rowCount + 1; i++) {
                Row row = usersSheet.getRow(i);
                for (int j = 1; j < row.getLastCellNum(); j++) {
                    storeInfo.put(row.getRowNum(),new String[]{row.getCell(3).getStringCellValue(),"$"+row.getCell(4).getStringCellValue()});
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }

        storeInfo.forEach((k,v) -> System.out.println(k + " ==> " + Arrays.toString(v)));
    }

    public void enterStore(String store) {
        Map<Integer,String[]> storeInv = new HashMap<>();
        String sNAME = null;

        try {
            FileInputStream file = new FileInputStream(filename);
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheet("Items");
            Sheet itemSheet = workbook.getSheetAt(0);

            int rowCount = itemSheet.getLastRowNum() - itemSheet.getFirstRowNum();

            for (int i = 1; i < rowCount + 1; i++) {
                Row row = itemSheet.getRow(i);
                for (int j = 1; j < row.getLastCellNum(); j++) {
                     if (row.getCell(j).getStringCellValue().equalsIgnoreCase(store)){
                         storeInv.put(row.getRowNum(),new String[]{row.getCell(3).getStringCellValue(),"$"+row.getCell(4).getStringCellValue()});
                     }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        storeInv.forEach((k,v) -> System.out.println(Arrays.toString(v)));
    }

    public void getStoreListInv () {
        List<Object> objectList = new ArrayList<>();
        try {
            FileInputStream file = new FileInputStream(filename);
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheet("Items");
            Sheet itemSheet = workbook.getSheetAt(0);

            int rowCount = itemSheet.getLastRowNum() - itemSheet.getFirstRowNum();
            System.out.println("| StoreName        || ProductID        || ProductName      || ProductPrice     || ProductQTY       |");
            System.out.println("----------------------------------------------------------------------------------------------------");
            for (int i = 1; i < rowCount + 1; i++) {
                Row row = itemSheet.getRow(i);
                for (int j = 1; j < row.getLastCellNum(); j++) {
               // objectList.add(row.getCell(j).getStringCellValue());
                    //Print Excel data in console
                    //System.out.print(row.getCell(j).getStringCellValue()+"|| ");
                    System.out.printf("| %-15s  |",row.getCell(j).getStringCellValue());
                }
                //System.out.print(objectList);
                System.out.println();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void setQty(int rowNum,String qty) throws IOException {
        final String filename = "Item Information.xlsx";
        FileInputStream file = new FileInputStream(filename);
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheet("Items");
        Sheet itemSheet = workbook.getSheetAt(0);

        Cell cell2Update = sheet.getRow(rowNum).getCell(5);
        cell2Update.setCellValue(qty);

        FileOutputStream outStream = new FileOutputStream(filename);
        sheet.getWorkbook().write(outStream);
        outStream.close();
        sheet = new XSSFWorkbook(new FileInputStream(new File(filename))).getSheetAt(0);
        try {
            workbook = new XSSFWorkbook(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void save () {
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


