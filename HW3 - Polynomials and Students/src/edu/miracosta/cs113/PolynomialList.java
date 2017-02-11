package edu.miracosta.cs113;

import java.util.LinkedList;



public class PolynomialList<E extends Term> {
	
	private Node<E> head;
	private int size = 0;
	
	public PolynomialList(){
		head = null;
	}
	
	public PolynomialList(E firstNode){
		head = new Node<E> (firstNode, null, null);
	}
	
	
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
	
	public int getSize(){
		return size;
	}
	
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
	private void addAfter(Node<E> presentNode, E newTerm){
		if(presentNode.next == null){
			presentNode.next = new Node<E>(newTerm, presentNode, null);
		}else{
			presentNode.next = new Node<E>(newTerm, presentNode, presentNode.next);
		}
		size++;
	}
	
	private void addBefore(Node<E> presentNode, E newTerm){
		if(presentNode.prev == null){
			presentNode.prev = new Node<E>(newTerm, null, presentNode);
			head = presentNode.prev;
		}else{
			presentNode.prev = new Node<E>(newTerm, presentNode.prev, presentNode);
		}
		size++;
	}
	
	
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
	@Override
	public String toString(){
		String polyString = "";
		Node<E> currentNode = head;
		for(int i = 0; i < size; i++){
			polyString += currentNode.data.coefficient+"X^"+currentNode.data.exponent;
			if(currentNode.next != null){
				polyString += " + ";
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