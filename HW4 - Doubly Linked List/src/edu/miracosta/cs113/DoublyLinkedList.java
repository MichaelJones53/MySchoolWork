package edu.miracosta.cs113;


import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;



public class DoublyLinkedList<E>{
	
	// Data Fields
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
		if(index >= 0 && index <= size){
			if(index == 0){
				addFirst(obj);
			}else if(index == size){
				addLast(obj);
			}else{
				Node<E> current = head;
				for(int i = 0; i< index; i++){
					current = current.next;
				};
				Node<E> newNode = new Node<E>(obj);
				Node<E> tempPrev = current.prev;
				tempPrev.next = newNode;
				newNode.prev = tempPrev;
				current.prev = newNode;
				newNode.next = current;
				size++;
			}
		}else{
			throw new NoSuchElementException();
		}
	}
	
	
	/**
	 * adds new object to beginning of list
	 * 
	 * @param newItem
	 * 			Object to be added to the list 
	 */
	public void addFirst(E newItem){
		if(head == null){
			head = new Node<E>(newItem);
			tail = head;
		}else{
			Node<E> tempNode = head;
			head = new Node<E>(newItem);
			head.next = tempNode;
			
		}
		size++;
	}
	
	
	
	//public void addLast((E obj) adds object obj to the end of the list
	/**
	 * adds new element to end of list
	 * 
	 * @param newItem
	 * 			Object to be added to the list 
	 */
	public void addLast(E newItem){
		if(size == 0){
			head = new Node<E>(newItem);
			tail = head;
		}else{
			tail.next = new Node<E>(newItem);
			tail = tail.next;
		}
		size++;
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
		if(index >= 0 && index < size){
			Iterator<E> itr = iterator();
			for(int i = 0; i< index - 1 ; i++){
				itr.next();
			}
			return itr.next();
		}
		return null;
	}
	
	//public E getFirst() Gets the first element in the list.  Throws NoSuchElementException if the list is empty
	public E getFirst(){
		if(head != null){
			return head.data;
		}else{
			throw new NoSuchElementException();
		}
	}
	//public E getLast() Gets the last element in the list.  Throws NoSuchElementException if the list is empty
	public E getLast(){
		if(tail != null){
			return tail.data;
		}else{
			throw new NoSuchElementException();
		}
	}
	//public boolean remove(E obj) Removes the first occurrence of object obj from the list.  Returns True if the list contained object obj, otherwise returns false.  ***use its equals method***
	public boolean remove(E obj){
		boolean found = false;
		Node<E> tempNode = head;
		while(tempNode != null && !found){
			if(tempNode.data.equals(obj)){
				found = true;
			}
			tempNode = tempNode.next;
		}
		return found;
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
	private class DoubleListIterator implements ListIterator<E>{

		private Node<E> nextNode;
		private Node<E> lastItemReturned = null;
		private int index = 0;
		
		public DoubleListIterator(){
			nextNode = head;
		}
		
		public DoubleListIterator(int newIndex){
			if(newIndex < 0 || newIndex > size){
				throw new NoSuchElementException("Invalid index " + newIndex);
			}else if(newIndex == size){
				index = size;
				nextNode = null;
			}else{
				for(index = 0; index < newIndex; nextIndex()){
					nextNode = nextNode.next;
				}
			}
		}
		
		@Override
		public void add(E e) {
			Node<E> newNode = new Node<E>(e);
			//add empty
			if(head == null){
				head =  newNode;
				tail = head;
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
			
			//add head
			
			//add tail
			
			//add middle
			
			size++;
			index++;
			lastItemReturned = null;
			
		}

		@Override
		public boolean hasNext() {
			return nextNode != null;
		}

		@Override
		public boolean hasPrevious() {
			return (nextNode == null && size != 0 || nextNode.prev != null);
		}

		@Override
		public E next() {
			if(!hasNext()){
				throw new NoSuchElementException();
			}else{
				nextNode = nextNode.next;
				lastItemReturned = nextNode.prev;
				nextIndex();
				return lastItemReturned.data;
			}
		}

		@Override
		public int nextIndex() {
			return index++;
		}

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

		@Override
		public int previousIndex() {
			// TODO Auto-generated method stub
			return index--;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void set(E e) {
			// TODO Auto-generated method stub
			
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