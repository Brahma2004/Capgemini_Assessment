package Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

    public static String getData(int row,int column) throws IOException {
        FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData1.xlsx");
        XSSFWorkbook workbook=new XSSFWorkbook(fis);
        Sheet sheet=workbook.getSheet("TestData");
        Row currentRow=sheet.getRow(row);
        DataFormatter formatter=new DataFormatter();
        String data=formatter.formatCellValue(currentRow.getCell(column));
        workbook.close();
        fis.close();
        return data;
    }
}