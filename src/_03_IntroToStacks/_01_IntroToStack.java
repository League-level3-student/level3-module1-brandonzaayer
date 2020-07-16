package _03_IntroToStacks;

import java.util.Random;
import java.util.Stack;

import javax.swing.JOptionPane;

public class _01_IntroToStack {
	public static void main(String[] args) {
		//1. Create a Stack of Doubles
		//   Don't forget to import the Stack class
		Stack<Double> d = new Stack<Double>();
		//2. Use a loop to push 100 random doubles between 0 and 100 to the Stack.
		for(int i = 0; i < 100; i++) {
			Random rand = new Random();
			Double r = rand.nextDouble()*100;
			d.push(r);
		}
		//3. Ask the user to enter in two numbers between 0 and 100, inclusive. 
		String num1 = JOptionPane.showInputDialog("Enter one number between 0 & 100");
		String num2 = JOptionPane.showInputDialog("Enter a different number between 0 & 100");
		int uno = Integer.parseInt(num1);
		int dos = Integer.parseInt(num2);
		//4. Pop all the elements off of the Stack. Every time a double is popped that is
		//   between the two numbers entered by the user, print it to the screen.
		if(uno > dos) {
			System.out.println("Popping elements off stack elements between " + dos + " and " + uno + ":");
			for(int i = 0; i < d.size(); i++) {
				Double temp1 = d.pop();;
				if(temp1 > dos && temp1 < uno) {
					System.out.println(temp1);
				}
			}
		}
		if(dos > uno){
			System.out.println("Popping elements off stack elements between " + uno + " and " + dos + ":");
			for(int i = 0; i < d.size(); i++) {
				Double temp2 = d.pop();
				if(temp2 > uno && temp2 < dos) {
					System.out.println(temp2);
				}
			}
		}
		//   EXAMPLE:
		//   NUM 1: 65
		//   NUM 2: 75
		
		//   Popping elements off stack...
		//   Elements between 65 and 75:
		//   66.66876846
		//   74.51651681
		//   70.05110654
		//   69.21350456
		//   71.54506465
		//   66.47984807
		//   74.12121224
	}
}
