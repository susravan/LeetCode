package LeetCodeEasyQuestions;

public class ValidPalindrome2 {

	public boolean getValidPalindrome2(String str) {
		if(str == "")
			return true;
		
		char[] charMap = new char[26];
		
		for(char c: str.toCharArray()) {
			charMap[c - 'a']++;
		}
		int oneCharCount = 0;
		for(int i=0; i < charMap.length; i++) {
			if(charMap[i] == 1)
				oneCharCount++;
		}
		
		return oneCharCount <= 2;
	}

}
