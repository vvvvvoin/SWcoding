package programers_Lv2;

import java.util.ArrayList;

public class Exam33_2 {
	//static String expression = "100-200*300-500+20";
	static String expression = "50*6-3*2"	;
	static long answer = 0;
	public static void main(String[] args) {
		answer = 0;
		
		ArrayList<String> expressionArrayList = new ArrayList<String>();
		ArrayList<String> operatorSet = new ArrayList<String>();
		String tempStr = "";
		
		for(int i = 0; i < expression.length(); i++) {
			if(Character.isDigit(expression.charAt(i))){
				tempStr += expression.charAt(i);
			}else {
				operatorSet.add(String.valueOf(expression.charAt(i)));
				expressionArrayList.add(tempStr);
				tempStr = "";
			}
		}
		expressionArrayList.add(tempStr);

		ArrayList<String> operatorArray = new ArrayList<String>();
		for (int i = 0; i < operatorSet.size(); i++) {
			if (!operatorArray.contains(operatorSet.get(i))) {
				operatorArray.add(operatorSet.get(i));
			}
		}
		boolean[] visited = new boolean[operatorArray.size()];
		String[] temp = new String[visited.length];
		dfs(expressionArrayList, operatorSet, operatorArray, visited, temp, operatorArray.size(), 0);
		//전체표현 값과, 오퍼레이터 순서, 오퍼레이터 배열, visitied, 오퍼레이터 배열을 담을 값, 사이즈, 0
		System.out.println(answer);
	}

	
	private static void dfs(ArrayList<String> expressionArrayList, ArrayList<String> operatorSet, ArrayList<String> operatorArray, 
			boolean[] visited, String[] temp, long size, int n) {
		
		if(size == n) {
			int index = 0;
			ArrayList<String> tempSet = (ArrayList<String>) operatorSet.clone();
			ArrayList<String> tempExpression = (ArrayList<String>) expressionArrayList.clone();
			for(String op : temp) {
				for(int i = index; i < tempSet.size(); i++) {
					if(tempSet.get(i).equals(op)) {
						if(tempSet.get(i).equals("+")) {
							tempExpression.set(i, Long.parseLong(tempExpression.get(i)) + Long.parseLong(tempExpression.get(i + 1)) + "");
						}else if(tempSet.get(i).equals("-")) { 							
							tempExpression.set(i, Long.parseLong(tempExpression.get(i)) - Long.parseLong(tempExpression.get(i + 1)) + "");
						}else{
							tempExpression.set(i, Long.parseLong(tempExpression.get(i)) * Long.parseLong(tempExpression.get(i + 1)) + "");
						}
						tempSet.remove(i);
						tempExpression.remove(i+1);
						//	i 기준 전에는 찾지 못했으니까 1칸 전으로 돌아가 다시 탐색하면 제거된 후에도 존재하는 해당 연산자를 모두 찾을 수 있다
						// 여기서 많은 실수를 했다
						i--;
					}
				}
			}
			answer = Math.max(Math.abs(Long.parseLong(tempExpression.get(0))), answer);
			return;
		}
		
		for(int i = 0; i < visited.length; i++) {
			if(visited[i] == false) {
				visited[i] = true;
				temp[n] = operatorArray.get(i);
				dfs(expressionArrayList, operatorSet, operatorArray, visited, temp, size, n+1);
				visited[i] = false;
			}
		}
	}

}

