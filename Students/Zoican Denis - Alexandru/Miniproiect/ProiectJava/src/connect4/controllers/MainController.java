package connect4.controllers;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import connect4.models.MainModel;
import connect4.models.NodeMatrix;
import connect4.models.Point;
import connect4.views.ConstantsGame;
import connect4.views.HistoryDate;
import connect4.views.HistoryLabel;
import connect4.views.MainFrame;
import connect4.views.TokenImage;

public class MainController {

	private MainFrame f;
	private MainModel m;

	private ChangeFrame ch;
	private TimerDrop turn_timer = new TimerDrop(this);

	public MainController(MainFrame f, MainModel m) {
		this.f = f;
		this.m = m;
	}

	public MainFrame getMainFrame() {
		return f;
	}

	public MainModel getMainModel() {
		return m;
	}

	public void main() throws SQLException, ClassNotFoundException {

		ch = new ChangeFrame(f, m);

		ch.add_panels_matrix();

		// Connect to database
		Connection conn = ConnectionSQL.getConnection();
		String query = "SELECT * FROM history ORDER BY id DESC";
		Statement st = (Statement) conn.createStatement();

		/// Get data
		ResultSet rs = st.executeQuery(query);
		int count_history = 0;
		String date_prev = null;

		/// Add data
		while (rs.next() == true && count_history <= 6) {
			count_history++;
			if (date_prev == null || date_prev.compareTo(rs.getString("date_game")) != 0) {
				date_prev = rs.getString("date_game");
				f.getRightSQLHistory().add(new HistoryDate(date_prev));
			}
			f.getRightSQLHistory().add(new HistoryLabel(rs.getInt("winner"), rs.getString("player1"),
					rs.getString("player2"), rs.getInt("duration")));
		}
		st.close();

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(1800, 900);
		f.setResizable(false);

		f.setStartButtonListener(new ButtonActionListener());

		f.setKeyAdapter(new KeyAdapter('r'), new KeyAdapter('l'), new KeyAdapter('s'));
	}

	public class ButtonActionListener implements ActionListener {

		private String player_photo(String name, int us) {
			switch (name.toLowerCase()) {
			case "zoican":
				return "./Resources/face2.png";
			case "bianca":
				return "./Resources/face3.png";
			case "bursuk":
				return "./Resources/face4.png";
			case "cristian":
				return "./Resources/face5.png";
			case "vlad":
				return "./Resources/face6.png";
			case "malin":
				return "./Resources/face7.png";
			case "miruna":
				return "./Resources/face8.png";
			case "denisa":
				return "./Resources/face9.png";
			case "gabi":
				return "./Resources/face10.png";
			case "diana":
				return "./Resources/face11.png";
			default:
				if (us == 1)
					return "./Resources/face12.png";
				else
					return "./Resources/face13.png";
			}
		}

		private String player_win_photo(String name, int us) {
			switch (name.toLowerCase()) {
			case "zoican":
				return "./Resources/face2_win.png";
			case "bianca":
				return "./Resources/face3_win.png";
			case "bursuk":
				return "./Resources/face4_win.png";
			case "cristian":
				return "./Resources/face5_win.png";
			case "vlad":
				return "./Resources/face6_win.png";
			case "malin":
				return "./Resources/face7_win.png";
			case "miruna":
				return "./Resources/face8_win.png";
			case "denisa":
				return "./Resources/face9_win.png";
			case "gabi":
				return "./Resources/face10_win.png";
			case "diana":
				return "./Resources/face11_win.png";
			default:
				if (us == 1)
					return "./Resources/face12_win.png";
				else
					return "./Resources/face13_win.png";
			}
		}

		public void actionPerformed(ActionEvent e) {
			f.setPlayer1_string(f.getPlayer1_select().getNume());
			f.setPlayer2_string(f.getPlayer2_select().getNume());
			if (f.getPlayer1_string().toLowerCase().compareTo(f.getPlayer2_string().toLowerCase()) == 0) {
				JOptionPane.showMessageDialog(null, "You can't have the same name");
				return;
			}
			f.setStart(!f.isStart());
			f.setSrc1(player_photo(f.getPlayer1_string(), 1));

		
			if (f.getSrc1() == "./Resources/face12.png")
				f.setSrc2(player_photo(f.getPlayer2_string(), 2));
			else
				f.setSrc2(player_photo(f.getPlayer2_string(), 1));

			System.out.println(f.getSrc1()+" "+f.getSrc2());
			
			f.setSrc1_win(player_win_photo(f.getPlayer1_string(), 1));

			if (f.getSrc1_win() == "./Resources/face12_win.png")
				f.setSrc2_win(player_win_photo(f.getPlayer2_string(), 2));
			else
				f.setSrc2_win(player_win_photo(f.getPlayer2_string(), 1));

			System.out.println(f.getSrc1_win()+" "+f.getSrc2_win());
			
			f.setT(turn_timer.createNewTimerTurn());
			f.getT().start();
		}
	}

