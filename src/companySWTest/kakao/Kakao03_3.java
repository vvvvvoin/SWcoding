package companySWTest.kakao;

import java.util.HashMap;
import java.util.HashSet;


public class Kakao03_3 {
	static String[] info = {"java backend junior pizza 150",
	                  "python frontend senior chicken 210",
	                  "python frontend senior chicken 150",
	                  "cpp backend senior pizza 260",
	                  "java backend junior chicken 80",
	                  "python backend senior chicken 50"};
	static String[] query = {"java and backend and junior and pizza 100",
					"python and frontend and senior and chicken 200",
					"cpp and - and senior and pizza 250",
					"- and backend and senior and - 150",
					"- and - and - and chicken 100",
					"- and - and - and - 150"};
	
	//static String[] query = {"python and frontend and senior and chicken 200"};
	
	public static void main(String[] args) {
		HashMap<Integer, String[]> map = new HashMap<Integer, String[]>();
		for(int i = 0; i < info.length; i++) {
			String[] temp = info[i].split(" ");
			map.put(i, temp);
		}
		int[] answer = new int[query.length];
		for(int i = 0; i < query.length; i++) {
			HashMap<Integer, String[]> clone = (HashMap<Integer, String[]>) map.clone();
			HashSet<Integer> delete = new HashSet<Integer>(); 
			String[] temp = new String[5];
			for(int t = 0; t < temp.length - 1; t++) {
				temp[t] = query[i].split(" and ")[t];
			}
			temp[4] = temp[3].split(" ")[1];
			temp[3] =  temp[3].split(" ")[0];
			//"java backend junior pizza 100" <- 함정?
			for(int j = 0; j < temp.length; j++) {
				if(temp[j].equals("-")) continue;
				if(j == 4) {
					for(int key : clone.keySet()) {
                        if(delete.contains(key)) continue;
						if(Integer.parseInt(map.get(key)[j]) < Integer.parseInt(temp[j])) {
							delete.add(key);
						}
					}
				}else {
					for(int key : clone.keySet()) {
                        if(delete.contains(key)) continue;
						if(!map.get(key)[j].equals(temp[j])) {
							delete.add(key);
						}
					}
				}
			}
            for(int d : delete) {
					clone.remove(d);
				}
				delete.clear();
			answer[i] = clone.size();
		}
		
		
	}

	
}
