package programers_Lv2;

public class Exam34 {
	static String s = "3people Unfollowed Me";
	public static void main(String[] args) {
		// 항상 공백이 문제다
		// 그래서 stringtokenizer 같은 것보다는
		// split으로 전부쪼개거나
		// 하나하나 검사하는 방법이 확실하다
		s = s.toLowerCase();
		boolean flag = true;
		String answer = "";
		for(int i = 0; i < s.length(); i++) {
			if(Character.isLetterOrDigit(s.charAt(i))) {
				if(flag) {
					answer += String.valueOf(s.charAt(i)).toUpperCase();
					flag = false;
				}else {
					answer += s.charAt(i);
				}
			}else {
				answer += s.charAt(i);
				flag = true;
			}
		}
		
		
        System.out.println(answer);
	}
}
