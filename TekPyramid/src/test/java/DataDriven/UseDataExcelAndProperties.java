package DataDriven;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UseDataExcelAndProperties {

	public static void main(String[] args) throws Throwable {

		//read common data from properties file
		FileInputStream fis = new FileInputStream("C:\\Users\\kmadh\\Desktop\\Pro.properties");
		Properties pro = new Properties();
		pro.load(fis);

		String BROWSER = pro.getProperty("Browser");
		String URL = pro.getProperty("url");
		String USERNAME = pro.getProperty("Username");
		String PASSWORD = pro.getProperty("Password");
		
		//read testScript data from Excel file
		
		FileInputStream fis1=new FileInputStream("D:\\AutomationPrograms\\TekPyramid\\testData.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sh = wb.getSheet("org");
		Row row = sh.getRow(1);
		String orgName = row.getCell(2).toString();
		System.out.println(orgName);
		wb.close();

		WebDriver driver = null;
		if (BROWSER.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (BROWSER.equals("firefox")) {

			driver = new FirefoxDriver();

		} else if (BROWSER.equals("edge")) {

			driver = new EdgeDriver();
		}

		// step:1 Login to application

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		driver.get(URL);
		System.out.println(PASSWORD);
		System.out.println(USERNAME);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();

		// Step-2 Navigate to Organization module
		driver.findElement(By.linkText("Organizations")).click();

		// Step-3 Click on "create Organization" Button
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

		// Step-4 Enter all the details and create new Organisation
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		//Step-5 Logout 
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"))).perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();

	}
}
