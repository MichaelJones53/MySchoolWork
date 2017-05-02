package test;

import org.junit.Test;

import edu.miracosta.cs113.Sort;

import org.junit.Assert;

public class SortTests {

	@Test
	public void testIntArrayMergeSort() {
		int[] data1 = { 5, 4, 2, 1, 3 };
		int[] sorted = new int[data1.length];

		sorted = Sort.intArrayMergeSort(data1);

		Assert.assertTrue(sorted[0] == 1);
		Assert.assertTrue(sorted[1] == 2);
		Assert.assertTrue(sorted[2] == 3);
		Assert.assertTrue(sorted[3] == 4);
		Assert.assertTrue(sorted[4] == 5);

	}

	@Test
	public void testMergeSort() {
		int[] data1 = { 1, 2, 3, 4, 11};
		int[] data2 = { 0, 1, 2, 4, 10};
		int[] sorted = new int[data1.length + data2.length];

		sorted = Sort.mergeSort(data1, data2);
		for (int i = 0; i < sorted.length; i++) {
			System.out.println(sorted[i]);
		}
		Assert.assertTrue(sorted[0] == 0);
		Assert.assertTrue(sorted[1] == 1);
		Assert.assertTrue(sorted[2] == 1);
		Assert.assertTrue(sorted[3] == 2);
		Assert.assertTrue(sorted[4] == 2);
		Assert.assertTrue(sorted[5] == 3);
		Assert.assertTrue(sorted[6] == 4);
		Assert.assertTrue(sorted[7] == 4);
		Assert.assertTrue(sorted[8] == 10);
		Assert.assertTrue(sorted[9] == 11);

	}

}
