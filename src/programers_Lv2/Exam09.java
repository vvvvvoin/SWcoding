package programers_Lv2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class Exam09 {
	static int[] scoville = { 1, 2, 3};
	static int K = 11;

	public static void main(String[] args) {
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
		int time = 0;
		int firstMin = 0;
		int secondMin = 0;
		int cal = 0;
		for(int i =0; i < scoville.length; i++) {
			priorityQueue.offer(scoville[i]); 
		}
		while(true) {
			//처음 시작부터 최소값이 K이상이거나, 루프를 돌아서 K 이상이면 종료
			if(priorityQueue.peek() >= K) {
				break;
			}
			//타임
			time++;
			
			firstMin = priorityQueue.poll();

			//루프마지막에 무조건 하나이상에 값이 들어가고 값을 뽑는다
			//하지만 다음값이 존재하지 않는다면 최근값이 하나였고
			//그 하나가 K이상의 값이 아니므로 -1을 갖고 브레이크
			if(priorityQueue.peek() == null) {
				time = -1;
				break;
			}
			secondMin = priorityQueue.poll();
			cal = firstMin + secondMin * 2;
			priorityQueue.offer(cal);
		}
		System.out.println(time);
		
		//이건 효율성 빵점이다 ㅋㅋㅋㅋㅋㅋ
//		PriorityQueue 하나 배워가요
//		ArrayList<Integer> arrayList = new ArrayList<Integer>();
//		for(int i =0; i < scoville.length; i++) {
//			arrayList.add(scoville[i]); 
//		}
//		int firstMin = 0;
//		int secondMin = 0;
//		int time = 0;
//		int cal = 0;
//		while(true) {
//			if(Collections.min(arrayList) >= K) {
//				break;
//			}
//			time++;
//			firstMin = Collections.min(arrayList);
//			arrayList.remove(arrayList.indexOf(firstMin));
//			System.out.println(arrayList);
//			if(arrayList.size() == 0) {
//				time = -1;
//				break;
//			}
//			secondMin = Collections.min(arrayList);
//			arrayList.remove(arrayList.indexOf(secondMin));
//			
//			System.out.println(arrayList);
//			cal = firstMin + secondMin * 2;
//			arrayList.add(cal);
//			
//		}

	}
}















