package edu.miracosta.cs113;

import java.io.PrintWriter;
import java.util.Scanner;

public class Sort {
	/**
	 * pre: assumes file1 and file2 are sorted and streams open. Performs merge
	 * sort on provided files.
	 * 
	 * @param file1
	 *            file to be merged sorted with file 2
	 * @param file2
	 *            file to be merge sorted with file 1
	 */
	public static void fileMergeSort(Scanner file1, Scanner file2, PrintWriter destination) {
		Integer file1Item = null;
		Integer file2Item = null;

		while (file1.hasNext() && file2.hasNext()) {
			if (file1Item == null) {
				file1Item = file1.nextInt();
			}
			if (file2Item == null) {
				file2Item = file2.nextInt();
			}

			if (file1Item < file2Item) {
				destination.println("" + file1Item);
				file1Item = null;
			} else {
				destination.println("" + file2Item);
				file2Item = null;
			}
		}

		while (file1.hasNext()) {
			if (file1Item == null) {
				file1Item = file1.nextInt();
			}
			destination.println("" + file1Item);
			file1Item = null;

		}
		while (file2.hasNext()) {
			if (file2Item == null) {
				file2Item = file2.nextInt();
			}
			destination.println("" + file2Item);
			file2Item = null;

		}

	}

	/**
	 * performs recursive merge sort on integer array. assumes array is not
	 * empty
	 * 
	 * @param data
	 *            the array to be sorted
	 * @return returns the sorted array
	 */
	public static int[] intArrayMergeSort(int[] data) {
		if (data.length == 1) {
			return data;
		} else {
			int half = data.length / 2;
			int counter = 0;
			int[] leftHalf = new int[half];
			int[] rightHalf = new int[data.length - half];

			for (int i = 0; i < half; i++) {
				leftHalf[i] = data[i];
			}
			for (int i = half; i < data.length; i++) {
				rightHalf[counter] = data[i];
				counter++;
			}
			leftHalf = intArrayMergeSort(leftHalf);
			rightHalf = intArrayMergeSort(rightHalf);

			return mergeSort(leftHalf, rightHalf);
		}

	}

	/**
	 * Performs the merge sorting of arrays. assumes a and b are sorted
	 * 
	 * @param a
	 *            array to be merged with b
	 * @param b
	 *            array to be merged with a
	 * @return returns merge sorted array
	 */
	public static int[] mergeSort(int[] a, int[] b) {
		int[] sorted = new int[a.length + b.length];
		boolean isSorting = true;
		int aCounter = 0;
		int bCounter = 0;
		int sortedCounter = 0;

		if (a.length == 0) {
			return b;
		}

		if (b.length == 0) {
			return a;
		}

		while (isSorting) {

			if (a[aCounter] < b[bCounter]) {
				sorted[sortedCounter] = a[aCounter];
				aCounter++;
			} else {
				sorted[sortedCounter] = b[bCounter];
				bCounter++;
			}
			sortedCounter++;

			if (aCounter == a.length) {

				while (bCounter < b.length) {

					sorted[sortedCounter] = b[bCounter];
					bCounter++;
					sortedCounter++;
				}
			} else if (bCounter == b.length) {
				while (aCounter < a.length) {
					sorted[sortedCounter] = a[aCounter];
					aCounter++;
					sortedCounter++;
				}

			}
			if (sortedCounter == sorted.length) {
				isSorting = false;
			}
		}
		return sorted;
	}

}
