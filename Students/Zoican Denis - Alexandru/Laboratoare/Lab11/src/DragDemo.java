import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class DragDemo {

	public static void main(String[] args) {
		JFrame window = new JFrame();
		window.setTitle("Drag Demo");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setContentPane(new DragBallPanel());
		window.pack();
		window.show();
	}

}