package programers_Lv2;

import java.util.ArrayList;
import java.util.Stack;

public class Exam02 {
	static int[] progresses = {93,30,55};
	static int[] speeds = {1,30,5};
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		ArrayList<Integer> answerList = new ArrayList<Integer>();
		int index = 0;
		
		while(true) {
			//인덱스 부터 값을 더해준다
			for(int i = index; i<progresses.length;i++) {
				 progresses[i] += speeds[i];
			}
			//인덱스 부터 진행도가 100이상인 거를 차례대로 스택에 담는다
			//단 처음 뽑는 값이 100미만이면 break
			for(int i =index; i<progresses.length;i++) {
				if(progresses[i] < 100) break;
				 if(progresses[i] >= 100) {
					 stack.add(progresses[i]);
				 }
			}
			
			//해당 날에 끝낸 과정이 있는지 검사
			if (stack.size() != 0) {
				//인덱스는 과정이 끝마친거를 다시 처리할 필요 없으니 인덱스는 스택사이즈 만큼 누적
				index += stack.size();
				//스택에 쌓인 갯수가 당일 끝낸 과정 수
				answerList.add(stack.size());
				//스택 초기화
				stack.clear();
			}
			//현재의 인덱스가 과정의 크기를 넘겼다면 바로 나가야된다
			if(index >= progresses.length) {
				break;
			}
		}
		int[] answer = new int[answerList.size()];
		for(int i = 0; i< answerList.size(); i++) {
			answer[i]  = answerList.get(i);
		}
	}
}
