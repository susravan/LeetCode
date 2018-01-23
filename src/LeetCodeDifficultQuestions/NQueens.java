package LeetCodeDifficultQuestions;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
	public List<List<String>> getNQconfig(int n) {
		List<List<String>> res = new ArrayList<>();
		char[][] board = new char[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = '.';
			}
		}
		getNQconfigHelper(res, board, 0);
		return res;
	}

	private void getNQconfigHelper(List<List<String>> res, char[][] board, int row) {
		// Prepare list of strings (possible config) and add to res
		// print board
		if (row == board.length) {
			List<String> config = new ArrayList<>();
			for (int i = 0; i < board.length; i++) {
				String rowConfig = new String(board[i]);
				config.add(rowConfig);
			}
			res.add(config);
			return;
		}

		// Recurse over all the cols and check if 'Q' can be positioned in that column
		for (int col = 0; col < board.length; col++) {
			// Remember to send the updated board position and also reverting it once the
			// call is over
			if (isValid(board, row, col)) {
				board[row][col] = 'Q';
				getNQconfigHelper(res, board, row + 1);
				board[row][col] = '.';
			}
		}
	}

	// Checks if the current Q config is valid given the previous row's config
	private boolean isValid(char[][] board, int rowPos, int colPos) {
		// All checks can be completed in one loop
		for (int row = 0; row < rowPos; row++) {
			for (int col = 0; col < board.length; col++) {
				// No need to check for row as we are increasing the rowIndex and calling the
				// next step
				if (board[row][col] == 'Q' && (Math.abs(row - rowPos) == Math.abs(col - colPos) || col == colPos))
					return false;
			}
		}
		return true;
	}
}
