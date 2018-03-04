package LeetCodeMediumQuestions;

import java.util.Stack;

/**
 * @author sravan Implement a basic calculator to evaluate a simple expression
 *         string.
 * 
 *         The expression string contains only non-negative integers, +, -, *, /
 *         operators and empty spaces . The integer division should truncate
 *         toward zero.
 * 
 *         You may assume that the given expression is always valid.
 * 
 *         Some examples: "3+2*2" = 7 " 3/2 " = 1 " 3+5 / 2 " = 5 Note: Do not
 *         use the eval built-in library function.
 */

// Inspired by https://leetcode.com/problems/basic-calculator-ii/discuss/
public class BasicCalculator2 {
	public class Solution {
		public int calculate(String s) {
			int len;
			if (s == null || (len = s.length()) == 0)
				return 0;
			Stack<Integer> stack = new Stack<Integer>();
			int num = 0;
			char sign = '+';
			for (int i = 0; i < len; i++) {
				char ch = s.charAt(i);
				// For the case of multiple digit numbers
				if (Character.isDigit(ch)) {
					num = num * 10 + ch - '0';
				}
				if ((!Character.isDigit(ch) && ' ' != ch) || i == len - 1) {
					if (sign == '-') {
						stack.push(-num);
					}
					if (sign == '+') {
						stack.push(num);
					}
					if (sign == '*') {
						stack.push(stack.pop() * num);
					}
					if (sign == '/') {
						stack.push(stack.pop() / num);
					}
					sign = ch;
					num = 0; // Reset num to zero
				}
			}

			int res = 0;
			for (int i : stack) {
				res += i; // Only positive and negative numbers will be left in the stack now
			}
			return res;
		}
	}
}
