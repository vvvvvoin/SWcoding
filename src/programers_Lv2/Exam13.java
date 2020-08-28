package programers_Lv2;

import java.util.ArrayList;

public class Exam13 {
	static String numbers = "0000007";
	static String[] array;
	static boolean[] visited;
	static ArrayList<Integer> arrayList;
	public static void main(String[] args) {
		array = numbers.split("");
		visited = new boolean[numbers.length()];		
		arrayList = new ArrayList<Integer>();

		for(int i = 0; i < array.length; i++) {
			visited[i] = true;
			dfs(array[i]);
			visited[i] = false;
		}
		System.out.println(arrayList);
		System.out.println(arrayList.size());
		
	}
	
	static boolean check(int value) {
		if(value <= 1) return false;
		
		for(int i = 2; i < value; i++) {
			if(value % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	
	static void dfs(String string) {
		//hashSet으로도 가능할듯
		if(!arrayList.contains(Integer.parseInt(string)) && check(Integer.parseInt(string))) {
			arrayList.add(Integer.parseInt(string));
		}
		
		for(int i=0; i<array.length; i++){
            if(visited[i] == false){
                visited[i] = true;
                dfs(string + array[i]);
                visited[i] = false;
            }
        }
	}

		
}
