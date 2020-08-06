package _03_IntroToStacks;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class _02_TextUndoRedo implements KeyListener {
	/* 
	 * Create a JFrame with a JPanel and a JLabel.
	 * 
	 * Every time a key is pressed, add that character to the JLabel. It should look like a basic text editor.
	 * 
	 * Make it so that every time the BACKSPACE key is pressed, the last character is erased from the JLabel.
	 * Save that deleted character onto a Stack of Characters.
	 * 
	 * Choose a key to be the Undo key. Make it so that when that key is pressed, the top Character is popped 
	 * off the Stack and added back to the JLabel.
	 * 
	 * */
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	Stack<String> text = new Stack<String>();
	public static void main(String[] args) {
		_02_TextUndoRedo project = new _02_TextUndoRedo();
		project.run();
	}
	public void run() {
	frame.add(panel);
	panel.add(label);
	frame.addKeyListener(this);
	frame.setVisible(true);
	frame.pack();
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
			String temp = label.getText();
			text.push(temp.substring(temp.length()-1));
			label.setText(temp.substring(0, temp.length()-1));
		}
		else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			String tempChar = text.pop();
			label.setText(label.getText() + tempChar);
		}
		else{
			label.setText(label.getText() + e.getKeyChar());
		}
		
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
