package test;

import org.junit.Test;
import edu.miracosta.cs113.HashTableChain;
import org.junit.Assert;


public class HashTableChainTest {

	@Test
	public void testConstrucor(){
		HashTableChain<Integer, String> ht = new HashTableChain<Integer, String>();
		Assert.assertFalse(ht == null);
	}
	
	@Test
	public void testGetAndPut(){
		HashTableChain<Integer, String> ht = new HashTableChain<Integer, String>();
		ht.put(3, "three");
		Assert.assertTrue(ht.get(3).equals("three"));

	}
	
	@Test
	public void testRemove(){
		HashTableChain<Integer, String> ht = new HashTableChain<Integer, String>();
		ht.put(3, "three");
		Assert.assertTrue(ht.get(3).equals("three"));
		
		ht.remove(3);
		Assert.assertTrue(ht.get(3) == null);
		
	}
}
