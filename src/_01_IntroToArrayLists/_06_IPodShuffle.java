package _01_IntroToArrayLists;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


//Copyright The League of Amazing Programmers, 2015

public class _06_IPodShuffle implements MouseListener{
	ArrayList<Song> theMusic = new ArrayList<Song>();
	public _06_IPodShuffle() {
		// 1. Use the Song class the play the demo.mp3 file.
		//Song s = new Song("demo.mp3");
		//s.play();
				
		/**
		 * 2. Congratulations on completing the sound check! * Now we want to make an
		 * iPod Shuffle that plays random music. * Create an ArrayList of Songs and a
		 * "Surprise Me!" button that will play a random song when it is clicked. * If
		 * you're really cool, you can stop all the songs, before playing a new one on
		 * subsequent button clicks.
		 */
		
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JButton button = new JButton();
		frame.add(panel);
		panel.add(button);
		frame.setVisible(true);
		frame.pack();
		button.setText("Surprise me!");
		button.addMouseListener(this);
	}
	
	public static void main(String[] args) {
		new _06_IPodShuffle();
		_06_IPodShuffle Ipod = new _06_IPodShuffle();
		Ipod.initializeMusic();
		
	}
	
	private void initializeMusic() {
		Song one = new Song("demo.mp3");
		Song two = new Song("demo.mp3");
		Song three = new Song("demo.mp3");
		Song four = new Song("demo.mp3");
		theMusic.add(one);
		theMusic.add(two);
		theMusic.add(three);
		theMusic.add(four);
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}