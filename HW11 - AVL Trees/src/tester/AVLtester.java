package tester;

import org.junit.Assert;
import org.junit.Test;

import edu.miracosta.cs113.AVLTree;



public class AVLtester {

	@Test
	public void testAdd(){
	
//		AVLTree<Integer> st = new AVLTree<Integer>();
//		Assert.assertTrue(st.add(0));
//		Assert.assertTrue(st.add(19));
//		Assert.assertTrue(st.add(10));
//		Assert.assertTrue(st.add(25));
//		Assert.assertTrue(st.add(23));
//		Assert.assertTrue(st.add(21));
//		Assert.assertTrue(st.add(20));
//		Assert.assertTrue(st.add(13));
//		System.out.println(st.toString());

	}
//	
//	
	@Test 
	public void testDelete(){
		AVLTree<Integer> st = new AVLTree<Integer>();
		Assert.assertTrue(st.add(20));
		Assert.assertTrue(st.add(15));
		Assert.assertTrue(st.add(30));
		st.add(40);
		st.add(17);
//		
		st.delete(20);
	//	st.delete(15);
//		Assert.assertTrue(st.add(10));
//		Assert.assertTrue(st.add(17));
//		st.delete(20);
//		st.delete(20);
//		Assert.assertTrue(st.add(30));
//		Assert.assertTrue(st.add(8));
//		st.delete(8);
//		st.delete(25);
//		st.delete(10);
//		Assert.assertTrue(st.add(21));
//		st.delete(22);
//		Assert.assertTrue(st.add(2));
//		Assert.assertTrue(st.add(5));
//		st.delete(7);
//		Assert.assertTrue(st.add(1));
//		Assert.assertTrue(st.add(1));
//		st.delete(8);
//		Assert.assertTrue(st.add(1));
		System.out.println(st.toString());
		
		
	}
}
