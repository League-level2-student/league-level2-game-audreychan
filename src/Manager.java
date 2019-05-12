import java.awt.Graphics;

public class Manager {

	Paddle right;
	Paddle left;
	Paddle up;
	Paddle down;
	Ball ball;
	int score;
	GamePanel panel;
	int counter = 0;

	public Manager(Paddle r, Paddle l, Paddle u, Paddle d, Ball b, GamePanel p) {
		right = r;
		left = l;
		up = u;
		down = d;
		ball = b;
		panel = p;
	}

	void update() {
		right.update();
		left.update();
		up.update();
		down.update();
		ball.update();
		checkCollision();
		counter++;
	}

	void draw(Graphics g) {
		right.draw(g);
		left.draw(g);
		up.draw(g);
		down.draw(g);
		ball.draw(g);
	}

	void checkCollision() {
		if (right.collisionBox.intersects(ball.collisionBox)) {
			ball.xspeed = Math.abs(ball.xspeed);
			if (counter > 3) {
				score++;
				counter = 0;
			}
			if (panel.isRUPressed) {
				System.out.println("extra");
				ball.yspeed = 3;
				ball.yspeed = 1.5;
			}
			if (panel.isSPressed) {
				System.out.println("extra");
				ball.yspeed = 3;
				ball.yspeed = 4.5;
			}
		}
		if (left.collisionBox.intersects(ball.collisionBox)) {
			ball.xspeed = -Math.abs(ball.xspeed);
			if (counter > 3) {
				score++;
				counter = 0;
			}
			if (panel.isUpPressed) {
				System.out.println("extra");
				ball.yspeed = 3;
				ball.yspeed = 1.5;
			}
			if (panel.isDownPressed) {
				System.out.println("extra");
				ball.yspeed = 3;
				ball.yspeed = 4.5;
			}
		}
		if (up.collisionBox.intersects(ball.collisionBox)) {
			ball.yspeed = Math.abs(ball.yspeed);
			if (counter > 3) {
				score++;
				counter = 0;
			}
			if (panel.isAPressed) {
				System.out.println("extra");
				ball.xspeed = 3;
				ball.xspeed = 1.5;
			}
			if (panel.isDPressed) {
				System.out.println("extra");
				ball.xspeed = 3;
				ball.xspeed = 4.5;
			}
		}
		if (down.collisionBox.intersects(ball.collisionBox)) {
			ball.yspeed = -Math.abs(ball.yspeed);
			if (counter > 3) {
				score++;
				counter = 0;
			}
			if (panel.isLeftPressed) {
				System.out.println("extra");
				ball.xspeed = 3;
				ball.xspeed = 1.5;
			}
			if (panel.isRightPressed) {
				System.out.println("extra");
				ball.xspeed = 3;
				ball.xspeed = 4.5;
			}
		}
		if (ball.x <= -20 || ball.x >= 820) {
			panel.currentState = panel.endState;
		} else if (ball.y <= -20 || ball.y >= 820) {
			panel.currentState = panel.endState;
		}
	}

	int getScore() {
		return score;
	}

}
