package LeetCodeEasyQuestions;

/**
 * @author sravan
 * created on Oct 7, 2017
 *
 */

/*  Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)

Example 1:
[[0,0,1,0,0,0,0,1,0,0,0,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,1,1,0,1,0,0,0,0,0,0,0,0],
 [0,1,0,0,1,1,0,0,1,0,1,0,0],
 [0,1,0,0,1,1,0,0,1,1,1,0,0],
 [0,0,0,0,0,0,0,0,0,0,1,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,0,0,0,0,0,0,1,1,0,0,0,0]]
Given the above grid, return 6. Note the answer is not 11, because the island must be connected 4-directionally.
Example 2:
[[0,0,0,0,0,0,0,0]]
Given the above grid, return 0.
Note: The length of each dimension in the given grid does not exceed 50.
 *
 */
 
public class MaxAreaOfIsland {

	public int getMaxAreaOfIsland(int[][] grid) {
		int len = grid.length;
        int wid = grid[0].length;
        
        boolean visited[][] = new boolean[len][wid];
 
        int maxArea = 0, area = 0;
        for (int i = 0; i < len; ++i) {
            for (int j = 0; j < wid; ++j) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    area = DFS(grid, i, j, visited, 1);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
	}
	
	// Once called with starting 1, returns the area of the entire island
	private static int DFS(int grid[][], int row, int col, boolean visited[][], int area)
    {
        // Used to look at neighbors
		int rowNbr[] = new int[] {-1, 0, 0, 1};
        int colNbr[] = new int[] {0, -1, 1, 0};
        visited[row][col] = true;
        
        // Call DFS on all neighbors
        for (int k = 0; k < rowNbr.length; ++k) {
            if (isSafe(grid, row + rowNbr[k], col + colNbr[k], visited) ) {
                area++;
                area = DFS(grid, row + rowNbr[k], col + colNbr[k], visited, area);
            }
        }
        return area;
    }
    
	// Returns if the step given is safe or not
    private static boolean isSafe(int grid[][], int row, int col, boolean visited[][])
    {
        return (row >= 0) && (row < grid.length) &&
               (col >= 0) && (col < grid[0].length) &&
               (grid[row][col]==1 && !visited[row][col]);
    }
}
