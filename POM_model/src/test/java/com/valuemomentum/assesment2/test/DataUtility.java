package com.valuemomentum.assesment2.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class DataUtility {
	   private static XSSFWorkbook ExcelWBook;
	    private static XSSFSheet ExcelWSheet;
	    private static XSSFCell Cell;
	    private static XSSFRow Row;

	 

	    @Test
	    public static String readData() throws Exception {
	       // setExcelFile();
	       // getTestData();
	    	String TestFile = "C:\\Training\\Java\\TestAutomation\\data\\demo.txt";
			FileReader FR = new FileReader(TestFile);
			BufferedReader BR = new BufferedReader(FR);
			String Content = "";

			//Loop to read all lines one by one from file and print It.
			while((Content = BR.readLine())!= null){
				System.out.println(Content);
			
				 return Content;
			}
			return " ";
	        
	       // System.out.println(getCellData(0, 1));
	       
	    }
	    
	    
	    public static Object[][] getTestData() throws Exception {
	    	String[][] arrayValue=null;
	    	try {
	            // Step 1 - Accessing file
	            FileInputStream ExcelFile = new FileInputStream(
	                    "C:\\Training\\Java\\TestAutomation\\data\\Amazon.xlsx");
	            ExcelWBook = new XSSFWorkbook(ExcelFile);
	            ExcelWSheet = ExcelWBook.getSheet("Amazon");
	           int startRow = 0;
	           int startCol = 0;
	           int totalRow = ExcelWSheet.getLastRowNum();
	           int totalcols = 1;
	           
	           arrayValue = new String [totalRow][totalcols];
	           for(int i= startRow; i<totalRow;i++) {
	        	   arrayValue[i][0]= getCellData(i,0);
	        	   System.out.println("Array value"+ arrayValue[i][0]);
	           }
	           return arrayValue;
	        } catch (Exception e) {
	            throw (e);
	        }
	    	
	    }
	    
	    public static void setExcelFile() throws Exception {
	        try {
	            // Step 1 - Accessing file
	            FileInputStream ExcelFile = new FileInputStream(
	                    "C:\\Training\\Java\\TestAutomation\\data\\Amazon.xlsx");
	            ExcelWBook = new XSSFWorkbook(ExcelFile);
	            ExcelWSheet = ExcelWBook.getSheet("Amazon");
	            System.out.println("====" + ExcelWSheet);
	        } catch (Exception e) {
	            throw (e);
	        }
	    }

	 

	    public static String getCellData(int RowNum, int ColNum) throws Exception {
	        try {
	            Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
	            String CellData = Cell.getStringCellValue();
	            return CellData;
	        } catch (Exception e) {
	            return "";
	        }
	    }

	 

	    public static void setCellData(String Result, int RowNum, int ColNum) throws Exception {
	        try {
	            Row = ExcelWSheet.getRow(RowNum);
	            Cell = Row.getCell(ColNum);
	            if (Cell == null) {
	                Cell = Row.createCell(ColNum);
	                Cell.setCellValue(Result);
	            } else {
	                Cell.setCellValue(Result);
	            }
	            FileOutputStream fileOut = new FileOutputStream(
	                    "C:\\Training\\Java\\TestAutomation\\data\\Amazon.xlsx");
	            ExcelWBook.write(fileOut);
	            fileOut.flush();
	            fileOut.close();
	        } catch (Exception e) {
	            throw (e);
	        }

	 

	    }

}