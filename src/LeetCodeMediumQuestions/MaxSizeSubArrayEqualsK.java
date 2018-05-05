package LeetCodeMediumQuestions;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Sravan
 * Created on Apr 20, 2018
 */

/**
 * Given an array nums and a target value k, find the maximum length of a subarray that sums to k. If there isn't one, return 0 instead.

Note:
The sum of the entire nums array is guaranteed to fit within the 32-bit signed integer range.

Example 1:
Given nums = [1, -1, 5, -2, 3], k = 3,
return 4. (because the subarray [1, -1, 5, -2] sums to 3 and is the longest)

Example 2:
Given nums = [-2, -1, 2, 1], k = 1,
return 2. (because the subarray [-1, 2] sums to 1 and is the longest)

Follow Up:
Can you do it in O(n) time?
 */

// Inspired from 
public class MaxSizeSubArrayEqualsK {
	public int maxSizeSubArray(int[] nums, int k) {
		int sum = 0, maxLen = 0;
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);
		
		for(int i=0; i < nums.length; i++) {
			sum += nums[i];
			int target = sum - k;
			if(map.containsKey(target))
				maxLen = Math.max(maxLen, i - map.get(target));
			if(!map.containsKey(sum))
				map.put(sum, i);
		}
		return maxLen;
	}
}