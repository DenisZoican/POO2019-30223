import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class MainFrame extends JFrame {
	private JPanel top_panel;
	private JPanel mid_panel;
	private JPanel bot_panel;

	private JLabel conv_text;
	private JComboBox from_c;
	private JLabel conv_img;
	private JComboBox to_c;
	private JTextField img;

	private JPanel suma;
	private JPanel suma1;
	private JLabel suma_text;
	private JTextField suma_input;
	private JLabel suma_simbol;

	private JPanel rez;
	private JPanel rez1;
	private JLabel rez_text;
	private JLabel rez_input;
	
	private JButton button_conv;

	private String to_c_string;
	
	private double from_d;
	private double to_d;
	
	public MainFrame() {
		top_panel = new JPanel();
		mid_panel = new JPanel();
		bot_panel = new JPanel();

		from_d = 1;
		to_d = 1;
		to_c_string = "RON";
		top_panel.setBackground(new Color(196, 237, 190));
		mid_panel.setBackground(new Color(196, 237, 190));
		bot_panel.setBackground(new Color(50, 168, 82));

		// Top_panel
		conv_text = new JLabel("1 RON = 1 RON");

		Font font1 = new Font("SansSerif", Font.BOLD, 40);

		conv_text.setForeground(new Color(69, 69, 69));

		conv_text.setBorder(new EmptyBorder(25, 25, 25, 25));
		conv_text.setFont(font1);

		top_panel.setLayout(new FlowLayout());
		top_panel.add(conv_text);

		/// mid pane;

		String[] mon_strings = {"RON - Leu Romanesc","USD-DolLar", "EUR-Euro", "LEM-Leu Moldovenesc", "DIN-Dinar", "RUB-Rubla Ruseasca","BIT-Bitcoin" };
		from_c = new JComboBox(mon_strings);
		conv_img = new JLabel(">>");
		to_c = new JComboBox(mon_strings);
		
		button_conv = new JButton("Convert");
		
		Font font2 = new Font("SansSerif", Font.BOLD, 80);
		conv_img.setFont(font2);

		mid_panel.add(from_c);
		mid_panel.add(to_c);
		mid_panel.add(button_conv);
		mid_panel.add(conv_img);

		SpringLayout slPanel = new SpringLayout();
		slPanel.putConstraint(SpringLayout.NORTH, from_c, 55, SpringLayout.NORTH, mid_panel);
		slPanel.putConstraint(SpringLayout.WEST, from_c, 25, SpringLayout.WEST, mid_panel);

		slPanel.putConstraint(SpringLayout.NORTH, to_c, 55, SpringLayout.NORTH, mid_panel);
		slPanel.putConstraint(SpringLayout.WEST, to_c, 320, SpringLayout.WEST, mid_panel);

		slPanel.putConstraint(SpringLayout.NORTH, conv_img, 15, SpringLayout.NORTH, mid_panel);
		slPanel.putConstraint(SpringLayout.WEST, conv_img, 205, SpringLayout.WEST, mid_panel);

		slPanel.putConstraint(SpringLayout.NORTH, button_conv, 105, SpringLayout.NORTH, mid_panel);
		slPanel.putConstraint(SpringLayout.WEST, button_conv, 205, SpringLayout.WEST, mid_panel);
		
		mid_panel.setLayout(slPanel);

		// bot_panel
		Font font3 = new Font("SansSerif", Font.BOLD, 25);
		suma = new JPanel();
		suma_text = new JLabel("Suma");
		suma_text.setFont(font3);

		Font font4 = new Font("SansSerif", Font.BOLD, 15);
		suma_input = new JTextField();
		suma_input.setPreferredSize(new Dimension(100, 35));
		suma_input.setFont(font4);
		suma_input.setHorizontalAlignment(SwingConstants.CENTER);
		suma_text.setBorder(new EmptyBorder(15, 15, 15, 15));

		suma_simbol = new JLabel("RON");
		suma_simbol.setFont(font3);
		suma_simbol.setBorder(new EmptyBorder(15, 15, 15, 15));

		

		suma1 = new JPanel();
		suma1.add(suma_text);
		suma1.add(suma_input);
		suma1.add(suma_simbol);
		
		rez = new JPanel();
		
		rez_text = new JLabel("Rezultat");
		rez_text.setFont(font3);

		rez_input = new JLabel("0.00");
		rez_input.setFont(font3);
		rez_input.setPreferredSize(new Dimension(300, 35));
		rez_text.setBorder(new EmptyBorder(15, 15, 15, 15));


		rez1 = new JPanel();
		rez1.add(rez_text);
		rez1.add(rez_input);
		
		suma.setLayout(new FlowLayout());
		rez.setLayout(new FlowLayout());
		
		suma.add(suma1);
		rez.add(rez1);
		
		bot_panel.add(suma);
		bot_panel.add(rez);
		bot_panel.setLayout(new GridLayout(2,0));
		
		this.setLayout(new GridLayout(3, 0));
		this.add(top_panel);
		this.add(mid_panel);
		this.add(bot_panel);

		this.setVisible(true);
		this.setPreferredSize(new Dimension(500, 500));
		this.setTitle("Drag Demo");
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public JLabel getConvText() {
		return conv_text;
	}
	
	public void addFromCListener(ActionListener e) {
		from_c.addActionListener(e);
	}
	
	public JLabel getSumaSimbol () {
		return suma_simbol;
	}
	
	
	public void addToCListener(ActionListener e) {
		to_c.addActionListener(e);
	}
	
	public JComboBox getFromC() {
		return from_c;
	}
	
	public JComboBox getToC() {
		return to_c;
	}
	
	public JTextField getSumaInput() {
		return suma_input;
	}
	
	public JLabel getRezInput() {
		return rez_input;
	}
	
	public String GetToCString() {
		return to_c_string;
	}
	
	public void SetToCString(String s) {
		to_c_string = s;
	}
	
	public void setButtonConv(ActionListener e) {
		button_conv.addActionListener(e);
	}

	public double getFrom_d() {
		return from_d;
	}

	public void setFrom_d(double from_d) {
		this.from_d = from_d;
	}

	public double getTo_d() {
		return to_d;
	}

	public void setTo_d(double to_d) {
		this.to_d = to_d;
	}
}
