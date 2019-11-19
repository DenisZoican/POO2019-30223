import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DrawRect extends JPanel implements MouseListener {
	
	int x;
	int y;
	int height;
	int width;
	public void paintComponent(Graphics g) {
    	super.paintComponent(g);
    		
    	g.setColor(Color.BLUE);
    	
    	g.fillRect(x, y, 50, 50);
    }
	
	
	
	DrawRect(int x,int y,int height,int width)
	{	
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
		this.addMouseListener(this); 
			
	}
	
	public void mousePressed(MouseEvent e) {
		System.out.println("Press");
	}
	 public void mouseReleased(MouseEvent e) {
		 System.out.println("Release");
	 }
	 
	 public void mouseClicked(MouseEvent e) {
		 System.out.println("Click");
	 }



	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println("Enter");
	}



	@Override
	public void mouseExited(MouseEvent e) {
		System.out.println("Exit");
		
	} 
	
}
