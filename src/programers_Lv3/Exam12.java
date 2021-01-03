package programers_Lv3;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Exam12 {
	//static String[] operations = {"I 16","D 1"};
	static String[] operations = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
	public static void main(String[] args) {
		PriorityQueue<Integer> maxQ = new PriorityQueue<Integer>(Comparator.reverseOrder());
		PriorityQueue<Integer> minQ = new PriorityQueue<Integer>();
		int[] answer = new int[2];
        for(int i = 0; i < operations.length; i++){
            String[] temp = operations[i].split(" ");
            if(temp[0].equals("I")){
            	int value = Integer.valueOf(temp[1]);
            	maxQ.add(value);
            	minQ.add(value);
            }else{
            	if(maxQ.isEmpty()) continue;
            	if(temp[1].equals("1")) {
            		int max = maxQ.peek();
            		maxQ.remove(max);
            		minQ.remove(max);
            	}else {
            		int min = minQ.peek();
            		maxQ.remove(min);
            		minQ.remove(min);
            	}
            }
        }
        
        if(!maxQ.isEmpty()) {
        	answer[0] = maxQ.peek();
        	answer[1] = minQ.peek();
        }
        for(int a : answer) {
        	System.out.print(a + " ");
        }

	}
	
}
