package edu.miracosta.cs113;

import edu.miracosta.cs113.BinaryTree.Node;

public class AVLTree<E extends Comparable<E>> extends BinarySearchTreeWithRotate<E> {
	private boolean increase;

	@Override
	public boolean add(E item) {
		increase = false;
		root = add((AVLNode<E>) root, item);
		return addReturn;
	}

	/**
	 * Recursive add method. Inserts the given object into the tree. post:
	 * addReturn is set true if the item is inserted,false if the item is
	 * already in the tree.
	 * 
	 * @param localRoot
	 *            The local root of the subtree
	 * @param item
	 *            The object to be inserted
	 * @return The new local root of the subtree with the item inserted
	 * 
	 */

	private AVLNode<E> add(AVLNode<E> localRoot, E item) {

		if (localRoot == null) {
			addReturn = true;
			increase = true;
			return new AVLNode<E>(item);
		}
		if (item.compareTo(localRoot.data) == 0) {
			// Item is already in the tree.
			increase = false;
			addReturn = false;
			return localRoot;
		} else if (item.compareTo(localRoot.data) < 0) {
			// item < data
			localRoot.left = add((AVLNode<E>) localRoot.left, item);

			if (increase) {

				decrementBalance(localRoot);
				if (localRoot.balance < AVLNode.LEFT_HEAVY) {
					increase = false;
					return rebalanceLeft(localRoot);
				}

			}

		} else if (item.compareTo(localRoot.data) > 0) {
			localRoot.right = add((AVLNode<E>) localRoot.right, item);

			if (increase) {
				incrementBalance(localRoot);
				if (localRoot.balance > AVLNode.RIGHT_HEAVY) {
					increase = false;
					return rebalanceRight(localRoot);
				}

			}
		}
		return localRoot; // Rebalance not needed.

	}

	/**
	 * Helper Method. rebalances tree to the left that has become out of balance
	 * 
	 * @param localRoot
	 *            root to be rebalanced to the lett
	 * @return returns rebalanced tree
	 */
	private AVLNode<E> rebalanceLeft(AVLNode<E> localRoot) {
		AVLNode<E> nextLeft = (AVLNode<E>) localRoot.left;
		AVLNode<E> nextNextLeft = (AVLNode<E>) localRoot.left.left;
		System.out.println("************reb-Left*******");

		if (nextLeft.balance > AVLNode.BALANCED) {
			System.out.println(" > entered (Left-RIght");
		AVLNode<E> nextLeftRight = (AVLNode<E>) localRoot.left.right;

			if(nextLeftRight.balance < AVLNode.BALANCED){
				incrementBalance(nextLeftRight);
				incrementBalance(localRoot);
			}else if(nextLeftRight.balance > AVLNode.BALANCED){
				decrementBalance(nextLeftRight);
				decrementBalance(nextLeft);
			}

			decrementBalance(nextLeft);
			localRoot.left = rotateLeft(localRoot.left);
			incrementBalance(localRoot);
			incrementBalance(localRoot);
			System.out.println("data: " + localRoot.data + "  new bal: " + localRoot.balance);
			System.out.println("***********************");
			return (AVLTree<E>.AVLNode<E>) rotateRight(localRoot);

		} else {

			System.out.println(" < entered (Left-Left");

			incrementBalance(nextLeft);
			System.out.println("data: " + nextLeft.data + "  new bal: " + nextLeft.balance);
			System.out.println("data: " + nextLeft.left.data + "  bal: " + nextNextLeft.balance);

			incrementBalance(localRoot);
			incrementBalance(localRoot);

			System.out.println("data: " + localRoot.data + "  double dec to new bal: " + localRoot.balance);
			System.out.println("***********************");
			return (AVLTree<E>.AVLNode<E>) rotateRight(localRoot);

		}

	}

	/**
	 * Helper Method. rebalances tree to the right that has become out of
	 * balance
	 * 
	 * @param localRoot
	 *            root to be rebalanced to the right
	 * @return returns rebalanced tree
	 */
	private AVLNode<E> rebalanceRight(AVLNode<E> localRoot) {
		System.out.println("********rebRight***************");
		AVLNode nextRight = (AVLNode<E>) localRoot.right;
		AVLNode nextNextRight = (AVLNode<E>) localRoot.right.right;
		// System.out.println("nextright :"+nextRight.data+" bal:
		// "+nextRight.balance);

		if (nextRight.balance > AVLNode.BALANCED) {
			System.out.println(" > entered (Right-RIght)");
			decrementBalance(nextRight);
			decrementBalance(localRoot);
			decrementBalance(localRoot);
			System.out.println("***********************");
			return (AVLTree<E>.AVLNode<E>) rotateLeft(localRoot);
		} else {
			System.out.println(" < entered (Right-Left)");
			incrementBalance((AVLNode<E>) localRoot.right);

			localRoot.right = rotateRight(localRoot.right);

			System.out.println("rotating left on " + localRoot.data);

			decrementBalance(localRoot);
			decrementBalance(localRoot);
			System.out.println("data: " + localRoot.data + "  double dec to new bal: " + localRoot.balance);
			System.out.println("***********************");
			return (AVLTree<E>.AVLNode<E>) rotateLeft(localRoot);

		}
	}

