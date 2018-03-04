package LeetCodeDifficultQuestions;

/**
 * @author Sravan
 * Created on Mar 4, 2018
 */

/**
 * Say you have an array for which the ith element is the price of a given stock
 * on day i.
 * 
 * Design an algorithm to find the maximum profit. You may complete at most two
 * transactions.
 * 
 * Note: You may not engage in multiple transactions at the same time (ie, you
 * must sell the stock before you buy again).
 */

// Inspired from
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/discuss/39615/My-explanation-for-O(N)-solution!
public class BestTimeToSellTwoTimes {
	public int maxProfit(int[] prices) {
		int buy1 = Integer.MIN_VALUE, buy2 = Integer.MIN_VALUE;
		int sell1 = 0, sell2 = 0;

		// Approach: See the link above for more details
		// For simplicity, assume buying as getting money with negative value
		// So now the problem is converted to getting maximum of negative values
		// available for buying, and selling at maximum value. Final Sell2 is the total
		// profit. If for any value of 'i', if buy1 doesn't change, other variables
		// calculate profits w.r.t that previous buy1 itself.
		for (int i = 0; i < prices.length; i++) {
			buy1 = Math.max(buy1, -prices[i]); // Since prices[i] is negative, taking max value works good
			sell1 = Math.max(sell1, prices[i] + buy1); // Selling price should be max always - obviously
			buy2 = Math.max(buy2, sell1 - prices[i]); // Running the optimization on the whole money you have till now
														// which makes sense bacause second tracsaction is dependent on
														// the first's money
			sell2 = Math.max(sell2, prices[i] + buy2); // Again maximizing the selling price
		}

		return sell2;
	}
}
