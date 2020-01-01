package connect4.controllers;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import connect4.models.MainModel;
import connect4.models.NodeMatrix;
import connect4.views.HistoryLabel;
import connect4.views.MainFrame;

public class ChangeFrame {
	private MainFrame f;
	private MainModel m;
	
	public ChangeFrame(MainFrame f,MainModel m) {
		this.f = f;
		this.m = m;
	}

	public void change_player_turn(int a, int r,boolean end) {
		remove_panels_matrix();

		f.getLeftPanel().removeAll();
		JLabel name = null;

		if (a == 1)
			name = new JLabel(f.getPlayer2_select().getNume(), SwingConstants.CENTER);
		else
			name = new JLabel(f.getPlayer1_select().getNume(), SwingConstants.CENTER);

		name.setFont(new Font("Courier New ", Font.BOLD, 37));
		name.setBackground(new Color(211, 86, 86));
		name.setOpaque(true);

		for (int i = 0; i < r; i++)
			f.getLeftPanel().add(new JLabel());

		f.getLeftPanel().add(name);
		
		if(end == true) {
			name = new JLabel("Won", SwingConstants.CENTER);
			name.setFont(new Font("Courier New ", Font.BOLD, 37));
			name.setBackground(new Color(230, 231, 235));
			name.setOpaque(true);
			f.getLeftPanel().add(name);
		}
		add_panels_matrix();

		f.validate();
		f.repaint();
	}

	public void remove_panels_matrix() {
		f.getRightPanel().removeAll();
		f.remove(f.getTotalPanel());
		f.getTokenPanel().removeAll();
		f.getMatrixPanel().removeAll();
		f.getMiddlePanel().removeAll();
		f.getTotalPanel().removeAll();
		f.getRightThisGame().removeAll();
		f.getRightThisGameAll().removeAll();
	}

	public void end_game() throws ClassNotFoundException, SQLException {
		
			
			/// Reset matrix with values
			for (int i = 0; i < 6; i++)
				for (int j = 0; j < 7; j++) {
					m.getMatVal()[i][j] = new NodeMatrix(i,j);
				}

			System.out.println("Am ajuns aici1");
			/// Remove left panel to insert inputText
			f.getLeftPanel().removeAll();
			for (Component c : f.getPlayer1_select().getComponents()) {
				if (c instanceof JTextField) {
					((JTextField) c).setText("");
				}
			}
			System.out.println("Am ajuns aici2");

			for (Component c : f.getPlayer2_select().getComponents()) {
				if (c instanceof JTextField) {
					((JTextField) c).setText("");
				}
			}

			System.out.println("Am ajuns aici3");
			JPanel empty = new JPanel();
			empty.setBackground(new Color(249, 213, 187));
			
			JPanel empty2 = new JPanel();
			empty2.setBackground(new Color(249, 213, 187));
			
			JPanel empty3 = new JPanel();
			empty3.setBackground(new Color(249, 213, 187));
			f.getLeftPanel().add(empty);
			f.getLeftPanel().add(f.getPlayer1_select());
			f.getLeftPanel().add(empty2);
			f.getLeftPanel().add(f.getPlayer2_select());
			f.getLeftPanel().add(empty3);
			f.getLeftPanel().add(f.getStartButton());

			/// Send information to database
			SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");
			Date now = new Date();
			String strDate = sdfDate.format(now);

			ConnectionSQL ex_conn = new ConnectionSQL();
			Connection conn = ex_conn.getConnection();
			String query = String.format(
					"insert into history(winner,player1,player2,date_game,duration) values (%d,'%s','%s','%s',%d);",
					f.getPlayer(), f.getPlayer1_string(), f.getPlayer2_string(), strDate, 23);
			System.out.println(query);
			Statement st = conn.createStatement();

			st.executeUpdate(query);

			remove_panels_matrix();

			JPanel a = new HistoryLabel(f.getPlayer(), f.getPlayer1_string(), f.getPlayer2_string(), 33);
			f.getListThisGame().addFirst(a);

			f.getRightThisGame().add(a, 0);

			if (f.getListThisGame().size() > 7)
				f.getListThisGame().removeLast();

			/// Remove and add middlePanel
			add_panels_matrix();
			f.validate();
			f.repaint();
			
			/// Set this variable to start the game with player1
			f.setPlayer(0);

	}

	public void add_panels_matrix() {
		for (int i = 0; i < 7; i++)
			f.getTokenPanel().add(f.getPozToken()[i]);

		for (int i = 0; i < 6; i++)
			for (int j = 0; j < 7; j++)
				f.getMatrixPanel().add(m.getMatVal()[i][j].getToken());

		Iterator<JPanel> it = f.getListThisGame().iterator();

		while (it.hasNext()) {
			f.getRightThisGame().add(it.next());
		}

		f.getRightPanel().add(f.getRightSQLHistory());
		f.getRightThisGameAll().add(f.getThisGamePanel());
		f.getRightThisGameAll().add(f.getRightThisGame());

		f.getRightPanel().add(f.getRightThisGameAll());

		f.getMiddlePanel().add(f.getTokenPanel());
		f.getMiddlePanel().add(f.getMatrixPanel());

		f.getTotalPanel().add(f.getLeftPanel());
		f.getTotalPanel().add(f.getMiddlePanel());
		f.getTotalPanel().add(f.getRightPanel());

		f.add(f.getTotalPanel());
	}

	public void init_panels() {
		
		Color basic = new Color(249, 213, 187);
		f.setBackground(basic);
		f.getLeftPanel().setBackground(basic);
		f.getMiddlePanel().setBackground(basic);
		f.getRightPanel().setBackground(basic);
		f.getTokenPanel().setBackground(basic);
		f.getMatrixPanel().setBackground(basic);
		f.getRightSQLHistory().setBackground(basic);
		f.getRightThisGameAll().setBackground(basic);
		f.getRightThisGame().setBackground(basic);
		f.getTotalPanel().setBackground(basic);
		f.getStartButton().setBackground(basic);
		
		
		f.getTokenPanel().setLayout(new GridLayout(0, 7));
		f.getTokenPanel().setPreferredSize(new Dimension(7 * 120, 140));
		f.getTokenPanel().setBorder(BorderFactory.createEmptyBorder(40, 0, 0, 0));

		f.getMatrixPanel().setLayout(new GridLayout(0, 7));
		f.getMatrixPanel().setPreferredSize(new Dimension(7 * 120, 6 * 110));
		f.getMatrixPanel().setBorder(BorderFactory.createEmptyBorder(25, 0, 0, 0));

		f.getRightThisGame().setLayout(new GridLayout(11, 1));
		f.getRightSQLHistory().setLayout(new GridLayout(0, 1));
		f.getRightPanel().setLayout(new GridLayout(0, 1));
		f.getLeftPanel().setLayout(new GridLayout(10, 1));

		f.getTotalPanel().setPreferredSize(new Dimension(1800, 900));
		f.getLeftPanel().setPreferredSize(new Dimension(250, 900));
		f.getRightPanel().setPreferredSize(new Dimension(400, 900));
		f.getRightThisGame().setPreferredSize(new Dimension(400, 500));
		f.getRightThisGameAll().setPreferredSize(new Dimension(400, 900));
		f.getMiddlePanel().setPreferredSize(new Dimension(860, 900));
	}
}
