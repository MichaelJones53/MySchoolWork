package edu.miracosta.cs113;

@SuppressWarnings("serial")
public class BinarySearchTreeWithRotate<E extends Comparable<E>> extends BinarySearchTree<E> {

	
	/**
	 * Rotates tree to left from local root node
	 */
	protected Node<E> rotateLeft(Node<E> localRoot){
		Node<E> temp = localRoot.right;
		localRoot.right = temp.left;
		temp.left = localRoot;
		localRoot =temp;
		
		return localRoot;
		
	}
	
	/**
	 * Rotates tree to right from local root node
	 */
	protected Node<E> rotateRight(Node<E> localRoot){
		Node<E> temp = localRoot.left;
		localRoot.left = temp.right;
		temp.right = localRoot;
		localRoot =temp;
		return localRoot;
	}
}
