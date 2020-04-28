package baekJoonSW;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exam05_경비원 {
	static BufferedReader br;
	static StringTokenizer st;
	static int initX, initY, X, Y;
	static int initWaterR, initWaterC;
	static int N, ans;
	static int[] dirR = { };
	static int[] dirC = { };


	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(br.readLine());
		ArrayList<Point> arrayList = new ArrayList<>();
		for(int i =1; i<=N;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int d = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			Point p = new Point(d, n, X, Y);
			arrayList.add(p);
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		int d = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		Point init = new Point(d, n, X, Y);
		
		ans = 0;
		int temp = 0;
		if (d == 1) {
	        temp = 2;
	    } else if (d == 2) {
	        temp = 1;
	    } else if (d == 3) {
	        temp = 4;
	    } else {
	        temp = 3;
	    }

		for(int i = 0; i <arrayList.size();i++) {
			Point tempPoint = arrayList.get(i);
			int direction = tempPoint.direction;
			int distance = tempPoint.distance;
			if(temp == direction) {
				if(direction == 1 || direction == 2) {
					ans += Math.min(init.x + init.y + tempPoint.y + tempPoint.x, (X - init.x) + init.y + tempPoint.y + (X-tempPoint.x));
				}else {
					ans += Math.min(init.y + init.x + tempPoint.x + tempPoint.y, (Y - init.y) + init.x + tempPoint.x + (Y-tempPoint.y));
				}
			}else {
				ans += Math.abs(init.x - tempPoint.x) + Math.abs(init.y - tempPoint.y); 
			}
			
		}
		
		System.out.println(ans);
		
		
		
		
		
	}//end of main
	
	static class Point {
		private int direction, distance;
		private int x, y;

		public Point(int direction, int distance, int row, int col) {
			super();
			this.direction = direction;
			if(direction == 1) {
				this.x = 0;
				this.y = distance;
			}else if(direction == 2) {
				this.x= col;
				this.y = distance;
			}else if(direction == 3) {
				this.x = distance;
				this.y = 0;
			}else  {
				this.x = distance;
				this.y = col;
			}
		}
	}
} // end of class
