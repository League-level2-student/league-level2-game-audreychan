import java.awt.Dimension;

import javax.swing.JFrame;

public class FourPong {
	
	JFrame frame;
	GamePanel panel;
	
	static int length = 800;
	
	public static void main(String[] args) {
		FourPong pong = new FourPong();
		pong.setup();
	}
	
	public FourPong() {
		frame = new JFrame();
		panel = new GamePanel();
	}
	
	void setup() {
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addKeyListener(panel);
		
		frame.add(panel);
		
		frame.getContentPane().setPreferredSize(new Dimension(length, length));

        frame.pack();
	}
	
}
