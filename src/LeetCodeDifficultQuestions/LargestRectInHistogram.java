package LeetCodeDifficultQuestions;

import java.util.Stack;

/**
 * @author Sravan
 * Created on Jan 21, 2018
 */

/**
 * Given n non-negative integers representing the histogram's bar height where
 * the width of each bar is 1, find the area of largest rectangle in the
 * histogram. Above is a histogram where width of each bar is 1, given height =
 * [2,1,5,6,2,3]. The largest rectangle is shown in the shaded area, which has
 * area = 10 unit.
 * 
 * For example, Given heights = [2,1,5,6,2,3], return 10.
 */

public class LargestRectInHistogram {
	public int largestRectangleArea(int[] heights) {
		Stack<Integer> st = new Stack<>();
		int i = 0, maxArea = 0;

		while (i < heights.length) {
			if (st.isEmpty() || heights[i] > heights[st.peek()]) {
				st.push(i++);
			} else {
				int currArea = heights[st.pop()] * (st.isEmpty() ? i : (i - st.peek() - 1));
				maxArea = Math.max(maxArea, currArea);
			}
		}
		while (!st.isEmpty()) {
			int currArea = heights[st.pop()] * (st.isEmpty() ? i : (i - st.peek() - 1));
			maxArea = Math.max(maxArea, currArea);
		}
		return maxArea;
	}
}
