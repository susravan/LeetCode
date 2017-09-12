package LeetCodeEasyQuestions;

public class ReverseInteger {

	public int getReverseInteger(int num) {
		String str = Integer.toString(num);
		boolean isNegative = false;
		if(str.charAt(0) == '-') {
			str = str.substring(1, str.length());
			isNegative = true;
		}
		if(str.charAt(0) == 0)
			return 0;
		
		int strLen = str.length();
		StringBuilder sb = new StringBuilder(str);
		// Reverse string
		for(int i=0; i < sb.length(); i++) {
			char temp = sb.charAt(i);
			sb.setCharAt(i, sb.charAt(strLen - i - 1));
			sb.setCharAt(strLen - i - 1, temp);
		}
		
		if(isNegative)
			str = "-" + sb.toString();
		else
			str = sb.toString();
		return Integer.parseInt(str);
	}

}
