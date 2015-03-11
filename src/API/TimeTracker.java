package API;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;


//author : Haricharran Sampat


// handles dates and times for the app
public class TimeTracker {

	
	protected String [] dates;
	
	protected String zone;
	
	protected TimeZone t;
	
	
	//works out faster to create dates as opposed to searching the xml page every time
	
	
	public TimeTracker(){
		
		// note that times are set for UK only
		// can set to handle different timezones 
		// have a lookup table with city codes and timezones
		// given city -> look up timezone 
		// set timezone on calendar eg Calendar c = new GregorianCalendar(timezone)
		// -> should set days and hours correctly for any city  
		
	}
	
	
	// gets the time periods and dates for hourly weather info
	// predetermined by website -> 48 objects with 3h slots starting from current time 
	public String[] getHourlyDates() {

		dates = new String[48];

		Calendar c = new GregorianCalendar();

		for (int i = 0; i < dates.length; i++) {

			int hour = c.get(Calendar.HOUR_OF_DAY);

			// set hour in correct 3h time interval eg 11.00 -> 9-12
			hour = hour - (hour % 3);

			int day = c.get(Calendar.DAY_OF_MONTH);
			int month = c.get(Calendar.MONTH);
			month++;
			int year = c.get(Calendar.YEAR);

			dates[i] = new String(hour + " - " + (hour + 3) + " " + day + " "
					+ month + " " + year);

			c.add(Calendar.HOUR_OF_DAY, 3);

		}

		return dates;
	}
	
	
	
	//gets dates  for daily weather info
	public String[] getDayDates(int numDays) {

		dates = new String[numDays];

		// t = TimeZone.getTimeZone(zone);

		Calendar c = new GregorianCalendar();

		for (int i = 0; i < numDays; i++) {

			int day = c.get(Calendar.DAY_OF_MONTH);
			int month = c.get(Calendar.MONTH);
			month++;
			int year = c.get(Calendar.YEAR);

			dates[i] = new String(day + " " + month + " " + year);

			// System.out.println(dates[i]);

			c.add(Calendar.DAY_OF_MONTH, 1);

		}
		return dates;
	}
  
	
	
}//end class
