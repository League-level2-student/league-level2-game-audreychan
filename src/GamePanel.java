import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JApplet;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements KeyListener, ActionListener {

	Font titleFont;
	Font textFont;
	Font smallFont;

	Timer timer;

	public static final int titleState = 0;
	public static final int gameState = 1;
	public static final int endState = 2;
	public static final int icState = 3; // ic stands for instruction/credits
	public static final int settingState = 4;
	public static int currentState = titleState;
	
	Paddle right = new Paddle(10, 350, 10, 100);
	Paddle left = new Paddle(FourPong.length - 20, 350, 10, 100);
	Paddle up = new Paddle(350, 10, 100, 10);
	Paddle down = new Paddle(350, FourPong.length - 20, 100, 10);
	Ball ball = new Ball(388, 388, 15, 15);
	Manager manager = new Manager(right, left, up, down, ball, this);

	boolean isRUPressed = false;//Right Paddle Up Key
	boolean isRDPressed = false;//Right Down
	boolean isULPressed = false;
	boolean isURPressed = false;
	boolean isLUPressed = false;
	boolean isLDPressed = false;
	boolean isDLPressed = false;
	boolean isDRPressed = false;

	boolean isPaused = false;
	
	String pauseText;
	
//	int changeKey;
//	int ru = 87; //right up key - default: W
//	int rd = 83; //right down - default: S
	
	KeyRebind rebind;

	public GamePanel() {
		titleFont = new Font("Arial", Font.PLAIN, 48);
		textFont = new Font("Arial", Font.PLAIN, 24);
		smallFont = new Font("Arial", Font.PLAIN, 16);
		timer = new Timer(1000 / 60, this);
		rebind = new KeyRebind();
		timer.start();
	}

	void updateGameState() {
		manager.update();
		ball();
		move();
	}

	void drawTitleState(Graphics g) {
		g.setColor(new Color(0, 10, 45));
		g.fillRect(0, 0, FourPong.length, FourPong.length);

		g.setColor(Color.white);
		g.setFont(textFont);
		g.drawString("Welcome to", 325, 40);
		g.drawString("Press SPACE to start.", 270, 270);
		g.drawString("Press B to get instructions.", 250, 300);
		g.drawString("Press N to rebind keys.", 260, 330);
		g.drawString("Warning: The keys may stop working.", 200, 400);

		g.setFont(titleFont);
		g.drawString("4 Way Pong", 250, 100);
	}

	void drawGameState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, FourPong.length, FourPong.length);

		g.setColor(Color.white);
		g.setFont(textFont);
		g.drawString("Score: " + manager.score, 20, 40);
		
		g.setFont(smallFont);
		if(isPaused) {
			pauseText = "Press SPACE to unpause";
			g.drawString("Press B to get instructions", 600, 66);
		} else {
			pauseText = "Press SPACE to pause";
		}
		g.drawString(pauseText, 600, 40);

		manager.draw(g);
	}

	void drawEndState(Graphics g) {
		g.setColor(new Color(33, 0, 0));
		g.fillRect(0, 0, FourPong.length, FourPong.length);

		g.setColor(Color.white);
		g.setFont(titleFont);
		g.drawString("Game Over!", 255, 100);

		g.setFont(textFont);
		g.drawString("Press SPACE to play again.", 245, 400);
		g.drawString("Press B to get instructions.", 250, 430);

		if (manager.score == 0) {
			g.drawString("You got no points.", 290, 270);
		} else if (manager.score == 1) {
			g.drawString("You got 1 point.", 300, 270);
		} else {
			g.drawString("You got " + manager.score + " points.", 300 - (scoreDigit() * 5), 270);
		}
	}

	void drawICState(Graphics g) {
		g.setColor(new Color(0, 33, 0));
		g.fillRect(0, 0, FourPong.length, FourPong.length);

		g.setColor(Color.white);
		g.setFont(titleFont);
		g.drawString("Keys", 40, 74);
		g.drawString("Credits", 440, 74);

		g.setFont(textFont);
		g.drawString("SPACE: Start and Pause game", 40, 128);
		g.drawString("V: End game early", 40, 162);
		g.drawString("B: Return to start", 40, 196);
		g.drawString("N: Rebind keys", 40, 230);
		g.drawString(rebind.labels[2].getText().toUpperCase() + " & " + rebind.labels[3].getText().toUpperCase() + ": Top paddle", 40, 264);
		g.drawString(rebind.labels[4].getText().toUpperCase() + " & " + rebind.labels[5].getText().toUpperCase() + ": Left paddle", 40, 298);
		g.drawString(rebind.labels[6].getText().toUpperCase() + " & " + rebind.labels[7].getText().toUpperCase() + ": Bottom paddle", 40, 332);
		g.drawString(rebind.labels[0].getText().toUpperCase() + " & " + rebind.labels[1].getText().toUpperCase() + ": Right paddle", 40, 366);

		g.drawString("Me.", 440, 128);

		g.drawLine(400, 0, 400, 800); 
	}
	
	void drawSettingState(Graphics g) {
		g.setColor(new Color(23, 3, 40));
		g.fillRect(0, 0, FourPong.length, FourPong.length);
		
		g.setColor(Color.white);
		g.setFont(titleFont);
		g.drawString("Settings", 300, 74);
		
		g.setFont(textFont);
		g.drawString("To rebind keys, press the button below the you want to change,", 60, 162);
		g.drawString("then enter a new letter into the text field.", 170, 196);
		g.drawString("For arrow keys, write out the direction of the key (i.e. left)", 90, 264);
		g.drawString("To get back to title screen, press the back button at the bottom.", 60, 332);
	}

	@Override
	public void paintComponent(Graphics g) {
		if (currentState == titleState) {
			drawTitleState(g);
		} else if (currentState == gameState) {
			drawGameState(g);
		} else if (currentState == endState) {
			drawEndState(g);
		} else if (currentState == icState) {
			drawICState(g);
		} else if(currentState == settingState) {
			drawSettingState(g);
		}
	}

	void move() {
		if (isRUPressed) {
			right.y -= right.speed;
		}
		if (isRDPressed) {
			right.y += right.speed;
		}
		if (isULPressed) {
			up.x -= up.speed;
		}
		if (isURPressed) {
			up.x += up.speed;
		}
		if (isLUPressed) {
			left.y -= left.speed;
		}
		if (isLDPressed) {
			left.y += left.speed;
		}
		if (isDLPressed) {
			down.x -= down.speed;
		}
		if (isDRPressed) {
			down.x += down.speed;
		}
	}

	void ball() {
		ball.x += ball.xspeed;
		ball.y += ball.yspeed;
	}

	void reset() {
		ball.x = 388;
		ball.y = 388;
		right.y = 350;
		left.y = 350;
		up.x = 350;
		down.x = 350;
		ball.xspeed = 3;
		ball.yspeed = 1.5;
		manager.score = 0;
	}

	int scoreDigit() {
		String scoreString = manager.score + "";
		return scoreString.length();
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		//System.out.println(e.getKeyCode() + " typed");
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e.getKeyCode() + " pressed");
//		if(currentState == titleState && e.getKeyCode() != 66) {
//			test = e.getKeyCode();
//		}
//		if(e.getKeyCode() == test) {
//			System.out.println("test");
//		}
		System.out.println(rebind.keys[0]);
		if (e.getKeyCode() == rebind.keys[0]) { //
			isRUPressed = true;
		}
		if (e.getKeyCode() == rebind.keys[1]) { //
			isRDPressed = true;
		}
		if (e.getKeyCode() == rebind.keys[2]) { //
			isULPressed = true;
		}
		if (e.getKeyCode() == rebind.keys[3]) { //
			isURPressed = true;
		}
		if (e.getKeyCode() == rebind.keys[4]) { //
			isLUPressed = true;
		} 
		if (e.getKeyCode() == rebind.keys[5]) { //
			isLDPressed = true;
		}
		if (e.getKeyCode() == rebind.keys[6]) { //
			isDLPressed = true;
		}
		if (e.getKeyCode() == rebind.keys[7]) { //
			isDRPressed = true;
		}

		if (e.getKeyCode() == 32) { // Space (shift: 16)
			//System.out.println("space");
			if (currentState == titleState || currentState == endState || currentState == icState) {
				currentState = gameState;
				reset();
				System.out.println(currentState);
			} else if (currentState == gameState) {
				isPaused = !isPaused;
			} 
		}
		if (e.getKeyCode() == 86) { // v
			if (currentState == titleState || currentState == gameState) {
				currentState = endState;
			} else if (currentState == endState) {
				currentState = titleState;
			}
		}
		if (e.getKeyCode() == 66) { // b
			if (currentState == titleState || currentState == gameState && isPaused || currentState == endState) {
				currentState = icState;
			} else if (currentState == icState) {
				currentState = titleState;
			}
		}
		
		
		
		if(e.getKeyCode() == 78) { //n
			if(currentState == titleState || currentState == icState) {
				currentState = settingState;
			} else if(currentState == settingState) {
				currentState = titleState;
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == rebind.keys[0]) { // 
			isRUPressed = false;
		}
		if (e.getKeyCode() == rebind.keys[1]) { //
			isRDPressed = false;
		}
		if (e.getKeyCode() == rebind.keys[2]) { //
			isULPressed = false;
		}
		if (e.getKeyCode() == rebind.keys[3]) { //
			isURPressed = false;
		}
		if (e.getKeyCode() == rebind.keys[4]) { //
			isLUPressed = false;
		}
		if (e.getKeyCode() == rebind.keys[5]) { //
			isLDPressed = false;
		}
		if (e.getKeyCode() == rebind.keys[6]) { //
			isDLPressed = false;
		}
		if (e.getKeyCode() == rebind.keys[7]) { //
			isDRPressed = false;
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
		if (currentState == gameState && isPaused == false) {
			updateGameState();
		}
		if(currentState == settingState) {
			rebind.frame.setVisible(true);
		} else {
			rebind.frame.setVisible(false);
		}
	}
}
