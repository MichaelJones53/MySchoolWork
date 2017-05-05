package tester;

import org.junit.Assert;
import org.junit.Test;

import edu.miracosta.cs113.BinarySearchTree;



public class BinarySearchTreeTest {
	
	@Test
	public void testAdd(){
		BinarySearchTree<Integer> st = new BinarySearchTree<Integer>();
		Assert.assertTrue(st.add(7));
		Assert.assertFalse(st.add(7));
		Assert.assertTrue(st.add(1));
		
		
	}
	
	@Test
	public void testFind(){
		BinarySearchTree<Integer> st = new BinarySearchTree<Integer>();
		st.add(3);
		st.add(9);
		st.add(5);
		st.add(1);
		st.add(4);
		st.add(15);
		
		Assert.assertTrue(5 == st.find(5));
		Assert.assertTrue(null == st.find(7));
		Assert.assertFalse(null != st.find(8));
		
		
	}
	
	@Test 
	public void testContains(){
		
		BinarySearchTree<Integer> st = new BinarySearchTree<Integer>();
		st.add(3);
		st.add(9);
		st.add(5);
		st.add(1);
		st.add(4);
		st.add(15);
		
		Assert.assertTrue(st.contains(5));
		Assert.assertFalse(st.contains(7));
		Assert.assertFalse(st.contains(8));
		Assert.assertTrue(st.contains(15));
	
	}
	
	@Test
	public void testDelete(){
		BinarySearchTree<Integer> st = new BinarySearchTree<Integer>();
		st.add(3);
		st.add(9);
		st.add(5);
		st.add(1);
		st.add(4);
		st.add(15);
		st.add(5);
		st.add(14);
		st.add(19);
		st.add(2);
		st.add(0);
		st.add(27);
		st.add(33);
		st.add(65);
		st.add(88);
		st.add(43);
		st.add(78);
		st.add(21);
		
		Assert.assertTrue(4 == st.delete(4));
		Assert.assertTrue(null == st.delete(4));
		Assert.assertTrue(78 == st.delete(78));
		Assert.assertTrue(null == st.delete(78));
		Assert.assertTrue(2 == st.delete(2));
		Assert.assertTrue(null == st.delete(2));
		
	}
	
	@Test
	public void testRemove(){
		BinarySearchTree<Integer> st = new BinarySearchTree<Integer>();
		st.add(3);
		st.add(9);
		st.add(5);
		st.add(1);
		st.add(4);
		
		Assert.assertTrue(st.remove(3));
		Assert.assertFalse(st.remove(3));
		Assert.assertFalse(st.remove(7));
		Assert.assertTrue(st.remove(9));
		
	}
}
