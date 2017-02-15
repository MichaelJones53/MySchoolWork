package Test;

import org.junit.Test;
import org.junit.Assert;

import edu.miracosta.cs113.DoublyLinkedList;


public class DoublyLinkedTest {

	@Test
	public void addFirst(){
		DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
		Integer newInt = 4;
		list.addFirst(newInt);
		
		Assert.assertTrue(4 == list.getFirst());
	}
	
	
}
