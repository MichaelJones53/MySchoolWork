package edu.miracosta.cs113;

import java.util.ArrayList;


public class Change {

    private static final int[] COIN_DENOMINATIONS = {25, 10, 5, 1};
    private static ArrayList<Integer> combinationList = new ArrayList<>();

    /**
	 * No argument constructor.  instantiates change object
	 */
    public Change() {
    }

    /**
     * wrapper for countOptions method
     * @param amount
     * 		amount to find the number of combinations for
     */
    public static void combinations(int amount) {
            countOptions(amount, combinationList, 0);
    }

    /**
     * display to screen all possible combinations of coins to equal provided change value
     * @param value 
     * 			amount of change to find combinations to
     * @param coins
     * 			arrayList to store coin values
     * @param nextCoin
     * 			identifies highest denomination being used to calculate through recursion
     */
    public static void countOptions(int value, ArrayList<Integer> coins, int nextCoin) {
        if (value == 0) {
        	int quarters = 0;
        	int dimes = 0;
        	int nickels = 0;
        	int pennies = 0;
        	
        	for(int coin:coins){
        		if(coin == 25){
        			quarters++;
        		}else if(coin == 10){
        			dimes++;
        		}else if(coin == 5){
        			nickels++;
        		}else if(coin == 1){
        			pennies++;
        		}
        	}
            System.out.println("Quarters ("+quarters+")   Dimes ("+dimes+")    Nickels ("+nickels+")    Pennies("+pennies+")");
        }
        else{
            if (value >= COIN_DENOMINATIONS[nextCoin]) {
                coins.add(COIN_DENOMINATIONS[nextCoin]); 
                countOptions(value - COIN_DENOMINATIONS[nextCoin], coins, nextCoin);
                coins.remove(coins.size() - 1);
            }
            if (nextCoin + 1 < COIN_DENOMINATIONS.length) {
                countOptions(value, coins, nextCoin + 1);
            }
         }
    }

}
