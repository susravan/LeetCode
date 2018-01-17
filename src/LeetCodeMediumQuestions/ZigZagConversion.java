package LeetCodeMediumQuestions;

/**
 * @author Sravan
 *
 *         The string "PAYPALISHIRING" is written in a zigzag pattern on a given
 *         number of rows like this: (you may want to display this pattern in a
 *         fixed font for better legibility)
 * 
 *         P A H N A P L S I I G Y I R And then read line by line:
 *         "PAHNAPLSIIGYIR" Write the code that will take a string and make this
 *         conversion given a number of rows:
 * 
 *         string convert(string text, int nRows); convert("PAYPALISHIRING", 3)
 *         should return "PAHNAPLSIIGYIR".
 */

// Inspired from https://leetcode.com/problems/zigzag-conversion/discuss/3403
public class ZigZagConversion {
	public String getZigZag(String str, int nRows) {
		StringBuilder[] sb = new StringBuilder[nRows];
		int len = str.length();

		for (int i = 0; i < nRows; i++) {
			sb[i] = new StringBuilder();
		}

		int index = 0;
		while (index < len) {
			// Move downward
			for (int i = 0; i < nRows && index < len; i++)
				sb[i].append(str.charAt(index++));
			// Move upward - one less at both the ends
			for (int i = nRows - 2; i >= 1 && index < len; i--)
				sb[i].append(str.charAt(index++));
		}
		for (int i = 1; i < sb.length; i++)
			sb[0].append(sb[i]);
		return sb.toString();
	}
}
