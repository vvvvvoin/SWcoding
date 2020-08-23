package programers_Lv2;

import java.util.ArrayList;

public class Exam06 {
	static int bridge_length = 100;
	static int weight = 100;
	static int[] truck_weights = {10,10,10,10,10,10,10,10,10,10};
	//
	//카운터를 살펴 지난 트럭 빼주기
	//무게를 먼저 판별해 건널지 말지를 선택
	//다리에 존재하는 트럭의 다리길이 카운트
	public static void main(String[] args) {
		ArrayList<Truck> arrayList = new ArrayList<Truck>();
        //초기화
		for(int i = 0; i < truck_weights.length;i++) {
			arrayList.add(new Truck(truck_weights[i], 0));
		}
		
		int weightCnt = 0;
		int index = 0;
		int time = 0;
		while(true) {
			time++;
            //누적된 트럭의 무게에서 다리를 지난간(bridge_length) 트럭이 있다면 누적무게에서 빼준다
			for(int i = 0; i<arrayList.size(); i++) {
				if(arrayList.get(i).cnt == bridge_length) {
					weightCnt -= arrayList.get(i).weight; 
				}
			}
            
            //다음 트럭이 무게가 견딜수 있는지 보고 누적 후 다음 트럭을 확인하기 위해 인덱스++
            //인덱스가 어레이리스트 크기보다 작을때만 수행되어야 한다
			if (index < arrayList.size()) {
				if (weightCnt + arrayList.get(index).weight <= weight) {
					weightCnt += arrayList.get(index).weight;
					index++;
				}
			}	
			
            //인덱스 내에 모든 트럭을 이동시킨다(cnt++)
			for(int i = 0; i<index; i++) {
				arrayList.get(i).cnt++;
			}
			//처음무터 못 올라갈리는 없으니 마지막 트럭이 빠지는 무게0일때 끝낸다
			if(weightCnt == 0) break;
		}
		System.out.println(time);
	}
	
	static class Truck{
		int weight;
		int cnt;
		public Truck(int weight, int cnt) {
			super();
			this.weight = weight;
			this.cnt = cnt;
		}
		
	}
}
