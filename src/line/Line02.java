package line;

import java.util.ArrayList;
import java.util.HashSet;

public class Line02 {
	//static int[] ball = {1, 2, 3, 4, 5, 6};
	//static int[] order = {6, 2, 5, 1, 4, 3};
	//static int[] ball = {11, 2, 9, 13, 24};
	//static int[] order = {9, 2, 13, 24, 11};
	static int[] ball = {1, 2, 3, 4, 5};
	static int[] order = {2, 3, 5, 4, 1};
	public static void main(String[] args) {
		HashSet<Integer> set = new HashSet<Integer>();
		ArrayList<Integer> answerList = new ArrayList<Integer>();
		int first = 0;
		int last = ball.length - 1;
		boolean flag = false;
		for(int i = 0; i < order.length; i++) {
			if(order[i] == ball[first]) {
				answerList.add(ball[first]);
				ball[first] = 0;
				first++;
				while(true) {
					flag = false;
					for(int value : set) {
						if(value == ball[first]) {
							answerList.add(value);
							ball[first] = 0;
							first++;
							flag = true;
						}
					}
					if(!flag) break;
				}
			}else if(order[i] == ball[last]) {
				answerList.add(ball[last]);
				ball[last] = 0;
				last--;
				while(true) {
					flag = false;
					for(int value : set) {
						if(value == ball[last]) {
							answerList.add(value);
							ball[last] = 0;
							last--;
							flag = true;
						}
					}
					if(!flag) break;
				}
			}else {
				set.add(order[i]);
			}
		}
		int[] answer = new int[answerList.size()];
		for(int i = 0; i < answer.length; i++) {
			answer[i] = answerList.get(i);
		}
		System.out.println(answerList);
	}
}
