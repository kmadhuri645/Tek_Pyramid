package practice.contacttest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactTest {

	public static void main(String[] args) throws IOException {
		//read common data from properties file
		FileInputStream fis = new FileInputStream("D:\\AutomationPrograms\\TekPyramid\\src\\test\\resources\\Pro.properties");
		Properties pro = new Properties();
		pro.load(fis);

		String BROWSER = pro.getProperty("browser");
		String URL = pro.getProperty("url");
		String USERNAME = pro.getProperty("username");
		String PASSWORD = pro.getProperty("password");
		
		//generate the random number
		Random random = new Random();
		int randomInt = random.nextInt(1000);
		
		//read testScript data from Excel file
		
		FileInputStream fis1=new FileInputStream("D:\\AutomationPrograms\\TekPyramid\\src\\test\\resources\\testData.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sh = wb.getSheet("contact");
		Row row = sh.getRow(1);
		                    
		String lastName = row.getCell(2).toString()+randomInt;
		//System.out.println(lastName);
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
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();

		// Step-2 Navigate to Contact module
		driver.findElement(By.linkText("Contacts")).click();

		// Step-3 Click on "create Contact" Button
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();

		// Step-4 Enter all the details and create new lastname
		driver.findElement(By.name("lastname")).sendKeys(lastName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click(); 
		
		//verify LastName  Expected Result
		String actLastName = driver.findElement(By.id("dtlview_Last Name")).getText();
		
		if(actLastName.equals(lastName)) {
			System.out.println(lastName+"information is verified  ==PASS");
		}else {
			System.out.println(lastName+"information is not created ==FAIL");
		}

		//Step-5 Logout 
		driver.close();

	}

}
