import java.awt.Color;
import java.awt.Graphics;

public class Ball extends GameObject{

	
	double xspeed;
	double yspeed;
	
	public Ball(int x, int y, int width, int height) {
		super(x, y, width, height);
		xspeed = 3;
		yspeed = 3;
	}
	
	void draw(Graphics g) {
		g.setColor(Color.WHITE);
		g.drawOval(x, y, width, height);
	}
	
	void update() {
		super.update();
	}
	
//	double getSpeed(String s) {
//		if(s.equals("x")) {
//			return xspeed;
//		}
//		else if(s.equals("y")) {
//			return yspeed;
//		}
//		else {
//			return 0;
//		}
//	}
	
}
