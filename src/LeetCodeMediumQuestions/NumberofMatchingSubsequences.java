package LeetCodeMediumQuestions;

import java.util.ArrayList;

/**
 * @author Sravan
 * Created on Mar 16, 2018
 */

/**
 * Given string S and a dictionary of words words, find the number of words[i] that is a subsequence of S.

Example :
Input: 
S = "abcde"
words = ["a", "bb", "acd", "ace"]
Output: 3
Explanation: There are three words in words that are a subsequence of S: "a", "acd", "ace".
Note:

All words in words and S will only consists of lowercase letters.
The length of S will be in the range of [1, 50000].
The length of words will be in the range of [1, 5000].
The length of words[i] will be in the range of [1, 50].
 */

// Inspired from 
public class NumberofMatchingSubsequences {
	public int numMatchingSubseq(String str, String[] words) {
		if(str.equals("") || words.length == 0)
			return 0;
		
		int count = 0;
		ArrayList<Node>[] heads = new ArrayList[26];
		for(int i=0; i < 26; i++)
			heads[i] = new ArrayList<>();

		for(int i=0; i < words.length; i++) {
			heads[words[i].charAt(0)- 'a'].add(new Node(words[i], 0));
		}
		
		for(int i=0; i < str.length(); i++) {
			char ch = str.charAt(i);
			ArrayList<Node> oldBucket = heads[ch-'a'];
			heads[ch-'a'] = new ArrayList<>();
			
			for(Node n: oldBucket) {
				n.index++;
				if(n.index == n.word.length())
					count++;
				else
					heads[n.word.charAt(n.index) - 'a'].add(n);
			}
		}
		return count;
	}
}

class Node {
	String word;
	int index;
	
	public Node(String str, int index) {
		this.word = str;
		this.index = index;
	}
}
