package edu.miracosta.cs113;

public class Main {
	public static void main(String[] args) throws InterruptedException{
		
		int[] test = {2,13,1,4,7,5};
	
		test = Sort.radixSort(test);
	
		for(int i = 0; i< test.length; i++){
			System.out.println(test[i]);
		}
		
		
	}

}
