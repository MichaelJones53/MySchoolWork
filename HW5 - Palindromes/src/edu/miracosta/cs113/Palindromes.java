package edu.miracosta.cs113;

import java.util.Scanner;
/**
 * Palindromes.java : Program for testing for palindromes
 * 
 * @author Michael Jones
 * @version 1.0
 *
 */
public class Palindromes {

	private static ArrayListStack<Character> stack1 = new ArrayListStack<>(); 
	private static ArrayListStack<Character> stack2 = new ArrayListStack<>();
	private static int halfCount = 0;
	private static String userIn = "";
	private static boolean isPalindrome = true;
	
	/**
	 * Driver for palindrome program
	 * 
	 * @param args
	 *            command line arguments (unnused)
	 */
	public static void main(String[] args){
		Scanner keyboard = new Scanner(System.in);
		boolean isRunning = true;
		
		while(isRunning){
			System.out.println("Please enter a sentence without puncuation to test for palindrome");
			userIn = keyboard.nextLine();
			userIn = userIn.replaceAll(" ", "").toLowerCase();
			halfCount = userIn.length()/2;
			
			if(userIn.length() %2 == 0){
				fillStacksEvenWord();
			}else{
				fillStacksOddWord();
			}
			checkIsPalindrome();
			
			if(isPalindrome){
				System.out.println("That is a palindrome");
			}else{
				System.out.println("That is NOT a palindrome");
			}
			
			System.out.println("enter \"Y\" to run again, anything else to quit");
			userIn = keyboard.nextLine();
			if(!(userIn.charAt(0)== 'Y') && !(userIn.charAt(0)== 'y')){
				isRunning = false;
			}
		}
	}
	
	/**
	 * splits even number of character word into two stacks for comparison 
	 */
	private static void fillStacksEvenWord(){
		for(int i = 0; i< halfCount; i++){
			stack1.push(userIn.charAt(userIn.length()-1));
			userIn = userIn.substring(0, userIn.length()-1);
		}
		while(!userIn.isEmpty()){
			stack2.push(userIn.charAt(0));
			userIn = userIn.substring(1, userIn.length());
		}
	}
	
	/**
	 * splits odd number of character word into two stacks for comparison 
	 */
	private static void fillStacksOddWord(){
		for(int i = 0; i< halfCount; i++){
			stack1.push(userIn.charAt(userIn.length()-1));
			userIn = userIn.substring(0, userIn.length()-1);
		}
		userIn = userIn.substring(0, userIn.length()-1);
		while(!userIn.isEmpty()){
			stack2.push(userIn.charAt(0));
			userIn = userIn.substring(1, userIn.length());
		}
	}
	
	/**
	 * performs test on stacks to determine if the provide string is a paplindrome. 
	 */
	private static void checkIsPalindrome(){
		while(!stack1.empty()){
			if(stack1.pop() != stack2.pop()){
				
				isPalindrome = false;
			}
		}
	}

}
