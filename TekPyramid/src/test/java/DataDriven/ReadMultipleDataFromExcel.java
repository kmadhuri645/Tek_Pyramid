package DataDriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMultipleDataFromExcel {

	public static void main(String[] args) throws IOException {
		// step-1 get the Excel path location and java object of the physical excelFile
		FileInputStream fis = new FileInputStream("D:\\AutomationPrograms\\TekPyramid\\testData.xlsx");

		// step-2 open workbook in read mode

		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet1");

		int rowCount = sh.getLastRowNum();

		for (int i = 1;i<=rowCount; i++) {

			Row row = sh.getRow(i);

			String column1Data = row.getCell(0).toString();
			String column2Data = row.getCell(1).toString();

//			System.out.println(column1Data);
//			System.out.println(column2Data);

			System.out.println(column1Data +" : "+ column2Data);

		}

		wb.close();

	}

}
