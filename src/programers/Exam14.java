package programers;

import java.util.Arrays;

public class Exam14 {
	static String[] seoul = {"jane", "Kim"};
	public static void main(String[] args) {
		int index = Arrays.asList(seoul).indexOf("Kim");
		System.out.println(index);
	}
}
