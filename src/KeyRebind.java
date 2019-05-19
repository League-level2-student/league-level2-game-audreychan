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
	
	public static void main(String[] args) {
		KeyRebind rebind = new KeyRebind();
	}
	
	public KeyRebind() {
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.add(panel);
		panel.addKeyListener(this);
		
		panel.add(ruLabel);
		panel.add(rdLabel);
		panel.add(ulLabel);
		panel.add(urLabel);
		panel.add(luLabel);
		panel.add(ldLabel);
		panel.add(dlLabel);
		panel.add(drLabel);
		
		panel.add(ruButton);
		panel.add(rdButton);
		panel.add(ulButton);
		panel.add(urButton);
		panel.add(luButton);
		panel.add(ldButton);
		panel.add(dlButton);
		panel.add(drButton);
		
		ulLabel.setText("a");
		urLabel.setText("d");
		urButton.addActionListener(this);
		ulButton.addActionListener(this);
		
		labels[2] = ulLabel;
		labels[3] = urLabel;
		
		buttons[2] = ulButton;
		buttons[3] = urButton;
		
		keys[2] = 'a';
		keys[3] = 'd';
		
		frame.pack();
	}
	
	void rebind(int index) {
		String newKeyString = JOptionPane.showInputDialog("Enter a new key");
		char newKey = newKeyString.charAt(0);
		keys[index] = newKey;
		labels[index].setText(newKey + "");
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
		rebind(findIndex(pressed));
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
