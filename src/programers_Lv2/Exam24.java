package programers_Lv2;

import java.util.ArrayList;
import java.util.HashMap;

public class Exam24 {
	static String s = "{{1,2,3},{2,1},{1,2,4,3},{2}}";
	public static void main(String[] args) {
		// 걍 제일 많이 카운트된거 순서로 하면되지 않나?
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		String str = "";
		
		// 입력 s를 모두 찾는데
		// 시작이 숫자일경우 str에 누적
		// 다음값이 숫자가 아닌경우 str 초기화후 map에 넣어준다
		// 시작부터 문자가 아닌값이 들어올 수 있으므로 if(!str.equals("")) 체크
		for(int i = 0; i < s.length(); i++) {
			if(Character.isDigit(s.charAt(i))) {
				str += s.charAt(i);
			}else {
				if(!str.equals("")) {
					map.put(str, map.getOrDefault(str, 0) + 1);
					str = "";
				}
			}
		}
		
		int max = 0;
		String key = "";
		ArrayList<String> arrayList = new ArrayList<String>();
		// map의 value가 가장큰 키 값을 찾아 어레이리스트에 넣고 삭제 반복
		while(!map.isEmpty()) {
			for(String  value : map.keySet()) {
				if(map.get(value) > max){
					max = map.get(value);
					key = value;
				}
			}
			arrayList.add(key);
			map.remove(key);
			max = 0;
		}
		
		// array생성 후 변환
		int[] answer = new int[arrayList.size()];
		for(int i = 0; i < arrayList.size(); i++)		{
			answer[i] = Integer.parseInt(arrayList.get(i));
		}
		
		for(int v : answer) {
			System.out.println(v);
		}
		
	}
}
