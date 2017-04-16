package tests;

import org.junit.Test;

import edu.miracosta.cs113.MinHeap;

import org.junit.Assert;



public class MinHeapTest {
	@Test
	public void testOffer(){
		MinHeap<Integer> heap = new MinHeap<Integer>();
		heap.offer(3);
		Assert.assertTrue(heap.peek() == 3);
		heap.offer(2);
		Assert.assertTrue(heap.peek() == 2);
		heap.offer(7);
		Assert.assertTrue(heap.peek() == 2);
		
		
	}
	
	@Test
	public void testPoll(){
		MinHeap<Integer> heap = new MinHeap<Integer>();
		Assert.assertTrue(heap.poll() == null);
		heap.offer(3);
		heap.offer(3);
		heap.offer(7);
		Assert.assertTrue(heap.poll() == 3);
		Assert.assertTrue(heap.poll() == 3);
		Assert.assertTrue(heap.poll() == 7);
		Assert.assertTrue(heap.poll() == null);
	}
	
	@Test
	public void testRemove(){
		MinHeap<Integer> heap = new MinHeap<Integer>();
		heap.offer(3);
		heap.offer(3);
		heap.offer(7);
		Assert.assertTrue(heap.remove() == 3);
		Assert.assertTrue(heap.remove() == 3);
		Assert.assertTrue(heap.remove() == 7);
	}
	
	
	
}
