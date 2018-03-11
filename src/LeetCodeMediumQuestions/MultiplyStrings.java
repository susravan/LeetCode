package LeetCodeMediumQuestions;

/**
 * @author Sravan
 * Created on Mar 10, 2018
 */

/**
 * Given two non-negative integers num1 and num2 represented as strings, return
 * the product of num1 and num2
 * 
 * Note:
 * 
 * The length of both num1 and num2 is < 110. Both num1 and num2 contains only
 * digits 0-9. Both num1 and num2 does not contain any leading zero. You must
 * not use any built-in BigInteger library or convert the inputs to integer
 * directly.
 */

// Inspired from
public class MultiplyStrings {
	public String multiply(String num1, String num2) {
		if (num1.equals("0") || num2.equals("0"))
			return "0";

		StringBuilder sb = new StringBuilder();
		int offset = 0;

		// Parse first string backwards
		for (int i = num1.length() - 1; i >= 0; i--) {
			int carry = 0;
			int dig1 = Character.getNumericValue(num1.charAt(i));
			String temp = "";

			// Parse second string backwards
			for (int j = num2.length() - 1; j >= 0; j--) {
				int dig2 = Character.getNumericValue(num2.charAt(j));
				int res = dig1 * dig2 + carry;
				carry = res / 10;
				res %= 10;
				temp += res;
			}
			if (carry != 0)
				temp += carry;

			// Add one row of result to main result
			merge(sb, temp, offset++);
		}
		return sb.reverse().toString();
	}

	// Merges main result 'sb' to new multiplication row 'str'
	private void merge(StringBuilder sb, String str, int offset) {
		int carry = 0;

		for (int i = 0; i < str.length(); i++) {
			int sbNum = (offset >= sb.length()) ? 0 : Character.getNumericValue(sb.charAt(offset));
			int sum = Character.getNumericValue(str.charAt(i)) + carry + sbNum;
			carry = sum / 10;
			sum %= 10;

			if (offset >= sb.length())
				sb.append(sum);
			else {
				sb.replace(offset, offset + 1, sum + "");
			}
			offset++;
		}
		if (carry != 0) {
			sb.append(carry);
		}
	}
}
