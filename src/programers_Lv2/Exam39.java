package programers_Lv2;

import java.util.ArrayList;

public class Exam39 {
	static int n = 2;
	//static String[] words = { "tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank" };
	//static String[] words = {"hello", "observe", "effect", "take", "either", "recognize", "encourage",
			//"ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"};	
	static String[] words = {"hello", "one", "even", "never", "now", "world", "draw"};
	

	public static void main(String[] args) {
		ArrayList<String> wordsList = new ArrayList<String>();
		ArrayList<Person> personList = new ArrayList<Person>();
		int[] answer = new int[n]; 
		// 사람들 초기화
		for(int i = 1; i <= n; i++) {
			personList.add(new Person(i, 0));
		}
		String lastWord = words[0].substring(words[0].length() - 1 , words[0].length());
		wordsList.add(words[0]);
		for(int i = 0; i < words.length ; i++) {
			personList.get(i % n).order++; 
			if(i != 0) {
				// 처음이 아닌 최근단어와 현재단어를 비교
				// 최근단어와 다음단어가 일치하면
				if(lastWord.equals(String.valueOf(words[i].charAt(0))) && !wordsList.contains(words[i])) {
					lastWord = words[i].substring(words[i].length() - 1 , words[i].length());
					wordsList.add(words[i]);
				}else {
					answer[0] = personList.get(i % n).number;
					answer[1] = personList.get(i % n).order;
					break;
				}
			}
		}
		System.out.println(lastWord);
		System.out.println(personList);
		System.out.println(wordsList);
		System.out.println(answer[0] + " " + answer[1]);
		
	}
	
	static class Person{
		private int number;
		private int order;
		
		public Person(int number, int order) {
			super();
			this.number = number;
			this.order = order;
		}

		@Override
		public String toString() {
			return "Person [number=" + number + ", order=" + order + "]";
		}
		
		
	}
}
