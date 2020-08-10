package programers;

import java.util.ArrayList;

public class Exam06 {
	static String s = "qwerqwer";
	public static void main(String[] args) {
		ArrayList<String> array = new ArrayList<>();
		String answer = "";
		for(int i = 0; i < s.length(); i++) {
			String str = Character.toString(s.charAt(i)); 
			array.add(str);
		}
		
		int length = s.length();
		
		if(length % 2 == 0) {
			length = length / 2;
			answer = array.get(length-1) + array.get(length);
			System.out.println("짝수");
		}else {
			length = (length / 2);
			System.out.println(length);
			answer  = array.get(length);
			System.out.println("홀수");
		}
		System.out.println(answer);
		
	}
}
