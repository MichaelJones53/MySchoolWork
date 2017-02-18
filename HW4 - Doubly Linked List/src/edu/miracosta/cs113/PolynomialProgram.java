package edu.miracosta.cs113;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

/**
 * PolynomialProgram.java : Program for polynomial problem incorporating doubly linked list
 * 
 * @author Michael Jones
 * @version 1.0
 *
 */
public class PolynomialProgram {

	private static DoublyLinkedList<Term> polynomialList = new DoublyLinkedList<>();
	/**
	 * Tester for polynomial program
	 * 
	 * @param args
	 *            command line arguments (unnused)
	 */
	public static void main(String[] args) {

		//create linkedList for polynomials
		
		
		boolean isRunning = true;
		
		while(isRunning){
			
			//prompt user to enter coefficient or quit
			Term newTerm = readPolynomialValue();
			addTerm(newTerm);

			//display polynomial to user
			System.out.println(polynomialList.toString());
		}
	}
	
	
	/**
	 * Reads polynomial value from user.  
	 *
	 *@return 
	 *		returns new Term object of entered values 
	 */
	private static Term readPolynomialValue(){
		int tempCoefficient = 0;
		int tempExponent = 0;
		
		System.out.println("Enter the integer value coefficinet of the term to add to the polynomial.  Enter anything else to quit.");
		tempCoefficient = readValue();
		
		System.out.println("Enter the integer value of the exponent of the term to add to the polynomial.  Enter anything else to quit.");
		tempExponent = readValue();
		
		return new Term(tempCoefficient, tempExponent);
	}
	
	
	/**
	 * Reads in integer vaules from user.  System exit if non-integer entered
	 *
	 *@return 
	 *		returns integer value inputted by user. 
	 */
	private static int readValue(){
		Scanner keyboard = new Scanner(System.in);
		int newValue = 0;
		
		try{
			newValue = keyboard.nextInt();
		}catch(InputMismatchException e){
			System.exit(0);
		}
		return newValue;
	}
	
	public static void addTerm(Term newTerm){
		
		Iterator<Term> itr = polynomialList.iterator();
		Term currentTerm;
		boolean added = false;
		if(polynomialList.size() == 0){
			polynomialList.add(itr, newTerm);
		}else{
			while(!added){
				currentTerm = (Term) itr.next();
				if(newTerm.exponent > currentTerm.exponent){
					polynomialList.addBefore(itr, newTerm);
					added = true;
				}else if(newTerm.exponent == currentTerm.exponent){
					currentTerm.coefficient+= newTerm.coefficient;
					added = true;
				}else if(!itr.hasNext()){
					polynomialList.add(itr, newTerm);
					added = true;
				}
			}
		}
	}
	
	

}
