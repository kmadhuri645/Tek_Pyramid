package practiceJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class VaidateSelectQueryTestTryCatch {

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
						
			String query = "select * from madhu";
			
			
			//Step-4 execute statement/Query
			ResultSet result = stat.executeQuery(query);
			
			
			while(result.next()) {
				
		    String check=result.getString(2);
		    
		    if(check.equals("Ali")) {
		    	System.out.println("Ali Ok");
		    }
				
		}
		}catch (Exception e) {
			System.out.println("handle exception");
		}finally {
			//step-5 close the connection
			con.close();
			System.out.println("=======close the connection========");
		}
	}

}
