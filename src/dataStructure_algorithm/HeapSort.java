package dataStructure_algorithm;

public class HeapSort {
	public static void main(String[] args) {
		int[] arr = {40, 20, 50, 10, 30, 70, 80, 88, 44, 64, 3, 47, 1, 5};
		System.out.println("정렬전");
		for(int value : arr) {
			System.out.print(value + " ");
		}
		System.out.println();
		heapSort(arr);
		System.out.println("정렬후");
		for(int value : arr) {
			System.out.print(value + " ");
		}
	}
	
	static public void heapSort(int[] arr) {
		heapify(arr, arr.length);
		System.out.println("트리 구조");
		for(int value : arr) {
			System.out.print(value + " ");
		}
		System.out.println();
		for(int i = arr.length-1; i > 0; i--){
			swap(arr, 0, i);
			heapify(arr, i);
		}
	}
	 
	static public void heapify(int[] arr, int index) {
		for(int i = 1; i < index; i++) {
			int child = i;
			while(child > 0) {
				int parent = (child - 1) / 2;
				if(arr[child] > arr[parent]) {
					swap(arr, child, parent);
				}
				child = parent;
			}
		}
	}

	static public void swap(int[] arr, int parent, int child) {
		int temp = arr[parent];
		arr[parent] = arr[child];
		arr[child] = temp;
	}
}
