package programers_Lv2;

import java.util.HashMap;

public class Exam17 {
	static String[][] clothes = { { "yellow_hat", "headgear" }, { "blue_sunglasses", "eyewear" },
			{ "green_turban", "headgear" } };

	public static void main(String[] args) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		//contain으로 확인할 필요없이 default값을 주면된다
		for(String[] str : clothes) {
			map.put(str[1], map.getOrDefault(str[1], 0) + 1);
		}
		// 경우의 수를 곱셉하기 위해 기본 1을 준다
		int answer = 1;
		
		for(int value : map.values()) {
			// +1은 해당 타입의 의류를 안입는 경우를 추가한 것이다
			answer *= value+1;
		}
		//모든 옷을 안입는 경우가 포함됨으로 1을 빼준다
		System.out.println(answer-1);
	}

}
