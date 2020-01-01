package connect4.views;

import connect4.models.NodeMatrix;
import connect4.models.Point;

import connect4.controllers.MainController.KeyAdapter;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.LinkedList;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import connect4.controllers.ChangeFrame;
import connect4.controllers.ConnectionSQL;
import connect4.controllers.TimerDrop;

public class MainFrame extends JFrame {

	private int poz = 3;
	private boolean start = false;
	private int player = 0;

	private LinkedList<JPanel> listThisGame;


	private TokenImage pozToken[] = { new TokenImage(ConstantsGame.SRC_BLANK),
			new TokenImage(ConstantsGame.SRC_BLANK), new TokenImage(ConstantsGame.SRC_BLANK),
			new TokenImage(ConstantsGame.ICON), new TokenImage(ConstantsGame.SRC_BLANK),
			new TokenImage(ConstantsGame.SRC_BLANK), new TokenImage(ConstantsGame.SRC_BLANK) };

	private JPanel tokenPanel;
	private JPanel rightSQLHistory;
	private JPanel rightThisGameAll;
	private JPanel rightThisGame;
	private JPanel thisGamePanel;
	private JPanel matrixPanel;
	private JPanel historyPanel;
	private JPanel middlePanel;
	private JPanel leftPanel;
	private JPanel rightPanel;
	private JPanel totalPanel;
	private PlayerLabel player1_select;
	private String player1_string;
	private PlayerLabel player2_select;
	private String player2_string;
	private JPanel startButton;

	private int turn_time = 0;

	private Timer t = null;

	private String src1;

	private String src2;

	private String src2_win;

	private String src1_win;


	public MainFrame() throws ClassNotFoundException, SQLException {

		setStartButton(new Button("Start", this));
		setListThisGame(new LinkedList<JPanel>());
		setTokenPanel(new JPanel());
		setRightSQLHistory(new JPanel());
		setRightThisGameAll(new JPanel());
		setRightThisGame(new JPanel());
		setThisGamePanel(new HistoryDate("This game"));
		setMatrixPanel(new JPanel());
		historyPanel = new JPanel();
		setMiddlePanel(new JPanel());
		setLeftPanel(new JPanel());
		setRightPanel(new JPanel());
		setTotalPanel(new JPanel());
		setPlayer1_select(new PlayerLabel(1));
		setPlayer2_select(new PlayerLabel(2));
		setStartButton(new Button("Start", this));
		
		Color basic = new Color(249, 213, 187);
		this.setBackground(basic);
		leftPanel.setBackground(basic);
		middlePanel.setBackground(basic);
		rightPanel.setBackground(basic);
		tokenPanel.setBackground(basic);
		matrixPanel.setBackground(basic);
		rightSQLHistory.setBackground(basic);
		rightThisGameAll.setBackground(basic);
		rightThisGame.setBackground(basic);
		totalPanel.setBackground(basic);
		startButton.setBackground(basic);
		
		
		tokenPanel.setLayout(new GridLayout(0, 7));
		tokenPanel.setPreferredSize(new Dimension(7 * 120, 140));
		tokenPanel.setBorder(BorderFactory.createEmptyBorder(40, 0, 0, 0));

		matrixPanel.setLayout(new GridLayout(0, 7));
		matrixPanel.setPreferredSize(new Dimension(7 * 120, 6 * 110));
		matrixPanel.setBorder(BorderFactory.createEmptyBorder(25, 0, 0, 0));

		rightThisGame.setLayout(new GridLayout(11, 1));
	    rightSQLHistory.setLayout(new GridLayout(0, 1));
		rightPanel.setLayout(new GridLayout(0, 1));
		leftPanel.setLayout(new GridLayout(10, 1));

		totalPanel.setPreferredSize(new Dimension(1800, 900));
		leftPanel.setPreferredSize(new Dimension(250, 900));
		rightPanel.setPreferredSize(new Dimension(400, 900));
		rightThisGame.setPreferredSize(new Dimension(400, 500));
		rightThisGameAll.setPreferredSize(new Dimension(400, 900));
		middlePanel.setPreferredSize(new Dimension(860, 900));

		JPanel empty = new JPanel();
		empty.setBackground(new Color(249, 213, 187));

		JPanel empty2 = new JPanel();
		empty2.setBackground(new Color(249, 213, 187));

		JPanel empty3 = new JPanel();
		empty3.setBackground(new Color(249, 213, 187));

		getLeftPanel().add(empty);
		getLeftPanel().add(getPlayer1_select());
		getLeftPanel().add(empty2);
		getLeftPanel().add(getPlayer2_select());
		getLeftPanel().add(empty3);
		getLeftPanel().add(getStartButton());

		this.add(getTotalPanel());
		this.setVisible(true);

		/// Set keyboard inputs
		getMiddlePanel().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("D"), "right");

