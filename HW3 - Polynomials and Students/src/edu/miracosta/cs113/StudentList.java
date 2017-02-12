package edu.miracosta.cs113;



public class StudentList<E extends Student> {
	
	private Node<E> head;
	private int size = 0;
	/**
	 * Empty constructor.  head set to null
	 */
	public StudentList(){
		head = null;
	}
	/**
	 * Single argument constructor.  head set to passed node
	 * 
	 * @param firstNode
	 * 			node to be set as first node in the list
	 */
	public StudentList(E firstNode){
		head = new Node<E> (firstNode);
		size++;
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
	 * adds new element to beginning of list
	 * 
	 * @param newStudent
	 * 			Object to be added to the list 
	 */
	public void addFirst(E newStudent){
		if(size == 0){
			head = new Node<E>(newStudent);
		}else{
			Node<E> tempNode = head;
			head = new Node<E>(newStudent);
			head.next = tempNode;
		}
		size++;
	}
	
	/**
	 * adds new element to end of list
	 * 
	 * @param newStudent
	 * 			Object to be added to the list 
	 */
	public void addEnd(E newStudent){
		if(size == 0){
			head = new Node<E>(newStudent);
		}else{
			Node<E> tempNode = head;
			while(tempNode.next != null){
				tempNode = tempNode.next;
			}
			tempNode.next = new Node<E>(newStudent);
		}
		size++;
	}
	
	
	/**
	 * removes ad returns first element of list.  If list is empty, returns null.
	 * 
	 *  * @returns
	 * 			 returns removed element in list. returns null if 
	 * 			list is empty.
	 */
	public E removeFirst(){
		Node<E> tempNode = head;
		if(size > 0){
			head = head.next;
			size--;
			return tempNode.data;
			
		}
		return null;
	}
	
	/**
	 * removes and returns specific element in list
	 * 
	 * @param newStudent
	 * 			Object to be added to the list 
	 * @returns
	 * 			 returns specific element in list. returns null if 
	 * 			list is empty or specified element is not found.
	 */
	public E removeSpecific(E remove){
		Node<E> tempNode = head;
		Node<E> removingNode = null;
		boolean isFound = false;
		if(size == 0){
			return null;
		}else if(head.data.equals(remove)){
			removingNode = head;
			isFound = true;
			removeFirst();
		}else if(size>0){
			while(tempNode.next != null && isFound == false){
				if(tempNode.next.data.equals(remove)){
					removingNode = tempNode.next;
					tempNode.next = tempNode.next.next;
					isFound = true;
					size--;
				}
				if(!isFound){
					tempNode = tempNode.next;
				}
			}
		}
		if(!isFound){
			return null;
		}else{
			return removingNode.data;
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
	 * String representation of list

	 * @return 
	 * 		returns string representation of list
	 */
	public String toString(){
		String studentList = "";
		for(int i= 0; i< size; i++){
			studentList += this.get(i).toString();
			if( i != size-1){
				studentList += ", ";
			}
		}
		return studentList;
	}
	
	
	
	private static class Node<E> {
		 private E data;
		 private Node<E> next = null;
		 
		 /**
			 * Creates Node containing reference to data object.
			 * 
			 * @param dataItem
			 *            data object to be refereneced
			 */
		 private Node(E dataItem) {
			 data = dataItem;
		 }
	}
}
