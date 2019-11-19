import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class change_frame {
	private timerFace ex;
	
	change_frame(timerFace ex)
	{
		this.ex = ex;
	}
	
	public void change_player_turn(int a,int r) {
		ex.ch.remove_panels_matrix();
		ex.leftPanel.removeAll();
		ex.leftPanel.setBackground(Color.MAGENTA);
		JLabel name = null;
		
		if(a==1)
		name = new JLabel(ex.player1_select.getData(),SwingConstants.CENTER);
		else
		name = new JLabel(ex.player2_select.getData(),SwingConstants.CENTER);
		
		name.setFont(new Font("Courier New ",Font.BOLD,37));
		name.setBackground(Color.green);
		name.setOpaque(true);
		
		for(int i=0;i<r;i++)
			ex.leftPanel.add(new JLabel());
		
		ex.leftPanel.add(name);
		ex.ch.add_panels_matrix();
		
		ex.f.validate();
		ex.f.repaint();
	}
	public void remove_panels_matrix() {
		System.out.println("Out");
	
		ex.f.remove(ex.totalPanel);
		ex.tokenPanel.removeAll();
		ex.matrixPanel.removeAll();
		ex.middlePanel.removeAll();
		ex.totalPanel.removeAll();
		
	}
	
	public void end_game() {
		
	}
	
	public void add_panels_matrix() {
		for(int i=0;i<7;i++)
			ex.tokenPanel.add(ex.pozToken[i]);
				 
		for(int i=0;i<6;i++)
			for(int j=0;j<7;j++)
				ex.matrixPanel.add(ex.matToken[i][j]);
		
		ex.middlePanel.add(ex.tokenPanel);
		ex.middlePanel.add(ex.matrixPanel);
						
		ex.totalPanel.add(ex.leftPanel);
		ex.totalPanel.add(ex.middlePanel);
		ex.totalPanel.add(ex.rightPanel);
		ex.f.add(ex.totalPanel);
	}
	
	public void init_panels() {
		 ex.leftPanel.setBackground(Color.red);
		 ex.middlePanel.setBackground(Color.yellow);
		 ex.rightPanel.setBackground(Color.cyan);
		 
		 ex.tokenPanel.setLayout(new GridLayout(0,7));
		 ex.tokenPanel.setPreferredSize(new Dimension(960, 100));
		 ex.tokenPanel.setBackground(Color.green);
		 
		 ex.matrixPanel.setLayout(new GridLayout(0,7));
		 ex.matrixPanel.setPreferredSize(new Dimension(960, 6*100));
		 ex.matrixPanel.setBorder(BorderFactory.createEmptyBorder(25,0,0,0)); 
		 
		 ex.rightPanel.setLayout(new GridLayout(20,1));
		 ex.leftPanel.setLayout(new GridLayout(10,1));
	}
}
