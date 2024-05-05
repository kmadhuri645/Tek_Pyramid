package DataDriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.zip.DataFormatException;

import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Check {
	public static void main(String[] args) throws IOException {
		File f = new File("D:\\AutomationPrograms\\TekPyramid\\testData.xlsx");

		FileInputStream fis = new FileInputStream(f);

		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet s = wb.getSheet("Sheet2");
		for (int i = 0; i <= s.getLastRowNum(); i++) {

			DataFormatter formate = new DataFormatter();

			XSSFRow r = s.getRow(i);
			XSSFCell c = r.getCell(1);
			String s2 = formate.formatCellValue(c);
			System.out.println(s2);
		}

	}
}
