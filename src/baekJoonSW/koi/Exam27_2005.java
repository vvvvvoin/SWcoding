package baekJoonSW.koi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Exam27_2005 {
	static BufferedReader br;
	static StringTokenizer st;
	static int maxH = 0;
	static ArrayList<Pole> list;
	static int answer = 0;
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		// 가장 높은 기둥보다 바로 아래 낮은 기둥의 차이를 이용해

		list = new ArrayList<Pole>();
		int maxIdx = 0;
		int maxHeightIdx = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int index = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());
			list.add(new Pole(index, height));
			maxH = Math.max(maxH, height);
			maxIdx = Math.max(maxIdx, index);
		}
		Collections.sort(list);
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).height == maxH) {
				maxHeightIdx = i;
				break;
			}
		}
		int[][] arr = new int[maxH + 1][maxIdx + 1];
		right(arr, maxHeightIdx);
		left(arr, maxHeightIdx);
		for(int i = 0; i < maxH; i++) {
			arr[i][list.get(maxHeightIdx).index] = 1;
		}
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[0].length; j++) {
				if(arr[i][j] == 1) answer++;
			}
		}
		
		System.out.println(answer);
		
	}

	private static void right(int[][] arr, int start) {
		while(true) {
			if(start == list.size() - 1) break;
			int maxHeight = 0;
			int maxIdx = 0;
			for(int i = start + 1; i < list.size(); i++) {
				if(maxHeight <= list.get(i).height) {
					maxHeight = list.get(i).height;
					maxIdx = i;
				}
			}
			for(int i = 0; i < maxHeight; i++) {
				for(int j = list.get(start).index + 1; j <= list.get(maxIdx).index; j++) {
					arr[i][j] = 1;
				}
			}
			start = maxIdx;
		}
	}

	private static void left(int[][] arr, int start) {
		while(true) {
			if(start <= 0) break;
			int maxHeight = 0;
			int maxIdx = 0;
			for(int i = start - 1; i >= 0; i--) {
				if(maxHeight <= list.get(i).height) {
					maxHeight = list.get(i).height;
					maxIdx = i;
				}
			}
			for(int i = 0; i < maxHeight; i++) {
				for(int j = list.get(start).index; j >= list.get(maxIdx).index; j--) {
					arr[i][j] = 1;
				}
			}
			start = maxIdx;
		}
	}

	private static class Pole implements Comparable<Pole> {
		private int index;
		private int height;

		public Pole(int index, int height) {
			super();
			this.index = index;
			this.height = height;
		}

		@Override
		public int compareTo(Pole o) {
			if (o.index < this.index) {
				return 1;
			}else {
				return -1;
			}
		}

		@Override
		public String toString() {
			return "Pole [index=" + index + ", height=" + height + "]";
		}

	}
}
