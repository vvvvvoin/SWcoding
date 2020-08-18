package programers;

public class Exam32 {
	static int x = 2;
	static int n = 5;
	public static void main(String[] args) {
		long[] a = new long[] {0};
		long[] answer = new long[n];
		int temp = x;
        for(int i = 0; i< n; i++){
            answer[i] = x;
            x += temp;
        }
        
        for(long i : answer) {
        	System.out.println(i);
        }
	}
}
