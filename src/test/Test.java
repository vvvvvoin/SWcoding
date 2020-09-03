package test;

import java.util.ArrayList;

public class Test {
	static int[] arr = {50, 54, 56, 56 };
	public static void main(String[] args) {
		boolean flag = false;
		for(int j = 0; j < arr.length -1; j++) {
    		if(arr[j] == arr[j + 1]) {
    			flag = true;
    		}else {
    			flag = false;
    		}
    	}
		
		System.out.println(flag);
	}

}

