package LeetCodeMediumQuestions;

/**
 * @author sravan created on Sep 4, 2017
 *
 */

/*
 * Given n non-negative integers a1, a2, ..., an, where each represents a point
 * at coordinate (i, ai). n vertical lines are drawn such that the two endpoints
 * of line i is at (i, ai) and (i, 0). Find two lines, which together with
 * x-axis forms a container, such that the container contains the most water.
 * 
 * Note: You may not slant the container and n is at least 2.
 *
 */

// Inspired from
public class ContainerWithMostWater {

	public int getContainerWithMostWater(int[] height) {
		int maxArea_so_far = 0;
		int maxArea = 0;
		int start = 0, end = height.length - 1;

		while (start < end) {
			maxArea_so_far = Math.min(height[start], height[end]) * (end - start);
			maxArea = Math.max(maxArea, maxArea_so_far);

			if (height[start] < height[end])
				start++;
			else
				end--;
		}
		return maxArea;
	}

}
