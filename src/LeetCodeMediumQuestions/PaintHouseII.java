package LeetCodeMediumQuestions;

/**
 * @author Sravan
 * Created on May 7, 2018
 */

/**
 * There are a row of n houses, each house can be painted with one of the k
 * colors. The cost of painting each house with a certain color is different.
 * You have to paint all the houses such that no two adjacent houses have the
 * same color.
 * 
 * The cost of painting each house with a certain color is represented by a n x
 * k cost matrix. For example, costs[0][0] is the cost of painting house 0 with
 * color 0; costs[1][2] is the cost of painting house 1 with color 2, and so
 * on... Find the minimum cost to paint all houses.
 * 
 * Note: All costs are positive integers.
 * 
 * Follow up: Could you solve it in O(nk) runtime?
 */

public class PaintHouseII {
	public int minCostII(int[][] costs) {
		if(costs == null || costs.length == 0)
			return 0;
		
		int len = costs.length;
		for(int i=1; i < len; i++) {
			int[] mins = getMins(costs[i-1]);
			for(int j=0; j < costs[0].length; j++) {
				// If the min cost has the same painting, select another one
				if(costs[i-1][j] == mins[0])
					costs[i][j] += mins[1];
				else
					costs[i][j] += mins[0];
			}
		}
		return getMins(costs[len-1])[0];
	}
	
	// Returns 2 minimum values from the array
	private int[] getMins(int[] costs) {
		int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
		for(int num: costs) {
			if(num <= min1) {
				min2 = min1;
				min1 = num;
			}
			else if(num < min2)
				min2 = num;
		}
		return new int[] {min1, min2};
	}
}
