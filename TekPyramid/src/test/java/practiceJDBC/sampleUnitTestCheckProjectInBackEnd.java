package practiceJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class sampleUnitTestCheckProjectInBackEnd {
	
	@Test
	public void projectCheckTest() throws SQLException {
		
		String expectedProjectName="noida";
		boolean flag=false;
		
		//Step-1 register / load the mysql database
				Driver driverRef=new Driver();
				DriverManager.registerDriver(driverRef);
				
				//Step-2 get connect to the database
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/madhu", "root", "root");
				
				//Step-3 create SQL Statement
				Statement stat = con.createStatement();
				String query = "select * from madhu";
				
				//Step-4 execute statement/Query
				ResultSet result = stat.executeQuery(query);
				System.out.println(result);
				
				while(result.next()) {
					//only which data avilable
					String actProjectName = result.getString(4);
					//System.out.println(actProjectName);
					if(expectedProjectName.equals(actProjectName)) {
						System.out.println(expectedProjectName+"is avilable ==PASS");
						Assert.fail();
						flag=true;
					}
				}
				if(flag==false) {
					System.out.println(expectedProjectName+"is not avilable ==PASS");	
					
				}
				//Step-5 close the connection
				con.close();

		
		
	}

}
