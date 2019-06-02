import java.applet.AudioClip;
import java.awt.Graphics;

import javax.swing.JApplet;

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
			blip();
			ball.xspeed = Math.abs(ball.xspeed);
			if (counter > 3) {
				score++;
				counter = 0;
			}
			if (panel.isRUPressed) {
				//System.out.println("extra");
				ball.yspeed = 3;
				ball.yspeed = 1.5;
			}
			if (panel.isRDPressed) {
				//System.out.println("extra");
				ball.yspeed = 3;
				ball.yspeed = 4.5;
			}
		}
		if (left.collisionBox.intersects(ball.collisionBox)) {
			blip();
			ball.xspeed = -Math.abs(ball.xspeed);
			if (counter > 3) {
				score++;
				counter = 0;
			}
			if (panel.isLUPressed) {
				//System.out.println("extra");
				ball.yspeed = 3;
				ball.yspeed = 1.5;
			}
			if (panel.isLDPressed) {
				//System.out.println("extra");
				ball.yspeed = 3;
				ball.yspeed = 4.5;
			}
		}
		if (up.collisionBox.intersects(ball.collisionBox)) {
			blip();
			ball.yspeed = Math.abs(ball.yspeed);
			if (counter > 3) {
				score++;
				counter = 0;
			}
			if (panel.isULPressed) {
				//System.out.println("extra");
				ball.xspeed = 3;
				ball.xspeed = 1.5;
			}
			if (panel.isURPressed) {
				//System.out.println("extra");
				ball.xspeed = 3;
				ball.xspeed = 4.5;
			}
		}
		if (down.collisionBox.intersects(ball.collisionBox)) {
			blip();
			ball.yspeed = -Math.abs(ball.yspeed);
			if (counter > 3) {
				score++;
				counter = 0;
			}
			if (panel.isDLPressed) {
				//System.out.println("extra");
				ball.xspeed = 3;
				ball.xspeed = 1.5;
			}
			if (panel.isDRPressed) {
				//System.out.println("extra");
				ball.xspeed = 3;
				ball.xspeed = 4.5;
			}
		}
		if (ball.x <= -20 || ball.x >= 820) {
			GamePanel.currentState = GamePanel.endState;
		} else if (ball.y <= -20 || ball.y >= 820) {
			GamePanel.currentState = GamePanel.endState;
		}
	}

	int getScore() {
		return score;
	}

	private void blip() {
		AudioClip sound = JApplet.newAudioClip(getClass().getResource("blip.wav"));
		sound.play();
	}

}
