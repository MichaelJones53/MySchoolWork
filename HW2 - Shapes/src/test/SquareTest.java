package test;

import edu.miracosta.cs113.*;


import org.junit.Test;
import org.junit.Assert;


public class SquareTest {
	//checks method getShapeName
	@Test
	public void testShapeName(){
		testGetShapeName();
	}
	//checks methods if entered value is 0
	@Test
	public void testCheckZero(){
		double value = 0;
		testCheckWidth(value);
		testComputeArea(value);
		testComputePerimeter(value);
		testToString(value);
		
	}

	//checks methods if entered value is a negative number
	@Test
	public void testCheckNegative(){
		double value = -6.8;
		testCheckWidth(value);
		testComputeArea(value);
		testComputePerimeter(value);
		testToString(value);
	}
	
	//checks methods if entered value is a decimal
	@Test
	public void testCheckDecimal(){
		double value = 78.35;
		testCheckWidth(value);
		testComputeArea(value);
		testComputePerimeter(value);
		testToString(value);
	}
	
	//checks methods if entered value is a whole number
	@Test
	public void testCheckWholeNumber(){
		double value = 10;
		testCheckWidth(value);
		testComputeArea(value);
		testComputePerimeter(value);
		testToString(value);
	}
	
	//tester method for testing getWidth method
	public void testCheckWidth(double width){
		Square square = new Square(width);
		Assert.assertTrue(square.getWidth() == width);
		
	}
	
	//tester method for testing computeArea method
	public void testComputeArea(double width){
		Square square = new Square(width);
		Assert.assertTrue(square.computeArea() == (width * width));
		
		
	}
	
	//tester method for testing computePerimeter method
	public void testComputePerimeter(double width){
		Square square = new Square(width);
		Assert.assertTrue(square.computePerimeter() == width * 4);
		
	}
	
	//tester method for testing toString method
	public void testToString(double width){
		Square square = new Square(width);
		Assert.assertTrue(square.toString().equals("Shape is a Square: width is " + width));
		
	}
	//tester for getShapeName method
	public void testGetShapeName(){
		Square square = new Square();
		Assert.assertTrue(square.getShapeName().equals("Square"));
	}
	
	
}