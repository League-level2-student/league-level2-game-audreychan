import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInput implements KeyListener{

	GamePanel panel;
	
	public KeyInput(GamePanel p) {
		panel = p;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		//System.out.println(e.getKeyCode() + " typed");
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		//System.out.println(e.getKeyCode() + " pressed");
//		if(currentState == titleState && e.getKeyCode() != 66) {
//			test = e.getKeyCode();
//		}
//		if(e.getKeyCode() == test) {
//			System.out.println("test");
//		}
		//System.out.println(panel.rebind.keys[0]);
		if (e.getKeyCode() == panel.rebind.keys[0]) { //
			panel.isRUPressed = true;
		}
		if (e.getKeyCode() == panel.rebind.keys[1]) { //
			panel.isRDPressed = true;
		}
		if (e.getKeyCode() == panel.rebind.keys[2]) { //
			panel.isULPressed = true;
		}
		if (e.getKeyCode() == panel.rebind.keys[3]) { //
			panel.isURPressed = true;
		}
		if (e.getKeyCode() == panel.rebind.keys[4]) { //
			panel.isLUPressed = true;
		} 
		if (e.getKeyCode() == panel.rebind.keys[5]) { //
			panel.isLDPressed = true;
		}
		if (e.getKeyCode() == panel.rebind.keys[6]) { //
			panel.isDLPressed = true;
		}
		if (e.getKeyCode() == panel.rebind.keys[7]) { //
			panel.isDRPressed = true;
		}

		if (e.getKeyCode() == 32) { // Space (shift: 16)
			//System.out.println("space");
			if (GamePanel.currentState == GamePanel.titleState || GamePanel.currentState == GamePanel.endState || GamePanel.currentState == GamePanel.icState) {
				GamePanel.currentState = GamePanel.gameState;
				panel.reset();
				//System.out.println(GamePanel.currentState);
			} else if (GamePanel.currentState == GamePanel.gameState) {
				panel.isPaused = !panel.isPaused;
			} 
		}
		if (e.getKeyCode() == 86) { // v
			if (GamePanel.currentState == GamePanel.titleState || GamePanel.currentState == GamePanel.gameState) {
				GamePanel.currentState = GamePanel.endState;
			} else if (GamePanel.currentState == GamePanel.endState) {
				GamePanel.currentState = GamePanel.titleState;
			}
		}
		if (e.getKeyCode() == 66) { // b
			if (GamePanel.currentState == GamePanel.titleState || GamePanel.currentState == GamePanel.gameState && panel.isPaused || GamePanel.currentState == GamePanel.endState) {
				GamePanel.currentState = GamePanel.icState;
			} else if (GamePanel.currentState == GamePanel.icState) {
				GamePanel.currentState = GamePanel.titleState;
			}
		}
		
		
		
		if(e.getKeyCode() == 78) { //n
			if(GamePanel.currentState == GamePanel.titleState || GamePanel.currentState == GamePanel.icState) {
				GamePanel.currentState = GamePanel.settingState;
			} else if(GamePanel.currentState == GamePanel.settingState) {
				GamePanel.currentState = GamePanel.titleState;
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == panel.rebind.keys[0]) { // 
			panel.isRUPressed = false;
		}
		if (e.getKeyCode() == panel.rebind.keys[1]) { //
			panel.isRDPressed = false;
		}
		if (e.getKeyCode() == panel.rebind.keys[2]) { //
			panel.isULPressed = false;
		}
		if (e.getKeyCode() == panel.rebind.keys[3]) { //
			panel.isURPressed = false;
		}
		if (e.getKeyCode() == panel.rebind.keys[4]) { //
			panel.isLUPressed = false;
		}
		if (e.getKeyCode() == panel.rebind.keys[5]) { //
			panel.isLDPressed = false;
		}
		if (e.getKeyCode() == panel.rebind.keys[6]) { //
			panel.isDLPressed = false;
		}
		if (e.getKeyCode() == panel.rebind.keys[7]) { //
			panel.isDRPressed = false;
		}

	}
}
