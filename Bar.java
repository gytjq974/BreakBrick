package breakbrick;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class Bar implements EnvironmentSet{
	Image barImg = new ImageIcon("Image/bar2.png").getImage();  //bar 이미지를 가져온다.
	Point barLocation = new Point(MAPWIDTH / 2 - XBARSIZE  / 2, MAPHEIGHT-(YBARSIZE+80));
	Printer Paint;
	
	Bar(Printer Paint){
		this.Paint = Paint;
	}
	
	public void paintBar(Graphics g){
		g.drawImage(barImg, barLocation.x, barLocation.y, XBARSIZE, YBARSIZE, Paint);
	}
	
	public void moveBar(int keyCode){
		switch(keyCode){
		case KeyEvent.VK_LEFT:
			if(barLocation.x > 0 ){
				barLocation.setLocation(barLocation.x-BARSPEED, barLocation.y);
			}
			break;
			
		case KeyEvent.VK_RIGHT:
			if(barLocation.x < 880 - XBARSIZE){
				barLocation.setLocation(barLocation.x+BARSPEED, barLocation.y);
			}
			break;		
		} // switch	
		
	}

	
}
