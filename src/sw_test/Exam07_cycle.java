package sw_test;

import java.util.Scanner;

public class Exam07_cycle {
	static int input, result;
	static int a, b, c; 
	static int cycle;
	static int temp;
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		input = sc.nextInt();
		
		if(input  < 10) {
			input = input *10;
		}
		cycle = 0;
		result = 0;
		temp  = input;
		
		while(true) {
			a = temp /10;
			b = temp % 10;
			c = (a + b)%10;
			
			result = (b*10) + c;
			temp = result;
			cycle++;
			if(result == input) break;
		}
		System.out.println(cycle);
		
	}
}
