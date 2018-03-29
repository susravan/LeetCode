package LeetCodeMediumQuestions;

/**
 * @author Sravan
 * Created on Mar 28, 2018
 */

/**
 * Given an array of citations (each citation is a non-negative integer) of a
 * researcher, write a function to compute the researcher's h-index.
 * 
 * According to the definition of h-index on Wikipedia: "A scientist has index h
 * if h of his/her N papers have at least h citations each, and the other N − h
 * papers have no more than h citations each."
 * 
 * For example, given citations = [3, 0, 6, 1, 5], which means the researcher
 * has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations
 * respectively. Since the researcher has 3 papers with at least 3 citations
 * each and the remaining two with no more than 3 citations each, his h-index is
 * 3.
 * 
 * Note: If there are several possible values for h, the maximum one is taken as
 * the h-index.
 */

// Inspired from
public class hIndex {
	public int hIndex(int[] citations) {
		// // Sorting method
		// Arrays.sort(citations);
		// int hIndex = 0, len = citations.length;

		// for(int i=len-1; i >= 0; i--) {
		// if(citations[i] < len-i)
		// break;
		// else
		// hIndex = len-i;
		// }
		// return hIndex;

		// Bucket sort
		int len = citations.length;
		int[] buckets = new int[len + 1];
		for (int i = 0; i < len; i++) {
			if (citations[i] >= len)
				buckets[len]++;
			else
				buckets[citations[i]]++;
		}

		int sumCitations = 0;
		for (int i = len; i >= 0; i--) {
			sumCitations += buckets[i];
			if (sumCitations >= i)
				return i;
		}
		return 0;
	}
}
