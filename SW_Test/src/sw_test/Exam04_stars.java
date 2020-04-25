package sw_test;

import java.util.Scanner;

public class Exam04_stars {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int count = sc.nextInt();
		
		for(int i =1; i<=count;i++) {
			for(int j = 0; j <i ; j++) {
				System.out.print("*");
			}
		System.out.println();
		}
		

	}

}
