
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CreateAccount extends Inventory{
    //Scanner scanner = new Scanner(System.in);
    Inventory accID;
    private  XSSFSheet sheet;
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

    private void createSpreadsheet() {
        XSSFWorkbook workbook = new XSSFWorkbook();
        sheet = workbook.createSheet();
        XSSFRow row = sheet.createRow(0);
        XSSFCell accountType = row.createCell(0);
        accountType.setCellValue("AccountType");
        XSSFCell fullName = row.createCell(1);
        fullName.setCellValue("UserID");
        XSSFCell password = row.createCell(2);
        password.setCellValue("Password");
        save();
    }

    public void addAccount (String accountType, String fullName, String password) {
        int newRowIndex = sheet.getPhysicalNumberOfRows();
        XSSFRow newRow = sheet.createRow(newRowIndex);

        XSSFCell accountTypeCell = newRow.createCell(0);
        accountTypeCell.setCellValue(accountType);
        XSSFCell fullNameCell = newRow.createCell(1);
        fullNameCell.setCellValue(fullName);
        XSSFCell passwordCell = newRow.createCell(2);
        passwordCell.setCellValue(password);
        save();

        accID = new Inventory();
    }

    public boolean verfiyAccount (String name, String password) {
        String tempUserName  = "";
        String tempPassword = "";
        List<String> userInfo = new ArrayList<>();
        boolean found = false;
        try {
            FileInputStream file = new FileInputStream(filename);
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheet("users");
            Sheet usersSheet = workbook.getSheetAt(0);

            int rowCount = usersSheet.getLastRowNum()-usersSheet.getFirstRowNum();

            for (int i = 1; i < rowCount+1; i++) {
                Row row = usersSheet.getRow(i);
                for (int j = 1 ; j < row.getLastCellNum(); j++) {
                    userInfo.add(row.getCell(j).getStringCellValue());
                }
            }
            if (userInfo.contains(name) && userInfo.contains(password)) {
                System.out.println("Welcome " + name);
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