package _06_Intro_To_Hash_Maps;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_LogSearch implements ActionListener {
	HashMap<Integer, String> hash = new HashMap<Integer, String>();
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton button1 = new JButton();
	JButton button2 = new JButton();
	JButton button3 = new JButton();
	JButton button4 = new JButton();
	public static void main(String[] args) {
		_02_LogSearch run = new _02_LogSearch();
		run.setup();
	}
	void setup() {
		frame.setVisible(true);
		frame.add(panel);
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		button1.setText("Add Entry");
		button2.setText("Search by ID");
		button3.setText("View List");
		button4.setText("Remove entry");
	}
	/*
	 * Crate a HashMap of Integers for the keys and Strings for the values. Create a
	 * GUI with three buttons. Button 1: Add Entry When this button is clicked, use
	 * an input dialog to ask the user to enter an ID number. After an ID is
	 * entered, use another input dialog to ask the user to enter a name. Add this
	 * information as a new entry to your HashMap.
	 * 
	 * Button 2: Search by ID When this button is clicked, use an input dialog to
	 * ask the user to enter an ID number. If that ID exists, display that name to
	 * the user. Otherwise, tell the user that that entry does not exist.
	 * 
	 * Button 3: View List When this button is clicked, display the entire list in a
	 * message dialog in the following format: ID: 123 Name: Harry Howard ID: 245
	 * Name: Polly Powers ID: 433 Name: Oliver Ortega etc...
	 * 
	 * When this is complete, add a fourth button to your window. Button 4: Remove
	 * Entry When this button is clicked, prompt the user to enter an ID using an
	 * input dialog. If this ID exists in the HashMap, remove it. Otherwise, notify
	 * the user that the ID is not in the list.
	 *
	 */

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(button1)) {
			String idTemp = JOptionPane.showInputDialog("Enter an ID number");
			int id = Integer.parseInt(idTemp);
			String name = JOptionPane.showInputDialog("Enter a name");
			hash.put(id, name);
		} else if (e.getSource().equals(button2)) {
			String idTemp = JOptionPane.showInputDialog("Search for an ID number");
			int id = Integer.parseInt(idTemp);
			System.out.println(hash.get(id));
		} else if (e.getSource().equals(button3)) {
			for (int i = 0; i < hash.size()+1; i++) {
				System.out.println(hash);
			}
		}
		else {
			String idTemp = JOptionPane.showInputDialog("Enter an ID number");
			int id = Integer.parseInt(idTemp);
			hash.remove(id);
		}
	}

}
