package edu.miracosta.cs113;

public interface SearchTree<E> {
	
	/**
	 * inserts item where it belongs in the tree.
	 * @param item
	 * 		item to be inserted in the tree
	 * @return
	 * 		returns true if item was inserted.  otherwise, false (item already exists)
	 */
	public boolean add(E item);
	
	/**
	 * Returns true if target is found in tree.  otherwise, returns false.
	 * @param target
	 * 		target to be searched for
	 * @return
	 * 		Returns true if target is found in tree.  otherwise, returns false.
	 */
	public boolean contains(E target);
	
	/**
	 * Returns a reference to the data in the node that is equal to the target.
	 * @param target
	 * 		target to be searched for and referenced
	 * @return
	 * 		Returns a reference to the data in the node that is equal to the target.  otherwise returns null
	 */
	public E find(E target);
	
	/**
	 * removes target from tree and returns it
	 * @param target
	 * 		target to be removed from tree
	 * @return
	 * 		returns target if found and removed. otherwise, returns null
	 */
	public E delete(E target);
	
	/**
	 * removes target from tree
	 * @param target
	 * 		target to be removed from tree
	 * @return
	 * 		returns true if target is found and removed. otherwise, returns false
	 */
	public boolean remove(E target);
	

}
