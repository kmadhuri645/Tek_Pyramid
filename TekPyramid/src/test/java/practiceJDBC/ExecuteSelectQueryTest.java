package practiceJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ExecuteSelectQueryTest {

	public static void main(String[] args) throws Throwable {
		
		//Step-1 register / load the mysql database
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		
		//Step-2 get connect to the database
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/qspiders", "root", "root");
		
		//Step-3 create SQL Statement
		Statement stat = con.createStatement();
		String query = "select * from qspider";
		
		//Step-4 execute statement/Query
		ResultSet result = stat.executeQuery(query);
		System.out.println(result);
		
		while(result.next()) {
			System.out.println(result.getInt(1)+"\t" +result.getString(2)+"\t"+result.getString(3)+"\t");
			
			//System.out.print(result.getInt(1)+"\t");
			//System.out.print(result.getString(2)+"\t");
			//System.out.print(result.getString(3)+"\t");
			//System.out.println(result.getByte(4)+"\t");
			
			
		}
		//Step-5 close the connection
		con.close();

	}

}
