import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class history_label extends JPanel {
	history_label(int winner,String player1,String player2,int duration){
		 this.setLayout(new GridLayout(0,3));
		 
		 
		 JLabel player1_label = new JLabel(player1);
		 JLabel space_label = new JLabel(new String("\u039E")+new String("\u039E")+new String("\u039E")+new String("\u039E")+new String("\u039E")+new String("\u039E"));
		 JLabel player2_label = new JLabel(player2);
		 
		 player1_label.setFont(new Font("Courier New ",Font.BOLD,24));
		 space_label.setFont(new Font("Courier New ",Font.BOLD,24));
		 player2_label.setFont(new Font("Courier New ",Font.BOLD,24));
		 this.setBorder(BorderFactory.createEmptyBorder(0,40,0,0)); 
		 
		 space_label.setForeground(new Color(60, 101, 117));
		 
		 if(winner==1)
		 {
			 player1_label.setForeground(new Color(16, 204, 66));
			 player2_label.setForeground(new Color(209, 59, 8));
		 } else {
			 player2_label.setForeground(new Color(16, 204, 66));
			 player1_label.setForeground(new Color(209, 59, 8));
		 }
		

		 
		 this.add(player1_label);
		 this.add(space_label);
		 this.add(player2_label);
		 
	}
}
