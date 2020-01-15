package Views;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainView {
	private JFrame f;
	private JButton bt;
	private JPanel btPanel;
	
	public MainView() {
		btPanel = new JPanel();
		f = new JFrame();
		f.setVisible(true);
		f.setSize(1000, 500);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLayout(new GridLayout(0,1));
		
		bt = new JButton("Start");
		btPanel.add(bt);
		f.add(btPanel);
	}

	
	public JFrame getF() {
		return f;
	}

	public JPanel getBtPanel() {
		return btPanel;
	}
	
	public void setF(JFrame f) {
		this.f = f;
	}
	
	public JButton getBt() {
		return bt;
	}

	public void setBt(JButton bt) {
		this.bt = bt;
	}
}
