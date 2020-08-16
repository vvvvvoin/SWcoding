package programers;

public class Exam16 {
	static String s = "AB";
	static int n = 1;
	public static void main(String[] args) {
		//다른사람들의 풀이를 봤을때 직관적이지 못해
		//다시 if문으로 구현했다
		String answer = "";
		for(int i = 0; i<s.length(); i++) {
			char c = s.charAt(i);
			
			if(Character.isUpperCase(c)) {
				c = (char)( c  + n);
				if(!(c >= 'A' && c <= 'Z')) {
					c = (char)(c-26);
				}
			}else if(Character.isLowerCase(c)) {
				c = (char)( c  + n);
				if(!(c >= 'a' && c <= 'z')) {
					c = (char)(c-26);
				}
			}
			answer += c;
		}
		System.out.println(answer);
	}
}
