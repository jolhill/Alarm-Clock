import java.applet.Applet;
import java.applet.AudioClip;

public class Sound {
	public static void soundAlarm(){
		try{
			AudioClip clip;
			clip = Applet.newAudioClip(Sound.class.getResource("alarm.wav"));
			clip.play();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
