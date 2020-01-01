package connect4.views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import connect4.controllers.LimitText;

public class PlayerLabel extends JPanel{
	public JTextField txtInput = null;
	
	public PlayerLabel(Integer player)
	{
		this.setLayout(new GridLayout(2,1));
		this.setPreferredSize(new Dimension(200,200));
		JLabel player_label= new JLabel("Player"+player);
		player_label.setFont(new Font("Courier New ",Font.BOLD,26));
		txtInput = new JTextField();
		player_label.setBackground(new Color(10, 163, 184));
		player_label.setForeground(new Color(38, 35, 35));
		player_label.setBorder(new EmptyBorder(0,0,10,0));
		txtInput.setFont(new Font("Courier New ",Font.BOLD,20));
		this.setBackground(new Color(60, 61, 71));
		this.add(player_label);
		txtInput.setHorizontalAlignment(JTextField.CENTER);
		txtInput.setBorder(new EmptyBorder(5, 15, 5, 5));
		txtInput.setDocument(new LimitText(8));
		txtInput.setBorder(BorderFactory.createLineBorder(new Color(211, 86, 86), 3));
		this.add(txtInput);
		this.setBorder(new EmptyBorder(10, 10, 20, 10));
	}
	
	public String getNume() {
		return txtInput.getText();
	}
	
}
