package edu.miracosta.cs113;

public class Sort {

	/**
	 * precondition - Data is assumed to be >= 0 and integers 
	 * Sorts array of positive integers 
	 * @param data
	 * 		the data to be sorted
	 * @return
	 * 		sorted array of the provided data
	 */
	public static int[] radixSort(int[] data) {
		int[] counter = new int[10];
		int[] transfer = new int[data.length];
		int maxValue = 0;
		int pass = 0;

		for (int i = 0; i < data.length; i++) {
			if (data[i] > maxValue) {
				maxValue = data[i];
			}
		}

		return redistribute(data, counter, transfer, pass, maxValue);
	}

	
	/**
	 * Helper method to recursively provress through dataset and continue sorting using radix algorithm
	 * @param data
	 * 		the data to be sorted
	 * @param counter
	 * 		array that stores the number of times a digit appears in the set
	 * @param transfer
	 * 		array to store the sorted data
	 * @param pass
	 * 		keeps track of which pass the recursive method is on
	 * @param maxVal
	 * 		largest value in the data.  needed for ending recursive calls
	 * @return
	 * 		returns the sorted data
	 */
	private static int[] redistribute(int[] data, int[] counter, int[] transfer, int pass, int maxVal) {

		resetCounter(counter);
		countDigits(data, counter, pass);

		for (int i = 0; i < counter.length - 1; i++) {
			counter[i + 1] += counter[i];
		}

		for (int i = data.length - 1; i >= 0; i--) {
			int value = data[i];
			int modResults = (value / (int) Math.pow(10, pass)) % 10;
			int destination = counter[modResults] - 1;
			transfer[destination] = value;
			counter[modResults]--;

		}
		if ((maxVal % (int) Math.pow(10, pass)) != maxVal) {
			pass++;
			return redistribute(transfer, counter, data, pass, maxVal);
		} else {
			return transfer;
		}

	}

	/**
	 * Helper method to reset the coutner array to 0
	 * @param data
	 * 		the counter array to be reset
	 */
	private static void resetCounter(int[] data) {
		for (int i = 0; i < data.length; i++) {
			data[i] = 0;
		}
	}

	/**
	 * Helper method that reads through the data and counts the orrurance of the digits in the desired place
	 * @param data
	 * 		data to be searched through
	 * @param counter
	 * 		array that keeps track of the orrurances of the digit
	 * @param pass
	 * 		the number of sorting attempts conducted
	 */
	private static void countDigits(int[] data, int[] counter, int pass) {
		for (int i = 0; i < data.length; i++) {
			int counterLocation = (data[i] / (int) Math.pow(10, pass)) % 10;
			counter[counterLocation]++;

		}
	}

}
