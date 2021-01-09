package baekJoonSW;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.EmptyStackException;
import java.util.Stack;
import java.util.StringTokenizer;

public class Exam58 {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int n = Integer.valueOf(br.readLine());
		int[] arr = new int[n + 1];
		for (int t = 0; t < n; t++) {
			arr[t] = Integer.valueOf(br.readLine());
		}

		Stack<Integer> stack = new Stack<Integer>();
		int cnt = 0;
		int num = 1;
		int index = 0;
		stack.add(num);
		sb.append("+").append("\n");
		while (true) {
			if (stack.size() != 0 && stack.peek() == arr[index]) {
				index++;
				sb.append("-").append("\n");
				stack.pop();
				cnt++;
				continue;
			}
			num++;
			stack.add(num);
			if (num > n)
				break;
			sb.append("+").append("\n");
		}
		if(cnt == n) {
			System.out.println(sb);
		}else {
			System.out.println("NO");
		}
	}
}
