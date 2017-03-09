package test;

import edu.miracosta.cs113.Printer;
import org.junit.Assert;
import org.junit.Test;

public class PrinterTester {
	
	@Test
	public void testTime(){
		Printer.setTime(0);
		Assert.assertTrue(Printer.getTime() == 0);
		Printer.incrimentTime();
		Assert.assertTrue(Printer.getTime() == 1);
		Printer.setTime(0);
		Assert.assertTrue(Printer.getTime() == 0);
	}
	
	@Test
	public void testAddJobAndHasNextJob(){
		Printer printer = new Printer("testPrinter", 1, Integer.MAX_VALUE);
		Assert.assertTrue(!printer.hasNextJob());
		printer.addJob(5);
		Assert.assertTrue(printer.hasNextJob());
	}
	
	@Test
	public void testGetName(){
		Printer printer = new Printer("testPrinter", 1, Integer.MAX_VALUE);
		Assert.assertTrue(printer.getName().equals("testPrinter"));
		Assert.assertFalse(printer.getName().equals("someOtherName"));
	}
	@Test
	public void testSetName(){
		Printer printer = new Printer("testPrinter", 1, Integer.MAX_VALUE);
		printer.setName("setName");
		Assert.assertTrue(printer.getName().equals("setName"));
		Assert.assertFalse(printer.getName().equals("testPrinter"));
	}
	
	@Test
	public void testGetMinimumPages(){
		Printer printer = new Printer("testPrinter", 1, Integer.MAX_VALUE);
		Assert.assertTrue(printer.getMininumPages() == 1);
		Assert.assertFalse(printer.getMininumPages() == 2);
	}
	
	@Test
	public void testSetMinimumPages(){
		Printer printer = new Printer("testPrinter", 6, Integer.MAX_VALUE);
		Assert.assertFalse(printer.getMininumPages() == 1);
		printer.setMininumPages(1);
		Assert.assertTrue(printer.getMininumPages() == 1);
		
	}
	
	@Test
	public void testGetMaximumPages(){
		Printer printer = new Printer("testPrinter", 1, Integer.MAX_VALUE);
		Assert.assertTrue(printer.getMaximumPages() == Integer.MAX_VALUE);
		Assert.assertFalse(printer.getMaximumPages() == 2);
	}
	
	@Test
	public void testSetMaximumPages(){
		Printer printer = new Printer("testPrinter", 6, Integer.MAX_VALUE);
		Assert.assertFalse(printer.getMaximumPages() == 1);
		printer.setMaximumPages(1);
		Assert.assertTrue(printer.getMaximumPages() == 1);
		
	}
	

	@Test
	public void testPrintNextJob(){
		Printer printer = new Printer("testPrintNextJobPrinter", 6, Integer.MAX_VALUE);
		printer.addJob(10);
		printer.printNextJob();
		Printer.incrimentTime();

		
	}
	
	
}
