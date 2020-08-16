package programers;

public class Exam19 {
	static int N = 123;
	public static void main(String[] args) {
		int answer = 0;
		String value = String.valueOf(N);
		for(int i = 0; i<value.length(); i++) {
			answer += Integer.parseInt(Character.toString(value.charAt(i)));
		}
		System.out.println(answer);
	}
}
