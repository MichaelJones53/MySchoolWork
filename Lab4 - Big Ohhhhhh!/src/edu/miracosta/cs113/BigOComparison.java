package edu.miracosta.cs113;
/**
 * BigOComparison.java :compares number of tasks for O(N) to O(N^2)
 * 
 * @author Michael Jones
 * @version 1.0
 *
 */
public class BigOComparison {
	/**
	 * Driver for BigO comparison
	 * 
	 * @param args
	 *            command line arguments (unnused)
	 */
	public static void main(String[] args) {
		//display table header
		System.out.println("Y1 (100n + 10) \t|| Y2 (5N^2 +2)");
		System.out.println("-----------------------------");
		//loop 100 times, display results of the two provied equations
		for(int i = 0; i< 100; i++){
			System.out.println((100*i)+10 +"\t\t||\t"+((5*i*i)+2));
			
		}
	}

}
