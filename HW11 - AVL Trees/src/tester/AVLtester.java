package tester;

import org.junit.Assert;
import org.junit.Test;

import edu.miracosta.cs113.AVLTree;



public class AVLtester {

	@Test
	public void testAdd(){
	
		AVLTree<Integer> st = new AVLTree<Integer>();
		Assert.assertTrue(st.add(10));
		Assert.assertTrue(st.add(15));
		Assert.assertTrue(st.add(13));
		Assert.assertTrue(st.add(22));
		Assert.assertTrue(st.add(18));
		Assert.assertTrue(st.add(20));
		Assert.assertTrue(st.add(19));
//		Assert.assertTrue(st.add(3));
		System.out.println(st.toString());

	}
}
