package programers_Lv3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Exam14 {
	static String[] genres = {"classic", "pop", "classic", "classic", "pop"};	 
	static int[] plays = {500,600,150,800,2500};
	public static void main(String[] args) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		ArrayList<Music> list = new ArrayList<>();
		for(int i = 0; i < genres.length; i++) {
			list.add(new Music(genres[i], i, plays[i]));
			if(!map.containsKey(genres[i])) {
				map.put(genres[i], plays[i]);
			}else {
				map.put(genres[i], map.get(genres[i]) + plays[i]);
			}
		}
		Collections.sort(list);
		ArrayList<Gen> genList = new ArrayList<>();
		for(String key : map.keySet()) {
			genList.add(new Gen(key, map.get(key)));
		}
		Collections.sort(genList);
		ArrayList<Integer> answer = new ArrayList<Integer>();
		int cnt = 0;
		for(Gen g : genList) {
			cnt = 0;
			for(int i = 0; i < list.size(); i++) {
				if(cnt == 2) {
					cnt = 0;
					 break;
				}
				if(g.gene.equals(list.get(i).gene)) {
					answer.add(list.get(i).index);
					cnt++;
				}
			}
		}
		int[] ans = new int[answer.size()];
		for(int i = 0; i < answer.size(); i++) {
			ans[i] = answer.get(i);
			System.out.println(ans[i]);
		}
		
		
	}
	private static class Gen implements Comparable<Gen>{
		String gene;
		int sum;
		public Gen(String gene, int sum) {
			super();
			this.gene = gene;
			this.sum = sum;
		}
		@Override
		public int compareTo(Gen o) {
			if(this.sum > o.sum) {
				return -1;
			}else {
				return 1;
			}
		}
	}
	
	private static class Music implements Comparable<Music>{
		String gene;
		int index;
		int play;
		
		public Music(String gene, int index, int play) {
			super();
			this.gene = gene;
			this.index = index;
			this.play = play;
		}

		@Override
		public int compareTo(Music o) {
			if(this.gene.equals(o.gene)) {
				if(this.play == o.play) {
					return Integer.compare(this.play, o.play);
				}
				return -Integer.compare(this.play, o.play);
			}
			
			return this.gene.compareTo(o.gene);
		}
	}
}
