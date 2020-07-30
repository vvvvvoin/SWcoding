package programers;

import java.util.ArrayList;
import java.util.Arrays;

public class Exam03 {
	static int[] array = {1, 5, 2, 6, 3, 7, 4};
	static int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
	static ArrayList<Integer> arrayList = new ArrayList<>();
	
	public static void main(String[] args) {
		int cnt = 0;
		for(int i = 0; i<commands.length; i++) {
			int[] test = new int[commands[i][1] - commands[i][0] + 1];
			
			for(int j = 0; j<array.length; j++) {
				if((commands[i][0]-1) <= j && (commands[i][1]-1) >= j){
					test[cnt] = array[j];
					cnt++;
				}
			}
			Arrays.sort(test);
			arrayList.add(test[commands[i][2]-1]);
			cnt = 0;
		}
		
		int[] answer = new int[arrayList.size()];
		for(int v = 0; v < arrayList.size(); v++) {
			answer[v] = arrayList.get(v);
		}
		
		System.out.println(answer);
	}
}
