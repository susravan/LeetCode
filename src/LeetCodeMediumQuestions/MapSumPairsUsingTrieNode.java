package LeetCodeMediumQuestions;

import java.util.HashMap;
import java.util.Map;

import com.sun.org.apache.xml.internal.utils.Trie;

public class MapSumPairsUsingTrieNode {

	TrieNode node = new TrieNode();
	
	public MapSumPairsUsingTrieNode() {
		this.node.score = 0;
	}
	
	public void insert(String key, int val) {
        if(key.length() == 0) {
//        	this.node.
        }
        	
		TrieNode pointer = new TrieNode();
        pointer = this.node;
        int strIndex = 0;
        
        while(strIndex < key.length()) {
        	char c = key.charAt(strIndex);
        	if(this.node.map.containsKey(c)) {
        		pointer = this.node.map.get(c);
        		
        	}
        	else {
        		this.node.map.put(c, new TrieNode());
        	}
        	
        }
    }
	
	
	public class TrieNode {
		Map<Character, TrieNode> map = new HashMap<>();
		int score;
	}

}
