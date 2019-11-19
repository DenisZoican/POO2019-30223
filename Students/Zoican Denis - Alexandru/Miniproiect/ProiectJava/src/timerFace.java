import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.swing.*;
import javax.swing.border.Border;
public class timerFace extends JPanel{

	 change_frame ch = new change_frame(this);
	 
	 public int poz = 0;
	 boolean start = false;
	 int player = 0;
	 
	 static String src1 = "face3.png";
	 static String src2 = "face2.png";
	 static String src_blank = "face.png";
	 
	 public static int matVal[][] = {
			 {0,0,0,0,0,0,0},
			 {0,0,0,0,0,0,0},
			 {0,0,0,0,0,0,0},
			 {0,0,0,0,0,0,0},
			 {0,0,0,0,0,0,0},
			 {0,0,0,0,0,0,0},
			 {0,0,0,0,0,0,0}
	 };
	 
	 
	 public static DrawImage pozToken[]= {
			 new DrawImage(src1),
			 new DrawImage(src_blank),
			 new DrawImage(src_blank),
			 new DrawImage(src_blank),
			 new DrawImage(src_blank),
			 new DrawImage(src_blank),
			 new DrawImage(src_blank),
	 };
	 
	 public static DrawImage matToken[][] = {
			 {new DrawImage(src_blank),new DrawImage(src_blank),new DrawImage(src_blank),new DrawImage(src_blank),new DrawImage(src_blank),new DrawImage(src_blank),new DrawImage(src_blank)},
			 {new DrawImage(src_blank),new DrawImage(src_blank),new DrawImage(src_blank),new DrawImage(src_blank),new DrawImage(src_blank),new DrawImage(src_blank),new DrawImage(src_blank)},
			 {new DrawImage(src_blank),new DrawImage(src_blank),new DrawImage(src_blank),new DrawImage(src_blank),new DrawImage(src_blank),new DrawImage(src_blank),new DrawImage(src_blank)},
			 {new DrawImage(src_blank),new DrawImage(src_blank),new DrawImage(src_blank),new DrawImage(src_blank),new DrawImage(src_blank),new DrawImage(src_blank),new DrawImage(src_blank)},
			 {new DrawImage(src_blank),new DrawImage(src_blank),new DrawImage(src_blank),new DrawImage(src_blank),new DrawImage(src_blank),new DrawImage(src_blank),new DrawImage(src_blank)},
			 {new DrawImage(src_blank),new DrawImage(src_blank),new DrawImage(src_blank),new DrawImage(src_blank),new DrawImage(src_blank),new DrawImage(src_blank),new DrawImage(src_blank)}
	 };
	 
	 
	 static JPanel tokenPanel = new JPanel();
	 static JFrame f = new JFrame("Test");
	 static JPanel matrixPanel = new JPanel();
	 static JPanel historyPanel = new JPanel();
	 static JPanel middlePanel = new JPanel();
	 static JPanel leftPanel = new JPanel();
	 static JPanel rightPanel = new JPanel();
	 static JPanel totalPanel = new JPanel();
	 static player_label player1_select = new player_label(1);
	 static player_label player2_select = new player_label(2);
	 public JPanel start_button = new make_button("Start",this);

	 public int turn_time = 0;

	 
	 public timer_drop turn_timer = new timer_drop(this);
	 
	 public Timer t = null;

	
	 timerFace() throws ClassNotFoundException, SQLException{
		 
		 connection ex_conn = new connection();
		 Connection conn = ex_conn.getConnection();
		 String query = "SELECT * FROM history";
		 Statement st = conn.createStatement();
		    
		 rightPanel.setLayout(new GridLayout(0,1));
		 String date_prev = null;
		 ResultSet rs = st.executeQuery(query);
		 int count_history = 0;
		 while (rs.next()==true && count_history<=6)
		 {
			 count_history++;
		        if(date_prev == null || date_prev.compareTo(rs.getString("date_game"))!=0)
		        		{
		        			date_prev = rs.getString("date_game");
		        			System.out.println(date_prev);
		        			rightPanel.add(new history_date(date_prev),0);
		        		}
		        rightPanel.add(new history_label(rs.getInt("winner"),rs.getString("player1"),rs.getString("player2"),rs.getInt("duration")),0);
		 }
		 st.close();
		 
		 
		 totalPanel.setPreferredSize(new Dimension(1800,900));
		 leftPanel.setPreferredSize(new Dimension(250,900));
		 rightPanel.setPreferredSize(new Dimension(400,900));
		 middlePanel.setPreferredSize(new Dimension(860, 900));
		 
		 ch.init_panels();
		 
		 leftPanel.add(player1_select);
		 leftPanel.add(player2_select);
		 leftPanel.add(start_button);
		 
		 ch.add_panels_matrix();
		 
		 f.add(totalPanel);
		 f.setVisible(true);
				
		 middlePanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("D"), "right");
		 middlePanel.getActionMap().put("right", new keyAdapter(this,'r'));
		 
