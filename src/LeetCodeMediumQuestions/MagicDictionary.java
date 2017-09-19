package LeetCodeMediumQuestions;

import java.util.ArrayList;
import java.util.Arrays;

public class MagicDictionary {

	ArrayList<String> list = new ArrayList<>();
	public MagicDictionary() {
//		this.list = null;
	}
	
	/** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for(String str : dict) {
        	list.add(str);
        }
    }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
		int wordLen = word.length();
		for(int i=0; i < this.list.size(); i++) {
			if(list.get(i).length() == wordLen) {
				int[] map = new int[26];
				for(int j=0; j < wordLen; j++) {
					map[word.charAt(j) - 'a']++;
				}
				for(int j=0; j < list.get(i).length(); j++) {
					map[list.get(i).charAt(j) - 'a']--;
				}
				boolean found = false;
				int j=0;
				for(j=0; j < map.length; j++) {
					if(map[j] != 0) {
						if(map[j] == 1 || map[j] == -1) {
							if(found)
								break;
							else
								found = true;
						}
						else
							break;
					}
				}
				if(j == map.length)
					return true;
					
			}
		}
    	return true;
    }
    
    public boolean strCompare(String a, String b) {
    	int[] map = new int[26];
    	
    	for(int j=0; j < a.length(); j++) {
			map[a.charAt(j) - 'a']++;
		}
		
    	for(int j=0; j < b.length(); j++) {
			map[b.charAt(j) - 'a']--;
		}
		System.out.println(Arrays.toString(map));
		boolean foundOne = false;
		boolean foundMinusOne = false;
		int sum = 0;
		int j=0;
		while(j < map.length) {
			if(map[j] != 0) {
				if(map[j] == 1)
					foundOne = true;
				
				if(map[j] == -1)
					foundMinusOne = true;
				
			}
			j++;
		}
		
		return true;
    }

}
