package programers_Lv3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Exam04 {
	static String sentence = "HzEzLzLzObWORLDb";
	//static String sentence = "SpIpGpOpNpGJqOqA";
	//static String sentence = "AxAxAxAoBoBoB";
	public static void main(String[] args) {
			// 순서에 맞게 광고문자를 넣으면 해결될듯
		
			String[] sentenceArray = sentence.split("");

			HashMap<String, Integer> map = new HashMap<String, Integer>();
			HashSet<Word> hashSet = new HashSet<Word>();
			for(int i = 0; i < sentenceArray.length; i++) {
				if(Character.isLowerCase(sentence.charAt(i))) {
					map.put(sentence.charAt(i) + "", map.getOrDefault(sentence.charAt(i) + "" , 0) + 1);
				}
			}
			for(String key : map.keySet()) {
				int start = sentence.indexOf(key);
				int end = sentence.lastIndexOf(key);
				
				//인덱스가 대문자 하나 이상 두고 있고 소문자는 2개인 경우
				if(end - start > 2 && map.get(key) == 2) {
					hashSet.add(new Word(key, start, end,  2));
					
					//인덱스가 대문자하나를 두고 있고 소문자는 2개인 경우
				}else if(end - start == 2 && map.get(key) == 2) {
					hashSet.add(new Word(key, start, end,  1));
					
					//규칙1
				}else if(map.get(key) > 2) {
					hashSet.add(new Word(key, start, end,  1));
				}
				
			}
				
			System.out.println(map);
			System.out.println(hashSet);
			//스타트 엔드에 값을 -2씩해서 해당 인덱스의 값이 서로 같다면(소문자로) 규칙2를 포함하는 것이기에
			//해당 규칙값을 0으로 변경
			//스타트 엔드에 값을 -2씩해서 해당 인덱스의 값들이 서로 다를 경우 규칙1, 2를 나누어
			//추후에 정답으로 start, end -1, +1 규칙에 맞게 분류 문자하나 생성
			HashMap<Integer, Integer> check = new HashMap<Integer, Integer>();
			for(Word word : hashSet) {
				check.put(word.start, check.getOrDefault(word.start, 0) + 1);
				check.put(word.end, check.getOrDefault(word.end, 0) + 1);
			}
			
			for(Word word : hashSet) {
				int start = word.start - 2;
				if(start < 0) start = 0;
				int end = word.end + 2;
				if(end >= sentence.length()) end = sentence.length() - 1;
				
				if(sentenceArray[start] == sentenceArray[end] && word.rule == 1) {
					word.rule = 0;
					continue;
				}else if(sentenceArray[start] != sentenceArray[end] && word.rule == 1) {
					word.start -= 1;
					if(word.start  < 0) word.start = 0;
					word.end += 1;
					if(word.end >= sentence.length()) word.end = sentence.length() - 1;
				}else if(sentenceArray[start] != sentenceArray[end] && word.rule == 2) {
					word.start += 1;
					word.end -= 1;
				}
			}
			for(Word word : hashSet) {
				check.put(word.start, check.getOrDefault(word.start, 0) + 1);
				check.put(word.end, check.getOrDefault(word.end, 0) + 1);
			}
			System.out.println(hashSet);
			
			for(int value : check.values()) {
				if(value >= 2) System.out.println("error");
			}
			
			ArrayList<String> temp = new ArrayList<String>();
			for(Word word : hashSet) {
				if(word.rule == 0) continue;
				String str = "";
				for(int i = word.start; i <= word.end; i++) {
					if(Character.isUpperCase(sentence.charAt(i))) {
						str += sentence.charAt(i);
					}
				}
				temp.add(str);
			}
			String answer = "";
			for(String str : temp) {
				answer += str + " ";
			}
			System.out.println(answer.trim());
			
	}

	
	static class Word{
		private String word;
		private int start;
		private int end;
		private int rule = 0;
		
		public Word(String word, int start, int end, int rule) {
			super();
			this.word = word;
			this.start = start;
			this.end = end;
			this.rule = rule;
		}


		@Override
		public String toString() {
			return "Word [word=" + word + ", start=" + start + ", end=" + end + ", rule=" + rule + "]";
		}
		
		
	}
}

