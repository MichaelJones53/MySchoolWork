package test;

import org.junit.Test;
import edu.miracosta.cs113.ArrayListStack;
import org.junit.Assert;

public class ArrayListStackTests {

	@Test
	public void testEmpty(){
		ArrayListStack<Integer> testStack = new ArrayListStack<>();
		Assert.assertTrue(testStack.empty());
		testStack.push(5);
		Assert.assertFalse(testStack.empty());
		
	}
	
	@Test
	public void testNotEmpty(){
		ArrayListStack<Integer> testStack = new ArrayListStack<>();
		testStack.push(5);
		Assert.assertFalse(testStack.empty());
	}
	
	@Test
	public void testPeek(){
	
		ArrayListStack<Integer> testStack = new ArrayListStack<>();
		testStack.push(5);
		Assert.assertTrue(testStack.peek() == 5);
		Assert.assertFalse(testStack.peek() == 3);
		
	}
	
	@Test
	public void testPush(){
		ArrayListStack<Integer> testStack = new ArrayListStack<>();
		testStack.push(5);
		Assert.assertFalse(testStack.empty());
		Assert.assertTrue(testStack.peek() == 5);
	}
	
	@Test
	public void testToString(){
		ArrayListStack<Integer> testStack = new ArrayListStack<>();
		testStack.push(5);
		testStack.push(37);
		Assert.assertTrue(testStack.toString().equals("[5, 37]"));
		
	}
	@Test
	public void testToStringEmpty(){
		ArrayListStack<Integer> testStack = new ArrayListStack<>();
		Assert.assertTrue(testStack.toString().equals("[]"));
		
	}
}
