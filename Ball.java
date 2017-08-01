package breakbrick;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import javax.swing.ImageIcon;

public class Ball implements EnvironmentSet{
	Image ballImg = new ImageIcon("Image/ball2.png").getImage();
	Point ballLocation = new Point((int)Math.round(Math.random()*500 ),400); // º¼ À§Ä¡
	Printer Paint;
	Bar bar;
	int xBallSpeed = BALLSPEED ;
	int yBallSpeed = BALLSPEED ;
	
	Ball(Printer Paint, Bar bar){
		this.Paint = Paint;
		this.bar = bar;
	}
	
	public void paintBall(Graphics g){
		g.drawImage(ballImg, ballLocation.x, ballLocation.y, BALLSIZE, BALLSIZE, Paint);
	}
	
	void moveBall(){
		ballLocation.x += xBallSpeed;
		ballLocation.y += yBallSpeed;
	}

	void isLimitBall(int xLocation, int yLocation){
		if(xLocation > (MAPWIDTH-45)){ xBallSpeed *= -1;}
		if(xLocation < 0){ xBallSpeed *= -1;}
		if(yLocation > (MAPHEIGHT-65)){ ballLocation.y = 0;}
		if(yLocation < 0){ yBallSpeed *= -1;}
	}
	
	void isboundBall(){
		if((bar.barLocation.x <= ballLocation.x) && (bar.barLocation.x + XBARSIZE >= ballLocation.x) 
				&& (ballLocation.y >= bar.barLocation.y) && ballLocation.y <= bar.barLocation.y+ YBARSIZE){
			yBallSpeed *= -1;
		}
	}

	
}
