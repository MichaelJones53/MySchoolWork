package tester;

import org.junit.Assert;
import org.junit.Test;

import edu.miracosta.cs113.AVLTree;



public class AVLtester {

//	@Test
//	public void testAdd(){
//	
//		AVLTree<Integer> st = new AVLTree<Integer>();
//		Assert.assertTrue(st.add(10));
//		Assert.assertTrue(st.add(15));
//		Assert.assertTrue(st.add(13));
//		Assert.assertTrue(st.add(25));
//		Assert.assertTrue(st.add(20));
//		Assert.assertTrue(st.add(30));
//		Assert.assertTrue(st.add(33));
//		Assert.assertTrue(st.add(3));
//		System.out.println(st.toString());
//
//	}
//	
	
	@Test 
	public void testDelete(){
		AVLTree<Integer> st = new AVLTree<Integer>();
		Assert.assertTrue(st.add(25));
		Assert.assertTrue(st.add(20));
		
		st.add(15);
		
//		st.delete(20);
	//	Assert.assertTrue(st.add(10));
	//	Assert.assertTrue(st.add(7));
//		st.delete(15);
	//	st.delete(20);
	//	Assert.assertTrue(st.add(9));
//		Assert.assertTrue(st.add(8));
//		st.delete(15);
//		st.delete(10);
//		Assert.assertTrue(st.add(4));
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
