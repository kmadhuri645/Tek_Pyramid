package practiceJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateProjectAndVerifyDataINDBwithGUI {

	public static void main(String[] args) throws InterruptedException, SQLException {
		
		//Create Project in GUI using selenium code
		String expected="raina Kumar";
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		driver.get("http://106.51.90.215:8084/dashboard/projects");
		
		driver.findElement(By.id("username")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		driver.findElement(By.xpath("//a[text()='Projects']")).click();
		driver.findElement(By.xpath("//span[text()='Create Project']")).click();
		//String expected="Madhuri";
		driver.findElement(By.name("projectName")).sendKeys("nehal Kumar");
		driver.findElement(By.name("createdBy")).sendKeys("chahal");
		WebElement sel=  driver.findElement(By.xpath("//label[text()='Project Status ']/following-sibling::select[@name=\"status\"]"));
		Select select = new Select(sel);
		select.selectByVisibleText("Completed");
		
	
		
		driver.findElement(By.xpath("//input[@value=\"Add Project\"]")).click();
		
		//Verify the Project in BackEnd [DB] using Jdbc
		boolean flag=false;
		
		//Step-1 register / load the mysql database
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		
		//Step-2 get connect to the database
		Connection con = DriverManager.getConnection("jdbc:mysql://106.51.90.215:3333/projects", "root@%", "root");
		
		//Step-3 create SQL Statement
		Statement stat = con.createStatement();
		
		
		//Step-4 execute statement/Query
		
		String query = "select * from project";
		ResultSet result = stat.executeQuery(query);
		//System.out.println(result);
		
		while(result.next()) {
			//only which data avilable
			String actProjectName = result.getString(4);
			System.out.println(actProjectName);
			
			if(actProjectName.equals(expected)) {
				flag=true;
				System.out.println(expected+"is avilable ==PASS");
				//Assert.fail();
				
			}
		}
 	    if(flag==false) {
		System.out.println(expected+"is not avilable ==PASS");	
	
	}
		//Step-5 close the connection
		con.close();

		
		
		
		
	}

}
