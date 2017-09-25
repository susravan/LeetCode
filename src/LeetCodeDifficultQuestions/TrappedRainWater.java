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
		if (height.length < 3)
			return 0;

		Stack<Integer> st = new Stack<>();

		int index = 0;
		int[] leftGreaterHeight = new int[height.length];

		// Store largest element to the left
		while (index < height.length) {
			if (st.isEmpty() || st.peek() <= height[index]) {
				leftGreaterHeight[index] = 0;
				st.push(height[index]);
			} else
				leftGreaterHeight[index] = st.peek();
			index++;
		}

		st.clear();
		int trappedWater = 0;
		int maxHeightRight = 0;
		index = height.length - 1;
		// Calculate largest element to the right on the fly along with calculating the
		// trapped rain water
		while (index >= 0) {
			if (st.isEmpty() || st.peek() <= height[index]) {
				maxHeightRight = 0;
				st.push(height[index]);
			} else
				maxHeightRight = st.peek();

			trappedWater += Math.max(Math.min(leftGreaterHeight[index], maxHeightRight) - height[index], 0);
			index--;
		}
		return trappedWater;
	}

}
