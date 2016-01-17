import javax.swing.JOptionPane;


public class AlarmClock {
	
	private int iAlarmHour;
	private int iAlarmMinute;
	private String sDayOrNight;
	
	//Constructors
	public AlarmClock(int iAlarmHour,String sDayOrNight){
		setAlarmHour(iAlarmHour);
		setAlarmMinute(0);
		setsDayOrNight(sDayOrNight);
	}
	public AlarmClock(int iAlarmHour,int iAlarmMinute,String sDayOrNight){
		setAlarmHour(iAlarmHour);
		setAlarmMinute(iAlarmMinute);
		setsDayOrNight(sDayOrNight);
	}
	public AlarmClock(int iAlarmHour){
		setAlarmHour(iAlarmHour);
		setAlarmMinute(0);
		setsDayOrNight("A.M.");
	}
	public AlarmClock(int iAlarmHour,int iAlarmMinute){
		setAlarmHour(iAlarmHour);
		setAlarmMinute(iAlarmMinute);
		setsDayOrNight("A.M.");
	}

	
	//Accessors and Mutators
	public String getsDayOrNight() {
		return sDayOrNight;
	}
	public void setsDayOrNight(String sDayOrNight) {
		this.sDayOrNight = sDayOrNight;
	}
	public int getAlarmHour() {
		return iAlarmHour;
	}
	public void setAlarmHour(int iAlarmHour) {
		if(iAlarmHour >=0 && iAlarmHour <= 12){
			this.iAlarmHour = iAlarmHour;
		}
		else{
			do{
				String sAnswer = JOptionPane.showInputDialog(null,(iAlarmHour + " is not a valid hour for an alarm, please enter"
						+ " a number between 0 and 12: "));
				iAlarmHour = Integer.parseInt(sAnswer);
			}while(!(iAlarmHour >=0 && iAlarmHour <= 12));
			this.iAlarmHour = iAlarmHour;
		}
	}
	public int getAlarmMinute() {
		return iAlarmMinute;
	}
	public void setAlarmMinute(int iAlarmMinute) {
		if(iAlarmMinute >=0 && iAlarmMinute <=59){
			this.iAlarmMinute = iAlarmMinute;
		}
		else{
			do{
				String sAnswer = JOptionPane.showInputDialog(null,(iAlarmMinute + " is not a valid minute for an alarm, please enter"
						+ " a number between 0 and 59: "));
				iAlarmMinute = Integer.parseInt(sAnswer);
			}while(!(iAlarmMinute >=0 && iAlarmMinute <= 59));
			this.iAlarmMinute = iAlarmMinute;
		}
	}
	
	//toString method (Overridden)
	public String toString(){
		int iMinute = getAlarmMinute();
		String sMinute;
		if(iMinute < 10){
			sMinute = ("0" + iMinute);
		}
		else{
			sMinute = ("" + iMinute);
		}
		return("Alarm: " + getAlarmHour() + ":" + sMinute + " " + sDayOrNight);
	}
	
	//returns beeping if the alarm time matches clock time, otherwise you continue sleeping
	public boolean soundAlarm(){
		if(iAlarmHour == SysClock.getHour() && iAlarmMinute == SysClock.getMinute()
				&& sDayOrNight.equalsIgnoreCase(SysClock.getTimeOfDay())){
			return true;
		}
		else{
			return false;
		}

	}

	public void toggleDayOrNight(){
		if(sDayOrNight.equalsIgnoreCase("A.M.")){
			sDayOrNight = "P.M.";
		}
		else{
			sDayOrNight = "A.M.";
		}
		
	}
}