	public void change_player_turn(int a, int r, boolean end) {
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

		if (end == true) {
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
				(m.getMatVal())[i][j] = new NodeMatrix(i, j);
			}

		/// Remove left panel to insert inputText
		f.getLeftPanel().removeAll();
		for (Component c : f.getPlayer1_select().getComponents()) {
			if (c instanceof JTextField) {
				((JTextField) c).setText("");
			}
		}

		for (Component c : f.getPlayer2_select().getComponents()) {
			if (c instanceof JTextField) {
				((JTextField) c).setText("");
			}
		}

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
		Statement st = (Statement) conn.createStatement();

		st.executeUpdate(query);

		remove_panels_matrix();

		JPanel a = new HistoryLabel(f.getPlayer(), f.getPlayer1_string(), f.getPlayer2_string(), 33);
		f.getListThisGame().addFirst(a);

		f.getRightThisGame().add(a, 0);

		if (f.getListThisGame().size() > 7)
			f.getListThisGame().removeLast();

		f.getPozToken()[f.getPoz()] = new TokenImage(ConstantsGame.ICON);

		// System.out.println("poz este "+f.poz+" "+f.pozToken[f.poz].getClass());
		/// Remove and add middlePanel
		add_panels_matrix();
		f.validate();
		f.repaint();

		/// Set this variable to start the game with f.player1
		f.setPlayer(0);

	}

