package baekJoonSW;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exam60 {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.valueOf(br.readLine());
		Queue<TwoValue> q = new LinkedList<TwoValue>();
		Queue<TwoValue> tempQ = new LinkedList<TwoValue>();
		for (int t = 0; t < n; t++) {
			String[] oper = br.readLine().split(" ");
			String[] strArr = br.readLine().split(" ");

			for (int i = 0; i < strArr.length; i++) {
				q.add(new TwoValue(i, Integer.valueOf(strArr[i])));
			}
			boolean flag = false;
			ArrayList<Integer> answer = new ArrayList<Integer>();
			while (!q.isEmpty()) {
				TwoValue compare = q.poll();
				TwoValue temp;
				tempQ.clear();
				tempQ.addAll(q);
				
				while (!tempQ.isEmpty()) {
					temp = tempQ.poll();
					if(compare.value < temp.value) {
						flag = true;
						break;
					}
				}
				
				if(flag == true) {
					q.add(compare);
					flag = false;
				}else {
					answer.add(compare.index);
				}
			}
			
			for(int i = 0; i < answer.size(); i++) {
				if(answer.get(i) == Integer.valueOf(oper[1])) {
					System.out.println(i + 1);
				}
			}
			
		}
	}

	private static class TwoValue {
		int index;
		int value;

		public TwoValue(int index, int value) {
			super();
			this.index = index;
			this.value = value;
		}

	}
}
