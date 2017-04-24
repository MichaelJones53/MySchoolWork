package edu.miracosta.cs113;

import java.util.AbstractMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public class HashTableChain<K, V> extends AbstractMap<K, V> implements Map<K, V> {

	private LinkedList<Entry<K, V>>[] table;
	private static final int START_CAPACITY = 2;
	private static final double LOAD_THRESHOLD = 3.0;
	private int numKeys = 0;

	public HashTableChain() {
		table = new LinkedList[START_CAPACITY];
	}

	/**
	 * gets the value for the provided key from the table
	 * 
	 * @param key
	 *            key to be used to search for
	 * @return returns the value associated with the provided key if in list.
	 *         else returns null
	 */
	public V get(Object key) {
		int index = key.hashCode() % table.length;
		if (index < 0) {
			index += table.length;
		}
		if (table[index] == null) {
			return null;
		}
		for (Entry<K, V> item : table[index]) {
			if (item.key.equals(key)) {
				return item.value;
			}

		}

		return null;

	}

	/**
	 * adds key value pair to table
	 * 
	 * @param key
	 *            key to be paired with value
	 * @param value
	 *            value to be paired with key
	 * @return returns the prvious value paired with key if there was one.
	 *         otherwide, returns null;
	 */
	public V put(K key, V value) {
		int index = key.hashCode() % table.length;
		
		if (index < 0) {
			index += table.length;
		}
		if (table[index] == null) {
			table[index] = new LinkedList<Entry<K, V>>();
		}

		for (Entry<K, V> item : table[index]) {
			if (item.equals(key)) {
				V previousValue = item.value;
				item.setValue(value);
				return previousValue;
			}
		}

		table[index].addFirst(new Entry<K, V>(key, value));
		numKeys++;
		if (numKeys > (LOAD_THRESHOLD * table.length)) {
			rehash();
		}
		return null;
	}

	/**
	 * removes the key from the key table
	 * 
	 * @param key
	 *            key to be removed
	 * @return returns the value for the assocaited removed key if found.
	 *         otherwise, returns false
	 */
	@Override
	public V remove(Object key) {
		V value = null;
		int index = key.hashCode() % table.length;
		if (index < 0) {
			index += table.length;
		}
		if (table[index] == null) {
			return null;
		}
		int loc = 0;
		for (Entry<K, V> item : table[index]) {
			
			if (item.getKey().equals(key)) {
				numKeys--;
				value = table[index].remove(loc).getValue();
				if (table[index].size() == 0) {
					table[index] = null;
				}
			}
			loc++;
		}

		return value;
	}

	/**
	 * Expands table size when loadFactor exceeds LOAD_THRESHOLD
	 * 
	 * @post the size of table is doubled and is an odd integer. Each entry from
	 *       the original table is reinserted into the expanded table.
	 */
	// If you use the rehash of the HashtableOpen the difference is
	// in the re-insertion logic

	private void rehash() {
		LinkedList<Entry<K, V>>[] newTable = new LinkedList[(table.length * 2) + 1];
		for (int i = 0; i < table.length; i++) {
			for (Entry<K, V> item : table[i]) {
				int index = item.key.hashCode() % newTable.length;
				if (index < 0) {
					index += table.length;
				}
			
				if (newTable[index] == null) {
					newTable[index] = new LinkedList<Entry<K, V>>();
				}
				newTable[index].addFirst(item);

			}
		}
		table = newTable;

	}

	/** Returns the number of entries in the map */
	@Override
	public int size() {

		return numKeys;
	}

	@Override
	public V getObject(Object key) {
		// TODO Auto-generated method stub
		return get(key);
	}

	@Override
	public Set<java.util.Map.Entry<K, V>> entrySet() {
		// TODO Auto-generated method stub
		return null;
	}

	
	/**
	 * Provides string representation of data in table
	 * @return	
	 * 		returns string representation of data in table. if table is empty, returns empty string.
	 */
	public String toString(){
		String tableAsString = "";
		for(int i = 0; i < table.length; i++){
			tableAsString = tableAsString+"\n"+i+") ";
			if(table[i] == null){
				tableAsString = tableAsString + "null";
			}else{
				for(Entry<K,V> item: table[i]){
					tableAsString = tableAsString + item.toString()+"\t";
					
				}
			}
			
			
		}
		return tableAsString;
	}

	/** Inner class to implement the set view. */
	private class EntrySet extends java.util.AbstractSet<Entry<K, V>> {
		/** Return the size of the set. */
		public int size() {
			return numKeys;
		}

		/** Return an iterator over the set. */
		@Override
		public Iterator<Entry<K, V>> iterator() {
			return new SetIterator();
		}
	}

	/** Inner class to implement the set iterator. */
	private class SetIterator implements Iterator<Entry<K, V>> {
		int index = 0;
		Iterator<Entry<K, V>> localIterator = null;
		Entry<K,V> lastItemReturned = null;
		
		public java.util.Set<Entry<K, V>> entrySet() {
			return new EntrySet();
		}

		/**
		 * Informs whether the set has more entries or not
		 * @return		
		 * 		returns true if there are more entries. otherwise, false
		 */
		@Override
		public boolean hasNext() {
			if (localIterator != null) {
				if (localIterator.hasNext()) {
					return true;
				} else {
					localIterator = null;
					index++;
				}
			}
			while (index < table.length && table[index] == null) {
				index++;
			}
			if (index == table.length) {
				return false;
			}
			localIterator = table[index].iterator();
			return localIterator.hasNext();
		}
		/**
		 * returns the next item in the set. assumes hasNext is true.
		 * @return		
		 * 		returns next item in the set
		 */

		@Override
		public Entry<K, V> next() {
			lastItemReturned = localIterator.next();
			return lastItemReturned;
		}

		/**
		 * Removes the last item returned form the list.  assume next was previously called.
		 */
		@Override
		public void remove() {
			localIterator.remove();
			lastItemReturned = null;
		}

		
	}

	private class Entry<K, V> {

		private K key;
		private V value;

		/**
		 * Constructor for Entry. creates Entry object for hashtable
		 * 
		 * @param key
		 *            Key to be paired with value
		 * @param value
		 *            value to be paired with key
		 */
		public Entry(K key, V value) {

			this.key = key;
			this.value = value;
		}

		/**
		 * Retrives the current Entries key
		 * 
		 * @return returns the entries key
		 */
		public K getKey() {
			return key;
		}

		/**
		 * Retrives the current Entries value
		 * 
		 * @return returns the entries value
		 */
		public V getValue() {

			return value;
		}

		/**
		 * sets the current Entries value
		 * 
		 * @return returns the entries new value
		 */
		public V setValue(V value) {

			value = this.value;
			return value;

		}

		/**
		 * Return a String representation of the Entry
		 * 
		 * @return a String representation of the Entry in the form key = value
		 */
		@Override
		public String toString() {
			return key.toString() + " = " + value.toString();
		}

	}
}
