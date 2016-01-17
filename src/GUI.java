import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI implements ActionListener{

	private JFrame frame;
	private JPanel ClockPanel;
	private JLabel ClockLabel;
	private JButton SetAlarmButton;
	private JPanel AlarmPanel;
	private JLabel AlarmLabel;
	public boolean alarmSet;
	private AlarmClock oAlarm;
	
	public GUI(){
		gui();
	}
	
	public void gui(){
		alarmSet = false;
		frame = new JFrame("Clock");
		frame.setSize(250, 100);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ClockPanel = new JPanel();
		ClockPanel.setBackground(Color.LIGHT_GRAY);
		SetAlarmButton = new JButton("Set an Alarm");
		SetAlarmButton.addActionListener(this);
		ClockLabel = new JLabel("Time: " + SysClock.getTime());
		ClockPanel.add(ClockLabel,BorderLayout.WEST);
		ClockPanel.add(SetAlarmButton,BorderLayout.EAST);
		
		AlarmPanel = new JPanel();
		AlarmPanel.setBackground(Color.LIGHT_GRAY);
		AlarmLabel = new JLabel("Alarm : Not set");
		AlarmPanel.add(AlarmLabel,BorderLayout.WEST);
		
		frame.add(ClockPanel,BorderLayout.SOUTH);
		frame.add(AlarmPanel,BorderLayout.NORTH);
	}
	
	public void redraw(){
		ClockLabel.setVisible(false);
		ClockLabel.setText("Time: " + SysClock.getTime());
		ClockLabel.setVisible(true);
	}
	public void redrawWithAlarm(){
		ClockLabel.setVisible(false);
		ClockLabel.setText("Time: " + SysClock.getTime());
		ClockLabel.setVisible(true);
		if(oAlarm.soundAlarm()){
			Sound.soundAlarm();
			AlarmLabel.setVisible(false);
			AlarmLabel.setText("Alarm : Not set");
			AlarmLabel.setVisible(true);
			alarmSet = false;
		}
	}
	public void addAlarm(String sTime){
		AlarmLabel.setVisible(false);
		AlarmLabel.setText("Alarm set for:  " + sTime);
		AlarmLabel.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		oAlarm = alarm();
		alarmSet = true;
	}
	
	public AlarmClock alarm(){
		
		Object[] lOptions = {"A.M.","P.M."};
		
		//Setting Alarm
		String sAlarmHour = JOptionPane.showInputDialog(null,"Please enter the hour for your alarm: ");
		int iAlarmHour = Integer.parseInt(sAlarmHour);
		String sAlarmMinute = JOptionPane.showInputDialog(null,"Please enter the minutes for your alarm: ");
		int iAlarmMinute = Integer.parseInt(sAlarmMinute);
		
		//keep null, Prompt, Title of box, Type of message, icon {ignore this}, object[] containing options, default answer
		String sDayOrNight = (String)JOptionPane.showInputDialog(null, "Select time or day", 
				"Time", JOptionPane.PLAIN_MESSAGE, null, lOptions, "A.M.");
		if (sDayOrNight == null){
			System.out.println("Exiting");
			System.exit(0);
		}
		AlarmClock oAlarm = new AlarmClock(iAlarmHour,iAlarmMinute,sDayOrNight);
		addAlarm(oAlarm.toString());
		return(oAlarm);
	}
	

}
