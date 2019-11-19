import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.JPanel;
import javax.swing.Timer;

public class timer_drop{
	
	private timerFace ex;
	
	timer_drop(timerFace ex){
		this.ex = ex;
	}
	
	public Timer createNewTimerTurn() {
		Timer timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	ex.turn_time++;
                ex.ch.change_player_turn(ex.player, ex.turn_time);
                if(ex.turn_time == 8)
                	{
                		((Timer)e.getSource()).stop();	
                		try {
							ex.drop_token();
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
                	}
            }
        });	
		return timer;
	}
}
