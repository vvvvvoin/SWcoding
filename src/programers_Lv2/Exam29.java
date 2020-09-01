package programers_Lv2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Exam29 {
	static String s = "-1 -2 -3 -4";
	public static void main(String[] args) {
		// 생각보다 스트림이랑 크게 속도차이는 크지 않았다
		// mapToInt같은 방법알면 쉽게 문제를 해결할 수 있을거 같다
		
		String[] array = s.split(" ");
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		
		for(int i = 0; i < array.length; i++) {
			if(max < Integer.parseInt(array[i])) max = Integer.parseInt(array[i]);
			if(min > Integer.parseInt(array[i])) min = Integer.parseInt(array[i]);
 		}
		
//      int max = Arrays.stream(array).mapToInt(Integer::parseInt).max().getAsInt();
//      int min = Arrays.stream(array).mapToInt(Integer::parseInt).min().getAsInt();
        
        System.out.println(max);
        System.out.println(min);
        
	}
}
