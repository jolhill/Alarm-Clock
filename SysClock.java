import java.text.SimpleDateFormat;
import java.util.Date;

public class SysClock {
	
	public static String getFullDate(){
		long ms = System.currentTimeMillis();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd,yyyy HH:mm");    
		Date firstFormat = new Date(ms);
		return(dateFormat.format(firstFormat));
	}
	public static String getDateOrigionalFormat(){
		long ms = System.currentTimeMillis();   
		Date firstFormat = new Date(ms);
		return(firstFormat.toString());
	}
	public static int getSeconds(){
		String sOrigional = getDateOrigionalFormat();
		String [] aOrigional = sOrigional.split(" ");
		String sTime = aOrigional[3];
		String [] aTime = sTime.split(":");
		String sSeconds = aTime[2];
		return(Integer.parseInt(sSeconds));
	}
	
	private static String [] getDateSplit(){
		String sDate = getFullDate();
		String [] dateArray = sDate.split(" ");
		return dateArray;
	}
	
	public static String getMonth(){
		String [] aDate = getDateSplit();
		return aDate[0];
	}
	
	private static String [] getDayAndYear(){
		String [] aDate = getDateSplit();
		String sDayAndYear = aDate[1];
		String [] aDayAndYear = sDayAndYear.split(",");
		return(aDayAndYear);
	}
	
	public static int getDay(){
		String [] aDate = getDayAndYear();
		String sDay = aDate[0];
		return (Integer.parseInt(sDay));
	}
	
	public static int getYear(){
		String [] aDate = getDayAndYear();
		String sYear = aDate[1];
		return(Integer.parseInt(sYear));
	}
	
	public static String getMillitaryTime(){
		String [] aDate = getDateSplit();
		return aDate[2];
	}
	public static String getTime(){
		int iHour = getHour();
		int iMinute = getMinute();
		int iSeconds = getSeconds();
		String sMinute;
		if(iMinute < 10){
			sMinute = ("0" + iMinute);
		}
		else{
			sMinute = ("" + iMinute);
		}
		String sSeconds;
		if(iSeconds < 10){
			sSeconds = ("0" + iSeconds);
		}
		else{
			sSeconds = ("" + iSeconds);
		}
		return(iHour + ":" + sMinute +":"+sSeconds+ " " + getDayOrNight());
	}
	public static String getDayOrNight(){
		int iHour = getMillitaryHour();
		if(iHour >= 12){
			return("P.M.");
		}
		else{
			return("A.M.");
		}
	}
	
	private static String [] getTimeSplit(){
		String sTime = getMillitaryTime();
		String [] aTime = sTime.split(":");
		return(aTime);
	}
	
	public static int getMillitaryHour(){
		String [] aTime = getTimeSplit();
		String sTime = aTime[0];
		return(Integer.parseInt(sTime));
	}
	public static int getHour(){
		String [] aTime = getTimeSplit();
		String sTime = aTime[0];
		int iTime = Integer.parseInt(sTime);
		if(iTime >= 13){
			iTime -= 12;
		}
		return iTime;
	}
	
	public static int getMinute(){
		String [] aTime = getTimeSplit();
		String sTime = aTime[1];
		return(Integer.parseInt(sTime));
	}
		
	public static String getTimeOfDay(){
		int iHour = getMillitaryHour();
		if(iHour >= 12){
			return "P.M.";
		}
		else{
			return "A.M.";
		}
	}
}
