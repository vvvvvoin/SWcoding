package programers;

import java.util.Stack;

public class Exam07 {
	static int[] arr = {1,1,3,3,5};
	public static void main(String[] args) {
		//이전에 풀었던 '크레인 인형뽑기'를 응용해봤다
		//다른사람의 풀이가 대부분 어레리 리스트로 풀었는데
		//스택이 더 쉬운거 같다
		//처음에는 큐로 풀러고 했는데 큐는 공부를 더 해봐야겠다
		Stack<Integer> qu = new Stack<Integer>();
		qu.add(arr[0]);
		for(int i : arr) {
			if(qu.peek() == i) {
				continue;
			}else {
				qu.add(i);
			}
		}
		int[] answer = new int[qu.size()];
		for(int i = qu.size() - 1; i>= 0; i--) {
			answer[i] = qu.pop();
		}
		System.out.println(answer);
	}
}
