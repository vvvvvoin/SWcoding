package programers_Lv2;


import java.util.ArrayList;
import java.util.HashSet;

public class Exam45 {
	static String[][] relation = {{"100","ryan","music","2" ,"A", "1"},
										{"200","apeach","math","2", "B", "2"},
										{"300","tube","computer","3", "C", "3"},
										{"400","con","computer","4", "D", "4"},
										{"500","muzi","music","3", "E", "5"},
										{"600","apeach","music","2", "F", "6"}};
	static ArrayList<String> array;

	public static void main(String[] args) {
		int answer = 0;
		array = new ArrayList<String>();
		HashSet<String> hashSet = new HashSet<String>();
		String str = "";
		boolean[] check = new boolean[relation[0].length];
		String temp = "";
		for(int i = 1; i <= relation.length; i++) {
			combination(relation, check, temp, -1, 0, i);
		}
		System.out.println(array);
		
	}

	private static void combination(String[][] relation, boolean[] check, String temp, int index, int depth, int end) {
		
		if(depth == end) {
			String[] tuple = new String[relation.length];
			for(int i = 0; i < tuple.length; i++) {
				String str = "";
				for(int j = 0; j < temp.length(); j++) {
					str += relation[i][temp.charAt(j) - '0'];
				}
				tuple[i] = str;
			}
			
			if(!is_duplication(tuple)) {
				array.add(temp);
			}
			return;
			
		}
		
		for(int i = index + 1; i < relation.length; i++) {
			if(check[i] == false) {
				check[i] = true;
				temp += i;
				combination(relation, check, temp, i, depth + 1, end);
			}
			check[i] = false;
		}
		
	}
	
	public static boolean is_duplication(String[] list){ //중복검사
        boolean result = false;
        for (int i = 0; i < list.length; i++) {
            String str1 = list[i];
            for (int j = 0; j < list.length; j++) {
                if (i == j) continue;
                String str2 = list[j];
                if (str1.equals(str2)) {
                    result = true;
                    //System.out.println("중복 => " + i + ". " + str1);
                    break;
                }
            }
        }
        return result;
    }
}

