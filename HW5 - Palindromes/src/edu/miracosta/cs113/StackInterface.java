package edu.miracosta.cs113;

import java.util.EmptyStackException;

/**
 * StackInterface.java : StackInterface for implementing Stack methods
 * 
 * @author Michael Jones
 * @version 1.0
 *
 */
public interface StackInterface<E> {

	/**
	 * returns whether or not the stack is empty
	 * 
	 * @return 
	 * 			returns true if the stack is empty, otherwise, false
	 */
	public boolean empty();
	
	/**
	 * returns the object at the top of the stack without removing it
	 * 
	 * @return 
	 * 			returns the object at the top of the stack without removing it.  throws EmptyStackException if stack is empty
	 */
	public E peek() throws EmptyStackException;
	
	/**
	 * returns and removes the object at the top of the stack
	 * 
	 * @return 
	 * 			returns the object at the top of the stack. throws EmptyStackException if stack is empty
	 */
	public E pop() throws EmptyStackException;
	
	/**
	 * adds object to top of stack and returns that same object
	 * 
	 * @return 
	 * 			returns the object at added to the top of the stack. 
	 */
	public E push(E obj);
}
