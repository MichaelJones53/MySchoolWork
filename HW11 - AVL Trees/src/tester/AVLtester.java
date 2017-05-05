package tester;

import org.junit.Assert;
import org.junit.Test;

import edu.miracosta.cs113.AVLTree;



public class AVLtester {

	@Test
	public void testAdd(){
	
		AVLTree<Integer> st = new AVLTree<Integer>();
		Assert.assertTrue(st.add(10));
		Assert.assertTrue(st.add(11));
		Assert.assertTrue(st.add(12));
		Assert.assertTrue(st.add(15));
		Assert.assertTrue(st.add(16));
		Assert.assertTrue(st.add(18));
//		Assert.assertTrue(st.add(4));
//		Assert.assertTrue(st.add(3));
		System.out.println(st.toString());

	}
}
