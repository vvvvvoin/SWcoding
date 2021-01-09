package baekJoonSW;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exam57 {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		int n = Integer.valueOf(st.nextToken());
		int k = Integer.valueOf(st.nextToken()) - 1;
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 1; i <= n; i++) {
			list.add(i);
		}
		sb.append("<");
		int index = 0;
		int size = list.size();
		while(!list.isEmpty()) {
			index += k;
			size = list.size();
			if(index >= size) {
				index %= size;
			}

			sb.append(list.remove(index)).append(", ");
		}
		String answer = sb.toString().trim();
		answer = answer.substring(0, answer.length() - 1);
		System.out.println(answer + ">");
	}
}

	