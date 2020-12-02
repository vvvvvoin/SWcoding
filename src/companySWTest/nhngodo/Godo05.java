package companySWTest.nhngodo;

import java.util.Arrays;

public class Godo05 {
	static int[] votes = {5,7,7};
	//static int[] votes = {10, 10, 10, 10};
	//static int[] votes = {5, 10, 7, 3, 8};
	//static int[] votes = {100};
	public static void main(String[] args) {
		Who[] arr = new Who[votes.length];
		for(int i = 0; i < votes.length; i++) {
			arr[i] = new Who(false ,votes[i]);
		}
		arr[0].me = true;
		int myIndex = 0;
		int answer = 0;
		if(arr.length == 1) System.out.println("0");
		else {
			while(true) {
				Arrays.sort(arr);
				for(int i = 0; i < arr.length; i++) {
					if(arr[i].me == true) {
						myIndex = i;
						break;
					}
				}
				if(myIndex == 0 && arr[myIndex].cnt > arr[1].cnt ) break;
				answer++;
				arr[0].cnt--;
				arr[myIndex].cnt++;
			}
			System.out.println(answer);
			
		}
		
	}
	static class Who implements Comparable<Who>{
		boolean me;
		int cnt;
		public Who(boolean me, int cnt) {
			super();
			this.me = me;
			this.cnt = cnt;
		}
		@Override
		public int compareTo(Who o) {
			if(this.cnt < o.cnt) return 1;
			else if(this.cnt > o.cnt) return -1;
			else{
				if(this.me == false) return -1 ;
				else return 1;
			}
		}
		@Override
		public String toString() {
			return "Who [me=" + me + ", cnt=" + cnt + "]";
		}		
	}
}
