package programers_Lv2;

import java.util.LinkedList;
import java.util.Queue;

public class Exam03 {
	static int[] prices = { 1, 2, 3, 2, 3 };

	public static void main(String[] args) {
		//효율성 빵점이다 ㅋㅋㅋㅋㅋㅋ
		//처음에 했던 방식이 올바른 방식이었다
//		int[] answer = new int[prices.length];
//		Queue<Integer> queue = new LinkedList<Integer>();
//		int index = 0;
//		int index2 = 0;
//		int time = 0;
//		int stackValue = 0;
//		while(true) {
//			for (int i = index; i < prices.length; i++) {
//				queue.add(prices[i]);
//			}
//			stackValue = queue.poll();
//			while(true) {
//				if(queue.isEmpty()) break;
//				time++;
//				if(stackValue > queue.poll()) break;
//			}
//			answer[index2] = time;
//			index += 1;			
//			index2++;
//			time = 0;
//			queue.clear();
//			if(index >= prices.length) break;
//		}
		int time = 0;
		int[] answer = new int[prices.length];
		for (int i = 0; i < prices.length; i++) {
			for (int j = i+1; j < prices.length; j++) {
				if(prices[i] <= prices[j]) {
					time++;
				}else {
					time++;
					break;
				}
			}
			answer[i] = time;
			time = 0;
		}
		
		for (int value : answer) {
			System.out.println(value);
		}
	}
}
