package programers_Lv2;

import java.util.ArrayList;

public class Exam22 {
	// 조건을 담을 클래스를 만들고 글래스마다 적절한 연산방식 함수를 만든다
	// 클래스를 객체를 리스트에 담는다
	// 모든 경우의 수를 찾아 리스트의 함수와 비교해서 boolean 값에 따라 카운트한다
	
	// 또 전역변수 문제로 프래그래머스에서 오류먹어서 삽질 20분 한거 같다
	// 처음 생각한것처럼 푸니까 풀렸고 다른사람들과 풀이는 유사했다
	// 모든 경우의 수를 찾는 방법외에는 없겠지?
	
	static int n = 2;
	static String[] data = {"N~F=0", "R~T>2"};
	//static String[] data = {"M~C<2", "C~M>1"};
	static String[] members = {"A", "C", "F", "J", "M", "N", "R", "T"};
	static int answer = 0;
	public static void main(String[] args) {
		ArrayList<How> howList = new ArrayList<How>();
		
		String a = "";
		String b = "";
		String operator = "";
		int value = 0;
		
		for(String str : data) {
			a = String.valueOf(str.charAt(0));
			b = String.valueOf(str.charAt(2));
			operator = String.valueOf(str.charAt(3));
			value = Character.getNumericValue(str.charAt(4));
			howList.add(new How(a, b, operator, value));
		}
		
		boolean[] visited = new boolean[members.length];
		String[] output = new String[members.length];
		
		dfs(members, output, visited, members.length, 0, howList);
		System.out.println(answer);
		
	}
	
	static void dfs(String[] members, String[] output, boolean[] visited, int length, int depth, ArrayList<How> howList) {
		if(depth == length) {
			boolean flag = false;
			for(How how : howList) {
				flag = how.check(output);
				if(flag == false) break;
			}
			if(flag)  answer++;
			return;
		}
		for(int i = 0; i < members.length; i++) {
			if(visited[i] == false) {
				visited[i] = true;
				output[depth] = members[i];
				dfs(members, output, visited, members.length, depth + 1, howList);
				visited[i] = false;
			}
		}
	}
	
	static class How {
		String a;
		String b;
		String operator;
		int value;
		
		public How(String a, String b, String operator, int value) {
			super();
			this.a = a;
			this.b = b;
			this.operator = operator;
			this.value = value;
		}
		
		boolean check(String[] characterArray){
			int presentA = 0;
			int presentB = 0;
			for(int i = 0; i < characterArray.length; i++) {
				if(characterArray[i].equals(this.a)) {
					presentA = i;
				}
				if(characterArray[i].equals(this.b)) {
					presentB = i;
				}
			}
			
			if(this.operator.equals("<")) {
				if(Math.abs(presentA - presentB) - 1 < this.value)
				return true;
			}else if(this.operator.equals(">")){
				if(Math.abs(presentA - presentB) - 1 > this.value)
				return true;
			}else if(operator.equals("=")) { 
				if(Math.abs(presentA - presentB) - 1 == this.value)
				return true;
			}
			
			return false;
					
		}
		
	}
}
