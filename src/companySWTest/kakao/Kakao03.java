package kakao;

import java.util.HashMap;
import java.util.HashSet;

public class Kakao03 {
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
	
	//static String[] query = {"java and backend and junior and pizza 100"};
	
	public static void main(String[] args) {
		HashMap<Integer, Person> map = new HashMap<Integer, Person>();
		for(int i = 0; i < info.length; i++) {
			String[] temp = info[i].split(" ");
			map.put(i, new Person(temp[0], temp[1], temp[2], temp[3], Integer.parseInt(temp[4])));
		}
		int[] answer = new int[query.length];
		for(int i = 0; i < query.length; i++) {
			HashMap<Integer, Person> clone = (HashMap<Integer, Person>) map.clone();
			HashSet<Integer> delete = new HashSet<Integer>(); 
			String[] temp = query[i].split(" and ");
			//"java backend junior pizza 100" <- 함정?
			for(int j = 0; j < temp.length; j++) {
				if(j == 0) {
					if(temp[j].equals("-")) {
						continue;
					}else {
						for(int key : clone.keySet()) {
							if(!clone.get(key).language.equals(temp[j])) {
								delete.add(key);
							}
						}
						for(int d : delete) {
							clone.remove(d);
						}
						delete.clear();
					}
				}else if(j == 1){
					if(temp[j].equals("-")) {
						continue;
					}else {
						for(int key : clone.keySet()) {
							if(!clone.get(key).fb.equals(temp[j])) {
								delete.add(key);
							}
						}
						for(int d : delete) {
							clone.remove(d);
						}
						delete.clear();
					}
				}else if(j == 2){
					if(temp[j].equals("-")) {
						continue;
					}else {
						for(int key : clone.keySet()) {
							if(!clone.get(key).career.equals(temp[j])) {
								delete.add(key);
							}
						}
						for(int d : delete) {
							clone.remove(d);
						}
						delete.clear();
					}
				}else {
					
					String[] foodScore = temp[j].split(" ");
					for (int k = 0; k < foodScore.length; k++) {
						if (k == 0) {
							if (foodScore[k].equals("-")) {
								continue;
							} else {
								for(int key : clone.keySet()) {
									if(!clone.get(key).food.equals(foodScore[k])) {
										delete.add(key);
									}
								}
								for(int d : delete) {
									clone.remove(d);
								}
								delete.clear();
							}
						}else {
							if (foodScore[k].equals("-")) {
								continue;
							} else {
								for(int key : clone.keySet()) {
									if(clone.get(key).socre < Integer.parseInt(foodScore[k])) {
										delete.add(key);
									}
								}
								for(int d : delete) {
									clone.remove(d);
								}
								delete.clear();
							}
						}
					}
				}
			}
			answer[i] = clone.size();
		}
		
	}
	
	static class Person{
		private String language = "";
		private String fb = "";
		private String career = "";
		private String food = "";
		private int socre = 0;
		
		public Person(String language, String fb, String career, String food, int socre) {
			super();
			this.language = language;
			this.fb = fb;
			this.career = career;
			this.food = food;
			this.socre = socre;
		}

		@Override
		public String toString() {
			return "Person [language=" + language + ", fb=" + fb + ", career=" + career + ", food=" + food + ", socre="
					+ socre + "]";
		}		
		
		
	}
		
	
}
