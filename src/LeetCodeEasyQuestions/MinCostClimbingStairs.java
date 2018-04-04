package LeetCodeEasyQuestions;

/**
 * @author Sravan
 * Created on Apr 4, 2018
 */

/**
 * On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).

Once you pay the cost, you can either climb one or two steps. You need to find minimum cost to reach the top of the floor, and you can either start from the step with index 0, or the step with index 1.

Example 1:
Input: cost = [10, 15, 20]
Output: 15
Explanation: Cheapest is start on cost[1], pay that cost and go to the top.
Example 2:
Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
Output: 6
Explanation: Cheapest is start on cost[0], and only step on 1s, skipping cost[3].
Note:
cost will have a length in the range [2, 1000].
Every cost[i] will be an integer in the range [0, 999].
 */

// Inspired from 
public class MinCostClimbingStairs {
	public int minCostClimbingStairs(int[] cost) {
		if (cost.length == 0 || cost == null)
			return 0;
		if (cost.length <= 2)
			return Math.min(cost[0], cost.length == 2 ? cost[1] : Integer.MAX_VALUE);

		int step1 = cost[0], step2 = cost[1];
		for (int i = 2; i < cost.length; i++) {
			int currCost = Math.min(step1, step2) + cost[i];
			step1 = step2;
			step2 = currCost;
		}
		return Math.min(step1, step2);
	}
}
