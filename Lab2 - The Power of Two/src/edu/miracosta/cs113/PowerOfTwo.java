package edu.miracosta.cs113;
/**
 * PowerOfTwo.java : Power of two identifier program
 * 
 * @author Michael Jones
 * @version 1.0
 *
 */

import java.util.Scanner;
import java.util.InputMismatchException;

public class PowerOfTwo {
	private static int powersOfTwo[] = new int[32];
	/**
	 * Tester for identifying if a number is a power of two
	 * 
	 * @param args
	 *            command line arguments (unnused)
	 */
	public static void main(String[] args){
		Scanner keyboard = new Scanner(System.in);
		int enteredNumber = 0;
		boolean isEntering = true;
		
		//build power of two array for comparison
		for(int i = 0; i < powersOfTwo.length; i++){
			powersOfTwo[i] = (int)Math.pow(2, i);
		}
		
		//take input from the user.  if non integer entered, catch exceptions
		while(isEntering){
			System.out.println("Enter a whole number to see if it is of a power of two!");
			try{
				enteredNumber = keyboard.nextInt();
				isEntering = false;
			}catch(InputMismatchException e){
				System.out.println("Improper entry.  Enter an integer as a whole number (i.e. 1, 97, etc)");
				keyboard.nextLine();
			}	
		}
		//close Scanner stream
		keyboard.close();
		
		//check for power of two, then display results to user
		if(checkPowerOfTwo(enteredNumber)){
			System.out.println(enteredNumber + " is a power of two!");
		}else{
			System.out.println(enteredNumber + " is NOT a power of two.");
		}
		
		
		
	}
	/**
	 * Checks if a number is a power of two.  Compares passed value against
	 * an array containing possible options
	 * 
	 * @param number
	 *            integer being check if it is a power of two
	 * @return boolean value, true if number is a power of two, otherwise false
	 */
	public static boolean checkPowerOfTwo(int number){
		boolean isPowerOfTwo = false;
		
		for(int i = 0; i < powersOfTwo.length; i++){
			if(number == powersOfTwo[i]){
				isPowerOfTwo = true;
			}
		}
		return isPowerOfTwo;
	}
}
