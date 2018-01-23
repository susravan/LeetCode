package LeetCodeMediumQuestions;

public class WordSearch {
	// Approach: BFS from each character in the matrix to all four neighbors - O(4^mn)
		public boolean exist(char[][] board, String word) {
			for(int i=0; i < board.length; i++) {
				for(int j=0; j < board[0].length; j++) {
					if(wordSearchHelper(board, i, j, word, 0))
						return true;
				}
			}
			return false;
		}
		
		// XOR masking with 256 (or) overwriting the character with '*' can be used to avoid extra space
		private boolean wordSearchHelper(char[][] board, int row, int col, String word, int start) {
			if (start == word.length())
				return true;

			if (row < 0 || row >= board.length || col < 0 || col >= board[0].length)
				return false;

			if (board[row][col] != word.charAt(start))
				return false;

			board[row][col] = '*';
			boolean wordExist = wordSearchHelper(board, row + 1, col, word, start + 1)
					|| wordSearchHelper(board, row - 1, col, word, start + 1)
					|| wordSearchHelper(board, row, col + 1, word, start + 1)
					|| wordSearchHelper(board, row, col - 1, word, start + 1);
			board[row][col] = word.charAt(start);
			return wordExist;
		}
}
