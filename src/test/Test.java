package test;

import java.util.HashMap;
import java.util.Map;

class Test {

	public static void main(String[] args) {
		Map<String, Integer> hashMap = new HashMap<>();
		hashMap.put("a", 1);
		hashMap.put("b", 2);
		hashMap.put("c", 3);
		hashMap.put(null, 3);
		
		System.out.println(hashMap);
		System.out.println(hashMap.getOrDefault("a", 0));
		System.out.println(hashMap.getOrDefault("4", 100));
		System.out.println(hashMap);
	}

}
