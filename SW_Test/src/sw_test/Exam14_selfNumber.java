package sw_test;

public class Exam14_selfNumber {
	static boolean[] check = new boolean[10001];
	
	static void calSelfNum(int a) {
		String str = "" + a;
		int result = 0;
		
		int[] array = new int[str.length()];
		
		for(int i = 0; i<str.length(); i++) {
			array[i] = str.charAt(i)-'0';
		}
		
		for(int i = 0; i<str.length(); i++) {
			result += array[i];
		}
		result += a; 
		if(result <= 10000) check[result] = true;
	}
	public static void main(String[] args) {
		
		for(int i =1; i <=10000; i++) {
			calSelfNum(i);
		}
		
		for(int i =1; i <=10000; i++) {
			if(!check[i]) {
				System.out.println(i);
			}
		}

	}

}
