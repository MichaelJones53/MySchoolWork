package edu.miracosta.cs113;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;

@SuppressWarnings("serial")
public abstract class Heap<E> extends PriorityQueue<E> implements Comparator<E> {

	private ArrayList<E> theData;

	/**
	 * pre: The ArrayList theData is in heap order. post: The item is in the
	 * priority queue and theData is in heap order.
	 * 
	 * @param item
	 *            The item to be inserted
	 * @throws NullPointerException
	 *             if the item to be inserted is null.
	 **/
	@Override
	public boolean offer(E item) {
		// Add the item to the heap.
		theData.add(item);
		// child is newly inserted item.
		int child = theData.size() - 1;
		int parent = (child - 1) / 2; // Find child’s parent.
		// Reheap
		while (parent >= 0 && compare(theData.get(parent), theData.get(child)) > 0) {
			swap(parent, child);
			child = parent;
			parent = (child - 1) / 2;
		}
		return true;
	}

	/**
	 * Remove an item from the priority queue pre: The ArrayList theData is in
	 * heap order. post: Removed smallest item, theData is in heap order.
	 * 
	 * @return The item with the smallest priority value or null if empty.
	 */
	@Override
	public E poll() {
		if (isEmpty()) {
			return null;
		}
		// Save the top of the heap.
		E result = theData.get(0);
		// If only one item then remove it.
		if (theData.size() == 1) {
			theData.remove(0);
			return result;
		}
		/*
		 * Remove the last item from the ArrayList and place it into the first
		 * position.
		 */
		theData.set(0, theData.remove(theData.size() - 1));
		// The parent starts at the top.
		int parent = 0;
		while (true) {
			int leftChild = 2 * parent + 1;
			if (leftChild >= theData.size()) {
				break; // Out of heap.
			}
			int rightChild = leftChild + 1;
			int minChild = leftChild; // Assume leftChild is smaller.
			// See whether rightChild is smaller.
			if (rightChild < theData.size() && compare(theData.get(leftChild), theData.get(rightChild)) > 0) {
				minChild = rightChild;
			}
			// assert: minChild is the index of the smaller child.
			// Move smaller child up heap if necessary.
			if (compare(theData.get(parent), theData.get(minChild)) > 0) {
				swap(parent, minChild);
				parent = minChild;
			} else { // Heap property is restored.
				break;
			}
		}

		return result;

	}
	/**
	 * Returns the smallest entry without removing it.  if empty, returns null
	 * @return
	 * 		returns smallest entry. if empty, returns null
	 */
	@Override
	public E peek(){
		if(theData.isEmpty()){
			return null;
		}else{
			return theData.get(0);
		}
		
	}
	
	
	
	
	/**
	 * Removes the smallest entry and returns it if list is not empty.  if empty, throws NoSuchElementException
	 * @return
	 * 		returns smallest entry in list.  if empty, throws NoSuchElementException
	 */
	@Override
	public E remove(){
		if (isEmpty()) {
			throw new NoSuchElementException();
		}else{
			return poll();
		}
		
	}

	/**
	 * 
	 * @param parent
	 * @param child
	 */
	private void swap(int parent, int child) {
		E temp = (E) theData.get(parent);
		theData.set(parent, theData.get(child));
		theData.set(child, temp);
	}

}
