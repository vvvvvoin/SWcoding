package programers;

public class Exam26 {
	static int n = 3;
	static int m = 12;
	public static void main(String[] args) {
		int[] answer = new int[2];
		//최소공배수
		int gcf = Integer.MIN_VALUE; //그레이티스트 커먼 팩터
		int lcf = Integer.MAX_VALUE;	//리스트 커먼 팩터
		for(int  i = 1; i<= m; i++) {
			if(n%i ==0 && m%i ==0) {
				gcf = Math.max(gcf, i);
			}
		}
		int temp = 1;
		
		for(int i = 1; i<1000000; i++) {
			if(n%i ==0 && m%i ==0) {
				temp *= i;
				n = n/i;
				m = m/i;
				i = 1;
				continue;
			}
		}
		lcf = temp * n * m;
	
		System.out.println(gcf);
		System.out.println(lcf);
		
		
	}
}
