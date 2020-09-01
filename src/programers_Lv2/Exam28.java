package programers_Lv2;

public class Exam28 {
	static int n = 15;
	public static void main(String[] args) {
		int answer = 0;
		int temp = 0;
		for(int i = 1; i <= 15; i++) {
			for(int j = i; j <= 15; j++) {
				temp += j;
				if(temp > n) break;
				if(temp == n) {
					answer++;
					break;
				}
			}
			temp = 0;
		}
		System.out.println(answer);
	}
}
