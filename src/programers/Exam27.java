package programers;

public class Exam27 {
	static double num = 626331;
	public static void main(String[] args) {
		long i = 0;
		int answer = 0;
		int temp = 0;
        for( i = 0; i<500;i++) {
        	if(num == 1) break;
        	//짝수
        	num = num%2 == 0? num/2 : num*3+1;
            
        }
        
        System.out.println(i);
	}
}
