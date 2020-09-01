package programers;

import java.util.Arrays;
import java.util.HashMap;

public class Exam01 {
	static String[] participant = {"mislav", "stanko", "mislav", "ana"};
	static String[] completion = {"stanko", "ana", "mislav"};
	public static void main(String[] args) {
		HashMap<String, Integer> hash = new HashMap<String, Integer>();
		for(String str : participant) {
			hash.put(str, hash.getOrDefault(str, 0) + 1);
		}
		
		for(String str : completion) {
			hash.put(str, hash.get(str) - 1);
		}
		
		for(String str : hash.keySet()) {
			if(hash.get(str) == 1) System.out.println(str);
		}
	}
}
