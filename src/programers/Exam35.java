package programers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeMap;

public class Exam35 {
	static int N = 5;
	static int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
	public static void main(String[] args) {
		HashMap<Integer, Double> map = new HashMap<Integer, Double>();
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		for(int num : stages) {
			arrayList.add(num);
		}
		double cal = 0;
		int temp = 0;
		for (int i = 1; i <= N; i++) {
			cal = 0;
			temp = 0;
			for (int j = 0; j < arrayList.size(); j++) {
				if(i == stages[j]) {
					temp++;
				}
			}
			cal = temp/arrayList.size();
			arrayList.remove();
			map.put(i, cal);
		}

	}
}
