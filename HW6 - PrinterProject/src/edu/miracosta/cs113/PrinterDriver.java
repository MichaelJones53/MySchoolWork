package edu.miracosta.cs113;
import java.util.Scanner;
/**
 * PrinterDriver.java : Program for testing for printer class with queues
 * 
 * @author Michael Jones
 * @version 1.0
 *
 */

public class PrinterDriver {
	private static int[] testArray;
	private static int MAX_PAGES = 50;

	/**
	 * Driver for printer program
	 * 
	 * @param args
	 *            command line arguments (unnused)
	 */
	public static void main(String[] args){
		String numPrinters = "";
		boolean isEntering = true;
		Scanner keyboard = new Scanner(System.in);
		Printer smallPrinter = new Printer("smallPrinter", 1, Integer.MAX_VALUE);
		Printer mediumPrinter = new Printer("mediumPrinter", 1, Integer.MAX_VALUE);
		Printer largePrinter = new Printer("largePrinter", 1, Integer.MAX_VALUE);
		
		generateTestArray(100);
		
		while(isEntering){
			System.out.println("Enter the number of printers 1-3");
			numPrinters = keyboard.nextLine();
			if(numPrinters.equals("1") || numPrinters.equals("2") || numPrinters.equals("3")){
				isEntering = false;
			}else{
				System.out.println("!!!!!!!!!!Invalid entry!!!!!!");
			}
		}
		keyboard.close();

		if(numPrinters.equals("3")){
			for(int i = 0;i<testArray.length;i++){
				if(testArray[i]<=10){
					smallPrinter.addJob(testArray[i]);
				}else if(testArray[i]<=20){
					mediumPrinter.addJob(testArray[i]);
				}else{
					largePrinter.addJob(testArray[i]);
				}
				
				smallPrinter.printNextJob();
				mediumPrinter.printNextJob();
				largePrinter.printNextJob();
				Printer.incrimentTime();
			}
		}else if(numPrinters.equals("2")){
			for(int i = 0;i<testArray.length;i++){
				if(testArray[i]<=10){
					smallPrinter.addJob(testArray[i]);
				}else{
					mediumPrinter.addJob(testArray[i]);
				}
				
				smallPrinter.printNextJob();
				mediumPrinter.printNextJob();
				Printer.incrimentTime();
			}
		}else{
			for(int i = 0;i<testArray.length;i++){
				smallPrinter.addJob(testArray[i]);
				smallPrinter.printNextJob();
				Printer.incrimentTime();
			}
		
		}
		while(smallPrinter.hasNextJob() || mediumPrinter.hasNextJob() || largePrinter.hasNextJob()){
			smallPrinter.printNextJob();
			mediumPrinter.printNextJob();
			largePrinter.printNextJob();
			Printer.incrimentTime();
		}
	}
	
	/**
	 * generates array of random integers between 1 and MAX_PAGES
	 */
	private static void generateTestArray(int size){
		testArray = new int[size];
		for(int i=0; i<testArray.length;i++){
			testArray[i] = (int) Math.ceil(Math.random()*MAX_PAGES);
		}
		
		
	}
}
