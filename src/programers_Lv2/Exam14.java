package programers_Lv2;

import java.util.Arrays;
import java.util.Comparator;

public class Exam14 {
	static int[] numbers = { 9, 30, 34, 5, 3 };

	public static void main(String[] args) {
		String[] array = new String[numbers.length];
		
		for(int i = 0; i < numbers.length; i++) {
			array[i] = String.valueOf(numbers[i]);
		}
		Arrays.sort(array);
		for(String str : array) {
			System.out.println(str);
		}
		Arrays.sort(array, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				// o1, o2, o2, o1 순으로 시작하여 compareTo하면 오름차순으로 설정된다
				// 그렇기에 반환할대는 음수를 곱하여 내림차순으로 하게한다
				// 혹은 초기에 o2, o1, o1, o2 순으로 시작하여 compareTO하면 내림차순으로 정렬이된다
				int result = (o1 + o2).compareTo(o2 + o1);
				//int result = (o2 + o1).compareTo(o1 + o2);
				return -result;
				
				//return -(o1 + o2).compareTo(o2 + o1);
			}
		});
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < array.length; i++) {
			if(array[0].equals("0")) {
				System.out.println("정답은 0");
			}else {
				sb.append(array[i]);
			}
			
		}
		
		System.out.println(sb.toString());
	}

}
