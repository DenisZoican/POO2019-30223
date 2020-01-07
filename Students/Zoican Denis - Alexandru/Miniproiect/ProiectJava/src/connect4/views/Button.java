package connect4.views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

/**
 * 
 * Class for the start button
 */
public class Button extends JPanel{
	MainFrame face = null;
	public Button(String s,MainFrame f){
		face = f;
		JButton b=new JButton(s); 
		b.setBackground(new Color(211, 86, 86));
		b.setPreferredSize(new Dimension(100,50));
		b.setFont(new Font("Courier New ",Font.BOLD,24));
		b.setBorder(new LineBorder(new Color(60, 61, 71),3));
		this.add(b);
	}
	
	
}
