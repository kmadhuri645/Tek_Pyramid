package DataDriven;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadTheDataBackToExcelTest {

	public static void main(String[] args) throws  IOException {
		FileInputStream fis = new FileInputStream("D:\\AutomationPrograms\\TekPyramid\\testData.xlsx");//readmode
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("org");
		Row row = sh.getRow(1);
		Cell cel = row.createCell(4);
		cel.setCellType(CellType.STRING);//Which type of data we are storing (depericated)
		cel.setCellValue("PASS");//write the data
		
		FileOutputStream fos = new FileOutputStream("D:\\AutomationPrograms\\TekPyramid\\testData.xlsx");//write mode
		wb.write(fos);//save the data
		wb.close();
		System.out.println("excuted");


	}

}
