package breakbrick;

import java.awt.CardLayout;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Background extends JPanel implements EnvironmentSet{
	Image backgroundImg = new ImageIcon("Image/background.jpg").getImage();

	Background(){
		this.setLayout(null);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(backgroundImg, 0, 0, MAPWIDTH, MAPHEIGHT, this); // width(800), getHeight(700)

	}
}
