package line;

import java.util.HashMap;

public class Line01 {
	static int[][] boxes = { { 1, 2 }, { 2, 1 }, { 3, 3 }, { 4, 5 }, { 5, 6 }, { 7, 8 } };
	//static int[][] boxes = { { 1, 2 }, { 3, 4 }, { 5, 6 } };
	//static int[][] boxes = { { 1, 2 }, { 2, 3 }, { 3, 1 } };
	//static int[][] boxes = { { 1, 1 }, { 1, 1 }, { 3, 1 }, { 1, 1 }  };

	public static void main(String[] args) {
		int box = boxes.length;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i < boxes.length; i++) {
			for(int j = 0; j < boxes[0].length; j++) {
				map.put(boxes[i][j], map.getOrDefault(boxes[i][j], 0) + 1);
			}
		}
		for(int key : map.keySet()) {
			// 2보다 클 경우 그 박스에 대해서 계속 빼준다
			if(box == 0) break;
			if(map.get(key) >= 2) {
				while(true) {
					if(box == 0) break;
					if(map.get(key) >= 2) {
						map.put(key, map.get(key) - 2);
						box -= 1;
					}else {
						break;
					}
				}
				
			}
		}
		int answer = 0;
		for(int key : map.keySet()) {
			if(box == 0) break;
			if(map.get(key) == 1) {
				box -= 1;
				answer++;
			}
		}
		System.out.println(answer);
	}
}
