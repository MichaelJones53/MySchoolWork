package test;

import edu.miracosta.cs113.*;


import org.junit.Test;
import org.junit.Assert;


public class EquilateralTriangleTest {
	//checks method getShapeName
	@Test
	public void testShapeName(){
		testGetShapeName();
	}
	
	//checks methods if entered value is 0
	@Test
	public void testCheckZero(){
		double value = 0;
		testCheckSide(value);
		testComputeArea(value);
		testComputePerimeter(value);
		testToString(value);
	}

	//checks methods if entered value is a negative number
	@Test
	public void testCheckNegative(){
		double value = -6.8;
		testCheckSide(value);
		testComputeArea(value);
		testComputePerimeter(value);
		testToString(value);
	}
	
	//checks methods if entered value is a decimal
	@Test
	public void testCheckDecimal(){
		double value = 78.35;
		testCheckSide(value);
		testComputeArea(value);
		testComputePerimeter(value);
		testToString(value);
	}
	
	//checks methods if entered value is a whole number
	@Test
	public void testCheckWholeNumber(){
		double value = 10;
		testCheckSide(value);
		testComputeArea(value);
		testComputePerimeter(value);
		testToString(value);
	}
	
	//tester method for testing getSide method
	public void testCheckSide(double side){
		EquilateralTriangle triangle = new EquilateralTriangle(side);
		Assert.assertTrue(triangle.getSide() == side);
		
	}
	
	//tester method for testing computeArea method
	public void testComputeArea(double side){
		EquilateralTriangle triangle = new EquilateralTriangle(side);
		Assert.assertTrue(triangle.computeArea() == (Math.sqrt(3)/4) * (side * side));
		
		
	}
	
	//tester method for testing computePerimeter method
	public void testComputePerimeter(double side){
		EquilateralTriangle triangle = new EquilateralTriangle(side);
		Assert.assertTrue(triangle.computePerimeter() == side * 3);
		
		
	}
	
	//tester method for testing toString method
	public void testToString(double side){
		EquilateralTriangle triangle = new EquilateralTriangle(side);
		Assert.assertTrue(triangle.toString().equals("Shape is a Equilateral Triangle: one side is " + side));
		
		
	}
	
	//tester for getShapeName method
	public void testGetShapeName(){
		EquilateralTriangle triangle = new EquilateralTriangle();
		Assert.assertTrue(triangle.getShapeName().equals("Equilateral Triangle"));
	}
	
}
