package breakbrick;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;


public class BreakBrick extends JFrame implements EnvironmentSet{
	Container contentPane;
	Background background;
	Printer printer;
	
	BreakBrick(){
			setTitle("Bounce Ball");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			contentPane = getContentPane();
			background = new Background();
			printer = new Printer();
			
			background.add(printer);
			contentPane.add(background);
			setSize(MAPWIDTH  ,MAPHEIGHT);
			setVisible(true);
	}

	
	public static void main(String[] args) {
		new BreakBrick();
	}



}
