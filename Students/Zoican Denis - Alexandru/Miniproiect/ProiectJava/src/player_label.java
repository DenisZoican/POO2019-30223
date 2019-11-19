import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class player_label extends JPanel{
	public JTextField txtInput = null;
	
	player_label(Integer player)
	{
		this.setLayout(new GridLayout(0,2));
	
		JLabel player_label= new JLabel("Player"+player);
		player_label.setFont(new Font("Courier New ",Font.BOLD,26));
		txtInput = new JTextField("");
		player_label.setBackground(new Color(110, 163, 184));
		txtInput.setFont(new Font("Courier New ",Font.BOLD,20));
		this.setBackground(new Color(110, 163, 184));
		this.add(player_label);
		JPanel empty = new JPanel();
		empty.setBackground(new Color(110, 163, 184));
		txtInput.setBorder(new EmptyBorder(0, 10, 0, 0));
		txtInput.setDocument(new limit_text(30));
		this.add(empty);
		this.add(txtInput);
		this.setBorder(new EmptyBorder(10, 20, 10, 10));
	}
	
	public String getData () {
		return txtInput.getText();
	}
	
	
}
