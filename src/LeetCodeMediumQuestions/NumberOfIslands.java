package LeetCodeMediumQuestions;

/**
 * @author Sravan
 * Created on Jan 28, 2018
 */

/**
 *Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

11110
11010
11000
00000
Answer: 1

Example 2:

11000
11000
00100
00011
Answer: 3


 */


public class NumberOfIslands {
	public int numIslands(char[][] grid) {
		int count = 0;

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (isIsland(grid, i, j))
					count++;
			}
		}
		return count;
	}

	private boolean isIsland(char[][] grid, int row, int col) {
		if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] == '1') {
			grid[row][col] = '*';
			isIsland(grid, row + 1, col);
			isIsland(grid, row - 1, col);
			isIsland(grid, row, col + 1);
			isIsland(grid, row, col - 1);
			return true;
		}
		return false;
	}
}
