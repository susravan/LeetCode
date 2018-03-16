package LeetCodeMediumQuestions;

import java.util.ArrayList;

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
