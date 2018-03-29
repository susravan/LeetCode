package LeetCodeMediumQuestions;

/**
 * @author Sravan
 * Created on Mar 28, 2018
 */

/**
 * Follow up for H-Index: What if the citations array is sorted in ascending
 * order? Could you optimize your algorithm?
 */

// Inspired from
public class hIndexII {
	public int hIndex(int[] citations) {
		int hIndex = 0;
		int len = citations.length;
		for (int i = len - 1; i >= 0; i--) {
			if (citations[i] < len - i)
				return hIndex;
			else {
				hIndex = len - i;
			}
		}
		return hIndex;
	}
}
