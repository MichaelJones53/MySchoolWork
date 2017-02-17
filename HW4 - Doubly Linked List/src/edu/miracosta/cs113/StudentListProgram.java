package edu.miracosta.cs113;

import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * StudentListProgram.java : Program for student list problem
 * 
 * @author Michael Jones
 * @version 1.0
 *
 */
public class StudentListProgram {
	private static Scanner keyboard = new Scanner(System.in);
	
	/**
	 * driver for student list program
	 * 
	 * @param args
	 *            command line arguments (unnused)
	 */
	public static void main(String[] args){
		boolean isEntering = true;
		DoublyLinkedList<Student> list = new DoublyLinkedList<>();
		int selection = 0;
		
		while(isEntering){
			System.out.println("enter \n1 to add to begining \n2 to add at the end \n3 to remove first \n4 to remove specific \n5 to show list\nAnything else to quit");
			selection = readInt();
			switch(selection){
			case 1:
				System.out.println("Enter the students whole name");
				list.addFirst(new Student(keyboard.nextLine()));
				break;
			case 2:
				System.out.println("Enter the students whole name");
				list.addLast(new Student(keyboard.nextLine()));
				break;
			case 3:
				list.remove(list.get(0));
				break;
			case 4:
				System.out.println("Enter the name of the student to remove (case sensative)");
				list.remove(new Student(keyboard.nextLine()));
				break;
			case 5:
				System.out.println(list.toString());
				break;
			default: 
				System.out.println("Program closing");
				isEntering = false;
				break;
			
			}
		}
	}
	
	private static int readInt(){
		int selection;
		try{
			selection = keyboard.nextInt();
			keyboard.nextLine();
		}catch(InputMismatchException e){
			selection = 0;
			keyboard.nextLine();
		}

		return selection;
	}
	
}
