package programers_Lv2;

public class Exam35 {
	static int[] arr = {2,6,8,14, 4864};
	public static void main(String[] args) {
		// 다른사람 풀이를 보니가 공식화된 메소드가 있는듯 하다
		// 그리고 정말 다양하게 풀 수 있는듯 하다
		
		int[] tempArr = arr.clone();
		int min = Integer.MAX_VALUE;
		int minIndex = 0;
		boolean flag = false;
        while(true) {
        	for(int j = 0; j < tempArr.length; j++) {
        		flag = true;
        		if(tempArr[0] != tempArr[j]) {
        			flag = false;
        			break;
        		}
        	}
        	
        	if(flag == true) break;
        	
        	for(int i = 0; i < arr.length; i++) {
        		if(min > tempArr[i]) {
        			min = tempArr[i];
        			minIndex = i;
        		}
        	}
        	tempArr[minIndex] += arr[minIndex];
        	min = Integer.MAX_VALUE;
        }
        System.out.println(tempArr[0]);

	}
}
