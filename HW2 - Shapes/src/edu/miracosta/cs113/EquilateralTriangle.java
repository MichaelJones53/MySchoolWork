package edu.miracosta.cs113;

import java.util.Scanner;

/**
 * Square.java :Represents a square. Extends Shape.
 * 
 * @author Michael Jones
 *
 */
public class EquilateralTriangle extends Shape {
	// Data Fields
	/** 
	 * One side of the triangle. 
	 **/ 
	private double side = 0;

    // Constructors
	/**  
	 * The default constructor.
	*/
    public EquilateralTriangle() {
        super("Equilateral Triangle");
    }
	/** 
	 * Constructs an Equilateral triangle with the specified radius. 
	 * @param side one side of the triangle
	*/
    public EquilateralTriangle(double side) {
        super("Equilateral Triangle");
        this.side = side;
    }
    // Methods
    /** 
     * Get the side of the triangle.
     * @return one side of the triangle 
     * */
    public double getSide() {
        return side;
    }

/** 
 * Compute the area.
 * @return The area of the triangle
*/
    @Override
    public double computeArea() {
        return (Math.sqrt(3)/4) * (side * side);
    }
/** 
 * Compute the perimeter.
 * @return The perimeter of the triangle
*/
    @Override
    public double computePerimeter() {
        return 3 * side;
    }
    /** 
     * Read the attributes of the triangle. 
     **/
    @Override
    public void readShapeData() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the lenght of one side of the triangle");
        side = in.nextDouble();
        in.close();
    }
	/** 
	 * Create a string representation of the triangle. 
	 * @return A string representation of the Triangle
	 */
    @Override
    public String toString() {
        return super.toString() + ": one side is " + side;
    } 
}