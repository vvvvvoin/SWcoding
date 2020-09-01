package programers_Lv2;

import java.util.Stack;

public class Exam31 {
	static int n = 200;
	public static void main(String[] args) {
		// n번쩨 수를 나누라는데 왜 모든값을 나눠야 할까
		// 너무 값이 커지는 것을 방지하는 느낌인데 이상하닥
		
		Stack<Double> stack = new Stack<Double>();
		stack.add((double) 0);
		stack.add((double) 1);
		double nextValue = 0;
		double pop = 0;
		for(int i = 0; i < n -1; i ++) {
			pop = stack.pop();
			nextValue = pop  + stack.peek();
			stack.add(pop %1234567);
			stack.add(nextValue %1234567);
		}
		double answer = stack.peek() % (double) 1234567;
		System.out.println(answer);
	}
	
	
//	 int answer = 0;
//     int a = 0; int b = 1;
//     for(int i=0; i<n; i++) {
//         int c = (a+b)%1234567;
//         a = b%1234567;
//         b = c%1234567;
//     }
//         
//     return a;
}
