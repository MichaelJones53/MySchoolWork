package edu.miracosta.cs113;

public class Sort {

	public static int[] radixSort(int[] data) throws InterruptedException {
		int[] counter = new int[10];
		int[] transfer = new int[data.length];
		int maxValue = 0;
		int pass = 1;
		
		
		for(int i = 0; i< data.length; i++){
			if(data[i]> maxValue){
				maxValue = data[i];
			}
		}
		
		return redistribute(data, counter, transfer, pass, maxValue);
	}

	/************** private helper methods 
	 * @throws InterruptedException **************/
	private static int[] redistribute(int[] data, int[] counter, int[] transfer, int pass, int maxVal) throws InterruptedException {

		resetCounter(counter);
		countDigits(data, counter);
		
		for (int i = 0; i < counter.length - 1; i++) {
			counter[i + 1] += counter[i];
		}
		
		for (int i = data.length - 1; i >= 0; i--) {
			int value = data[i];
			int modResults = (value/(int)Math.pow(10, pass-1)) % 10;
			int destination = counter[modResults] - 1;
			System.out.println(counter[modResults]);
			System.out.println(destination);
			transfer[destination] = value;
			counter[modResults]--;

		}
		if((maxVal % (int)Math.pow(10, pass)) != maxVal){
			System.out.println(maxVal);
			System.out.println((int)Math.pow(10, pass));
			System.out.println(maxVal % (int)Math.pow(10, pass));
			Thread.sleep(500);
			pass = pass+1;
			return redistribute(transfer, counter, data, pass, maxVal);
		}else{
			return transfer;
		}

	}

	private static void resetCounter(int[] data) {
		for (int i = 0; i < data.length; i++) {
			data[i] = 0;
		}
	}

	private static void countDigits(int[] data, int[] counter) {
		for (int i = 0; i < data.length; i++) {
			int counterLocation = data[i] % 10;
			counter[counterLocation]++;

		}
	}

}
