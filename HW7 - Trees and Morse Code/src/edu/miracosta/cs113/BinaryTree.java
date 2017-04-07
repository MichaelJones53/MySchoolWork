package edu.miracosta.cs113;

import java.io.Serializable;
import java.util.Scanner;

@SuppressWarnings("serial")
public class BinaryTree<E> implements Serializable {

	protected Node<E> root;

	/**
	 * No argument constructor.  instantiates BinaryTree object
	 */
	public BinaryTree() {
		root = null;
	}

	/**
	 * Constructs binary tree with given node as the root
	 * 
	 * @param root
	 * 		node to be used as trees root
	 */
	protected BinaryTree(Node<E> root) {
		this.root = root;
	}

	/**
	 * Constructs binary tree with given data as the root and the two given subtrees
	 * 
	 * @param data
	 * 			data to be set in root node
	 * @param leftTree
	 * 			Binary tree to be used as root nodes left subtree
	 * @param rightTree
	 * 			Binary tree to be used as root nodes right subtree
	 */
	public BinaryTree(E data, BinaryTree<E> leftTree, BinaryTree<E> rightTree) {
		root = new Node<E>(data);
		if (leftTree != null) {
			root.left = leftTree.root;
		} else {
			root.left = null;
		}
		if (rightTree != null) {
			root.right = rightTree.root;
		} else {
			root.right = null;
		}
	}

	/**
	 * gets the trees left subtree
	 *
	 * @return
	 * 		Returns the trees left subtree. returns null if left subtree is empty 
	 */
	public BinaryTree<E> getLeftSubtree() {
		if (root != null && root.left != null) {
			return new BinaryTree<E>(root.left);
		} else {
			return null;
		}
	}

	/**
	 * gets the trees right subtree
	 *
	 * @return
	 * 		Returns the trees right subtree. returns null if right subtree is empty 
	 */
	public BinaryTree<E> getRightSubtree() {
		if (root != null && root.right != null) {
			return new BinaryTree<E>(root.right);
		} else {
			return null;
		}
	}

	/**
	 * gets the data from the root node
	 *
	 * @return
	 * 		Returns the root nodes data.   returns null if node is null
	 */
	public E getData() {
		if (root != null) {
			return root.data;
		} else {
			return null;
		}
	}

	/**
	 * identifies if the node is a leaf node
	 * 
	 * @return
	 * 		returns true if node is a leaf node.  otherwise, returns false
	 */
	public boolean isLeaf() {
		return (root.left == null && root.right == null);
	}

	/**
	 * provides preorder traversal string representation of entire binary tree
	 * 
	 * @return
	 * 		returns preorder traversal string representation of binary tree
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		preOrderTraverse(root, 1, sb);
		return sb.toString();
	}

	/**
	 * performs preorder traversal of tree recursively.  
	 * @param node	
	 * 		root of tree being traversed
	 * 
	 * @param depth
	 * 		current level of tree
	 * 
	 * @param sb
	 * 		string being appended to be returned as string representation of tree
	 * 
	 * @return
	 * 		returns sb as preordered traversal string representation of tree 
	 */
	private void preOrderTraverse(Node<E> node, int depth, StringBuilder sb) {
		for (int i = 1; i < depth; i++) {
			sb.append(" ");
		}
		if (node == null) {
			sb.append("null\n");
		} else {
			sb.append(node.toString() + "\n");
			preOrderTraverse(node.left, depth + 1, sb);
			preOrderTraverse(node.right, depth + 1, sb);
		}
	}

	/**
	 * Constructs binary tree by reading data from scanner
	 * @param scan
	 * 		scanner being read from
	 * @return
	 * 		Binary tree created from scanner
	 */
	public static BinaryTree<String> readBinaryTree(Scanner scan) {
		String data = scan.next();
		if (data.equals("null")) {
			return null;
		} else {
			BinaryTree<String> leftTree = readBinaryTree(scan);
			BinaryTree<String> rightTree = readBinaryTree(scan);
			return new BinaryTree<String>(data, leftTree, rightTree);
		}
	}
	
	

	protected static class Node<E> implements Serializable {
		protected E data;
		protected Node<E> left;
		protected Node<E> right;


		/**
		 * No argument constructor.  instantiates Node object
		 */
		public Node(E data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}

		/**
		 * provides String representation of data in node.  assumes node is not null
		 * 
		 * @return
		 * 		returns string representation of data in node
		 */
		public String toString() {
			return data.toString();
		}
	}
}
