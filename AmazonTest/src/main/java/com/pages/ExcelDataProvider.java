package com.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {

	//for MS Excel
	//XSSFWorkbook xb;
	//for opensource
	HSSFWorkbook hb;
	
	public ExcelDataProvider() {
		File file = new File(".\\src\\main\\resources\\dataFiles\\Test Data.xls");
		try {
			FileInputStream fis  = new FileInputStream(file);
		//	xb = new XSSFWorkbook(fis);
			hb = new HSSFWorkbook(fis);
		} catch (Exception e) {
			System.out.println("Unable to read excel file: " + e.getMessage());
		}
	}
	
	public String getUserID(int row, int col) {
		return hb.getSheet("Credentials").getRow(row).getCell(col).getStringCellValue();
	}
	
	public String getPassword(int row, int col) {
		return hb.getSheet("Credentials").getRow(row).getCell(col).getStringCellValue();
	}
}
