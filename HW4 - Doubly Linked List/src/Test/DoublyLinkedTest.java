package Test;

import org.junit.Test;
import org.junit.Assert;

import edu.miracosta.cs113.DoublyLinkedList;


public class DoublyLinkedTest {

	@Test
	public void testAddEmptyBegin(){
		DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
		list.addFirst(4);
		Assert.assertTrue(list.getFirst() == 4);

	}
	
	@Test
	public void testAddEmptyAddLast(){
		DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
		list.addLast(4);
		Assert.assertTrue(list.getFirst() == 4);

	}
	@Test
	public void testAddBeginingListHasContent(){
		DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
		list.addFirst(4);
		list.addFirst(7);
		list.addFirst(2);
		list.addFirst(3);
		Assert.assertTrue(list.getFirst() == 3);
	}
	@Test
	public void testAddEndListHasContent(){
		DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
		list.addFirst(4);
		list.addFirst(7);
		list.addFirst(2);
		list.addLast(3);
		Assert.assertTrue(list.getLast() == 3);
	}
	
	@Test
	public void testAddMiddleListEmpty(){
		DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
		list.add(0, 4);
		Assert.assertTrue(list.getFirst() == 4);
	}
	
	@Test
	public void testAddMiddleListHasContent(){
		DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
		list.addFirst(4);
		list.addFirst(7);
		list.addFirst(2);
		list.add(2, 5);
		Assert.assertTrue(list.get(2) == 5);
	}
	
	@Test
	public void testGetMiddle(){
		DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
		list.addLast(4);
		list.addLast(7);
		list.addLast(2);
		list.addLast(9);
		Assert.assertTrue(list.get(1) == 7);
	}
	@Test
	public void testGetFirst(){
		DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
		list.addLast(4);
		list.addLast(7);
		list.addLast(2);
		list.addLast(9);
		Assert.assertTrue(list.getFirst() == 4);
	}
	@Test
	public void testGetLast(){
		DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
		list.addLast(4);
		list.addLast(7);
		list.addLast(2);
		list.addLast(9);
		Assert.assertTrue(list.getLast() == 9);
	}
	@Test
	public void testGetSize(){
		DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
		list.addLast(4);
		list.addLast(7);
		list.addLast(2);
		list.addLast(9);
		Assert.assertTrue(list.size() == 4);
	}
	@Test
	public void testGetSizeAfterexecutingRemove(){
		DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
		list.addLast(4);
		list.addLast(7);
		list.addLast(2);
		list.remove(7);
		list.addLast(9);
		Assert.assertTrue(list.size() == 3);
		
	}
	@Test
	public void testRemoveTrue(){
		DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
		list.addLast(4);
		list.addLast(7);
		list.addLast(2);
		list.addLast(9);
		Assert.assertTrue(list.remove(7));
		
	}
	
	@Test
	public void testRemoveFalse(){
		DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
		list.addLast(4);
		list.addLast(7);
		list.addLast(2);
		list.addLast(9);
		Assert.assertFalse(list.remove(30));
	}

	@Test
	public void testRemoveOnlyItem(){
		DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
		list.addLast(4);
		System.out.println(list.get(0));
		Assert.assertTrue(list.remove(4));
		Assert.assertTrue(list.size() == 0);
	}
	
	@Test
	public void testRemoveLast(){
		DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
		list.addFirst(4);
		list.add(0, 7);
		list.add(2, 2);
		list.add(1,9);
		list.addLast(10);
		Assert.assertTrue(list.remove(10));
		Assert.assertTrue(list.size() == 4);
		Assert.assertTrue(list.get(list.size()-1) == 2);
		
	}
	
	
}
