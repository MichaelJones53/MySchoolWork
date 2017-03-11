package edu.miracosta.cs113;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ChangeRecursion {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        Change change = new Change();
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

        change.combinations(amount);

    }
}

/*
 * Write	a	recursive	method	that	will	dispense	change	for	a	given	
amount	of	money.		The	method	will	display all	combinations	of	quarters,	
dimes,	nickels,	and	pennies	that	equal	the	desired	amount.		Avoid	
duplication	if	possible.
NOTE: Your	program	should	dispense	the	highest	coin	first	(quarters,	then	
dimes,	then	nickels, then	pennies).		Provide	tests	for	5	cent	increments	
between	5	cents	and	30	cents,	and	a	larger	test	for	75	cents	(hint:	75	cents	
has	121	unique	number	of	combinations)
 */

