package baekJoonSW;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exam07_날짜계산 {
	static BufferedReader br;
	static StringTokenizer st;
	static int E, S, M, e, s, m;
	static boolean flag;
	static int ans;
	public static void main(String[] args) throws Exception{
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		
		flag = true;
		ans = 1;
		E = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		e = 1;
		s = 1;
		m = 1;
		while(flag) {
			if(e == E && s == S && m ==M) {
				break;
			}
			e++;
			s++;
			m++;
			if( e > 15) {
				e = 1;
			}
			if( s > 28) {
				s = 1;
			}
			if( m > 19) {
				m= 1;
			}
			ans++;
		}
		System.out.println(ans);
	}

}