		getMiddlePanel().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("A"), "left");

		getMiddlePanel().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("SPACE"), "space");

		this.validate();
		this.repaint();
	}
	
	public void setKeyAdapter (KeyAdapter adapterR,KeyAdapter adapterL,KeyAdapter adapterS) {
		getMiddlePanel().getActionMap().put("right", adapterR);
		getMiddlePanel().getActionMap().put("left", adapterL);
		getMiddlePanel().getActionMap().put("space", adapterS);
	}

	
	public void setStartButtonListener(ActionListener a) {
		for(Component c:getStartButton().getComponents()) {
			if(c instanceof JButton) {
				((JButton)c).addActionListener(a); 
			}
		}
	}

	public JPanel getRightSQLHistory() {
		return rightSQLHistory;
	}

	public void setRightSQLHistory(JPanel rightSQLHistory) {
		this.rightSQLHistory = rightSQLHistory;
	}

	public String getPlayer1_string() {
		return player1_string;
	}

	public void setPlayer1_string(String player1_string) {
		this.player1_string = player1_string;
	}

	public PlayerLabel getPlayer1_select() {
		return player1_select;
	}

	public void setPlayer1_select(PlayerLabel player1_select) {
		this.player1_select = player1_select;
	}

	public String getPlayer2_string() {
		return player2_string;
	}

	public void setPlayer2_string(String player2_string) {
		this.player2_string = player2_string;
	}

	public PlayerLabel getPlayer2_select() {
		return player2_select;
	}

	public void setPlayer2_select(PlayerLabel player2_select) {
		this.player2_select = player2_select;
	}

	public boolean isStart() {
		return start;
	}

	public void setStart(boolean start) {
		this.start = start;
	}

	public String getSrc1() {
		return src1;
	}

	public void setSrc1(String src1) {
		this.src1 = src1;
	}

	public String getSrc2() {
		return src2;
	}

	public void setSrc2(String src2) {
		this.src2 = src2;
	}

	public String getSrc2_win() {
		return src2_win;
	}

	public void setSrc2_win(String src2_win) {
		this.src2_win = src2_win;
	}

	public String getSrc1_win() {
		return src1_win;
	}

	public void setSrc1_win(String src1_win) {
		this.src1_win = src1_win;
	}

	public Timer getT() {
		return t;
	}

	public void setT(Timer t) {
		this.t = t;
	}

	public JPanel getLeftPanel() {
		return leftPanel;
	}

	public void setLeftPanel(JPanel leftPanel) {
		this.leftPanel = leftPanel;
	}

	public JPanel getRightPanel() {
		return rightPanel;
	}

	public void setRightPanel(JPanel rightPanel) {
		this.rightPanel = rightPanel;
	}

	public JPanel getTotalPanel() {
		return totalPanel;
	}

	public void setTotalPanel(JPanel totalPanel) {
		this.totalPanel = totalPanel;
	}

	public JPanel getTokenPanel() {
		return tokenPanel;
	}

	public void setTokenPanel(JPanel tokenPanel) {
		this.tokenPanel = tokenPanel;
	}

	public JPanel getMatrixPanel() {
		return matrixPanel;
	}

	public void setMatrixPanel(JPanel matrixPanel) {
		this.matrixPanel = matrixPanel;
	}

	public JPanel getMiddlePanel() {
		return middlePanel;
	}

	public void setMiddlePanel(JPanel middlePanel) {
		this.middlePanel = middlePanel;
	}

	public JPanel getRightThisGame() {
		return rightThisGame;
	}

	public void setRightThisGame(JPanel rightThisGame) {
		this.rightThisGame = rightThisGame;
	}

	public JPanel getRightThisGameAll() {
		return rightThisGameAll;
	}

	public void setRightThisGameAll(JPanel rightThisGameAll) {
		this.rightThisGameAll = rightThisGameAll;
	}

	public JPanel getStartButton() {
		return startButton;
	}

	public void setStartButton(JPanel startButton) {
		this.startButton = startButton;
	}

	public LinkedList<JPanel> getListThisGame() {
		return listThisGame;
	}

	public void setListThisGame(LinkedList<JPanel> listThisGame) {
		this.listThisGame = listThisGame;
	}

	public int getPlayer() {
		return player;
	}

	public void setPlayer(int player) {
		this.player = player;
	}

	public TokenImage[] getPozToken() {
		return pozToken;
	}

	public void setPozToken(TokenImage pozToken[]) {
		this.pozToken = pozToken;
	}

	public int getPoz() {
		return poz;
	}

	public void setPoz(int poz) {
		this.poz = poz;
	}

	public JPanel getThisGamePanel() {
		return thisGamePanel;
	}

	public void setThisGamePanel(JPanel thisGamePanel) {
		this.thisGamePanel = thisGamePanel;
	}

	public int getTurn_time() {
		return turn_time;
	}

	public void setTurn_time(int turn_time) {
		this.turn_time = turn_time;
	}

}
