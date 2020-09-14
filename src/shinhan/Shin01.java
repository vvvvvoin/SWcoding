package shinhan;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Shin01 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		
		int start = Integer.parseInt(input.split(" ")[0]);
		int end = Integer.parseInt(input.split(" ")[1]);
		int answer = 0;
		for(int i = start; i <= end; i++) {
			String temp = i + "";
			
			String right = "";
			String left = "";
			for(int j = 0; j < temp.length(); j++) {
				right += temp.charAt(j);
			}
			for(int j = temp.length() - 1; j >= 0; j--) {
				left += temp.charAt(j);
			}
			if(right.equals(left)) {
				answer++;
			}
				
		}
		System.out.println(answer);
	}
}
