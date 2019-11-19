import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class history_date extends JPanel{
	history_date(String date_game)
	{
		JLabel date_game_label= new JLabel(date_game);
		date_game_label.setFont(new Font("Courier New ",Font.BOLD,26));
		this.setBackground(new Color(110, 163, 184));
		this.add(date_game_label);
	}
}
