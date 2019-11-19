import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

public class make_button extends JPanel implements ActionListener{
	timerFace face = null;
	make_button(String s,timerFace f){
		face = f;
		Button b=new Button(s);  
		b.addActionListener(this); 
		this.add(b);
	}
	
	public void actionPerformed(ActionEvent e) {
		face.start = !face.start;
		face.t = face.turn_timer.createNewTimerTurn();
		face.t.start();
	}
	
	
}
