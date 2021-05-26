package com.worksjoy.qa.util;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestUtil {

    public static long PAGE_LOAD_TIMEOUT = 20;
    public static long IMPLICITLY_WAIT = 10;


    public static String TEST_DATAFILE_PATH = "C:/Users/Admin.DESKTOP-6CD7RG7/IdeaProjects/WorksjoyProjectAutomationTest/src/main/java/com/worksjoy/qa/testdata/logindata1.xlsx";
    static Workbook book;
    static Sheet sheet;

    public static Object[][] getExcelData(String sheetName){

        FileInputStream file = null;
        try {
            file = new FileInputStream(TEST_DATAFILE_PATH);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }try {
            book = WorkbookFactory.create(file);
        }catch (IOException e){
            e.printStackTrace();
        }
        sheet = book.getSheet(sheetName);

        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
        for (int i=0;i<sheet.getLastRowNum();i++){
            for (int k=0;k<sheet.getRow(0).getLastCellNum();k++){
                data[i][k] = sheet.getRow(i+1).getCell(k).toString();
            }
        }
        return data;
    }
}
