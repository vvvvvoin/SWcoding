package baekJoonSW.koi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exam20_2002 {
	static BufferedReader br;
	static StringTokenizer st;
	
	static int person;
	static int pd;
	
	static ArrayList<Integer>[] list;
	static int[] targetNordCnt;
	static ArrayList<Integer> answer;
	static Queue<Integer> q;
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		answer = new ArrayList<Integer>();
		q = new LinkedList<Integer>();
		
		person = Integer.parseInt(st.nextToken());
		pd = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[person + 1];
		targetNordCnt = new int[person + 1];
		
		
		for(int i = 1; i <= person; i++) {
			list[i] = new ArrayList<Integer>(); 
		}
		
		for(int i = 0; i < pd; i++) {
			st = new StringTokenizer(br.readLine());
			int size = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			for(int j = 0; j < size - 1; j++) {
				int b = Integer.parseInt(st.nextToken());
				list[a].add(b);
				targetNordCnt[b]++;
				a = b;
			}			
		}
		
		for(int i = 1; i <= person; i++) {
			if(targetNordCnt[i] == 0) {
				q.add(i);
			}
		}
		
		while(!q.isEmpty()) {
			int currentNode = q.poll();
			answer.add(currentNode);
			
			for(int i = 0; i < list[currentNode].size(); i++) {
				int getNode = list[currentNode].get(i);

				targetNordCnt[getNode]--;
				if (targetNordCnt[getNode] == 0) {
					q.add(getNode);
				}
			}
		}
		
		for(int i = 1; i<=person; i++) {
			if(targetNordCnt[i] != 0) {
				System.out.println(0);
				return;
			}
		}
		
		for (int i = 0; i < answer.size(); i++) {
			System.out.println(answer.get(i));
		}

	}
}
