package sw_AdvancedTest;

import java.util.Scanner;

public class Exam00_MovieSeat {
	static int testCase;
	static int people;
	static int[] seat;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		testCase = sc.nextInt();
		for (int t = 0; t < testCase; t++) {
			people = sc.nextInt();
			seat = new int[people];

			int sum = 0;

			for (int i = 0; i < people; i++) {
				seat[i] = sc.nextInt();
			}
			for (int i = 0; i < people-1; i++) {
				sum += seat[i] > seat[i+1] ? seat[i] : seat[i+1];
//				if(seat[i] > seat[i+1]) {
//					sum += seat[i];
//				} else {
//					sum += seat[i+1];
//				}
								
			}

			sum = sum + people + seat[0] + seat[people - 1];
			System.out.println(sum);
		}

	}

}
