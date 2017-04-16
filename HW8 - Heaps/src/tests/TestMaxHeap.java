package tests;

import org.junit.Test;

import edu.miracosta.cs113.MaxHeap;

import org.junit.Assert;



public class TestMaxHeap {
	@Test
	public void testOffer(){
		MaxHeap<Integer> heap = new MaxHeap<Integer>();
		heap.offer(3);
		Assert.assertTrue(heap.peek() == 3);
		heap.offer(2);
		Assert.assertTrue(heap.peek() == 3);
		heap.offer(7);
		Assert.assertTrue(heap.peek() == 7);
		
		
	}
	
	@Test
	public void testPoll(){
		MaxHeap<Integer> heap = new MaxHeap<Integer>();
		Assert.assertTrue(heap.poll() == null);
		heap.offer(3);
		heap.offer(3);
		heap.offer(7);
		Assert.assertTrue(heap.poll() == 7);
		Assert.assertTrue(heap.poll() == 3);
		Assert.assertTrue(heap.poll() == 3);
		Assert.assertTrue(heap.poll() == null);
	}
	
	@Test
	public void testRemove(){
		MaxHeap<Integer> heap = new MaxHeap<Integer>();
		heap.offer(3);
		heap.offer(3);
		heap.offer(7);
		Assert.assertTrue(heap.remove() == 7);
		Assert.assertTrue(heap.remove() == 3);
		Assert.assertTrue(heap.remove() == 3);
	}
	
	
}