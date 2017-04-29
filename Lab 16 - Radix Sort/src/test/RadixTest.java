package test;

import org.junit.Assert;
import org.junit.Test;

import edu.miracosta.cs113.Sort;


public class RadixTest {
	
	@Test
	public void testRadixSort(){
		int[] test = {0,1,9,8,7,4,3,10,11,0,10,10000000};
		
		test = Sort.radixSort(test);
		
		for(int i = 0; i< test.length; i++){
			System.out.println((i+1)+") "+test[i]);
		}
		Assert.assertTrue(test[0] == 0);
		Assert.assertTrue(test[1] == 0);
		Assert.assertTrue(test[2] == 1);
		Assert.assertTrue(test[3] == 3);
		Assert.assertTrue(test[4] == 4);
		Assert.assertTrue(test[5] == 7);
		Assert.assertTrue(test[6] == 8);
		Assert.assertTrue(test[7] == 9);
		Assert.assertTrue(test[8] == 10);
		Assert.assertTrue(test[9] == 10);
		Assert.assertTrue(test[10] == 11);
		Assert.assertTrue(test[11] == 10000000);
		
	}
	

}
