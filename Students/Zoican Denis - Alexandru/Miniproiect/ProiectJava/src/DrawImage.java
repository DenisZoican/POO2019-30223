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

public class DrawImage extends JPanel{
	
	JLabel l = null;


	DrawImage(String src){
		 ImageIcon img = new ImageIcon(src);
		 l = new JLabel(img);
		 l.setLocation(0, 0);
		 int a = (int)Math.floor(Math.random()*10)%3;
		 if(a==0)
		 this.setBackground(Color.red);
		 if(a==1)
			 this.setBackground(Color.blue);
		 if(a==2)
			 this.setBackground(Color.yellow);
		 this.setPreferredSize(new Dimension(50,50)); //Why doesn't work?
		 this.add(l);
	}

	
	
}
