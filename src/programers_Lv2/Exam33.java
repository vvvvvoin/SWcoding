package programers_Lv2;

import java.util.ArrayList;

public class Exam33 {
	//static String expression = "100-200*300-500+20";
	static String expression = "50*6-3*2"	;
	static long answer = 0;
	public static void main(String[] args) {
		//어레이 리스트에 앞의 기호와 함께 저장하여 연산해야겠다
		//클래스를 만들어 스택?에 넣어서 연산하던가
		//일부는 정답인데 나머지는 틀리는게 아닌 런타임 오류가
		// 복잡하게 문제를 푼거 같아 새롭게 풀려고한다
		answer = 0;
		
		ArrayList<Where> whereList = new ArrayList<Where>();
		ArrayList<Character> operatorSet = new ArrayList<Character>();
		
		
		for(int i =0; i < expression.length(); i++) {
			if(!Character.isDigit(expression.charAt(i))) {
				whereList.add(new Where(i, expression.charAt(i)));
				if(!operatorSet.contains(expression.charAt(i))) {
					operatorSet.add(expression.charAt(i));					
				}
			}
		}
		boolean[] visited = new boolean[operatorSet.size()];
		char[] operatorArray = new char[visited.length];
		for(int i =0; i < operatorSet.size(); i++) {
			operatorArray[i] = operatorSet.get(i);
		}
		char[] temp = new char[visited.length];

		
		dfs(expression, whereList, operatorArray, visited, temp, operatorArray.length, 0);
		//전체표현 값과, where어레이리스트, 오퍼레이터 배열,visitied 오퍼레이터 배열을 담을 값, 사이즈, 0
		System.out.println(answer);
	}
	
	private static void dfs(String expression, ArrayList<Where> whereList, char[] operatorArray, boolean[] visited, char[] temp, long size, int n) {
		if(size == n) {
			String str = expression;
			for(char value : temp) {
				// temp에 담긴 경우를 whereList에서 찾아 연산한다
				for(int i = 0; i < whereList.size(); i++) {
					if(whereList.get(i).operator == value) {
						// 찾은 연산자로 부터 해당 인덱스에서 좌우로 연산한다
						str = cal(str, whereList.get(i).operator);

					}
					
				}
			}
			answer = Math.max(Math.abs(Long.parseLong(str)), answer);
			return;
		}
		
		for(int i = 0; i < visited.length; i++) {
			if(visited[i] == false) {
				visited[i] = true;
				temp[n] = operatorArray[i];
				dfs(expression, whereList, operatorArray, visited, temp, operatorArray.length, n+1);
				visited[i] = false;
			}
		}
	}
	
	
	static String cal(String expression, char operator) {
		int index = 0;
		for(int i = 1; i < expression.length(); i++) {
			if(expression.charAt(i) == operator) {
				index = i;
				break;
			}
		}
		// 인덱스 - 1 왼쪽 기준으로 숫자값만 받는다
		String leftValue = "";
		for (int i = index - 1; i >= 0; i--) {
			if (Character.isDigit(expression.charAt(i))) {
				leftValue = expression.charAt(i) + leftValue;
			} else {
				//숫자가 아닌경우
				//인덱스가 0인 경우
				if(i == 0) {
					leftValue = expression.charAt(i) + leftValue;
					break;
				}else {
					if (!Character.isDigit(expression.charAt(i - 1))) {
						leftValue = expression.charAt(i) + leftValue;
						break;
					}else {
						break;
					}
				}
				
				

			}
		}
		// 인덱스 + 1 오른쪽 기준으로 숫자값만 받는다
		String rightValue = "";
		for(int i = index +1; i < expression.length(); i++) {
			if(Character.isDigit(expression.charAt(i))) {
				rightValue = rightValue + expression.charAt(i);
			}else {
				if(i == index + 1){
					rightValue = rightValue + expression.charAt(i);
					continue;
				}
				break;
			}
		}
		
		//rightValue = rightValue + expression.charAt(i);
		//구해진 값 연산
		long newValue = 0;
		if(rightValue.equals("")) rightValue = "0";
		if(leftValue.equals("")) leftValue = "0";
		if(operator == '-') {
			newValue = Long.parseLong(leftValue) - Long.parseLong(rightValue);
		}else if(operator == '+') {
			newValue = Long.parseLong(leftValue) + Long.parseLong(rightValue);
		}else {//operator == '*'
			newValue = Long.parseLong(leftValue) * Long.parseLong(rightValue);
		}
		

		expression = expression.replace(leftValue+operator+rightValue, String.valueOf(newValue));
		return expression;
	}

	
	
	static class Where {
		private long index;
		private char operator;
		
		public Where(long index, char operator) {
			super();
			this.index = index;
			this.operator = operator;
		}
		
		
	}
}

