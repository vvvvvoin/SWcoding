package companySWTest.shinhan;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Shin05 {
	static int min = Integer.MAX_VALUE;
	static int campany = 0;
	static int line = 0;
	static int gas = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		campany = Integer.parseInt(input.split(" ")[0]);
		line = Integer.parseInt(input.split(" ")[1]);
		gas = Integer.parseInt(input.split(" ")[2]);
		Pos[] map = new Pos[line];
		for(int i = 0; i < line; i++) {
			String str = br.readLine();
			String[] temp = str.split(" "); 
			map[i] = new Pos(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]), Integer.parseInt(temp[2]));
		}
		
		for(int i = 0; i < map.length; i++) {
			if(map[i].j == gas) {
				solution(i, map, campany, gas);
			}
		}

	}
	
	private static void solution(int i, Pos[] map, int campany, int gas) {
		Stack<Pos> stack = new Stack<Pos>();
		stack.add(map[i]);
		while(!stack.isEmpty()) {
			Pos temp = stack.pop();
			for(int k = 0; k < map.length; k++) {
				if(temp.i == map[k].j) {
					stack.add(map[k]);
				}
			}
		}
	}

	static class Pos{
		private int i;
		private int j;
		private int dis;
		public Pos(int i, int j, int dis) {
			super();
			this.i = i;
			this.j = j;
			this.dis = dis;
		}
		
		
	}
}
