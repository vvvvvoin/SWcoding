package test;

import java.util.ArrayList;
import java.util.Arrays;

public class Test {
	public static void main(String[] args) {
		ArrayList<String> arrayList1 = new ArrayList<>();
		arrayList1.add("apple");
		arrayList1.add("banana");
		arrayList1.add("tomato");
		arrayList1.add("melon");
		arrayList1.add("watermelon");
			
		ArrayList<String> arrayList2 = (ArrayList<String>) arrayList1.clone();
		System.out.println(arrayList2);
	}
}
