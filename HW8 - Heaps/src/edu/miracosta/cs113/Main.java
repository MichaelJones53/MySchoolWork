package edu.miracosta.cs113;


public class Main {
	
	public static void main(String[] args){
		
		MaxHeap<Integer> maxHeap = new MaxHeap<Integer>();
		MinHeap<Integer> minHeap = new MinHeap<Integer>();
		
		
		System.out.println("adding 9,10,15, and 7 to max heap in that order");
		maxHeap.offer(9);
		maxHeap.offer(10);
		maxHeap.offer(15);
		maxHeap.offer(7);
		System.out.println("popping all items off max heap and displaying to user");
		while(!maxHeap.isEmpty()){
			System.out.println(maxHeap.poll());
		}
		
		
		System.out.println("\n\nAdding 9,10,15, and 7 to mininum heap in that order");
		minHeap.offer(9);
		minHeap.offer(10);
		minHeap.offer(15);
		minHeap.offer(7);
		System.out.println("popping all items off max heap and displaying to user");
		while(!minHeap.isEmpty()){
			System.out.println(minHeap.poll());
		}
		
		
		
	}
	
}
