package edu.miracosta.cs113;
/**
 * DoublyLinkedList.java : Doubly linked list class
 * 
 * @author Michael Jones
 * @version 1.0
 *
 */

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;



public class DoublyLinkedList<E>{
	
	private Node<E> head = null;
	private Node<E> tail = null;
	int size = 0;
	
	
	
	/**
	 * adds new object to at provided index
	 * 
	 * @param index
	 * 			index to add new list item at
	 * @param obj
	 * 			object to be added to list 
	 */
	public void add(int index, E obj){
		DoubleListIterator itr = new DoubleListIterator(index);
		
		itr.add(obj);
	}
	
	
	/**
	 * adds new object to beginning of list
	 * 
	 * @param newItem
	 * 			Object to be added to the list 
	 */
	public void addFirst(E obj){
		DoubleListIterator itr = new DoubleListIterator();
		itr.add(obj);
	}
	
	
	
	
	/**
	 * adds new element to end of list
	 * 
	 * @param newItem
	 * 			Object to be added to the list 
	 */
	public void addLast(E obj){
		DoubleListIterator itr = new DoubleListIterator(size);
		itr.add(obj);
	}
	
	
	/**
	 * Gets  item at position Index
	 * 
	 * @param index
	 * 			location of object data to retreive
	 * @return
	 * 		Returns the item at position Index 
	 */
	public E get(int index){
		DoubleListIterator itr = new DoubleListIterator(index);
		return itr.next();
		
	}
	
	/**
	 * Gets first item in list
	 * 
	 * @return
	 * 		Returns the first element in the list.  Throws NoSuchElementException if the list is empty
	 */
	public E getFirst(){
		return head.data;
	}
	
	/**
	 * Gets last item in list
	 * 
	 * @return
	 * 		Returns the last element in the list.  Throws NoSuchElementException if the list is empty
	 */
	public E getLast(){
		if(tail != null){
			return tail.data;
		}else{
			throw new NoSuchElementException();
		}
	}
	
	/**
	 * Removes first occurrence of pass object if one is in the list
	 * 
	 * @return
	 * 		Returns True if the list contained object obj, otherwise returns false
	 */
	public boolean remove(E obj){
		DoubleListIterator itr = new DoubleListIterator();
		
		boolean isFound = false;
		while(isFound == false && itr.hasNext()){
			if(itr.next().equals(obj)){
				
				isFound = true;
				
				itr.remove();
			}
		}
		return isFound;
	}
	
	/**
	 * accessor method for list size
	 * 
	 * @return
	 * 		    Returns the number of objects contained in the list
	 */
	public int size(){
		return size;
	}
	/**
	 * String representation of list

	 * @return 
	 * 		returns string representation of list
	 */
	// create iterator
	public Iterator<E> iterator(){
	
		return null;
	}
	/**
	 * String representation of list

	 * @return 
	 * 		returns string representation of list
	 */
	public String toString(){
		DoubleListIterator itr = new DoubleListIterator();
		String listAsString = "";
		while(itr.hasNext()){
			listAsString += itr.next()+"\n"; 
		}
		return listAsString;
	}
	private class DoubleListIterator implements ListIterator<E>{

		private Node<E> nextNode = head;
		private Node<E> lastItemReturned = null;
		private int index = 0;
		// Constructors
		/**  
		 * The default constructor.
		*/
		public DoubleListIterator(){
		}
	
