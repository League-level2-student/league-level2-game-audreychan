import java.awt.Graphics;

public class Manager {
	
	Paddle right;
	Paddle left;
	Paddle up;
	Paddle down;
	Ball ball;
	int score;
	
	public Manager(Paddle r, Paddle l, Paddle u, Paddle d, Ball b) {
		right = r;
		left = l;
		up = u;
		down = d;
		ball = b;
	}
	
	void update() {
		right.update();
		left.update();
		up.update();
		down.update();
		ball.update();
	}
	
	void draw(Graphics g) {
		right.draw(g);
		left.draw(g);
		up.draw(g);
		down.draw(g);
		ball.draw(g);
	}
	
	void checkCollision() {
		if(right.collisionBox.intersects(ball.collisionBox)) {
			ball.xspeed = -ball.xspeed;
			score ++;
		}
		if(left.collisionBox.intersects(ball.collisionBox)) {
			ball.xspeed = -ball.xspeed;
			score ++;
		}
		if(up.collisionBox.intersects(ball.collisionBox)) {
			ball.yspeed = -ball.yspeed;
			score ++;
		}
		if(down.collisionBox.intersects(ball.collisionBox)) {
			ball.yspeed = -ball.yspeed;
			score ++;
		}
	}
	
	int getScore() {
		return score;
	}
	
}
