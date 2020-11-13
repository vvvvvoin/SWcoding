package programers_Lv3;

import java.util.HashSet;
import java.util.LinkedList;

public class Exam06 {
	static int n = 3;
	//static int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
	static int[][] computers = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
	public static void main(String[] args) {
		HashSet<LinkedList<Integer>> set = new HashSet<LinkedList<Integer>>();
		for(int i = 0; i < computers.length; i++) {
			LinkedList<Integer> linked = new LinkedList<Integer>();
			int cnt = 0;
			for(int j = 0; j < computers[0].length; j++) {
				if(computers[i][j] == 1) {
					linked.add(j);
				}
			}
			set.add(linked);
		}
		
		System.out.println(set.size());
	}
}
