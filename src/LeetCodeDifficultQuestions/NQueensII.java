package LeetCodeDifficultQuestions;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sravan
 * Created on Jan 25, 2018
 */

/**
 * Follow up for N-Queens problem.
 * 
 * Now, instead outputting board configurations, return the total number of
 * distinct solutions.
 */

// Inspired from
public class NQueensII {
	public int totalNQueens(int n) {
		List<Integer> list = new ArrayList<>();

		return totalNQueensHelper(0, n, 0, list);
	}

	// Approach: Maintain a list containing the hash of row and col where Q is
	// placed. Use this array to check the validity of future positions
	private int totalNQueensHelper(int row, int n, int configCount, List<Integer> list) {
		if (row == n)
			return ++configCount;

		for (int col = 0; col < n; col++) {
			int hash = row * 10 + col;
			boolean toAdd = true;
			for (int i = 0; i < list.size(); i++) {
				int num = list.get(i);
				int x = num / 10;
				int y = num % 10;
				if (Math.abs(x - row) == Math.abs(y - col) || col == y) {
					toAdd = false;
					break;
				}
			}
			if (toAdd) {
				list.add(hash);
				configCount = totalNQueensHelper(row + 1, n, configCount, list);
				list.remove(list.size() - 1);
			}
		}
		return configCount;
	}
}
