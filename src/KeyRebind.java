import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class KeyRebind implements ActionListener, KeyListener {
	
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	
	JButton back = new JButton("Back");
	
	JLabel ruLabel = new JLabel();
	JLabel rdLabel = new JLabel();
	JLabel ulLabel = new JLabel();
	JLabel urLabel = new JLabel();
	JLabel luLabel = new JLabel();
	JLabel ldLabel = new JLabel();
	JLabel dlLabel = new JLabel();
	JLabel drLabel = new JLabel();
	
	JButton ruButton = new JButton();
	JButton rdButton = new JButton();
	JButton ulButton = new JButton();
	JButton urButton = new JButton();
	JButton luButton = new JButton();
	JButton ldButton = new JButton();
	JButton dlButton = new JButton();
	JButton drButton = new JButton();
	
	JButton[] buttons = new JButton[8];
	JLabel[] labels = new JLabel[8];
	public int[] keys = new int[8];
	
	public KeyRebind() {
		//frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.add(panel);
		panel.addKeyListener(this);
		
		panel.add(ruLabel);
		panel.add(ruButton);
		ruLabel.setText("w");
		ruButton.addActionListener(this);
		labels[0] = ruLabel;
		buttons[0] = ruButton;
		keys[0] = 'w' - 32;
		
		panel.add(rdLabel);
		panel.add(rdButton);
		rdLabel.setText("s");
		rdButton.addActionListener(this);
		labels[1] = rdLabel;
		buttons[1] = rdButton;
		keys[1] = 's' - 32;
		
		panel.add(ulLabel);
		panel.add(ulButton);
		ulLabel.setText("a");
		ulButton.addActionListener(this);
		labels[2] = ulLabel;
		buttons[2] = ulButton;
		keys[2] = 'a' - 32;
		
		panel.add(urLabel);
		panel.add(urButton);
		urLabel.setText("d");
		urButton.addActionListener(this);
		labels[3] = urLabel;
		buttons[3] = urButton;
		keys[3] = 'd' - 32;
		
		panel.add(luLabel);
		panel.add(luButton);
		luLabel.setText("up");
		luButton.addActionListener(this);
		labels[4] = luLabel;
		buttons[4] = luButton;
		keys[4] = 38;
		
		panel.add(ldLabel);
		panel.add(ldButton);
		ldLabel.setText("down");
		ldButton.addActionListener(this);
		labels[5] = ldLabel;
		buttons[5] = ldButton;
		keys[5] = 40;
		
		panel.add(dlLabel);
		panel.add(dlButton);
		dlLabel.setText("left");
		dlButton.addActionListener(this);
		labels[6] = dlLabel;
		buttons[6] = dlButton;
		keys[6] = 37;
		
		panel.add(drLabel);
		panel.add(drButton);
		drLabel.setText("right");
		drButton.addActionListener(this);
		labels[7] = drLabel;
		buttons[7] = drButton;
		keys[7] = 39;
		
		panel.add(back);
		back.addActionListener(this);
		
		frame.setPreferredSize(new Dimension(40, 600));
		frame.pack();
	}
	
	void rebind(int index) {
		String newKeyString = JOptionPane.showInputDialog("Enter a new letter");
		
		if(newKeyString.equalsIgnoreCase("left")) {
			keys[index] = 37;
			labels[index].setText("left");
		} else if(newKeyString.equalsIgnoreCase("up")) {
			keys[index] = 38;
			labels[index].setText("up");
		} else if(newKeyString.equalsIgnoreCase("right")) {
			keys[index] = 39;
			labels[index].setText("right");
		} else if(newKeyString.equalsIgnoreCase("down")) {
			keys[index] = 40;
			labels[index].setText("down");
		} else {
			char newKey = newKeyString.charAt(0);
			keys[index] = newKey - 32;
			labels[index].setText((char)newKey + "");
		}
	}
	
	int findIndex(JButton b) {
		for(int i = 0; i < buttons.length; i++) {
			if(buttons[i] == b) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton pressed = (JButton) e.getSource();
		if(pressed == back) {
			GamePanel.currentState = GamePanel.titleState;
		} else {
			rebind(findIndex(pressed));
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
