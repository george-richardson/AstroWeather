package API;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;


public class test {

	public static void main(String[] args) {
		
		//need to think about timezones eg australia data = 1 day behind 
		//once enter location -> get date in that location
		//work out 13 days from that date 
		
		//want to get the dates for today + 13 days 
		
		String [] dates = new String[14];
		
		String zone= "Europe/London";
		
		TimeZone t = TimeZone.getTimeZone(zone);
			
			
		
		Calendar c = new GregorianCalendar(t);
		
		for(int i=0; i<14; i++){
			
			int day = c.get(Calendar.DAY_OF_MONTH);
			int month = c.get(Calendar.MONTH);
			month++;
			int year = c.get(Calendar.YEAR);
			
			dates[i] = new String( day + " "+  month+ " " + year);
			
			System.out.println(dates[i]);
			c.add(Calendar.DAY_OF_MONTH, 1);
		}
		
		

		
	}//end main
	
	
	

}//end class
