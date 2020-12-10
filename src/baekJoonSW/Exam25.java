package baekJoonSW;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exam25 {
	static BufferedReader br;
	static StringTokenizer st;
	
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		
		for(int i = 0; i < n ; i++) {
			String input = br.readLine();
			isValid(input);
		}
	}

	private static void isValid(String input) {
		int left = 0;
		int right = 0;
		int index = 0;
		boolean flag = false;
		
		while(true) {
			for(int i = index; i < input.length(); i++) {
				if(input.charAt(index) == ')') {
					flag = true;
					break;
				}
				if(input.charAt(i) == '(') {
					left++;
				}
				if(input.charAt(i) == ')') {
					right++;
				}
				if(left != 0 && right != 0 && left == right) {
					index = i + 1;
					break;
				}
			}
			if(left != right) flag = true;
			if(index == input.length()) break;
			if(flag == true) break;
		}
		if(flag == true) {
			System.out.println("NO");
		}else {
			System.out.println("YES");
		}
		
	}
}
