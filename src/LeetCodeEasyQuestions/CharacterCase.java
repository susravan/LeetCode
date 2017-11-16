package LeetCodeEasyQuestions;

public class CharacterCase {
	public String CharacterCase(String str) {
		String[] arr = str.split(" ");
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i < arr.length; i++) {
			if(arr[i] != "") {
				sb.append(Character.toUpperCase(arr[i].charAt(0))).append(arr[i].substring(1)).append(" ");
			}
			else {
				sb.append(" ");
			}
		}
		return sb.toString();
	}
}
