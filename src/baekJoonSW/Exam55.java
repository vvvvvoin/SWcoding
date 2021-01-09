package baekJoonSW;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.EmptyStackException;
import java.util.Stack;
import java.util.StringTokenizer;

public class Exam55 {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<Integer> stack = new Stack<Integer>();
		int n = Integer.valueOf(br.readLine());
		
		for(int t = 0 ; t < n; t++) {
			String[] arr = br.readLine().split(" ");
			if(arr[0].equals("push")) {
				stack.add(Integer.valueOf(arr[1]));
			}else if(arr[0].equals("pop")) {
				try {
					bw.write(String.valueOf(stack.pop()));					
				} catch (EmptyStackException e) {
					bw.write("-1");
				}
				bw.write("\n");
			}else if(arr[0].equals("empty")) {
				if(stack.isEmpty()) {
					bw.write("1");
				}else {
					bw.write("0");
				}
				bw.write("\n");
			}else if(arr[0].equals("size")) {
				bw.write(String.valueOf(stack.size()));
				bw.write("\n");
			}else if(arr[0].equals("top")) {
				try {
					bw.write(String.valueOf(stack.peek()));
				} catch (EmptyStackException e) {
					bw.write("-1");
				}
				bw.write("\n");
			}
		}
		bw.flush();
		bw.close();
	}
}
