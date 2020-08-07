package programers;

public class Exam05 {
	static int a = 5;
	static int b = 24;
	public static void main(String[] args) {
		//1월 일때를 고려해야하므로 0을 넣어야했다
		int[] m = {0, 31, 29, 31, 30 ,31 ,30, 31, 31, 30 ,31 ,30 ,31};
		int fix = 5;
		String[] d = {"SUN","MON","TUE","WED","THU","FRI","SAT"};
		int total = 0;
		for(int i = 0; i < a; i++) {
			total += m[i];
		}
		
		total = (total+b) % 7 ;
		System.out.println(total);
		if(total == 0) total = 4;
		else if(total == 1) total = 5;
		else if(total == 2) total = 6;
		else if(total == 3) total = 0;
		else if(total == 4) total = 1;
		else if(total == 5) total = 2;
		else if(total == 6) total = 3;
		
		
		System.out.println(d[total]);
	}
}
