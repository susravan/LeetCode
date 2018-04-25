package LeetCodeDifficultQuestions;

import java.util.Stack;

/**
 * @author sravan created on Sep 25, 2017
 *
 */

/*
 * Given n non-negative integers representing an elevation map where the width
 * of each bar is 1, compute how much water it is able to trap after raining.
 * 
 * For example, Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 *
 */

public class TrappedRainWater {
	public int getTrappedRainWater(int[] height) {
		int maxWater = 0, maxLeft = 0, maxRight = 0;
		int left = 0, right = height.length-1;
		
		// Maintain 2 pointers and move them whichever is lesser
		while(left <= right) {
			if(height[left] < height[right]) {
				maxLeft = Math.max(maxLeft, height[left]);
				maxWater += maxLeft - height[left];
				left++;
			}
			else {
				maxRight = Math.max(maxRight, height[right]);
				maxWater += maxRight - height[right];
				right--;
			}
		}
		
		return maxWater;
	}

}