		/**  
		 * Constructor that creates iterator and identified index.
		 * @param newIndex
		 * 		Index to iterate iterator to at instantation
		*/
		public DoubleListIterator(int newIndex){
			
			if(newIndex < 0 || newIndex > size){
				throw new NoSuchElementException("Invalid index " + newIndex);
			}else if(newIndex == size){
				index = newIndex;
				nextNode = null;
				
			}else if(newIndex == 0){
				nextNode = head;
			}else{
				nextNode = head;
				for(index = 0; index < newIndex; index++){
					nextNode = nextNode.next;
				}
			}
		}
		/**
		 * adds new element to list
		 * 
		 * @param e
		 * 			Object to be added to the list 
		 */
		@Override
		public void add(E e) {
			Node<E> newNode = new Node<E>(e);
			
			if(head == null){
				head =  newNode;
				tail = newNode;
				nextNode = newNode;
			}else if(nextNode == head){
				
				newNode.next = nextNode;
				nextNode.prev = newNode;
				head = newNode;
			}else if(nextNode == null){
				tail.next = newNode;
				newNode.prev = tail;
				tail = newNode;
			}else{
				newNode.prev = nextNode.prev;
				nextNode.prev.next = newNode;
				newNode.next = nextNode;
				nextNode.prev = newNode;
			}
			size++;
			index++;
			
			lastItemReturned = null;
		}
		/**
		 * identifies if there is another item in the list 
		 * 
		 * @return
		 * 		Returns True if list contains a next item, otherwise false 
		 */
		@Override
		public boolean hasNext() {
			return nextNode != null;
		}
		/**
		 * identifies if there is a previous item in the list 
		 * 
		 * @return
		 * 		Returns True if list contains a previous item, otherwise false 
		 */
		@Override
		public boolean hasPrevious() {
			return (nextNode == null && size != 0 || nextNode.prev != null);
		}

		/**
		 * Advances the iterator to the next position 
		 * 
		 * @return
		 * 		Returns the data of the node being traversed over.  Throws NoSuchElementException if next is null
		 */
		@Override
		public E next() {
			if(!hasNext()){
				throw new NoSuchElementException();
			}else{
				lastItemReturned = nextNode;
				nextNode = nextNode.next;
				
				index++;
				return lastItemReturned.data;
			}
		}
		/**
		 * Next index if index were to be incremented 
		 * 
		 * @return
		 * 		Returns index value if it were to be incremented
		 */
		@Override
		public int nextIndex() {
			return index + 1;
		}

		/**
		 * Retreats the iterator back a position 
		 * 
		 * @return
		 * 		Returns the data of the node being traversed over.  Throws NoSuchElementException if previous is null
		 */
		@Override
		public E previous() {
			if(!hasPrevious()){
				throw new NoSuchElementException();
			}else if(nextNode == null){
				nextNode = tail;
			}else{
				nextNode = nextNode.prev;
			}
			lastItemReturned = nextNode;
			index--;
			return lastItemReturned.data;
		}

		/**
		 * previous index if index were to be decremented 
		 * 
		 * @return
		 * 		Returns index value if it were to be decremented
		 */
		@Override
		public int previousIndex() {
			
			return index - 1;
		}

		/**
		 * Removes last node traversed over.  Throws IllegalStateException if no element has been traversed
		 * 
		 */
		@Override
		public void remove() {
			if(lastItemReturned == null){
				throw new IllegalStateException();
			}
			if(lastItemReturned == head && tail == head){
				head = null;
				tail = null;
				nextNode = null;
			}else if(lastItemReturned == head){
				head = head.next;
				nextNode = head;
			}else if(lastItemReturned == tail){
				tail.prev.next = null;
				tail = tail.prev;
				nextNode = null;
				
			}else if(lastItemReturned == nextNode){
				//moved backwards through list
				nextNode.prev.next = nextNode.next;
				nextNode.next.prev = lastItemReturned.prev;
			}else{
				//moved forward through list
				lastItemReturned.prev.next = nextNode;
				nextNode.prev = lastItemReturned.prev;
			}
			
			size--;
			lastItemReturned = null;
		}

		/**
		 * Method not supported by this class.  Throws UnsupportedOperationException if called
		 */
		@Override
		public void set(E arg0) {
			throw new UnsupportedOperationException("set operation is not supported by list");
		}
	}
	private static class Node<E> {
		 private E data;
		 private Node<E> next = null;
		 private Node<E> prev = null;
		 
		 private Node() {
			 data = null;
		 }
		 /**
			 * Creates Node containing reference to data object.
			 * 
			 * @param dataItem
			 *            data object to be refereneced
			 * @param prevItem
			 *            previous object to be refereneced
			 */
		 private Node(E dataItem) {
			 data = dataItem;
		 }
	} 
}