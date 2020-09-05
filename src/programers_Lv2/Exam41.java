package programers_Lv2;

import java.util.ArrayList;
import java.util.HashMap;

public class Exam41 {
	static String str1 = "E=M*C^2";
	static String str2 = "e=m*c^2";
	public static void main(String[] args) {
		// 정규표현식 잘 익혀둬야 겠다
		int union = 0;
		int intersection = 0;
		ArrayList<String> hashSet1 = new ArrayList<String>();
		ArrayList<String> hashSet2 = new ArrayList<String>();
		HashMap<String, Integer> map1 = new HashMap<String, Integer>();
		HashMap<String, Integer> map2 = new HashMap<String, Integer>();
		HashMap<String, Integer> mapAnswer = new HashMap<String, Integer>();

		String str = "";
		for (int i = 0; i < str1.length() - 1; i++) {
			if (str1.substring(i, i + 2).matches("^[a-zA-Z]*$")) {
				str = str1.substring(i, i + 2).toLowerCase();
				hashSet1.add(str);
				map1.put(str, map1.getOrDefault(str, 0) + 1);
			}
		}

		for (int i = 0; i < str2.length() - 1; i++) {
			if (str2.substring(i, i + 2).matches("^[a-zA-Z]*$")) {
				str = str2.substring(i, i + 2).toLowerCase();
				hashSet2.add(str);
				map2.put(str, map2.getOrDefault(str, 0) + 1);
			}
		}
		// 합집합
		// 첫번째 map1을 일단 다 넣는다
		for (String key : map1.keySet()) {
			mapAnswer.put(key, map1.get(key));
		}
		// 두번째 map2에서 같은 값을 찾는다
		for (String key : map2.keySet()) {
			// 만약 두번째 map2에서 동일한 키 값이 있는지 확인한다.
			// key가 존재하지 않느면 예외가 발생하니 getOrDefault()를 사용해 없다면 0을 반환해 알 수 있도록 한다
			if (mapAnswer.getOrDefault(key, 0) != 0) {
				// 만약 서로 키에 해당하는 값이 있다면
				// 큰쪽의 값을 다시 매핑시킨다
				if (map1.get(key) < map2.get(key)) {
					mapAnswer.put(key, map2.get(key));
				}
			} else {
				// 동일한 키값이 없다면 그냥 넣는다
				mapAnswer.put(key, map2.get(key));
			}
		}

		// 각 키의 값을 모두 더하면 합집합 크기를 알 수 있다
		for (int value : mapAnswer.values()) {
			intersection += value;
		}

		// 교집합
		for (int i = 0; i < hashSet1.size(); i++) {
			for (int j = 0; j < hashSet2.size(); j++) {
				if (hashSet1.get(i).equals(hashSet2.get(j))) {
					hashSet1.remove(i);
					hashSet2.remove(j);
					union++;
					i--;
					break;
				}

			}
		}
		if (union == 0 && intersection == 0) {
			System.out.println(65536);
		}
		double answer = (double) union / (double) intersection * 65536;
		System.out.println((int) answer);
	}
	

}
