package LeetCodeEasyQuestions;

public class LongestCommonPrefix {

	public String getLongestCommonPrefix(String[] strs) {
		if(strs.length == 0)
            return "";
        if(strs.length == 1)
            return strs[0];
        
        StringBuilder sb = new StringBuilder(strs[0]);
        
        for(int i=1; i < strs.length; i++) {
            String str = strs[i];
            int j=0;
            System.out.println(sb.length());
            while(j < str.length() && j < sb.length()) {
                if(str.charAt(j) != sb.charAt(j)) {
                    sb = sb.delete(j, str.length());
                    break;
                }
                j++;
            }
        }
        return sb.toString();
	}

}
