
import java.awt.*;
import java.awt.event.*;
import java.util.TimerTask;

import javax.swing.*;

public class DragBallPanel extends JPanel implements MouseListener, MouseMotionListener, ActionListener {

	private boolean change_b;
	private Timer timer;
	private static final int BALL_DIAMETER = 40;

	private int _ballX = 50;
	private int _ballY = 50;

	private int _dragFromX = 0;
	private int _dragFromY = 0;

	private JPanel context = this;

	private JButton c_button;

	private boolean _canDrag = false;

	public DragBallPanel() {
		setPreferredSize(new Dimension(300, 300));
		setBackground(Color.blue);
		setForeground(Color.yellow);

		this.addMouseListener(this);
		this.addMouseMotionListener(this);

		c_button = new JButton("Drag");
		c_button.addActionListener(this);

		timer = new Timer(1000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				_ballX = (int) (Math.random() * 200);
				_ballY = (int) (Math.random() * 200);
				context.repaint();
			}
		});

		this.add(c_button);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.fillOval(_ballX, _ballY, BALL_DIAMETER, BALL_DIAMETER);
		g.drawString("x:" + _ballX + " y:" + _ballY, 10, 20);
	}

	public void mousePressed(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();

		if (x >= _ballX && x <= (_ballX + BALL_DIAMETER) && y >= _ballY && y <= (_ballY + BALL_DIAMETER)) {
			if (c_button.getText() == "Rand") {
				timer.start();
			} else {
				_canDrag = true;
				_dragFromX = x - _ballX;
				_dragFromY = y - _ballY;
			}
		} else {
			timer.stop();
			_canDrag = false;
		}

	}

	public void mouseDragged(MouseEvent e) {
		if (_canDrag) {
			_ballX = e.getX() - _dragFromX;
			_ballY = e.getY() - _dragFromY;

			_ballX = Math.max(_ballX, 0);
			_ballX = Math.min(_ballX, getWidth() - BALL_DIAMETER);

			_ballY = Math.max(_ballY, 0);
			_ballY = Math.min(_ballY, getHeight() - BALL_DIAMETER);

			this.repaint();
		}
	}

	public void mouseExited(MouseEvent e) {
		_canDrag = false;
	}

	public void mouseMoved(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseClicked(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	/// Button click
	@Override
	public void actionPerformed(ActionEvent e) {
		if (c_button.getText() == "Drag") {
			c_button.setText("Rand");
		} else {
			timer.stop();
			c_button.setText("Drag");
		}
	}
}