package edu.miracosta.cs113;

public class PrinterDriver {

	public static void main(String[] args){
		
		
		int[] testArray = {5,15,30,22,11, 7};
		Printer printer = new Printer("testPrinter", 1, 100);
		
		for(int i = 0;i<6;i++){
			printer.addJob(testArray[i]);
			printer.printNextJob();
			
			Printer.incrimentTime();
			
			
			
		}
		
		while(printer.hasNextJob()){
			printer.printNextJob();
			
			Printer.incrimentTime();
			
			
			
		}
		
		
		
	}
}
