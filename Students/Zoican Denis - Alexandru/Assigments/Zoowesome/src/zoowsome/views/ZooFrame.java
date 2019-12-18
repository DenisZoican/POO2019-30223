package zoowsome.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import zoowsome.services.factories.animals.Constants.FRAMES;
import zoowsome.views.utilities.FrameStack;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

public abstract class ZooFrame extends JFrame implements ZooFrame_I {

	protected JPanel contentPanel;
	protected JPanel contentPanelTop;
	protected JPanel TotalContentPanel;
	private JFrame f;
	private String timeString;

	public ZooFrame(String title) {
		this.f = this;

		FrameStack.getInstance().push(this);
		setTitle(title);
		setSize(FRAMES.WIDTH, FRAMES.HEIGHT);
		setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPanel = new JPanel();
		contentPanel.setLayout(new GridLayout(0, 1, 5, 5));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setBackground(Color.red);
		JScrollPane js = new JScrollPane(contentPanel);
		add(js);
	}

	public void setBackButtonActionListener(ActionListener a) {

		/*JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		JButton backButton = new JButton("Back");
		buttonPanel.add(backButton);
		this.add(buttonPanel, BorderLayout.NORTH);*/
		
		
		
		
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new GridLayout(1, 2));

		JButton backButton = new JButton("Back");
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		buttonPanel.add(backButton);

		topPanel.add(buttonPanel);
		backButton.addActionListener(a);

		JLabel clock = new JLabel("12:00:00");
		JPanel clockPanel = new JPanel();
		clockPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		clockPanel.add(clock);

		topPanel.add(clockPanel);

		this.add(topPanel,BorderLayout.NORTH);

		clock.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String[] options = { "GMT+0", "GMT+1", "GMT+2", "GMT+3", "GMT+4", "GMT+5", "GMT+6", "GMT+7" };
				String tz = (String) JOptionPane.showInputDialog(f, "Choose the timezone",
						"What timezone would you like", JOptionPane.QUESTION_MESSAGE, null, options, options[2]);
				timeString = tz;
			}
		});

		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					Calendar curr;
					if (timeString != null) {
						TimeZone tz = TimeZone.getTimeZone(timeString);
						curr = Calendar.getInstance(tz);
					} else
						curr = Calendar.getInstance();

					clock.setText(curr.get(Calendar.HOUR_OF_DAY) + ":" + curr.get(Calendar.MINUTE) + ":"
							+ curr.get(Calendar.SECOND));
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		t1.start();
		
	}

}