package edu.miracosta.cs113;
/**
 * PolynomialList.java : Doubly linked list for polynomials
 * 
 * @author Michael Jones
 * @version 1.0
 *
 */
import java.util.LinkedList;



public class PolynomialList<E extends Term> {
	
	private Node<E> head;
	private int size = 0;
	/**
	 * Empty constructor.  head set to null
	 */
	public PolynomialList(){
		head = null;
	}
	/**
	 * Single argument constructor.  head set to passed node
	 * 
	 * @param firstNode
	 * 			node to be set as first node in the list
	 */
	public PolynomialList(E firstNode){
		head = new Node<E> (firstNode, null, null);
	}
	
	/**
	 * Adds provided polynomial to list
	 * 
	 * @param newTerm
	 * 			new polynomial term to be added to list
	 */
	public boolean add(E newTerm){
		Node<E> currentNode = head;
		if(currentNode == null){
			head = new Node<E>(newTerm, null, null);
			size++;
		}else{
			while(newTerm.exponent < currentNode.data.exponent && currentNode.next != null){
				currentNode = currentNode.next;
			}
			addByComparison(currentNode, newTerm);
		}
		
	
		return true;
	}
	
	/**
	 * accessor method for elements of list
	 * 
	 * @param location
	 * 			location of list to retrieve data
	 * @return
	 * 		    returns shallow copy data 
	 */
	public E get(int location){
		Node<E> temp = head;
		if(location <0 || location >= size){
			return null;
		}else{
			for(int i=0; i<location; i++){
				temp = temp.next;
			}
			return temp.data;
		}
		
	}
	/**
	 * accessor method for list size
	 * 
	 * @return
	 * 		    returns list size as integer
	 */
	public int getSize(){
		return size;
	}
	/**
	 * Adds provided polynomial to list
	 * 
	 * @param callingNode
	 * 			node comparing to decide where to add new term
	 * 
	 * @param compaaringTerm
	 * 			term being compared against to be added to list
	 */
	private void addByComparison(Node<E> callingNode, E comparingTerm){
		int whereToAdd = callingNode.data.compareTo(comparingTerm);
		switch (whereToAdd){
		case 1:
			addAfter(callingNode, comparingTerm);
			break;
		case 0:
			combine(callingNode, comparingTerm);
			break;
		case -1:
			addBefore(callingNode, comparingTerm);
			break;
		}
	}
	
	/**
	 * Adds provided polynomial to list
	 * 
	 * @param presentNode
	 * 			pivot node to add newTerm beside
	 * 
	 * @param newTerm
	 * 			new term to be added to list
	 */
	private void addAfter(Node<E> presentNode, E newTerm){
		if(presentNode.next == null){
			presentNode.next = new Node<E>(newTerm, presentNode, null);
		}else{
			presentNode.next = new Node<E>(newTerm, presentNode, presentNode.next);
		}
		size++;
	}
	/**
	 * Adds provided polynomial to list
	 * 
	 * @param presentNode
	 * 			pivot node to add newTerm beside
	 * 
	 * @param newTerm
	 * 			new term to be added to list
	 */
	private void addBefore(Node<E> presentNode, E newTerm){
		if(presentNode.prev == null){
			presentNode.prev = new Node<E>(newTerm, null, presentNode);
			head = presentNode.prev;
			
		}else{
			presentNode.prev.next = new Node<E>(newTerm, presentNode.prev, presentNode);
		}
		size++;
	
	}
	
	/**
	 * Adds provided polynomial to list
	 * 
	 * @param presentNode
	 * 			 node to be combine newTerm with
	 * 
	 * @param newTerm
	 * 			new term to be added to list
	 */
	private void combine(Node<E> presentNode, E newTerm){
		int newCoef = presentNode.data.coefficient + newTerm.getCoefficient();
		Node<E> newPrev;
		Node<E> newNext;
		Node<E> newNode = null;
		E finalTerm = (E) new Term(newCoef, presentNode.data.exponent);
		
		newPrev = presentNode.prev;
		newNext = presentNode.next;
		newNode = new Node<E>(finalTerm, newPrev, newNext);
		
		if(presentNode.prev == null){
			head = newNode;
		}else{
			presentNode.prev.next = newNode;
		}if(presentNode.next != null){
			presentNode.next.prev = newNode;
		}
	}
	
	/**
	 * String representation of list

	 * @return 
	 * 		returns string representation of list
	 */
	@Override
	public String toString(){
		String polyString = "";
		Node<E> currentNode = head;
		for(int i = 0; i < size; i++){
			polyString += currentNode.data.coefficient+"X^"+currentNode.data.exponent;
			if(currentNode.next != null){
				if(currentNode.next.data.coefficient >=0){
					polyString += " + ";
				}else{
					polyString += "  ";
				}
				currentNode = currentNode.next;
			}
			
		}
		return polyString;
	}
	
	private static class Node<E> {
		 private E data;
		 private Node<E> next = null;
		 private Node<E> prev = null;
		 
		 /**
			 * Creates Node containing reference to data object.
			 * 
			 * @param dataItem
			 *            data object to be refereneced
			 * @param prevItem
			 *            previous object to be refereneced
			 */
		 private Node(E dataItem, Node<E> prevItem, Node<E> nextItem) {
			 data = dataItem;
			 prev = (Node<E>)prevItem;
			 next = (Node<E>) nextItem;
		 }
	} 
}