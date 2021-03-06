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

import org.hamcrest.core.SubstringMatcher;

public class HangMan implements KeyListener {
	JFrame frame;
	JPanel panel;
	JLabel label;
	JLabel showLives;
	JLabel showLetters;
	final static int WIDTH = 500;
	final static int HEIGHT = 500;
	Stack<String> words = new Stack<String>();
	int lives = 6;
	String guesses = "";
	String wordAmount;
	int amount;
	GridBagConstraints c = new GridBagConstraints();
	String currentWord;
	int timesPressed = 0;

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

	void setup() {
		frame.setSize(HangMan.WIDTH, HangMan.HEIGHT);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		panel.add(label, c);
		wordAmount = JOptionPane.showInputDialog("How many words would you like to guess?");
		amount = Integer.parseInt(wordAmount);
		for (int i = 0; i <= amount; i++) {
			String random = Utilities.readRandomLineFromFile("dictionary.txt");
			if (!words.contains(random))
				;
			{
				words.push(random);
			}
		}
		showLives = new JLabel("Lives: " + lives);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 0; // reset to default
		c.weighty = 1.0; // request any extra vertical space
		c.anchor = GridBagConstraints.PAGE_START; // bottom of space
		c.insets = new Insets(10, 0, 0, 0); // top padding
		c.gridx = 0; // aligned with button 1
		c.gridwidth = 2; // 2 columns wide
		c.gridy = 0; // first row
		panel.add(showLives, c);

		showLetters = new JLabel("Letters guessed: None");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 0; // reset to default
		c.weighty = 1.0; // request any extra vertical space
		c.anchor = GridBagConstraints.PAGE_START; // bottom of space
		c.insets = new Insets(10, 0, 0, 0); // top padding
		c.gridx = 0; // aligned with button 1
		c.gridwidth = 2; // 2 columns wide
		c.gridy = 2; // third row
		panel.add(showLetters, c);
	}

	void play() {
		currentWord = words.pop();
		Font wordFont = new Font("Arial", Font.PLAIN, 28);
		for (int i = 0; i <= currentWord.length() - 1; i++) {
			label.setFont(wordFont);
			label.setText(label.getText() + "_ ");
			c.fill = GridBagConstraints.HORIZONTAL;
			c.ipady = 40; // make this component tall
			c.weightx = 0.0;
			c.gridwidth = 3;
			c.gridx = 0;
			c.gridy = 1;
		}
		frame.addKeyListener(this);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		boolean wrong = true;
		String temp = label.getText().replace(" ", "");
		if (!guesses.contains("" + e.getKeyChar())) {
			label.setText("");
			guesses = guesses + e.getKeyChar();
			showLetters.setText("Letters guessed: " + guesses);
			for (int i = 0; i <= currentWord.length() - 1; i++) {
				if (e.getKeyChar() == currentWord.charAt(i)) {
					if (i == 0) {
						temp = (e.getKeyChar() + temp.substring(1));
					} else if (i == currentWord.length() - 1) {
						temp = (temp.substring(0, i) + e.getKeyChar());
					} else {
						temp = (temp.substring(0, i) + e.getKeyChar() + temp.substring(i + 1));
					}
					wrong = false;
				}
			}
			for (int i = 0; i < temp.length(); i++) {
				label.setText(label.getText() + temp.charAt(i) + " ");
			}
			if (wrong) {
				lives = lives - 1;
				showLives.setText("Lives: " + lives);
			}
			if (lives <= 0) {
				JOptionPane.showMessageDialog(null, "Game over, you have run out of lives");
				label.setText("");
				lives = 6;
				guesses = "";
				showLetters.setText("Letters guessed: None");
				showLives.setText("Lives: " + lives);
				wordAmount = JOptionPane.showInputDialog("Let's play agin! How many words would you like to guess?");
				amount = Integer.parseInt(wordAmount);
				for (int i = 0; i <= amount; i++) {
					String random = Utilities.readRandomLineFromFile("dictionary.txt");
					if (!words.contains(random)) {
						words.push(random);
					}
				}
				currentWord = words.push(words.lastElement());
				for (int i = 0; i <= currentWord.length() - 1; i++) {
					label.setText(label.getText() + "_ ");
				}
			}
			if (currentWord.contains(temp)) {
				JOptionPane.showMessageDialog(null, "Next word!");
				lives = 6;
				guesses = "";
				showLetters.setText("Letters guessed: None");
				showLives.setText("Lives: " + lives);
				label.setText("");
				currentWord = words.pop();
				for (int i = 0; i <= currentWord.length() - 1; i++) {
					label.setText(label.getText() + "_ ");
				}
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}
