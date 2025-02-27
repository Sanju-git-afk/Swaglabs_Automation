package utilities;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

public class ExcelUtil {

    private  static final  String FILE_PATH ="/home/niveus/Desktop/SanjanaProjects/SwagLabs/Testdata/Testdataswaglabs.xlsx";
    public static Object[][] getTestData(String sheetName)
    {

        Object[][] data = null;

        try (FileInputStream file = new FileInputStream(new File(FILE_PATH));
             Workbook workbook = new XSSFWorkbook(file)) {

            Sheet sheet = workbook.getSheet(sheetName);
            int rowCount = sheet.getPhysicalNumberOfRows();
            int colCount = sheet.getRow(0).getLastCellNum();
            data = new Object[rowCount - 1][colCount];

            for (int i = 1; i < rowCount; i++) { // Start from row 1 (ignore header)
                Row row = sheet.getRow(i);

                for (int j = 0; j < colCount; j++) {
                    Cell cell = row.getCell(j);
                    data[i - 1][j] = row.getCell(j).toString() ;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }
}
