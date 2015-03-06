package API;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;


//author : Haricharran Sampat


public class TimeTracker {

	
	protected String [] dates;
	
	protected String zone;
	
	protected TimeZone t;
	
	
	
	// return dates as strings, for given number of days  in  a given timezone
	// can be used to display dates needed in the app,
	//eg Australia is 1 day ahead of UK -> different date 
	
	//works out faster to create dates as opposed to searching the xml page every time
	public TimeTracker(String aZone, int numDays){
		
		
		this.zone = aZone;
		
		dates = new String[numDays];
		
		t = TimeZone.getTimeZone(zone);
		
		Calendar c = new GregorianCalendar(t);
		
		
		
		for(int i=0; i<numDays; i++){
			
			int day = c.get(Calendar.DAY_OF_MONTH);
			int month = c.get(Calendar.MONTH);
			month++;
			int year = c.get(Calendar.YEAR);
			
			dates[i] = new String( day + " "+  month+ " " + year);
			
			//System.out.println(dates[i]);
			
			c.add(Calendar.DAY_OF_MONTH, 1);
		}
		
		
	}
	
	
	
	public String[] getDates(){
		
		return this.dates;
	}
	
	
	
}//end class
