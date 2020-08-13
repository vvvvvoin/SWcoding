package programers;

import java.util.ArrayList;
import java.util.Collections;

public class Exam08 {
	static int[] arr = { 5, 9, 7, 10 };
	static int divisor = 5;

	public static void main(String[] args) {
		ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i : arr){
            if((i % divisor) == 0){
                arrayList.add(i);
            }
        }
        Collections.sort(arrayList);
        int[] answer = new int[arrayList.size()];
        if(answer.length == 0){
            answer = new int[1];
            answer[0] = -1;
        }else{
            for(int i = 0; i < arrayList.size(); i++){
                answer[i] = arrayList.get(i);
            }
        }
        System.out.println(answer);
	}
}
