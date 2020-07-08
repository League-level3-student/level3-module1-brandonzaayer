package _01_IntroToArrayLists;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


//Copyright The League of Amazing Programmers, 2015

public class _06_IPodShuffle implements MouseListener{
	ArrayList<Song> theMusic = new ArrayList<Song>();
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton button1 = new JButton();
	JButton button2 = new JButton();
	JButton button3 = new JButton();
	JButton button4 = new JButton();
	JButton button5 = new JButton();
	Song one = new Song("demo.mp3");
	Song two = new Song("jazz.mp3");
	Song three = new Song("country.mp3");
	Song four = new Song("hip-hop.mp3");
	boolean isPlaying;
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
		frame.add(panel);
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);
		panel.add(button5);
		frame.setVisible(true);
		button1.setText("Demo song");
		button1.addMouseListener(this);
		button2.setText("Jazz song");
		button2.addMouseListener(this);
		button3.setText("Country song");
		button3.addMouseListener(this);
		button4.setText("Hip-hop song");
		button4.addMouseListener(this);
		button5.setText("Random song");
		button5.addMouseListener(this);
		frame.pack();
	}
	
	public static void main(String[] args) {
		new _06_IPodShuffle();
		_06_IPodShuffle Ipod = new _06_IPodShuffle();
		Ipod.initializeMusic();
		
	}
	
	private void initializeMusic() {
		theMusic.add(one);
		theMusic.add(two);
		theMusic.add(three);
		theMusic.add(four);
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource().equals(button1)) {
			two.stop();
			three.stop();
			four.stop();
			
			one.play();
		}
		if(arg0.getSource().equals(button2)) {
			one.stop();
			three.stop();
			four.stop();
			
			two.play();
		}
		if(arg0.getSource().equals(button3)) {
			one.stop();
			two.stop();
			four.stop();
			
			three.play();
		}
		if(arg0.getSource().equals(button4)) {
			one.stop();
			two.stop();
			three.stop();
			
			four.play();
		}
		if(arg0.getSource().equals(button5)) {
			Random r = new Random();
			int rand = r.nextInt(4);
			if(rand == 0) {
				two.stop();
				three.stop();
				four.stop();
				
				one.play();
			}
			if(rand == 1) {
				one.stop();
				three.stop();
				four.stop();
				
				two.play();
			}
			if(rand == 2) {
				one.stop();
				two.stop();
				four.stop();
				
				three.play();
			}
			if(rand == 3) {
				one.stop();
				two.stop();
				three.stop();
				
				four.play();
			}
		}
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