package baekJoonSW;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exam56 {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		Queue<Integer> q = new LinkedList<Integer>();
		int n = Integer.valueOf(br.readLine());
		int last = -1;
		for(int t = 0 ; t < n; t++) {
			String[] arr = br.readLine().split(" ");
			if(arr[0].equals("push")) {
				q.add(Integer.valueOf(arr[1]));
				last = Integer.valueOf(arr[1]);
			}else if(arr[0].equals("pop")) {
				try {
					sb.append(q.remove());
				} catch (NoSuchElementException e) {
					sb.append(-1);
				}
				sb.append("\n");
			}else if(arr[0].equals("empty")) {
				if(q.isEmpty()) {
					sb.append(1);
				}else {
					sb.append(0);
				}
				sb.append("\n");
			}else if(arr[0].equals("size")) {
				sb.append(q.size());
				sb.append("\n");
			}else if(arr[0].equals("front")) {
				try {
					sb.append(q.element());
				} catch (NoSuchElementException e) {
					sb.append(-1);
				}
				sb.append("\n");
			}else if(arr[0].equals("back")) {
				if(last == -1 || q.size() == 0) {
					sb.append(-1);
				}else {
					sb.append(last);
				}
				sb.append("\n");
			}
		}
		System.out.println(sb.toString());
	}
}
