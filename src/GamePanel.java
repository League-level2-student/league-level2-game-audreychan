import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements KeyListener {

	Font titleFont;
	Font textFont;
	
	final int titleState = 0;
	final int gameState = 1;
	final int endState = 2;
	final int icState = 3; //ic stands for instruction/credits
	int currentState = gameState;
	
	Paddle right = new Paddle(10, 375, 10, 50);
	Paddle left = new Paddle(FourPong.length - 10, 375, 10, 50);
	Paddle up = new Paddle(375, 10, 50, 10);
	Paddle down = new Paddle(375, FourPong.length - 10, 50, 10);
	Ball ball = new Ball(388, 388, 15, 15);
	Manager manager = new Manager(right, left, up, down, ball);
	
	boolean isWPressed = false;
	boolean isSPressed = false;
	boolean isAPressed = false;
	boolean isDPressed = false;
	boolean isUpPressed = false;
	boolean isDownPressed = false;
	boolean isLeftPressed = false;
	boolean isRightPressed = false;
	
	boolean isPaused = false;
	
	public GamePanel() {
		titleFont = new Font("Arial", Font.PLAIN, 48);
		textFont = new Font("Arial", Font.PLAIN, 24);
	}
	
	void updateGameState() {
		manager.update();
	}
	
	void drawTitleState(Graphics g) {
		g.setColor(new Color(0, 10, 45));
		g.fillRect(0, 0, FourPong.length, FourPong.length);
		
		g.setColor(Color.white);
		g.setFont(textFont);
		g.drawString("Welcome to", 325, 40);
		
		g.setFont(titleFont);
		g.drawString("4 Way Pong", 250, 100);
	}
	
	void drawGameState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, FourPong.length, FourPong.length);
	}
	
	void drawEndState(Graphics g) {
		g.setColor(new Color(33, 0, 0));
		g.fillRect(0, 0, FourPong.length, FourPong.length);
	}
	
	void drawICState(Graphics g) {
		g.setColor(new Color(0, 33, 0));
		g.fillRect(0, 0, FourPong.length, FourPong.length);
	}

	@Override
	public void paintComponent(Graphics g){
		if(currentState == titleState) {
			drawTitleState(g);
		}
		else if(currentState == gameState) {
			drawGameState(g);
		}
		else if(currentState == endState) {
			drawEndState(g);
		}
		else if(currentState == icState) {
			drawICState(g);
		}
	}
	
	void move() {
		if(isWPressed) {
			right.y -= right.speed;
		}
		if(isSPressed) {
			right.y += right.speed;
		}
		if(isAPressed) {
			up.x -= up.speed;
		}
		if(isDPressed) {
			up.x += up.speed;
		}
		if(isUpPressed) {
			left.y -= left.speed;
		}
		if(isDownPressed) {
			left.y += left.speed;
		}
		if(isLeftPressed) {
			down.x -= down.speed;
		}
		if(isRightPressed) {
			down.x += down.speed;
		}
	}

	
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
