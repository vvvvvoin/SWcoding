package programers;

import java.util.Arrays;
import java.util.Collections;

public class Exam21 {
	static long n = 56721881;
	public static void main(String[] args) {
		String str = "" + n;
        String[] array = str.split("");
        Arrays.sort(array, Collections.reverseOrder());
        String str2 = "";
        for(String temp : array){
            str2 += temp;
        }
        
        long answer = Long.parseLong(str2);
        //n의 값에 따라서 Integer.parseInt하면 정답과 틀릴 경우도 있어
        //long으로 변환시킴
        
	}
}
