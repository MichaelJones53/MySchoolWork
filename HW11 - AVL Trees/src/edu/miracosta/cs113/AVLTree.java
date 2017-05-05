package edu.miracosta.cs113;

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

	private AVLNode<E> rebalanceLeft(AVLNode<E> localRoot) {
		System.out.println("rebalancing left on: " + localRoot.data);
		AVLNode nextLeft = (AVLNode) localRoot.left;
		if (nextLeft.balance < AVLNode.BALANCED) {
			incrementBalance(nextLeft);
			decrementBalance(localRoot);
			decrementBalance(localRoot);
			return (AVLTree<E>.AVLNode<E>) rotateRight(localRoot);
		} else {
			incrementBalance(nextLeft);
			localRoot.left = rotateLeft(localRoot.left);
			incrementBalance(localRoot);
			return (AVLTree<E>.AVLNode<E>) rotateRight(localRoot);

		}

	}

	private AVLNode<E> rebalanceRight(AVLNode<E> localRoot) {
		System.out.println("reb right entered: "+localRoot.data+"  bal: "+localRoot.balance);
		AVLNode nextRight = (AVLNode) localRoot.right;
		if (nextRight.balance > AVLNode.BALANCED) {
			decrementBalance(nextRight);
			decrementBalance(localRoot);
			return (AVLTree<E>.AVLNode<E>) rotateLeft(localRoot);
		} else {
			incrementBalance(nextRight);
			localRoot.left = rotateRight(localRoot.left);
			decrementBalance(localRoot);
			return (AVLTree<E>.AVLNode<E>) rotateLeft(localRoot);

		}
	}

	private void decrementBalance(AVLNode<E> node) {
		// Decrement the balance.
		node.balance--;
		if (node.balance == AVLNode.BALANCED) {
			/** If now balanced, overall height has not increased. */
			increase = false;
		}
	}

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

		return null;
	}

	@SuppressWarnings("serial")
	private class AVLNode<E> extends BinaryTree.Node<E> {
		private static final int LEFT_HEAVY = -1;
		private static final int RIGHT_HEAVY = 1;
		private static final int BALANCED = 0;
		private int balance;

		public AVLNode(E data) {
			super(data);
			balance = 0;
		}

	}

}
