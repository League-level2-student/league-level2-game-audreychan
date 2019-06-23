  import java.awt.Dimension;

import javax.swing.JFrame;

public class FourPong {
	
	JFrame frame;
	GamePanel panel;
	KeyInput input;
	
	static int length = 800;
	
	public static void main(String[] args) {
		FourPong pong = new FourPong();
		pong.setup();
	}
	
	public FourPong() {
		frame = new JFrame();
		panel = new GamePanel();
		input = new KeyInput(panel);
	}
	
	void setup() {
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addKeyListener(input);
		
		frame.add(panel);
		
		frame.getContentPane().setPreferredSize(new Dimension(length, length));

        frame.pack();
	}
	
}
