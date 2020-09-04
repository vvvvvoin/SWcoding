package programers_Lv2;

public class Exam38 {
	static int n = 1;
	public static void main(String[] args) {
		int answer = 0;
		int cnt = 0;
		while(cnt < 20) {
			cnt++;
			if(n == 2) {
				answer++;
				break;
			}
			if(n == 3) {
				answer = answer + 2;
				break;
			}
			
			System.out.println("변환전 = " + n);
			if(n % 2 != 0 ) {
				n = n - 1;
				n /= 2;
				answer++;
			}else {
				n /= 2;				
			}
			System.out.println("변환후 = " + n);
		}
		System.out.println(answer);
	}
}
