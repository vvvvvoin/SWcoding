package baekJoonSW.koi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Exam23_2003 {
	static BufferedReader br;
	static StringTokenizer st;
	static HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		map.put(0, 5);
		map.put(1, 3);
		map.put(2, 4);
		map.put(3, 1);
		map.put(4, 2);
		map.put(5, 0);
		
		int n = Integer.parseInt(br.readLine());
		int[][] dices = new int[n][6];
		for(int i = 0; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 6; j++) {
				dices[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int answer = 0;
		int top = 0;
		int bottom = 0;
		for(int i = 0; i < 6; i++) {
			ArrayList<Integer> list = new ArrayList<Integer>();		
			add(dices[0][i], dices[0][map.get(i)], list);
			top = dices[0][map.get(i)];
			for(int j = 1; j < n ; j++) {
				int index = 0;
				for(int k = 0; k < 6; k++) {
					if(dices[j][k] == top) {
						index = k;
						break;
					}
				}
				bottom = dices[j][index];
				top = dices[j][map.get(index)];
				add(top, bottom, list);
			}
			int temp = 0;
			for(int value : list) {
				temp += value;
			}
			answer = Math.max(answer, temp);
		}
				
		System.out.println(answer);
	}

	private static void add(int value1, int value2, ArrayList<Integer> list) {
		int max = 0;
		for(int i = 1; i <= 6; i++) {
			if(i != value1 && i != value2) {
				max = Math.max(max, i);
			}
		}
		list.add(max);
	}

}
