package programers_Lv3;

import java.util.ArrayList;

public class Exam01 {
	static int N = 1; 
	static int number = 111111111 ;
	public static void main(String[] args) {
		//숫자 2개를 사용했을때 표현가능한 숫자는
		//N을 이어붙인수와 사친연산의 결과이다
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		arrayList.add(N);
		int cnt = 0;	
		while(true) {
			
			cnt++;
			if(cnt > 8) {
				cnt = -1;
				break;
			}

			if(arrayList.contains(number)) break;

			int size = arrayList.size();
			for(int i = 0; i < size; i++) {
				arrayList.add(Integer.parseInt(String.valueOf(arrayList.get(i)) + N + ""));
				arrayList.add(arrayList.get(i) + N);
				arrayList.add(arrayList.get(i) - N);
				arrayList.add(arrayList.get(i) * N);
				arrayList.add(arrayList.get(i) / N);
			}
			
		}
		
		System.out.println(cnt);
	}
}

