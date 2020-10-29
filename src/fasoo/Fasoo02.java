package fasoo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Fasoo02 {
	static String[] nums = {};
	public static void main(String[] args) {
		for(int i = 0; i < nums.length; i++) {
			if(nums[i].charAt(0) == '-' || nums[i].charAt(nums[i].length() - 1) == '-') {
				nums[i] = "";
			}
			if(!rule01(nums[i])) {
				nums[i] = "";
			}
			if(!rule02(nums[i])) {
				nums[i] = "";
			}
			if(!rule03(nums[i])) {
				nums[i] = "";
			}
			
			if(nums[i].contains("--")) {
				nums[i] = "";
			}
		}
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for(int i = 0; i < nums.length; i++) {
			if(nums[i].equals("")) continue;
			String temp = "";
			for(int j  = 0; j < nums[i].length(); j++) {
				if(Character.isDigit(nums[i].charAt(j))){
					temp += "0";
				}else {
					temp += "-";
				}
			}
			if(map.containsKey(temp)) {
				map.put(temp, map.get(temp) + 1);
			}else {
				map.put(temp, 1);
			}
			
		}
		ArrayList<Integer> list = new ArrayList<Integer>();
		Collections.sort(list, Collections.reverseOrder());
		System.out.println(map);
		int[] answer = new int[list.size()];
		for(int i = 0 ; i < answer.length; i++) {
			answer[i] = list.get(i);
		}
	} 
	
	private static boolean rule01(String str){
		boolean flag = true;
		for(int i = 0; i < str.length(); i++) {
			if(!(Character.isDigit(str.charAt(i)) || str.charAt(i) == '-')) {
				return false;
			}
		}
		return flag;
	}
	
	private static boolean rule02(String str){
		int cnt = 0;
		for(int i = 0; i < str.length(); i++) {
			if(Character.isDigit(str.charAt(i))) {
				cnt++;
			}
		}
		if(cnt >= 11 & cnt <= 14) {
			return true;
		}else {
			return false;
		}
	}
	
	private static boolean rule03(String str){
		int cnt = 0;
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == '-') {
				cnt++;
			}
		}
		if(cnt >= 0 & cnt <= 3) {
			return true;
		}else {
			return false;
		}
	}
}
