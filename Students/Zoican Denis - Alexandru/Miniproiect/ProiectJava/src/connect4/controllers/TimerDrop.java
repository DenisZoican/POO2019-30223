package connect4.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.JPanel;
import javax.swing.Timer;

import connect4.views.MainFrame;

/**
 * Class used for animation
 * @author Denis Zoican
 *
 */
public class TimerDrop {

	private MainController ex;

	public TimerDrop(MainController ex) {
		this.ex = ex;
	}

	public Timer createNewTimerTurn() {
		Timer timer = new Timer(3000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ex.getMainFrame().setTurn_time(ex.getMainFrame().getTurn_time() + 1);
				ex.change_player_turn(ex.getMainFrame().getPlayer(), ex.getMainFrame().getTurn_time(),false);
				if (ex.getMainFrame().getTurn_time() == 8) {
					((Timer) e.getSource()).stop();
					try {
						ex.drop_token();
					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
					} catch (SQLException e1) {
						e1.printStackTrace();
					} catch (ParseException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		return timer;
	}
}
