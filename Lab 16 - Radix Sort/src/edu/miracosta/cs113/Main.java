package edu.miracosta.cs113;

public class Main {
	public static void main(String[] args) {

		int[] test = new int[50];

		for (int i = 0; i < 50; i++) {

			test[i] = (int) (Math.random() * 1000);
		}
		test = Sort.radixSort(test);

		for (int i = 0; i < test.length; i++) {
			System.out.println((i + 1) + ") " + test[i]);
		}

	}

}
