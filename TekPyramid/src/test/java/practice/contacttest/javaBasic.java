package practice.contacttest;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class javaBasic {

	public static void main(String[] args) {
		Date dateobj=new Date(); //dateobj in this object we have date and time also
		//but it will capture only date format and convert in to different pattern and return the output
		
		//System.out.println(dateobj.toString());
		
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");//here different type of format is there
		String actDate = sim.format(dateobj);
		System.out.println("Actual date :"+actDate);
		
		
	    Calendar cal = sim.getCalendar();//using cal we can specify how many days/years before we want or after
	    cal.add(Calendar.DAY_OF_MONTH, +30);
	   String dateRequires = sim.format(cal.getTime());
	  
		System.out.println("Expected date:"+dateRequires);

	}

}
