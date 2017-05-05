package edu.miracosta.cs113;

@SuppressWarnings("serial")
public class BinarySearchTreeWithRotate<E extends Comparable<E>> extends BinarySearchTree<E> {

	
	/**
	 * Rotates tree to left from local root node
	 */
	protected void rotateLeft(){
		Node<E> temp = root.right;
		root.right = temp.left;
		temp.left = root;
		root =temp;
		
		
	}
	
	/**
	 * Rotates tree to right from local root node
	 */
	protected void rotateRight(){
		Node<E> temp = root.left;
		root.left = temp.right;
		temp.right = root;
		root =temp;
	}
}
