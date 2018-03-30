package LeetCodeEasyQuestions;

import java.util.List;
import java.util.LinkedList;

/**
 * @author Sravan
 * Created on Mar 30, 2018
 */

/**
 * You are playing the following Flip Game with your friend: Given a string that
 * contains only these two characters: + and -, you and your friend take turns
 * to flip two consecutive "++" into "--". The game ends when a person can no
 * longer make a move and therefore the other person will be the winner.
 * 
 * Write a function to compute all possible states of the string after one valid
 * move.
 * 
 * For example, given s = "++++", after one move, it may become one of the
 * following states:
 * 
 * [ "--++", "+--+", "++--" ] If there is no valid move, return an empty list
 * [].
 */

// Inspired from
public class FlipGame {
	public List<String> generatePossibleNextMoves(String s) {
		char[] arr = s.toCharArray();
		List<String> res = new LinkedList<>();

		for (int i = 1; i < arr.length; i++) {
			if (arr[i] == '+' && arr[i - 1] == '+') {
				arr[i] = '-';
				arr[i - 1] = '-';
				res.add(String.valueOf(arr));
				arr[i] = '+';
				arr[i - 1] = '+';
			}
		}
		return res;
	}
}
