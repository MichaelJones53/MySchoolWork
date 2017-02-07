package edu.miracosta.cs113;

import java.util.ArrayList;

/**
 * Lab5Driver.java : Lab5Driver counter program
 * 
 * @author Michael Jones
 * @version 1.0
 *
 */
public class Lab5Driver {
	/**
	 * Driver for Lab 5 program assignment
	 * 
	 * @param args
	 *            command line arguments (unnused)	
	 */
	public static void main(String[] args){
		//create arraylist to test methods with
		ArrayList<String> myList = new ArrayList<String>();
		
		//add some data to the arraylist
		myList.add("Mike");
		myList.add("Tom");
		myList.add("Sara");
		myList.add("Bart");
		myList.add("Sara");
		
		System.out.println(myList);
		//test replace method
		replace(myList, "Sara", "Jill");	
		System.out.println(myList);
		
		//prove they worked
		
		
	}
	
	 /**
	  * Replaces each occurrence of oldItem in aList with newItem
	  **/
	public static void replace(ArrayList<String> aList, String oldItem, String newItem){
		int counter = 0;
		//check each element of the list.  if is the same as the oldItem, replace with newItem
		for(String element : aList){
			if(element.equals(oldItem)){
				aList.set(counter, newItem)
;			}
			counter++;
		}
	}
	
	 /** 
	  * Deletes the first occurrence of target in aList
	  */
	 public static void delete(ArrayList<String> aList, String target){
		 
		 
	 }
}


