package com.utility;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;

public class ReadExcelData {

    public static String getParticularData(int rowValue,int colValue) {
        String data = "";
        try {
            File file = new File("C:\\Users\\Welcome\\Downloads\\New folder\\DataDriven_IPT.xlsx");
            Workbook book = new XSSFWorkbook(file);
            Sheet sheet = book.getSheet("sheet1");
            Row row = sheet.getRow(rowValue);
            Cell cell = row.getCell(colValue);
            //String data = cell.getStringCellValue();
            // System.out.println(data);
            //DataFormatter ---> It will convert cell datatype into string
            DataFormatter dataformat = new DataFormatter();
            data = dataformat.formatCellValue(cell);
            System.out.println(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
        public static void getAllData() {
            try {
                File file = new File("C:\\Users\\Welcome\\Downloads\\New folder\\DataDriven_IPT.xlsx");
                Workbook book = new XSSFWorkbook(file);
                Sheet sheet = book.getSheet("Sheet1");

                int lastRowNum = sheet.getLastRowNum();
                System.out.println("No of rows: " + lastRowNum);

                Short lastCellNum = sheet.getRow(0).getLastCellNum();
                System.out.println("No of columns: " + lastCellNum);

                for (int row = 0; row <=lastRowNum; row++) { // row iteration

                    Row rows = sheet.getRow(row);

                    for (int clmn = 0; clmn <=lastCellNum; clmn++) {//column iteration
                        Cell cell = rows.getCell(clmn);
                        DataFormatter dataFormat = new DataFormatter();
                        String data = dataFormat.formatCellValue(cell);
                        System.out.println(data);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    public static void main(String[] args){
        getAllData();
    }
}
