

public class AlarmClient {

	public static void main(String[] args) {
		
		GUI oClock = new GUI();
		
		while(true){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e){e.printStackTrace();}
			
			if(oClock.alarmSet){
				oClock.redrawWithAlarm();
			}
			
			else{
				oClock.redraw();
			}
			
		}
		
	}
	
}
