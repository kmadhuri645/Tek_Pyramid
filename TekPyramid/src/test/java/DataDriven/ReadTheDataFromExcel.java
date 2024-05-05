package DataDriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadTheDataFromExcel {

	public static void main(String[] args) throws IOException {
		
		//step-1 get the Excel path location and java object of the physical excelFile
		FileInputStream fis=new FileInputStream("D:\\AutomationPrograms\\TekPyramid\\testData.xlsx");
		
		//step-2 open workbook in read mode
		
		Workbook wb = WorkbookFactory.create(fis);
		
		//step-3 get the control of the "org" sheet
		Sheet sh = wb.getSheet("Sheet1");//name of the sheet
		
		//step-4 get the control of the first row
		Row row = sh.getRow(0);
		
		//step-5: get the control of the "2nd" cell and read the String data
		Cell cel = row.getCell(0);
		String data=cel.getStringCellValue();
		System.out.println(data);
		
		//step-6 close the workbook
		//wb.close();
		
	}

}
