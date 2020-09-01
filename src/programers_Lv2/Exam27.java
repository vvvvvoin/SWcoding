package programers_Lv2;

import java.util.ArrayList;

public class Exam27 {
	static int[] nums = {3,1,2,3 };

	public static void main(String[] args) {
		ArrayList<Integer> arrayList = new ArrayList<Integer>();

		for (int value : nums) {
			if (!arrayList.contains(value)) {
				arrayList.add(value);
			}
		}
		System.out.println(arrayList.size());
		System.out.println(nums.length / 2);
		System.out.println((nums.length / 2) < arrayList.size() ? nums.length/2 : arrayList.size());
	}
}
