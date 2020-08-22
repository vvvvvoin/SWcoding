package programers_Lv2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Exam05 {
	//정말 순차 계산으로 푼었는데
	//다른 풀이는 이보다 간결한 것들이 많았고 모르는 API를 썼다
	//코드는 짧지만 이것보다 성능이 낮은것도 있지만 월등히 좋은것들도 있었다.
	//다른 풀이보고 공부해야하겠다
	//{2,2,2,1,3,4};
	//3
	static int[] priorities = {2, 1, 3, 2};
	static int location = 2;

	public static void main(String[] args) {
		Queue<TwoValue> queue = new LinkedList<TwoValue>();
		Queue<TwoValue> TempQueue = new LinkedList<TwoValue>();
		
		for (int i = 0; i < priorities.length; i++) {
			queue.add(new TwoValue(priorities[i], i));
		}

		boolean flag = false;
		TwoValue compareValue;
		TwoValue twoValue;
		ArrayList<TwoValue> arrayList = new ArrayList<TwoValue>();
		while (!queue.isEmpty()) {
			twoValue = queue.poll();
			TempQueue.clear();
			TempQueue.addAll(queue);
			while (!TempQueue.isEmpty()) {
				compareValue = TempQueue.poll();
				//값을 비교하는데 하나라도 현재값이 비교값보다 작다면 바로 나간다
				if(compareValue.value > twoValue.value) {
					flag = true;
					break;
				}
			}
			//현재값이 비교값보다 작다
			if(flag) {
				queue.add(twoValue);
				flag = false;
			}else {
				//모든 값을 비교했지만 현재값이 가장 큰값이다
				arrayList.add(twoValue);
			}
		}
		for(int i = 0; i < arrayList.size(); i++) {
			if(arrayList.get(i).index == location) {
				System.out.println(i+1);
			}
		}
	}

	static class TwoValue {
		private int value;
		private int index;
		
		public TwoValue(int value, int index) {
			super();
			this.value = value;
			this.index = index;
		}
		
	}
}
