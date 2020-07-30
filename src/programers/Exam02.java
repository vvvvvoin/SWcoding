package programers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

public class Exam02 {
//	static int[] answers = {1, 3, 2, 4, 2};
//	
//	static int aAnswer = 0;
//	static int[] aPat = {1, 2, 3, 4, 5};
//	static int bAnswer = 0;
//	static int[] bPat = {2,1,2,3,2,4,2,5};
//	static int cAnswer = 0;
//	static int[] cPat = {3,3,1,1,2,2,4,4,5,5};
//	public static void main(String[] args) {
//		aAnswer = aMethod(answers);
//		bAnswer = bMethod(answers);
//		cAnswer = cMethod(answers);
//		int[] answer = {};
//		ArrayList<Integer> array = new ArrayList<>();
//		int max = 0;
//		max = Math.max(aAnswer, Math.max(bAnswer, cAnswer));
//		if(max == aAnswer) {
//			array.add(1);
//		}
//		if(max == bAnswer) {
//			array.add(2);
//		}
//		if(max == cAnswer) {
//			array.add(3);
//		}
//		int[] aa = new int[array.size()];
//
//		int size=0;
//		for(Integer temp : array){
//			aa[size++] = temp;
//
//		}
//
//		System.out.println();
//		
//	}
//	
//	public static int aMethod(int[] answers) {
//		int i = 0;
//		for(int a : answers) {
//			if(i == aPat.length) i = 0;
//			if(a == aPat[i]) {
//				aAnswer++;
//				i++;
//			}else {
//				i++;
//			}
//		}
//		return aAnswer;
//	}
//	
//	public static int bMethod(int[] answers) {
//		int i = 0;
//		for(int a : answers) {
//			if(i == bPat.length) i = 0;
//			if(a == bPat[i]) {
//				bAnswer++;
//				i++;
//			}else {
//				i++;
//			}
//		}
//		return bAnswer;
//	}
//	
//	public static int cMethod(int[] answers) {
//		int i = 0;
//		for(int a : answers) {
//			if(i == cPat.length) i = 0;
//			if(a == cPat[i]) {
//				cAnswer++;
//				i++;
//			}else {
//				i++;
//			}
//		}
//		return cAnswer;
//	}
	static int[] answers = {5,1,5,4,1,2,1,4,3,2,1,5,1,4,2,3,1,4,2,1,3,5,1,2,4,5};
	public static void main(String[] args) {
		int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] arr3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(1, 0);
        map.put(2, 0);
        map.put(3, 0);
        
        for(int i = 0; i<answers.length; i++) {
        	if(answers[i] == arr1[i%5]) map.replace(1, map.get(1) +1);
        	if(answers[i] == arr2[i%8]) map.replace(2, map.get(2) +1);
        	if(answers[i] == arr3[i%10]) map.replace(3, map.get(3) +1);
        }
        int max = 0;
        for(int value : map.values()) {
        	if(max < value){
        		max = value;
        	}
        }
        
        ArrayList<Integer> array = new ArrayList<Integer>();
        for(Integer key : map.keySet()) {
        	if(map.get(key) == max) {
        		array.add(key);
        	}
        }
        
        Collections.sort(array);
        int[] answer = new int[array.size()];
        for(int i = 0; i< answer.length; i++) {
        	answer[i] = array.get(i);
        }
        
        for(int a : answer) {
        	System.out.println(a);
        }
	}
}


