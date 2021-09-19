package utilities;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

public class ExcelDataProvider {

    XSSFWorkbook wb;

    public ExcelDataProvider() {

        File scr = new File("./TestData/data.xlsx");

        try {

            FileInputStream fis = new FileInputStream(scr);

            wb = new XSSFWorkbook(fis);

        } catch (Exception e) {

            e.printStackTrace();

            System.out.println("Unable to read Excel file " + e.getMessage());

        }


    }

    public String getStringData(int sheetIndex, int row, int column) {

        return wb.getSheetAt(sheetIndex).getRow(row).getCell(column).getStringCellValue();

    }

    public String getStringData(String sheetName, int row, int column) {

        return wb.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();

    }

    public double getNumericData(String sheetName, int row, int column) {

        return wb.getSheet("sheetName").getRow(row).getCell(column).getNumericCellValue();

    }









}
