package edu.miracosta.cs113;

@SuppressWarnings("serial")
public class BinarySearchTree<E extends Comparable<E>> extends BinaryTree<E> implements SearchTree<E> {

	protected boolean addReturn;
	protected E deleteReturn;

	/**
	 * inserts item where it belongs in the tree.
	 * 
	 * @param item
	 *            item to be inserted in the tree
	 * @return returns true if item was inserted. otherwise, false (item already
	 *         exists)
	 */
	@Override
	public boolean add(E item) {

		root = add(root, item);
		return addReturn;
	}

	/**
	 * Recursive add method. post: The data field addReturn is set true if the
	 * item is added to the tree, false if the item is already in the tree.
	 * 
	 * @param localRoot
	 *            The local root of the subtree
	 * @param item
	 *            The object to be inserted
	 * @return The new local root that now contains the inserted item
	 */
	private Node<E> add(Node<E> localRoot, E item) {
		if (localRoot == null) {
			// item is not in the tree — insert it.
			addReturn = true;
			return new Node<E>(item);
		} else if (item.compareTo(localRoot.data) == 0) {
			// item is equal to localRoot.data
			addReturn = false;

		} else if (item.compareTo(localRoot.data) < 0) {
			// item is less than localRoot.data
			localRoot.left = add(localRoot.left, item);

		} else {
			// item is greater than localRoot.data
			localRoot.right = add(localRoot.right, item);

		}
		return localRoot;

	}

	/**
	 * Returns true if target is found in tree. otherwise, returns false.
	 * 
	 * @param target
	 *            target to be searched for
	 * @return Returns true if target is found in tree. otherwise, returns
	 *         false.
	 */
	@Override
	public boolean contains(E target) {

		return (find(target) != null);
	}

	/**
	 * Returns a reference to the data in the node that is equal to the target.
	 * 
	 * @param target
	 *            target to be searched for and referenced
	 * @return Returns a reference to the data in the node that is equal to the
	 *         target. otherwise returns null
	 */
	@Override
	public E find(E target) {

		return find(root, target);
	}

	/**
	 * Recursive find method.
	 * 
	 * @param localRoot
	 *            the local subtees root
	 * @param target
	 *            the object being searched for
	 * @return the object, if found, otherwise null
	 */
	private E find(Node<E> localRoot, E target) {

		if (localRoot == null) {
			return null;
		}

		int compResult = target.compareTo(localRoot.data);
		if (compResult == 0) {
			return localRoot.data;
		} else if (compResult < 0) {
			return find(localRoot.left, target);

		} else {
			return find(localRoot.right, target);
		}
	}

	/**
	 * removes target from tree and returns it
	 * 
	 * @param target
	 *            target to be removed from tree
	 * @return returns target if found and removed. otherwise, returns null
	 */
	@Override
	public E delete(E target) {

		root = delete(root, target);
		return deleteReturn;
	}

	/**
	 * Helper Method. deletes the target node if in tree.
	 * 
	 * @param localRoot
	 *            current root being examined
	 * @param target
	 *            data to be removed
	 * @return returns reference to the node that containds the data to be
	 *         removed. otherwise returns false
	 */
	private Node<E> delete(Node<E> localRoot, E target) {
		if (localRoot == null) {
			deleteReturn = null;

		} else {

			int compResult = target.compareTo(localRoot.data);
			if (compResult == 0) {
				deleteReturn = localRoot.data;

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

					localRoot.data = rightmostNodeDataAndRemove(localRoot, localRoot.left);

				}

			} else if (compResult < 0) {
				// item is less than localRoot.data
				localRoot.left = delete(localRoot.left, target);
			} else {
				// item is greater than localRoot.data
				localRoot.right = delete(localRoot.right, target);
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
	private E rightmostNodeDataAndRemove(Node<E> localRoot, Node<E> parentRoot) {
		if (localRoot.right == null) {
			parentRoot.right = localRoot.left;
			return localRoot.data;
		} else {

			return rightmostNodeDataAndRemove(localRoot.right, localRoot);
		}
	}

	/**
	 * removes target from tree
	 * 
	 * @param target
	 *            target to be removed from tree
	 * @return returns true if target is found and removed. otherwise, returns
	 *         false
	 */
	@Override
	public boolean remove(E target) {

		return (delete(target) != null);
	}

}
