package LeetCodeEasyQuestions;

/**
 * @author Sravan
 * Created on Jan 23, 2018
 */

/**
 * Say you have an array for which the ith element is the price of a given stock
 * on day i.
 * 
 * If you were only permitted to complete at most one transaction (ie, buy one
 * and sell one share of the stock), design an algorithm to find the maximum
 * profit.
 * 
 * Example 1: Input: [7, 1, 5, 3, 6, 4] Output: 5
 * 
 * max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger
 * than buying price) Example 2: Input: [7, 6, 4, 3, 1] Output: 0
 * 
 * In this case, no transaction is done, i.e. max profit = 0.
 * 
 */

public class StocksI {
	// Approach: Similar to maxDiff problem - find the maximum diff between 2
	// elements where the greater element's index is greater than the smaller
	// number's index
	public int maxProfit(int[] prices) {
		int maxProfit = 0, minPrice = Integer.MAX_VALUE;
		// Track minPrice as we traverse the array and calculate profit with respect to
		// this min value. This algo takes care of all cases where max profit can be
		// obtained using single transaction
		for (int i = 0; i < prices.length; i++) {
			if (prices[i] < minPrice)
				minPrice = prices[i];

			maxProfit = Math.max(maxProfit, prices[i] - minPrice);
		}
		return maxProfit;
	}
}
