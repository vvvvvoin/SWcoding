package programers;

import java.util.HashMap;

public class Exam25 {
	static class Map{
		private int x = 0;
		private int y = 0;
		public Map(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	static int[] num = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
	static String hand = "right";
	public static void main(String[] args) {
		String answer = "";
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		HashMap<Integer, Map> deep = new HashMap<Integer, Map>();
        deep.put(1, new Map(1, 1));
		deep.put(2, new Map(2, 1));
		deep.put(3, new Map(3, 1));
		deep.put(4, new Map(1, 2));
		deep.put(5, new Map(2, 2));
		deep.put(6, new Map(3, 2));
		deep.put(7, new Map(1, 3));
		deep.put(8, new Map(2, 3));
		deep.put(9, new Map(3, 3));
		deep.put(0, new Map(2, 4));
		
		//100은 왼손
		//300은 오른손
		deep.put(100, new Map(1, 4));
		deep.put(300, new Map(3, 4));
		for(int now : num) {
			if(now == 2 ||now == 5 ||now == 8 ||now == 0 ) {
                //x,y 좌표를 비교하여 절대값이 작은 것이 가까운 위치이므로 작은쪽일때 그 값을 대입
                //300, 오른손이 작음
				if(Math.abs(deep.get(100).y- deep.get(now).y) + Math.abs(deep.get(100).x- deep.get(now).x)
						>  Math.abs(deep.get(300).y- deep.get(now).y)+ Math.abs(deep.get(300).x- deep.get(now).x)) {
					deep.put(300, new Map(deep.get(now).x, deep.get(now).y));
					answer += "R";
                //100, 손이 작음
				}else if(Math.abs(deep.get(100).y- deep.get(now).y) + Math.abs(deep.get(100).x- deep.get(now).x)
						<  Math.abs(deep.get(300).y- deep.get(now).y)+ Math.abs(deep.get(300).x- deep.get(now).x)){
					deep.put(100, new Map(deep.get(now).x, deep.get(now).y));
					answer += "L";
				}else{
                    //x,y 좌표의 차이 값이 같다면 자주 사용하는 손을 사용
					if(hand.equals("left")){
						deep.put(100, new Map(deep.get(now).x, deep.get(now).y));
						answer += "L";
					}else {
						deep.put(300, new Map(deep.get(now).x, deep.get(now).y));
						answer += "R";
					}
					
				}
			}else {
				//왼손
				if(now == 1 ||now == 4 ||now == 7 ) {
					deep.put(100, new Map(deep.get(now).x, deep.get(now).y));
					answer += "L";
				//오른손
				}else if(now == 3 ||now == 6 ||now == 9 ){
					deep.put(300, new Map(deep.get(now).x, deep.get(now).y));
					answer += "R";
				}
			}
			
		}
		System.out.println(answer);
	}
}

//if(Math.abs(deep.get(100).y- deep.get(now).y) + Math.abs(deep.get(100).x- deep.get(now).x)
//==  Math.abs(deep.get(300).y- deep.get(now).y)+ Math.abs(deep.get(300).x- deep.get(now).x)){
//answer += realHand;
