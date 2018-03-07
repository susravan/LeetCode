package LeetCodeMediumQuestions;

public class OneEditDistance {
	public boolean isOneEditAway(String s, String t) {
		int sIndex = 0, tIndex = 0;
		while(sIndex < s.length() && tIndex < t.length()) {
			if(s.charAt(sIndex) != t.charAt(tIndex)) {
				boolean isReplaced = s.substring(sIndex+1).equals(t.substring(tIndex+1)); 
				boolean isInserted = s.substring(sIndex+1).equals(t.substring(tIndex));
				boolean isDeleted = s.substring(sIndex).equals(t.substring(tIndex+1));
				return isReplaced || isInserted || isDeleted;
			}
			sIndex++;
			tIndex++;
		}
		return Math.abs(s.length() - t.length()) == 1;
	}
}