		 middlePanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("A"), "left");
		 middlePanel.getActionMap().put("left", new keyAdapter(this,'l'));
		 
		 middlePanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("SPACE"), "space");
		 middlePanel.getActionMap().put("space", new keyAdapter(this,'s'));
		 
		 f.validate();
		 f.repaint();
	 }
 
	 
	 public void drop_token() throws ClassNotFoundException, SQLException, ParseException
	 {
		 if(matVal[0][poz]==0 && start==true)
		 {
		 ch.remove_panels_matrix();
		 int i = 0;
		 while(matVal[i][poz]==0 && i<6)
		 {
			 i++;
		 }
		 matVal[i-1][poz] = 1;
		 
		 if(player == 0)
		 {
			 matToken[i-1][poz] = new DrawImage(src1);
			 pozToken[poz] = new DrawImage(src2);
		 }
		 else
		 {
			 matToken[i-1][poz] = new DrawImage(src2);
			 pozToken[poz] = new DrawImage(src1);
		 }
		 
		 player =(player+1)%2;
		 
		 for(int h=0;h<7;h++)
				tokenPanel.add(pozToken[i]);
		 
		 ///Change animationLeft
		 turn_time = 0;
		 ch.change_player_turn(player, turn_time);
		 
		 ch.add_panels_matrix();
		 
		 t.restart();
			 
		 f.validate();
		 f.repaint();
		 
		 } else {
			 ///End of the game
			 start = false;
			 turn_time = 0;
			 
			 ///Reset matrix with values
			 for(int i=0;i<6;i++)
					for(int j=0;j<7;j++)
						{
							matToken[i][j] = new DrawImage(src_blank);
							matVal[i][j] = 0;
						}
			 
			 ///Remove left panel to insert inputText
			 leftPanel.removeAll();
			 for (Component c : player1_select.getComponents()) {
				    if (c instanceof JTextField) { 
				       ((JTextField)c).setText("");
				    }
				}
			 
			 for (Component c : player2_select.getComponents()) {
				    if (c instanceof JTextField) { 
				       ((JTextField)c).setText("");
				    }
				}
			 
			 leftPanel.add(player1_select);
			 leftPanel.add(player2_select);
			 leftPanel.add(start_button);
			 
			 ///Send information to database
			 rightPanel.removeAll();
			 SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");
			 Date now = new Date();
			 String strDate = sdfDate.format(now);
			    
			 connection ex_conn = new connection();
			 Connection conn = ex_conn.getConnection();
			 String query = String.format("insert into history(winner,player1,player2,date_game,duration) values (%d,'%s','%s','%s',%d);",player,"Denis","Marius",strDate,23);
			 System.out.println(query);
			 Statement st = conn.createStatement();
			    
			 st.executeUpdate(query);
			 
			 query = "SELECT * FROM history";
			 st = conn.createStatement();
			    
			 String date_prev = null;
			 ResultSet rs = st.executeQuery(query);
			 while (rs.next()==true)
			 {
			        if(date_prev == null || date_prev.compareTo(rs.getString("date_game"))!=0)
			        		{
			        			date_prev = rs.getString("date_game");
			        			rightPanel.add(new history_date(date_prev));
			        		}
			        rightPanel.add(new history_label(rs.getInt("winner"),rs.getString("player1"),rs.getString("player2"),rs.getInt("duration")));
			 }
			 st.close();
			 
			 ///Remove and add middlePanel
			 ch.remove_panels_matrix();
			 ch.add_panels_matrix();
			 f.validate();
			 f.repaint();
			 
			 ///Stop left animation
			 t.stop();
		 }
	 }
	 
	 public void change_face(int mode){
			
		 if(start==true)
			{
			 
			 ch.remove_panels_matrix();
			 pozToken[poz] = new DrawImage(src_blank);
			 
			 if(mode==0 && poz<6)
				 poz++;
			 else if(mode==1 && poz>0)
				 poz--;

			 if(player==0)
			 pozToken[poz] = new DrawImage(src1);
			 else
			 pozToken[poz] = new DrawImage(src2);
			
			ch.add_panels_matrix();
				 
			f.validate();
			f.repaint();
			}
		}
	 
	 public static void main() throws SQLException, ClassNotFoundException{
		   
	 f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 f.setSize(1800,900);
	 f.setResizable(false);
	 
	 }
}