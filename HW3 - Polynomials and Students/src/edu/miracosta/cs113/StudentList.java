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
	
	//addFirst
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
	
	//addEnd
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
	
	
	//removeFirst
	public void removeFirst(){
		if(size > 0){
			head = head.next;
		}
		size--;
	}
	
	//removeSpecific
	public void removeSpecific(E remove){
		Node<E> tempNode = head;
		boolean isFound = false;
		if(head.data.equals(remove)){
			removeFirst();
		}else if(size>0){
			while(tempNode.next != null && isFound == false){
				if(tempNode.next.data.equals(remove)){
					tempNode.next = tempNode.next.next;
					isFound = true;
					size--;
				}
				if(!isFound){
					tempNode = tempNode.next;
				}
			}
		}
		
	}

	public int getSize(){
		return size;
	}
	public String toString(){
		String studentList = "";
		for(int i= 0; i< size; i++){
			studentList += this.get(i).toString()+", ";
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
