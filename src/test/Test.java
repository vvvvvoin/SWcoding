package test;

import java.util.ArrayList;

public class Test {
	//static String[] members = {"A", "C", "R", "J", "X", "X", "X", "T"};
	static String[] members = {"J", "A", "M", "T", "F", "N", "C", "R"};
	static String[] data = {"N~F=0", "R~T>2"};
	static boolean[] visited;
	static ArrayList<How> howList;
	public static void main(String[] args) {
		visited = new boolean[members.length];
		String[] output = new String[members.length];
		howList = new ArrayList<How>();
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
		System.out.println(howList);
		for(How how : howList) {
			System.out.println(how.check(members));
		}
		//dfs(members, output, visited, members.length, 0);
	}
	
	private static void dfs(String[] members, String[] output, boolean[] visited, int length, int depth) {
		if(depth == length) {
			for(String str : output) {
				System.out.print(str);
			}
			System.out.println();
			return;
		}
		
		for(int i = 0; i < members.length; i++) {
			if(visited[i] == false) {
				visited[i] = true;
				output[depth] = members[i];
				dfs(members, output, visited, members.length, depth + 1);
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
				if(characterArray[i].equals(a)) {
					presentA = i;
				}
				if(characterArray[i].equals(b)) {
					presentB = i;
				}
			}
			System.out.println(a);
			System.out.println(b);
			System.out.println(presentA);
			System.out.println(presentB);
			if(this.operator.equals("<")) {
				if(Math.abs(presentA - presentB) - 1 < this.value)
				return true;
			}else if(this.operator.equals(">")){
				if(Math.abs(presentA - presentB) - 1 > this.value)
				return true;
			}else if(operator.equals("=")){ 
				if(Math.abs(presentA - presentB) - 1 == this.value)
				return true;
			}

			return false;
					
		}

		@Override
		public String toString() {
			return "How [a=" + a + ", b=" + b + ", operator=" + operator + ", value=" + value + "]";
		}
		
		
	}
}

