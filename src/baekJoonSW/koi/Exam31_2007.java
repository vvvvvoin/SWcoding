package baekJoonSW.koi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Exam31_2007 {
	static BufferedReader br;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<Integer, Candidate> map = new HashMap<>();
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < m; i++) {
			// 오래된 시간
			if(!map.isEmpty()) {
				for(int key : map.keySet()) {
					map.get(key).time++;
				}
			}
						
			int num = Integer.parseInt(st.nextToken());
			//후보자가 있다면 추천수 상승
			if(map.containsKey(num)) {
				map.get(num).recommend++;
			}else {
				// 없다면 추가
				map.put(num, map.getOrDefault(num, new Candidate(num, 1, 0)));
				// 추가해서 더이상 걸 수 있는 사진이 없다면
				if(map.size() > n) {
					ArrayList<Candidate> remove = new ArrayList<Candidate>();
					int value = 9999;
					// 최소 추천수 찾기
					for(int key : map.keySet()) {
						if(key == num) continue;
						value = Math.min(value, map.get(key).recommend);
					}
					// 최소 추천수를 갔는 모든 후보자 리스트에 담기
					for(int key : map.keySet()) {
						if(map.get(key).recommend == value) {
							if(key == num) continue;
							remove.add(map.get(key));
						}
					}
					value = 0;
					int who = 0;
					// 최소 추천 후보자 중 오래된 사람 조회
					for(Candidate c : remove) {
						if(c.time > value) {
							value = c.time;
							who = c.who;
						}
					}
					// 제거
					map.remove(who);
				}
			}
		}
		ArrayList<Integer> answer = new ArrayList<Integer>();
		for(int key : map.keySet()) {
			answer.add(key);
		}
		Collections.sort(answer);
		String str = "";
		for(int num : answer) {
			str += num + " ";
		}
		System.out.println(str.trim());
		
	}
	
	private static class Candidate{
		int who;
		int recommend;
		int time;

		public Candidate(int who, int recommend, int time) {
			super();
			this.who = who;
			this.recommend = recommend;
			this.time = time;
		}

		@Override
		public String toString() {
			return "Candidate [who=" + who + ", recommend=" + recommend + ", time=" + time + "]";
		}

		
	}
}
