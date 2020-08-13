package programers;

public class Exam09 {
	static int a = 5;
	static int b = 3;
	public static void main(String[] args) {
		long answer = 0;
		if(a < b){
            for(int i = a; i<= b; i++){
                answer += i;
            }
        }else{
            for(int i = a; i >= b; i--){
                answer += i;
            }
        }
		System.out.println(answer);
	}
}