	public void add_panels_matrix() {
		for (int i = 0; i < 7; i++)
			f.getTokenPanel().add(f.getPozToken()[i]);

		for (int i = 0; i < 6; i++)
			for (int j = 0; j < 7; j++)
				f.getMatrixPanel().add((m.getMatVal())[i][j].getToken());

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

	public void drop_token() throws ClassNotFoundException, SQLException, ParseException {

		remove_panels_matrix();

		f.getPozToken()[f.getPoz()] = new TokenImage(ConstantsGame.SRC_BLANK);

		int i = 0;
		if (f.getPlayer1_string().toLowerCase().compareTo("zoican") == 0 && f.getPlayer() == 0
				|| f.getPlayer2_string().toLowerCase().compareTo("zoican") == 0 && f.getPlayer() == 1
				|| f.getPlayer1_string().toLowerCase().compareTo("vlad") == 0 && f.getPlayer() == 0
				|| f.getPlayer2_string().toLowerCase().compareTo("vlad") == 0 && f.getPlayer() == 1) {
			Point bestMove = BotController.chooseBestMove(m.getMatVal(), f.getPlayer(), (f.getPlayer() + 1) % 2);
			f.setPoz(bestMove.getY());
			i = bestMove.getX();

			// Reach top and lose
			if ((m.getMatVal())[0][f.getPoz()].getValue() == 1 && f.isStart() == true) {
				TimerAnimation(-1, -1, -1);
				return;
			}
		} else {
			// Reach top and lose
			if ((m.getMatVal())[0][f.getPoz()].getValue() == 1 && f.isStart() == true) {
				TimerAnimation(-1, -1, -1);
				return;
			}
			while (i < 6 && (m.getMatVal())[i][f.getPoz()].getValue() == 0) {
				i++;
			}
			i--;
		}

		remove_panels_matrix();

		if (f.getPlayer() == 0)
			f.getPozToken()[f.getPoz()] = new TokenImage(f.getSrc1());
		else
			f.getPozToken()[f.getPoz()] = new TokenImage(f.getSrc2());

		add_panels_matrix();

		(m.getMatVal())[i][f.getPoz()].setValue(1);

		if (f.getPlayer() == 0) {
			(m.getMatVal())[i][f.getPoz()].setToken(new TokenImage(f.getSrc1()));
			(m.getMatVal())[i][f.getPoz()].setPlayer(0);
			f.getPozToken()[f.getPoz()] = new TokenImage(f.getSrc2());
		} else {
			(m.getMatVal())[i][f.getPoz()].setToken(new TokenImage(f.getSrc2()));
			(m.getMatVal())[i][f.getPoz()].setPlayer(1);
			f.getPozToken()[f.getPoz()] = new TokenImage(f.getSrc1());
		}

		/// Change animationLeft
		f.setTurn_time(0);

		f.setPlayer((f.getPlayer() + 1) % 2);
		for (int h = 0; h < 7; h++)
			f.getTokenPanel().add(f.getPozToken()[i]);

		change_player_turn(f.getPlayer(), f.getTurn_time(), false);

		add_panels_matrix();

		f.getT().restart();

		f.validate();
		f.repaint();

		// Down
		int pozi = i + 1;
		int pozj = f.getPoz();
		int c = 1;
		while (pozi < 6 && c < 4
				&& (m.getMatVal())[pozi][pozj].getPlayer() == (m.getMatVal())[i][f.getPoz()].getPlayer()) {
			pozi++;
			c++;
		}
		if (c == 4) {
			TimerAnimation(0, i, f.getPoz());
			return;
		}

		// Left+right
		pozi = i;
		pozj = f.getPoz() + 1;
		c = 1;
		while (pozj < 7 && c < 4
				&& (m.getMatVal())[pozi][pozj].getPlayer() == (m.getMatVal())[i][f.getPoz()].getPlayer()) {
			pozj++;
			c++;
		}

		if (c == 4) {
			TimerAnimation(1, i, f.getPoz());
			return;
		}

		pozi = i;
		pozj = f.getPoz() - 1;
		while (pozj >= 0 && c < 4
				&& (m.getMatVal())[pozi][pozj].getPlayer() == (m.getMatVal())[i][f.getPoz()].getPlayer()) {
			pozj--;
			c++;
		}

		if (c == 4) {
			TimerAnimation(1, i, f.getPoz());
			return;
		}

		// LD and UR
		pozi = i + 1;
		pozj = f.getPoz() - 1;
		c = 1;
		while (pozj >= 0 && pozi < 6 && c < 4
				&& (m.getMatVal())[pozi][pozj].getPlayer() == (m.getMatVal())[i][f.getPoz()].getPlayer()) {
			pozj--;
			pozi++;
			c++;
		}

		if (c == 4) {
			TimerAnimation(2, i, f.getPoz());
			return;
		}

		pozi = i - 1;
		pozj = f.getPoz() + 1;
		while (pozi >= 0 && pozj < 7 && c < 4
				&& (m.getMatVal())[pozi][pozj].getPlayer() == (m.getMatVal())[i][f.getPoz()].getPlayer()) {
			pozj++;
			pozi--;
			c++;
		}

		if (c == 4) {
			TimerAnimation(2, i, f.getPoz());
			return;
		}

		// LU and DR
		pozi = i - 1;
		pozj = f.getPoz() - 1;
		c = 1;
		while (pozj >= 0 && pozi >= 0 && c < 4
				&& (m.getMatVal())[pozi][pozj].getPlayer() == (m.getMatVal())[i][f.getPoz()].getPlayer()) {
			pozj--;
			pozi--;
			c++;
		}

		if (c == 4) {
			TimerAnimation(3, i, f.getPoz());
			return;
		}

		pozi = i + 1;
		pozj = f.getPoz() + 1;
		while (pozi < 6 && pozj < 7 && c < 4
				&& (m.getMatVal())[pozi][pozj].getPlayer() == (m.getMatVal())[i][f.getPoz()].getPlayer()) {
			pozj++;
			pozi++;
			c++;
		}

		if (c == 4) {
			TimerAnimation(3, i, f.getPoz());
			return;
		}

	}

	public void change_face(int mode) {

		if (f.isStart() == true) {

			remove_panels_matrix();
			f.getPozToken()[f.getPoz()] = new TokenImage(ConstantsGame.SRC_BLANK);

			if (mode == 0 && f.getPoz() < 6)
				f.setPoz(f.getPoz() + 1);
			else if (mode == 1 && f.getPoz() > 0)
				f.setPoz(f.getPoz() - 1);

			if (f.getPlayer() == 0)
				f.getPozToken()[f.getPoz()] = new TokenImage(f.getSrc1());
			else
				f.getPozToken()[f.getPoz()] = new TokenImage(f.getSrc2());

			add_panels_matrix();

			f.validate();
			f.repaint();
		}
	}

	public void TimerAnimation(int dir, int i, int j) {
		f.getT().stop();
		f.setStart(false);
		f.setTurn_time(0);

		String win_token = null;
		if (f.getPlayer() == 0) {
			win_token = f.getSrc2_win();
		} else {
			win_token = f.getSrc1_win();
		}

		System.out.println("DA DA "+win_token);
		change_player_turn((f.getPlayer() + 1) % 2, 3, true);
		if (dir == 0) {
			int pozi = i;
			int pozj = j;
			int c = 0;
			while (pozi < 6 && c < 4 && (m.getMatVal())[pozi][pozj].getPlayer() == (m.getMatVal())[i][j].getPlayer()) {
				(m.getMatVal())[pozi][pozj].setToken(new TokenImage(win_token));
				pozi++;
				c++;
			}
		} else if (dir == 1) {
			int pozi = i;
			int pozj = j;
			int c = 0;
			while (pozj < 7 && c < 4 && (m.getMatVal())[pozi][pozj].getPlayer() == (m.getMatVal())[i][j].getPlayer()) {
				(m.getMatVal())[pozi][pozj].setToken(new TokenImage(win_token));
				pozj++;
				c++;
			}

			pozi = i;
			pozj = j - 1;
			while (pozj >= 0 && c < 4 && (m.getMatVal())[pozi][pozj].getPlayer() == (m.getMatVal())[i][j].getPlayer()) {
				(m.getMatVal())[pozi][pozj].setToken(new TokenImage(win_token));
				pozj--;
				c++;
			}
		} else if (dir == 2) {
			int pozi = i;
			int pozj = j;
			int c = 0;
			while (pozj >= 0 && pozi < 6 && c < 4
					&& (m.getMatVal())[pozi][pozj].getPlayer() == (m.getMatVal())[i][j].getPlayer()) {
				(m.getMatVal())[pozi][pozj].setToken(new TokenImage(win_token));
				pozj--;
				pozi++;
				c++;
			}

			pozi = i - 1;
			pozj = j + 1;
			while (pozi >= 0 && pozj < 7 && c < 4
					&& (m.getMatVal())[pozi][pozj].getPlayer() == (m.getMatVal())[i][j].getPlayer()) {
				(m.getMatVal())[pozi][pozj].setToken(new TokenImage(win_token));
				pozj++;
				pozi--;
				c++;
			}
		} else if (dir == 3) {
			int pozi = i;
			int pozj = j;
			int c = 0;
			while (pozj >= 0 && pozi >= 0 && c < 4
					&& (m.getMatVal())[pozi][pozj].getPlayer() == (m.getMatVal())[i][j].getPlayer()) {
				(m.getMatVal())[pozi][pozj].setToken(new TokenImage(win_token));
				pozj--;
				pozi--;
				c++;
			}

			pozi = i + 1;
			pozj = j + 1;
			while (pozi < 6 && pozj < 7 && c < 4
					&& (m.getMatVal())[pozi][pozj].getPlayer() == (m.getMatVal())[i][j].getPlayer()) {
				(m.getMatVal())[pozi][pozj].setToken(new TokenImage(win_token));
				pozj++;
				pozi++;
				c++;
			}

		}

		remove_panels_matrix();
		add_panels_matrix();
		f.validate();
		f.repaint();

		new java.util.Timer().schedule(new java.util.TimerTask() {
			@Override
			public void run() {
				try {
					f.setPlayer((f.getPlayer() + 1) % 2);
					f.getPozToken()[f.getPoz()] = new TokenImage(ConstantsGame.SRC_BLANK);
					f.setPoz(3);
					f.getPozToken()[f.getPoz()] = new TokenImage(ConstantsGame.ICON);
					end_game();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}, 5000);
	}

	public class KeyAdapter extends AbstractAction {

		char cr;

		public KeyAdapter(char c) {
			cr = c;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (cr == 'r') {
				change_face(0);
			} else if (cr == 'l') {
				change_face(1);
			} else if (cr == 's' && f.isStart() == true) {
				try {
					drop_token();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
			}
		}
	}
}
