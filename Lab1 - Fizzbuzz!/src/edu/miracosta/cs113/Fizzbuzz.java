package edu.miracosta.cs113;

/**
 * Fizzbuzz.java : Fizzbuzz counter program
 * 
 * @author Michael Jones
 * @version 1.0
 *
 */
public class Fizzbuzz {
	/**
	 * Driver for Fizzbuzz program assignment
	 * 
	 * @param args
	 *            command line arguments (unnused)	
	 */
	public static void main(String[] args) {
		final int NUMBER_CAP = 100;
		
		fizzBuzzOutput(NUMBER_CAP);
		
	}
	/**
	 * Will count from 1 to NUMBER_CAP, printing the number to the screen.
	 * if number is multiple of 15, prints "Fizzbuzz" instead.  If number 
	 * is multiple of 5, prints "Buzz" instead.  If number is multiple 
	 * of 3, prints "Fizz" instead.  
	 * 
	 * @param num
	 *            number to be counted up to
	 */
	public static void fizzBuzzOutput(int num){
		for(int i=0; i< num; i++){
			if((i+1) % 15 == 0){
				System.out.println("Fizzbuzz");
			}else if((i+1) % 5 == 0){
				System.out.println("Buzz");
			}else if((i+1) % 3 == 0){
				System.out.println("Fizz");
			}else{
				System.out.println(i+1);
			}
		}
	}
}
