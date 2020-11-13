package programers_Lv3;

import java.util.ArrayList;

public class Exam03 {
	static int n = 6;
	static int answer = 0;
	static double cnt = 0;
	public static void main(String[] args) {
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		arrayList.add(n -2);
		arrayList.add(n - 1);
		
		int index = 0;

		while(true) {
			int size = arrayList.size();
			if(size == index) {
				break;
			}
			
			int cnt = 0;
			for(int i = index; i < size; i++) {
				cnt++;
				if(arrayList.get(i) == 0) {
					answer++;
					continue;
				}
				
				if(arrayList.get(i) - 2 >= 0) {
					arrayList.add(arrayList.get(i) - 2);

				}
				if(arrayList.get(i) - 1 >= 0) {
					arrayList.add(arrayList.get(i) - 1);
				}
			}
			
			index += cnt ;
		}
		System.out.println(answer);
	}


}
