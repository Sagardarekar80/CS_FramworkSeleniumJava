package com.mystore.utilities;

import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.*;


public class ReadExcelFile 
{

	public static FileInputStream inputStream;
	public static XSSFWorkbook workBook;
	public static XSSFSheet excelSheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	public static String getCellValue(String fileName, String sheetName, int rowNo, int cellNo)
	{
		try
		{
			inputStream = new FileInputStream(fileName);
			workBook = new XSSFWorkbook(inputStream);
			excelSheet = workBook.getSheet(sheetName);
			cell = workBook.getSheet(sheetName).getRow(rowNo).getCell(cellNo);
			
			workBook.close();
		}
		catch (Exception e)
		{
			return "";
		}
	}
	
	public static int getRowCount (String fileName, String sheetName)
	{
		try
		{
			inputStream = new FileInputStream(fileName);
			//create XSSFWorkBook Class object for excel file manipulation

			workBook = new XSSFWorkbook(inputStream);
			excelSheet = new workBook.getSheet(sheetName);

			//get total no of rows
			int ttlRows = excelSheet.getLastRowNum();

			workBook.close();

			return ttlRows;
		}

			catch(Exception e)
			{
				return 0;
			}
		
	}
}
/*
 import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.*;

 
 
 public static void main(String[] args) 
 
{
	XSSFWorkbook ExcelWBook = null;
	XSSFSheet ExcelWSheet;
	//XSSFRow Row;
	//XSSFCell Cell;

	// create an object of file class to open file
	File excelFile = new File("c:\\TestDataFile.xlsx");
	FileInputStream inputStream = null;
	//Create an object of FileInputStream to read data from file
	try {
		 inputStream =  new FileInputStream(excelFile);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	//Excel->Workbook-->Row-->Cell
	//Create object of XSSFworkbook to handle xlsx file 
	try {
		ExcelWBook = new XSSFWorkbook(inputStream);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	//To access workbook sheet
	ExcelWSheet = ExcelWBook.getSheetAt(0);
	
	//get total row count
	int ttlRows = ExcelWSheet.getLastRowNum() + 1;
	
	//get total no of cells in a row 
	int ttlCells = ExcelWSheet.getRow(0).getLastCellNum() + 1;
	
	for(int currentRow = 0; currentRow<ttlRows ; currentRow++)
	{
		for(int currentCell = 0; currentCell<ttlCells; currentCell++)
		{
			System.out.print(ExcelWSheet.getRow(currentRow).getCell(currentCell).toString());
			System.out.print("\t");			
		}
		System.out.println();
	}
	try {
		ExcelWBook.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}*/