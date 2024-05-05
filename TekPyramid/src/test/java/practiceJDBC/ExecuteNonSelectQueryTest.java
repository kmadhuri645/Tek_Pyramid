 package practiceJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ExecuteNonSelectQueryTest {

	public static void main(String[] args) throws Throwable {
		
		//Step-1 register / load the mysql database
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		
		//Step-2 get connect to the database
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/madhu", "root", "root");
		System.out.println("===============done===============");
		
		//Step-3 create SQL Statement
		Statement stat = con.createStatement();
		//String query = "select * from qspider";
		
		//Step-4 execute statement/Query
		int result = stat.executeUpdate("insert into madhu values(5759,'nidhi',7777777,'jharkhand1');");
		System.out.println(result);

	}

}
