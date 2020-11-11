package baekJoonSW.koi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//점수가 80이다
//거의 다 했느데 다음 테스트 케이스에 걸린다
/*18 7 3341
918 242
3608 845
1802 446
3544 365
1390 1530
440 1683
2907 360
460 1709
3251 656
1684 1403
0 12
1809 196
3738 477
2433 1264
983 1941
524 1595
921 1595
2180 585
*/
public class Exam44_2012 {
	static BufferedReader br;
	static StringTokenizer st;
	static int[] arr;
	static int k;
	static int s;
	static int distance;
	
	static Reference r;
	static int minIndex = Integer.MAX_VALUE;
	static int maxIndex = Integer.MIN_VALUE;
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		distance = 0;
		
		int n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());	//정원
		s = Integer.parseInt(st.nextToken());//학교위치
		
		arr = new int[100000];
		
		int pos = 0;
		int num = 0;
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			pos = Integer.parseInt(st.nextToken());
			num = Integer.parseInt(st.nextToken());
			arr[pos] = num;
			minIndex = Math.min(minIndex, pos);
			maxIndex = Math.max(maxIndex, pos);
		}
		
		if(minIndex > s) {
			minIndex = s;
		}
		if(maxIndex < s) {
			maxIndex = s;
		}
		System.out.println(minIndex);
		System.out.println(maxIndex);
		r = new Reference(-1, -1);
		while(true) {
			leftMove(k, minIndex);
			if(r.cnt == -1 && r.index == -1) {
				break;
			}else {
				minIndex = r.index;
			}
		}
		while(true) {
			rightMove(k, maxIndex);
			if(r.cnt == -1 && r.index == -1) {
				break;
			}else {
				maxIndex = r.index;
			}
		}

		System.out.println(distance);
	}
	static class Reference{
		int cnt;
		int index;
		public Reference(int cnt, int index) {
			super();
			this.cnt = cnt;
			this.index = index;
		}
	}
	private static void rightMove(int cnt, int index) {
		int lastIndex = -1;
		boolean flag = false;
		for(int i = index; i > s; i--) {
			if(arr[i] > 0 && flag == false) {
				index = i;
				flag = true;
			}
			if(arr[i] > 0 && arr[i] >= cnt)  {
				arr[i] -= cnt;
				cnt = 0;
				distance += Math.abs(index - s) * 2 ;
			}else if(arr[i] > 0 && arr[i] < cnt) {
				cnt -= arr[i];
				arr[i] = 0;
			}
			lastIndex = i;
			if(cnt == 0) {
				break;
			}
		}
		
		if( cnt == 0) {
			r.cnt = 0;
			r.index = lastIndex;	
		}else if(lastIndex == s + 1){
			if(cnt > 0) {
				distance += Math.abs(s - index) * 2;
				r.cnt = -1;
				r.index = -1;
			}
		}
	}
	
	private static void leftMove( int cnt, int index) {
		int lastIndex = -1;
		boolean flag = false;
		for(int i = index; i < s; i++) {
			if(arr[i] > 0 && flag == false) {
				index = i;
				flag = true;
			}
			if(arr[i] > 0 && arr[i] >= cnt)  {
				arr[i] -= cnt;
				cnt = 0;
				distance += Math.abs(index - s) * 2 ;
			}else if(arr[i] > 0 && arr[i] < cnt) {
				cnt -= arr[i];
				arr[i] = 0;
			}
			lastIndex = i;
			if(cnt == 0) {
				break;
			}
		}
		if( cnt == 0) {
			r.cnt = 0;
			r.index = lastIndex;	
		}else if(lastIndex == s - 1){
			if(cnt > 0) {
				distance += Math.abs(s - index) * 2;
				r.cnt = -1;
				r.index = -1;
			}
		}
	}

}
