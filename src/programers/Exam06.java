package programers;

import java.util.ArrayList;

public class Exam06 {
	static String s = "qwerwera";
	public static void main(String[] args) {
		ArrayList<String> array = new ArrayList<>();
		String answer = "";
		for(int i = 0; i < s.length(); i++) {
			String str = Character.toString(s.charAt(i)); 
			array.add(str);
		}
		System.out.println(s.substring((s.length() - 1)/2, s.length() / 2 + 1));
		System.out.println((s.length() - 1)/2);
		System.out.println(s.length() / 2 + 1);
		int length = s.length();
		
		if(length % 2 == 0) {
			length = length / 2;
			answer = array.get(length-1) + array.get(length);
		}else {
			length = (length / 2);
			answer  = array.get(length);
		}
		System.out.println(answer);
		
	}
}
