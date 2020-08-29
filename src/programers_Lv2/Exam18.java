package programers_Lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class Exam18 {
	static int[] people = {10,20,30,40,50,60,70,80,99};
	static int limit = 100;
	public static void main(String[] args) {
		
		int answer = 0;
		int index = 0;
        Arrays.sort(people);
        for(int i = people.length - 1; i  > index; i --) {
        	if(people[i] + people[index] <= limit) {
        		index++;
        		answer++;
        	}else {
        		answer++;
        	}
        }
        System.out.println(answer);
	}
}
