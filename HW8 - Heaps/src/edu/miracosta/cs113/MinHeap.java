package edu.miracosta.cs113;

import java.util.ArrayList;
import java.util.Comparator;

@SuppressWarnings("serial")
public class MinHeap<E> extends Heap<E> {

	/**
	 * Compare two items using either a Comparator object’s compare method or
	 * their natural ordering using method compareTo. pre: If comparator is
	 * null, left and right implement Comparable<E>.
	 * 
	 * @param left
	 *            One item
	 * @param right
	 *            The other item
	 * @return Negative int if left less than right, 0 if left equals right,
	 *         positive int if left > right
	 * @throws ClassCastException
	 *             if items are not Comparable
	 */
	@Override
	public int compare(Object o1, Object o2) {
		if (comparator != null) { // A Comparator is defined.
			return comparator.compare((E) o1, (E) o2);
		} else { // Use left’s compareTo method.
			return ((Comparable<E>) o1).compareTo((E) o2);
		}
	}

}
