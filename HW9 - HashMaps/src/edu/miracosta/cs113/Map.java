package edu.miracosta.cs113;

public interface Map<K,V> {
	
	/**
	 * Returns the value associated with the specified key.  
	 * @param key
	 * 		key to be used to fined associated value
	 * @return
	 * 		returns value associated with provide key.  returns null if key not found.
	 */
	public V getObject(Object key);
	
	/**
	 * Identifies if the map contains mappings
	 * @return
	 * 		return true if set contains at least 1 mapping.  otherwise, returns false
	 */
	public boolean isEmpty();
	
	/**
	 * Associates the specified value with the specified key.
	 * @param key
	 * 		Key to be used to associated the value with
	 * @param Value
	 * 		value to be mapped to the associated key
	 * @return
	 * 		returns the previous value associated with the specified key.  Returns null if no previous mapping existed
	 */
	public V put(K key, V Value);
	
	/**
	 * Removes associated mapping for provided key
	 * @param Key
	 * 		key to be unmapped
	 * @return
	 * 		returns the previous value associated with the specified key.  Returns null if no previous mapping existed
	 */
	public V remove(Object Key);
	
	/**
	 * provides number of key-value mappings in the map
	 * @return
	 * 		returns number of key-value mappings in the map
	 */
	public int size();
	

}
