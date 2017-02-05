package edu.miracosta.cs113;

import java.util.Scanner;

/**
 * Square.java :Represents a square. Extends Shape.
 * 
 * @author Michael Jones
 *
 */
public class Square extends Shape {
	// Data Fields
	/** 
	 * The width of the square. 
	 **/ 
	private double width = 0;

    // Constructors
	/**  
	 * The default constructor.
	*/
    public Square() {
        super("Square");
    }
	/** 
	 * Constructs a Circle with the specified radius. 
	 * @param radius the radius
	*/
    public Square(double width) {
        super("Square");
        this.width = width;
    }
    // Methods
    /** 
     * Get the width of the square.
     * @return The width 
     * */
    public double getWidth() {
        return width;
    }

/** 
 * Compute the area.
 * @return The area of the square
*/
    @Override
    public double computeArea() {
        return width * width;
    }
/** 
 * Compute the perimeter.
 * @return The perimeter of the square
*/
    @Override
    public double computePerimeter() {
        return 4* width;
    }
    /** 
     * Read the attributes of the sqyare. 
     **/
    @Override
    public void readShapeData() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the width of the Square");
        width = in.nextDouble();
        in.close();
        
    }
	/** 
	 * Create a string representation of the Square. 
	 * @return A string representation of the Square
	 */
    @Override
    public String toString() {
        return super.toString() + ": width is " + width;
    } 
}
