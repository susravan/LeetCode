package LeetCodeDifficultQuestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Sravan
 * Created on Mar 29, 2018
 */

/**
 * A group of two or more people wants to meet and minimize the total travel distance. You are given a 2D grid of values 0 or 1, where each 1 marks the home of someone in the group. The distance is calculated using Manhattan Distance, where distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|.

For example, given three people living at (0,0), (0,4), and (2,2):

1 - 0 - 0 - 0 - 1
|   |   |   |   |
0 - 0 - 0 - 0 - 0
|   |   |   |   |
0 - 0 - 1 - 0 - 0
The point (0,2) is an ideal meeting point, as the total travel distance of 2+2+2=6 is minimal. So return 6.
 */

// Inspired from https://leetcode.com/problems/best-meeting-point/solution/
public class BestMeetingPoint {
	// Think of how you would do if the problem is in 1D and extend that to 2D
	// 1D method - Find the median of the house's locations and calculate the
	// distances from each house to median - O(MNlog(MN)) time and O(MN) space
	// Median not mean - remember this
	public int minTotalDistance(int[][] grid) {
		List<Integer> rows = new ArrayList<>();
		List<Integer> cols = new ArrayList<>();
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					rows.add(i);
					cols.add(j);
				}
			}
		}
		int row = rows.get(rows.size() / 2);
		Collections.sort(cols);	// Doesn't need sorting for rows
		int col = cols.get(cols.size() / 2);

		return get1Ddist(rows, row) + get1Ddist(cols, col);
	}
	
	private int get1Ddist(List<Integer> rows, int origin) {
		int dist = 0;
		for (int point : rows)
			dist += Math.abs(point - origin);
		return dist;
	}

}
