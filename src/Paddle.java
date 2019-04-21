import java.awt.Color;
import java.awt.Graphics;

public class Paddle extends GameObject{

	int speed;
	
	public Paddle(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 7;
	}
	
	void draw(Graphics g) {
		g.setColor(Color.WHITE);
		g.drawRect(x, y, width, height);
	}
	
	void update() {
		super.update();
	}
	
}
