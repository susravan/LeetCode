package LeetCodeMediumQuestions;

/**
 * @author Sravan
 * Given an array of non-negative integers, you are initially
 *         positioned at the first index of the array.
 * 
 *         Each element in the array represents your maximum jump length at that
 *         position.
 * 
 *         Determine if you are able to reach the last index.
 * 
 *         For example: A = [2,3,1,1,4], return true.
 * 
 *         A = [3,2,1,0,4], return false.
 */

// Inspired from https://leetcode.com/problems/jump-game/solution/
public class JumpGame {
	enum Index {
		GOOD, BAD, UNKNOWN;
	}

	public boolean canJumpTD(int[] arr) {
		// Approach: DP top-down approach 
		// memo to store if an index is GOOD or BAD
		// For each index, see if it can go to atleast one good index. If yes, it is a
		// good index otherwise not
		Index[] memo = new Index[arr.length];
		for (int i = 0; i < memo.length; i++)
			memo[i] = Index.UNKNOWN;

		memo[memo.length - 1] = Index.GOOD;
		canJumpHelper(arr, memo, 0);
		for (int i = 0; i < memo.length; i++) {
			System.out.println(memo[i]);
		}
		return memo[0] == Index.GOOD;
	}
	
	// Returns if a position is GOOD or BAD and updates memo
	private boolean canJumpHelper(int[] arr, Index[] memo, int pos) {
		if (memo[pos] == Index.UNKNOWN) {
			int maxJumpPos = Math.min(pos + arr[pos], arr.length - 1);
			for (int j = pos + 1; j <= maxJumpPos; j++) {
				if (canJumpHelper(arr, memo, j)) {
					memo[pos] = Index.GOOD;
					return true;
				}
			}
			memo[pos] = Index.BAD;
			return false;
		} else
			return memo[pos] == Index.GOOD;
	}

	// canJump Bottom-Up approach
	// Approach: Instead of going from starting position as in the previous method,
	// here we are moving from target to the starting position which makes this a
	// bottom-up approach which doesn't require a recursion and so only O(n) space
	// as compared to O(2n) as in the previous case.
	public boolean canJumpBU(int[] arr) {
		Index[] memo = new Index[arr.length];
		for(int i=0; i < arr.length; i++)
			memo[i] = Index.UNKNOWN;
		memo[memo.length-1] = Index.GOOD;
		
		for(int i=arr.length-2; i >= 0; i--) {
			int maxJumpPos = i + arr[i];
			for(int j=maxJumpPos; j > i; j--) {
				if(memo[j] == Index.GOOD) {
					memo[i] = Index.GOOD;
					break;	// Any one of the steps being GOOD is fine 
				}
			}
		}
		return memo[0] == Index.GOOD;
	}

	// Approach: Traversing from right to left, maintain leftmostGoodIndex which
	// initially is the target. At each point, check if from that index any GOOD
	// index to it's right can be reached. If reached, update leftmostGoodIndex.
	public boolean canJumpLT(int[] arr) {
		int leftMostGoodPos = arr.length-1;
		for(int i=arr.length-2; i >= 0; i--) {
			if(i + arr[i] >= leftMostGoodPos)
				leftMostGoodPos = i;
		}
		return leftMostGoodPos == 0;
	}
}
