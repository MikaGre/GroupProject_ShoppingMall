import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.Scanner;

public class CreateAccount {
private static int userID = 0;
    //Scanner scanner = new Scanner(System.in);

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
        XSSFCell userID = row.createCell(0);
        userID.setCellValue("UserID");
        XSSFCell accountType = row.createCell(1);
        accountType.setCellValue("AccountType");
        XSSFCell fullName = row.createCell(2);
        fullName.setCellValue("Full Name");
        XSSFCell password = row.createCell(3);
        password.setCellValue("Password");
        save();
    }

    public void addAccount (String accountType, String fullName, String password) {
        int newRowIndex = sheet.getPhysicalNumberOfRows();
        XSSFRow newRow = sheet.createRow(newRowIndex);

        XSSFCell userIDCell = newRow.createCell(0);
        userIDCell.setCellValue(userID++);
        XSSFCell accountTypeCell = newRow.createCell(1);
        accountTypeCell.setCellValue(accountType);
        XSSFCell fullNameCell = newRow.createCell(2);
        fullNameCell.setCellValue(fullName);
        XSSFCell passwordCell = newRow.createCell(3);
        passwordCell.setCellValue(password);
        save();
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
