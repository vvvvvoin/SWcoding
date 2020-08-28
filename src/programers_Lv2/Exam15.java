package programers_Lv2;

import java.util.Arrays;
import java.util.Comparator;

public class Exam15 {
	static String[] phone_book = { "123", "456", "456789" };

	public static void main(String[] args) {

		String min = Arrays.stream(phone_book).min(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				int a = o1.length();
				int b = o2.length();
				return a - b;
			}

		}).get();
		

		for (String str : phone_book) {
			if (!str.equals(min)) {
				if (str.substring(0, min.length()).equals(min)) {
					System.out.println(false);
				}
			}
		}
		System.out.println("=============================");
		for(int i = 0; i < phone_book.length - 1; i++) {
			for(int j = i; j < phone_book.length; j++) {
				if(phone_book[i].startsWith(phone_book[j])) System.out.println("false");
				if(phone_book[j].startsWith(phone_book[i])) System.out.println("false");
			}
		}
		System.out.println(true);
	}
}
