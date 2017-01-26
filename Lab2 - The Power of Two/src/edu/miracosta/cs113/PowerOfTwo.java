package edu.miracosta.cs113;
/**
 * PowerOfTwo.java : Power of two identifier program
 * 
 * @author Michael Jones
 * @version 1.0
 *
 */

import java.util.Scanner;

public class PowerOfTwo {
	/**
	 * Tester for identifying if a number is a power of two+
	 * 
	 * @param args
	 *            command line arguments (unnused)
	 * @param 		
	 */
	public static void main(String[] args){
		Scanner keyboard = new Scanner(System.in);
		double enteredNumber;
		
		System.out.println("Enter a number to see if it is of a power of two");
		enteredNumber = keyboard.nextDouble();
		
		
		System.out.println(isPrime(enteredNumber));
		
	}
	public static boolean isPrime(double number){
		boolean isSquared = false;
		if(number<0){
			isSquared = false;
		}else if(number == 1){
			isSquared = true;
			//TODO- Finish method  - not functioning
		}
		
	
		return isSquared;
	}
	
}
