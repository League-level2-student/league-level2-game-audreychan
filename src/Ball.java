import java.awt.Color;
import java.awt.Graphics;

public class Ball extends GameObject{

	int xspeed;
	int yspeed;
	
	public Ball(int x, int y, int width, int height) {
		super(x, y, width, height);
		xspeed = 5;
		yspeed = 5;
	}
	
	void draw(Graphics g) {
		g.setColor(Color.WHITE);
		g.drawOval(x, y, width, height);
	}
	
	void update() {
		super.update();
	}
	
}
