package programers_Lv2;

import java.util.ArrayList;
import java.util.HashMap;

public class Exam47 {
	//static String msg = "KAKAO";
	static String msg = "TOBEORNOTTOBEORTOBEORNOT";
	//static String msg = "ABABABABABABABAB";
	public static void main(String[] args) {
		ArrayList<Integer> answerList = new ArrayList<Integer>();
		HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
		char a = 'A';
		for (int i = 0; i <= 25; i++) {
			hashMap.put((char) (a + i) + "", i + 1);
		}
		int value = 27;
		// HashMap에 존재하지 않는 String이 나올때까지 더한다
		// 존재하지 않는 문자가 나올경우
		// 직전값을 정답에 넣고, 존재하지 않는 문자는 HashMap에 넣는다

		String temp = "";
		for (int i = 0; i < msg.length(); i++) {
			temp += msg.charAt(i);
			if (hashMap.containsKey(temp)) {
				continue;
			} else {
				int answer = hashMap.get(temp.substring(0, temp.length() - 1));
				answerList.add(answer);
				hashMap.put(temp, value);
				value++;
				temp = "";
				// i-- 를 해야 존재하지 않는 ABC를 넣고 C부터 다시 시작해야하기 때문(안하면 C다음 문자부터 시작된다)
				i--;
			}
		}
		answerList.add(hashMap.get(temp));
		
		int[] answer = new int[answerList.size()];
		for(int i = 0; i < answer.length; i++) {
			answer[i] = answerList.get(i);
		}
	}
}
