package programers_Lv2;

import java.util.Stack;

public class Exam36 {
	static String s = "baabaa";

	public static void main(String[] args) {
		// 처음에 어레이 리스트로 했는데 테스트 케이스는 만점이지만
		// 효율성이 또 빵점이었다. 테스트 케이스도 상당히 시간이 걸렸다
		// 스택으로 했는데 잘되었다
		// 다른 코드와 비교했을때 더 짧고 같은 구조와 비교했는데 속도 차이는 없었다
		// 간결하게 코드를 만들 수 있도록 해야겠다
		
		int answer = 0;
		int index = 0;
		
		Stack<Character> stack = new Stack<Character>();
		while (true) {
			if (!stack.isEmpty()) {
				if (stack.peek() == s.charAt(index)) {
					stack.pop();
				} else {
					stack.add(s.charAt(index));
				}
			}else {
				stack.add(s.charAt(index));
			}

			index++;
			if (index == s.length()) break;

		}
		if (stack.isEmpty()) {
			answer = 1;
		} else {
			answer = 0;
		}

		System.out.println(answer);

//		int answer = 0;
//		ArrayList<Character> arrayList = new ArrayList<Character>();
//		for (int i = 0; i < s.length(); i++) {
//			arrayList.add(s.charAt(i));
//		}
//		boolean flag = false;
//		while (true) {
//			flag = true;
//			if (arrayList.size() == 0) {
//				answer = 1;
//				break;
//			}
//
//			for (int i = 0; i < arrayList.size() - 1; i++) {
//				if (arrayList.get(i) == arrayList.get(i + 1)) {
//					arrayList.remove(i + 1);
//					arrayList.remove(i);
//					i--;
//					flag = false;
//				}
//			}
//
//			if (flag) {
//				answer = 0;
//				break;
//			}
//		}
//		System.out.println(answer);
	}
}
