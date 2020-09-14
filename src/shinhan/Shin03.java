package shinhan;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Shin03 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int raw = Integer.parseInt(input.split(" ")[0]);
		int col = Integer.parseInt(input.split(" ")[1]);
		int time = Integer.parseInt(input.split(" ")[2]);
		
		Queue<Integer> queue = new LinkedList<Integer>();
		ArrayList<String> arrayList = new ArrayList<String>();
		for(int i = 1; i <= raw; i++) {
			String str = br.readLine();
			String[] tempStr = str.split(" ");
			if(i % 2 ==0) {
				for(int j = col - 1; j >= 0; j--) {
					arrayList.add(tempStr[j]);
				}
			}else {
				for(int j = 0; j < col; j++) {
					arrayList.add(tempStr[j]);
				}
			}
		}
		for(int i = arrayList.size() - 1; i >= 0; i--) {
			queue.add(Integer.parseInt(arrayList.get(i)));
		}
		for(int i = 0; i < time; i++) {
			int temp = queue.poll();
			queue.add(temp);
		}
		
		int[][] answer = new int[raw][col];
		for(int i = raw - 1; i >= 0; i--) {
			if(i % 2 ==0) {
				for(int j = col - 1; j >= 0; j--) {
					answer[i][j] = queue.poll();
				}
			}else {
				for(int j = 0; j < col; j++) {
					answer[i][j] = queue.poll();
				}
			}
		}
		
		for(int[] a : answer) {
			for(int b : a) {
				System.out.print(b + " ");
			}
			System.out.println();
		}
	}
}
