package LeetCodeMediumQuestions;

/**
 * @author Sravan
 * Created on Apr 7, 2018
 */

/**
 * Additive number is a string whose digits can form additive sequence.

A valid additive sequence should contain at least three numbers. Except for the first two numbers, each subsequent number in the sequence must be the sum of the preceding two.

For example:
"112358" is an additive number because the digits can form an additive sequence: 1, 1, 2, 3, 5, 8.

1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
"199100199" is also an additive number, the additive sequence is: 1, 99, 100, 199.
1 + 99 = 100, 99 + 100 = 199
Note: Numbers in the additive sequence cannot have leading zeros, so sequence 1, 2, 03 or 1, 02, 3 is invalid.

Given a string containing only digits '0'-'9', write a function to determine if it's an additive number.

Follow up:
How would you handle overflow for very large input integers?
 */

// Inspired from 
public class AdditiveNumber {
	public boolean isAdditiveNumber(String num) {
		int L = num.length();

		for (int i = 1; i <= (L - 1) / 2; i++) {
			if (num.charAt(0) == '0' && i >= 2)
				break;

			for (int j = i + 1; L - j >= i && L - j >= j - i; j++) {
				if (num.charAt(i) == '0' && j - i >= 2)
					break;

				long num1 = Long.parseLong(num.substring(0, i));
				long num2 = Long.parseLong(num.substring(i, j));
				if (isAdditive(num.substring(j), num1, num2))
					return true;
			}
		}
		return false;
	}

	private boolean isAdditive(String srcNum, long num1, long num2) {
		if (srcNum.equals(""))
			return true;

		long sum = num1 + num2;
		String str = Long.toString(sum);

		if (srcNum.startsWith(str))
			return isAdditive(srcNum.substring(str.length()), num2, sum);
		else
			return false;

	}
}
