package practiceJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class NoselectQuery {
public static void main(String[] args) throws SQLException {
		
		Connection con=null;
		try {
			//Step-1 register / load the mysql database
			Driver driverRef=new Driver();
			DriverManager.registerDriver(driverRef);
			
			//Step-2 get connect to the database
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/madhu", "root", "root");
			
			//Step-3 create SQL Statement
			Statement stat = con.createStatement();
	
			
			stat.executeUpdate("insert into madhu values(786,'Ali',8654.87,'jharkhand')");
		
			
			
		}catch (Exception e) {
			System.out.println("handle exception");
		}finally {
			//step-5 close the connection
			con.close();
			System.out.println("=======close the connection========");
		}
	}
}
