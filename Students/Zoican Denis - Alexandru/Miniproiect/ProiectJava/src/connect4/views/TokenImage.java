package connect4.views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * 
 * Panel that contains the image of the token
 */
public class TokenImage extends JPanel{
	
	public TokenImage(String src){
		 ImageIcon img = new ImageIcon(src);
		 JLabel l = new JLabel(img);
		 l.setLocation(0, 0); 
		 this.setBackground(new Color(60, 61, 71));
		 this.setBorder(BorderFactory.createLineBorder(new Color(211, 86, 86), 5));
		 this.setPreferredSize(new Dimension(25,25));
		 this.add(l);
	}

	
	
}
