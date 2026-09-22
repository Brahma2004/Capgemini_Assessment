package Utilities_1;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility_1 {

    public static String getExcelData(String sheetName, int rowNum, int cellNum)
            throws IOException {

        FileInputStream fis =new FileInputStream("./src/main/resources/ORANGE_2.xlsx");

        Workbook workbook = WorkbookFactory.create(fis);

        String data = workbook.getSheet(sheetName).getRow(rowNum).getCell(cellNum).toString();

        return data;
    }
}