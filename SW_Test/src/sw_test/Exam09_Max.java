package sw_test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Exam09_Max {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int max = 0;
		int index = 0;
		
		for(int i = 1; i <10 ;i++) {
			int a = Integer.parseInt(br.readLine());
			if(max < a) {
				max = a;
				index = i;
			}
			
		}
		
		System.out.println(max);
		System.out.println(index);
		
	}

}
