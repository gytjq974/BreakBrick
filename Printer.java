package breakbrick;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Printer extends JPanel implements ActionListener, EnvironmentSet{
	int ballCeil = 10; //공의 최대개수
	int ballNumber=0; // 공의 번호
	int brickCeil = 10; //공의 최대개수
	int brickNumber=0; // 공의 번호
	
	Ball[] ball = new Ball[ballCeil];
	Bar bar;
	Brick[] brick = new Brick[ballCeil];
	Timer timer;
	
	Printer(){
		timer = new Timer(TIMEDELAY,this);
		this.setOpaque(false); // 판넬을 불투명하게 한다.
		this.setBounds(0, 0, MAPWIDTH, MAPHEIGHT);
		this.setLayout(null);
		this.addKeyListener(new BarKeyListener());
		
		addBar();
		addBall(ballNumber);
		addBrick();

		timer.start();
		
		this.setFocusable(true);
		this.requestFocus();
	}// BallPaint(Constructor) end
	

	public void addBall(int i){
		ball[i] = new Ball(this, bar);
	}// addBall end
	
	public void addBar(){
		bar = new Bar(this);
	}// addBar end

	public void addBrick(){
		for(brickNumber = 0 ; brickNumber < brickCeil; brickNumber++){
			brick[brickNumber] = new Brick(this, ball[ballNumber], new Point(brickNumber*XBRICKSIZE, 50));
		}
	}// addBall end
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		ball[ballNumber].paintBall(g);
		bar.paintBar(g);
		for(brickNumber = 0 ; brickNumber < brickCeil; brickNumber++){
			brick[brickNumber].paintBrick(g);
		}
	}//paintComponent end
	
	@Override
	public void actionPerformed(ActionEvent e) {
		ball[ballNumber].moveBall();
		ball[ballNumber].isLimitBall(ball[ballNumber].ballLocation.x, ball[ballNumber].ballLocation.y);
		ball[ballNumber].isboundBall();
		for(brickNumber = 0 ; brickNumber < brickCeil; brickNumber++){
			brick[brickNumber].breakBrick();
		}
		repaint();
	} // actionPerformed end

	class BarKeyListener extends KeyAdapter{
		@Override
		public void keyPressed(KeyEvent e) {
			bar.moveBar(e.getKeyCode());
			repaint();
		}// keyPressed
	}// BarKeyListener
}// Class end
