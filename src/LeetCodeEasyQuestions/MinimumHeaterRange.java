package LeetCodeEasyQuestions;

/**
 * @author sravan created on Aug 11, 2017
 *
 */

/*
 * Winter is coming! Your first job during the contest is to design a standard
 * heater with fixed warm radius to warm all the houses.
 * 
 * Now, you are given positions of houses and heaters on a horizontal line, find
 * out minimum radius of heaters so that all houses could be covered by those
 * heaters.
 * 
 * So, your input will be the positions of houses and heaters seperately, and
 * your expected output will be the minimum radius standard of heaters.
 * 
 * Note: Numbers of houses and heaters you are given are non-negative and will
 * not exceed 25000. Positions of houses and heaters you are given are
 * non-negative and will not exceed 10^9. As long as a house is in the heaters'
 * warm radius range, it can be warmed. All the heaters follow your radius
 * standard and the warm radius will the same. Example 1: Input: [1,2,3],[2]
 * Output: 1 Explanation: The only heater was placed in the position 2, and if
 * we use the radius 1 standard, then all the houses can be warmed. Example 2:
 * Input: [1,2,3,4],[1,4] Output: 1 Explanation: The two heater was placed in
 * the position 1 and 4. We need to use radius 1 standard, then all the houses
 * can be warmed.
 *
 */

public class MinimumHeaterRange {

	public int getMinimumHeaterRange(int[] houses, int[] heaters) {
		int prevHeaterPos = binarySearch(houses, heaters[0]);
		int res = houses[prevHeaterPos] - houses[0];
		int currHeaterPos = -1; 
				
		int i = 1;
		for (i = 1; i < heaters.length; i++) {
			currHeaterPos = binarySearch(houses, heaters[i]);
			res = (int) Math.max(res,
					Math.ceil((houses[currHeaterPos] - houses[prevHeaterPos]) / (currHeaterPos - prevHeaterPos)));
		}
		int lastHeaterPos = binarySearch(houses, heaters[i - 1]);
		if (lastHeaterPos != houses.length - 1)
			res = (int) Math.max(res,
					Math.ceil((houses[currHeaterPos] - houses[prevHeaterPos]) / (currHeaterPos - prevHeaterPos)));
		return res;
	}

	private int binarySearch(int[] nums, int target) {
		int low = 0, high = nums.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (nums[mid] == target)
				return mid;
			else if (nums[mid] < target)
				low = mid + 1;
			else
				high = mid - 1;
		}
		return -1;
	}
}
