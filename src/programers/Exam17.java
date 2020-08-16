package programers;

public class Exam17 {
	static int n = 570;
	public static void main(String[] args) {
		int answer = 0;
        for(int i = 1; i<=n; i++){
            if(n % i == 0){
                answer += i;
            }   
        }

		System.out.println(answer);
	}
}
