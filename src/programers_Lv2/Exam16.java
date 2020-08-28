package programers_Lv2;

import java.util.Arrays;
import java.util.Stack;

public class Exam16 {
	static int[] citations = { 3, 0, 6, 4, 5 };

	public static void main(String[] args) {
		int h1 = 0;
        int h2 = 0;
        int max = Arrays.stream(citations).max().getAsInt();
        int answer = 0;

        for(int i = 1; i <= max; i++){
            for(int j = 0; j < citations.length; j++){
                if(i <= citations[j]){
                    h1++;
                }
            }
            h2 = citations.length - h1;
            if(i <= h1 && i >= h2) {
            	answer = Math.max(answer, i);
            }
            h1 = 0;
            h2 = 0;
        }
        System.out.println(answer);
	}
}
