package edu.miracosta.cs113;


import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import edu.miracosta.cs113.StudentList.Node;


public class DoublyLinkedList<E>{
	
	// Data Fields
	private Node<E> head = null;
	private Node<E> tail = null;
	int size = 0;
	
	
	
	//public void add(int index, E obj) Inserts object obj into the list at position index
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
	
	//public E get(int index) Returns the item at position Index
	
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
		Node<E> location = new Node<E>();
		location.next = head;
		location.prev = tail;
		Iterator<E> itr = new Iterator<E>(){
			
			
			@Override
			public boolean hasNext() {
				if(location.next != null){
					return true;
				}else{
					return false;
				}
			}
			
			
			@Override
			public E next() {
				location.next = location.next.next;
				location.prev = location.prev.next;
				
				return location.prev.data;
			}
		};
		return itr;
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