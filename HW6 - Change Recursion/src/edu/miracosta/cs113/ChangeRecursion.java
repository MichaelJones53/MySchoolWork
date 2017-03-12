package edu.miracosta.cs113;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ChangeRecursion {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        boolean isEntering = true;
        int amount = 0;

        while(isEntering){
	        System.out.println("Enter amount in cents to find all possible combinations.");
	        try{
	        	amount = keyboard.nextInt();
	        	if(amount < 0){
		        	throw new InputMismatchException();
	        	}
	        	isEntering = false;
	        }catch(InputMismatchException e){
	        	System.out.println("invalid input. Try again.");
	        	keyboard.nextLine();
	        }
        }

        Change.combinations(amount);

    }
}



