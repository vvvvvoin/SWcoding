package programers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exam14 {
	static String[] seoul = {"jane", "Kim"};
	public static void main(String[] args) {
		List<String> index =new ArrayList<String>(Arrays.asList(seoul));
		index.remove(1);
		Object[] answer = index.toArray();
		for(Object str : answer) {
			System.out.print(str);
		}
	}
}
