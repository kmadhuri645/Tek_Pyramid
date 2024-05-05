package DataDriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataBasedOnCondition {

	public static void main(String[] args) throws IOException {

		/*
		 * first read first row data and compaire it by using loop than if data is there
		 * than fatch the data
		 */
		// String data="";

		String expectedTestId = "TC_01";
		String data1 = "";
		String data2 = "";
		String data3 = "";
		boolean flag = false;

		FileInputStream fis = new FileInputStream("D:\\AutomationPrograms\\TekPyramid\\testData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("org");

		int rowCount = sh.getLastRowNum();

		/*
		 * in b/w row gap in thire thats why we getting error to aviod error we are
		 * using try and catch block if data is out side the forloop it will exceute
		 * multiple time
		 */

		for (int i = 0; i <= rowCount; i++) {

			String data = "";

			try {
				data = sh.getRow(i).getCell(0).toString();// method chaining

				if (data.equals(expectedTestId)) {
					flag = true;
					data1 = sh.getRow(i).getCell(1).toString();
					data2 = sh.getRow(i).getCell(2).toString();
					data3 = sh.getRow(i).getCell(3).toString();
				}
			} catch (Exception e) {
			}

		}
		if (flag == true) {
			System.out.println(data1);
			System.out.println(data2);
			System.out.println(data3);
		} else {
			System.out.println(expectedTestId + "data is not available");
		}

		wb.close();

	}

}
