package _04_HangMan;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class HangMan implements KeyListener{
	JFrame frame;
	JPanel panel;
	JLabel label;
	JLabel showLives;
	JLabel showLetters;
	final static int WIDTH = 500;
	final static int HEIGHT = 500;
	Stack<String> words = new Stack<String>();
	int lives = 6;
	GridBagConstraints c = new GridBagConstraints();
public static void main(String[] args) {
	HangMan game = new HangMan();
	game.setup();
	game.play();
}
public HangMan() {
	 frame = new JFrame();
	 panel = new JPanel(new GridBagLayout());
	 label = new JLabel();
}
void setup(){
	frame.setSize(HangMan.WIDTH, HangMan.HEIGHT);
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.add(panel);
	panel.add(label, c);
	String wordAmount = JOptionPane.showInputDialog("How many words would you like to guess?");
	int amount = Integer.parseInt(wordAmount);
	for(int i = 0; i <= amount; i++) {
		String random = Utilities.readRandomLineFromFile("dictionary.txt");
		if(!words.contains(random));{
			words.push(random);
		}
	}
	showLives = new JLabel("Lives: " + lives);
	c.fill = GridBagConstraints.HORIZONTAL;
	c.ipady = 0;       //reset to default
	c.weighty = 1.0;   //request any extra vertical space
	c.anchor = GridBagConstraints.PAGE_START; //bottom of space
	c.insets = new Insets(10,0,0,0);  //top padding
	c.gridx = 1;       //aligned with button 1
	c.gridwidth = 2;   //2 columns wide
	c.gridy = 0;       //first row
	panel.add(showLives, c);
	
	showLetters = new JLabel("Letters guesses: ");
	c.fill = GridBagConstraints.HORIZONTAL;
	c.ipady = 0;       //reset to default
	c.weighty = 1.0;   //request any extra vertical space
	c.anchor = GridBagConstraints.PAGE_START; //bottom of space
	c.insets = new Insets(10,0,0,0);  //top padding
	c.gridx = 0;       //aligned with button 1
	c.gridwidth = 2;   //2 columns wide
	c.gridy = 0;       //first row
	panel.add(showLetters, c);
}
void play() {
	String currentWord = words.push(words.lastElement());
	Font wordFont = new Font("Arial", Font.PLAIN, 28);
	for(int i = 0; i <= currentWord.length(); i++) {
		label.setFont(wordFont);
		label.setText(label.getText() + "_ ");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 40;      //make this component tall
		c.weightx = 0.0;
		c.gridwidth = 3;
		c.gridx = 0;
		c.gridy = 1;
	}
	frame.addKeyListener(this);
}
@Override
public void keyPressed(KeyEvent arg0) {
	// TODO Auto-generated method stub
	//if(e.getKeyCode() == ) {
		
	}
@Override
public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void keyTyped(KeyEvent e) {
	// TODO Auto-generated method stub
	
}
}	