	/**
	 * Helper Method. decrements the balance of a node
	 * 
	 * @param node
	 *            node whos balance is to be decremented
	 * 
	 */
	private void decrementBalance(AVLNode<E> node) {
		// Decrement the balance.
		node.balance--;
		if (node.balance == AVLNode.BALANCED) {
			/** If now balanced, overall height has not increased. */
			increase = false;
		}
	}

	/**
	 * Helper Method. increments the balance of a node
	 * 
	 * @param node
	 *            node whos balance is to be increments
	 * 
	 */
	private void incrementBalance(AVLNode<E> node) {
		// Decrement the balance.
		node.balance++;
		if (node.balance == AVLNode.BALANCED) {
			/** If now balanced, overall height has not increased. */
			increase = false;
		}
	}

	@Override
	public E delete(E target) {

		increase = false;
		deleteReturn = null;
		root = delete((AVLNode<E>) root, target);
		return deleteReturn;
	}

	private Node<E> delete(AVLNode<E> localRoot, E target) {
		if (localRoot == null) {
			deleteReturn = null;

		} else {

			int compResult = target.compareTo(localRoot.data);
			if (compResult == 0) {
				deleteReturn = localRoot.data;
				increase = true;

				if (localRoot.left == null && localRoot.right == null) {
					return null;
				} else if (localRoot.left == null) {
					return localRoot.right;
				} else if (localRoot.right == null) {
					return localRoot.left;
				} else {
					if (localRoot.left.right == null) {
						localRoot.left.right = localRoot.right;
						return localRoot.left;
					}

					localRoot.data = rightmostNodeDataAndRemove(localRoot.left, localRoot.left);

				}

			} else if (compResult < 0) {
				// item is less than localRoot.data
				localRoot.left = delete((AVLNode<E>) localRoot.left, target);
				System.out.println("looking left.  increase=" + increase);
				if (increase) {
					incrementBalance(localRoot);
					System.out.println("Inc locRoot: " + localRoot.data + "new bal: " + localRoot.balance);
					if (localRoot.balance > AVLNode.RIGHT_HEAVY) {
						increase = false;
						return rebalanceRight(localRoot);
					}

				}
			} else {
				// item is greater than localRoot.data
				System.out.println("looking right.  increase=" + increase);
				localRoot.right = delete((AVLNode<E>) localRoot.right, target);
				if (increase) {
					decrementBalance(localRoot);
					System.out.println("dec locRoot: " + localRoot.data + "new bal: " + localRoot.balance);
					if (localRoot.balance < AVLNode.LEFT_HEAVY) {
						increase = false;

						return rebalanceLeft(localRoot);
					}
				}
			}
		}
		return localRoot;
	}

	/**
	 * Helper method. finds the rightmost node, returns its data and removes
	 * that node
	 * 
	 * @param localRoot
	 *            current root being examined
	 * @param parentRoot
	 *            local roots parent
	 * @return returns data of rightmost root
	 */
	@Override
	protected E rightmostNodeDataAndRemove(Node<E> localRoot, Node<E> parentRoot) {
		if (localRoot.right == null) {
			decrementBalance((AVLNode<E>) parentRoot);
			parentRoot.right = localRoot.left;
			return localRoot.data;
		} else {

			return rightmostNodeDataAndRemove(localRoot.right, localRoot);
		}
	}

	@SuppressWarnings("serial")
	private class AVLNode<E> extends BinaryTree.Node<E> {
		private static final int LEFT_HEAVY = -1;
		private static final int RIGHT_HEAVY = 1;
		private static final int BALANCED = 0;
		private int balance;

		/**
		 * Constructor for AVLNode
		 * 
		 * @param data
		 *            data to be inserted into new AVLNode
		 */
		public AVLNode(E data) {
			super(data);
			balance = 0;
		}
		
		@Override
		public String toString(){
			return data.toString()+" ("+balance+")";
		}

	}

}
