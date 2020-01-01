package connect4.views;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class HistoryDate extends JPanel{
	public HistoryDate(String date_game)
	{
		JLabel date_game_label= new JLabel(date_game);
		date_game_label.setFont(new Font("Courier New ",Font.BOLD,26));
		this.setBackground(new Color(211, 86, 86));
		this.add(date_game_label);
	}
}
