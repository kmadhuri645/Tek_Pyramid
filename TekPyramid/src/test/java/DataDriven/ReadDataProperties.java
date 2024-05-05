package DataDriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import Generic.BAsecalss;

public class ReadDataProperties{

	public static void main(String[] args) throws Throwable {
		
		//step1-get the java representation object of the physical file
		FileInputStream fis=new FileInputStream("C:\\Users\\kmadh\\Desktop\\Pro.properties");
		
		//step-2 using properties class ,load all the keys
		Properties pro=new Properties();
		pro.load(fis);
		
		//step-3:get the value based on key
		System.out.println(pro.getProperty("url"));
		System.out.println(pro.getProperty("Browser"));

	}

}
