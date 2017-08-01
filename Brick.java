package breakbrick;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import javax.swing.ImageIcon;

public class Brick implements EnvironmentSet{
	Image brickImg = new ImageIcon("Image/brick2.png").getImage();
	Point brickLocation;
	Printer Paint;
	Ball ball;
	
	boolean enable = true;
	Brick(Printer Paint, Ball ball, Point brickLocation){
		this.Paint = Paint;
		this.ball = ball;
		this.brickLocation = brickLocation;
	}
	
	public void paintBrick(Graphics g){
		if(enable){
			g.drawImage(brickImg, brickLocation.x, brickLocation.y, XBRICKSIZE, YBRICKSIZE, Paint);
		}
	}
	
	public void breakBrick(){
		if(ball.ballLocation.x >= brickLocation.x && ball.ballLocation.x <= brickLocation.x+XBRICKSIZE
			&& ball.ballLocation.y <= brickLocation.y + YBRICKSIZE && ball.ballLocation.y >= brickLocation.y){
			if(enable){
				ball.yBallSpeed *= -1;
			}
			enable = false;
		}
	}
}
