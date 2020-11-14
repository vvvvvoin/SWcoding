package baekJoonSW.koi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
//https://maivve.tistory.com/36
public class Exam46_2013 {
	static BufferedReader br;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());	//마을 수
		int c = Integer.parseInt(st.nextToken());	//트럭 용량
		int m = Integer.parseInt(br.readLine());
		
		int[] weights = new int[n + 1];

		Town[] arr = new Town[m];
		
		int start = -1;
		int end = -1;
		int weight = -1;
		for(int i = 0; i <  m ; i++) {
			st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken());
			end= Integer.parseInt(st.nextToken());
			weight = Integer.parseInt(st.nextToken());
			arr[i] = new Town(start, end, weight);
		}
		
		Arrays.sort(arr);
		
		int answer = 0;

		Town temp = null;
		for(int i = 0; i < m; i++) {
			temp = arr[i];
			boolean flag = true;
			int max = 0;
			
			for(int j = temp.start; j < temp.end; j++) {
				if(weights[j] >= c ) {
					flag = false;
					break;
				}
				max = Math.max(max, weights[j]);
			}
			
			if(flag) {
				int value = c - max;
				if(value > temp.weight) {
					value = temp.weight;
				}
				answer += value;
				for(int j = temp.start; j < temp.end; j++) {
					weights[j] += value;
				}
			}
		}
		System.out.println(answer);
	}
	
	private static class Town implements Comparable<Town>{
		int start;
		int end;
		int weight;
		public Town(int start, int end, int weight) {
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
		@Override
		public int compareTo(Town o) {
			if(this.end < o.end) {
				return -1;
			}else if(this.end == o.end){
				return 0;
			}else {
				return 1;
			}
		}
		
	}
}
