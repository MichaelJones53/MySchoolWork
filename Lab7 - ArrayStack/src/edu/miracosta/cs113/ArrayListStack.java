package edu.miracosta.cs113;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class ArrayListStack<E> implements StackInterface<E> {
	private ArrayList<E> theData;
	
	/**
	 * No argument constructor.  Instantiates ArrayList to default size.
	 */
	public ArrayListStack(){
		theData = new ArrayList<E>();
	}
	
	/**
	 * Single argument constructor.  sets ArrayList size to passed parameter size
	 * 
	 * @param size
	 * 			integer size to set ArrayList to initially
	 */
	public ArrayListStack(int size){
		theData = new ArrayList<E>(size);
	}

	/**
	 * returns whether or not the stack is empty
	 * 
	 * @return 
	 * 			returns true if the stack is empty, otherwise, false
	 */
	@Override
	public boolean empty() {
		return theData.isEmpty();
	}

	/**
	 * returns the object at the top of the stack without removing it
	 * 
	 * @return 
	 * 			returns the object at the top of the stack without removing it.  throws EmptyStackException if stack is empty
	 */
	@Override
	public E peek() {
		if(theData.isEmpty()){
			throw new EmptyStackException();
		}else{
			return theData.get(theData.size()-1);
		}
	}

	/**
	 * returns and removes the object at the top of the stack
	 * 
	 * @return 
	 * 			returns the object at the top of the stack. throws EmptyStackException if stack is empty
	 */
	@Override
	public E pop() {
		if(theData.isEmpty()){
			throw new EmptyStackException();
		}else{
			return theData.remove(theData.size()-1);
		}
	}

	/**
	 * adds object to top of stack and returns that same object
	 * 
	 * @return 
	 * 			returns the object at added to the top of the stack. 
	 */
	@Override
	public E push(E obj) {
		theData.add(obj);
		return obj;
	}

	@Override
	public String toString(){
		return theData.toString();
	}
}
