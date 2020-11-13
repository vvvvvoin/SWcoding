package kakao;

import java.util.HashMap;
import java.util.HashSet;

import kakao.Kakao03.Person;

public class Kakao03_2 {
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
		
		Person[] person = new Person[info.length];
		for(int i = 0; i < info.length; i++) {
			String[] temp = info[i].split(" ");
			person[i] = new Person(temp[0], temp[1], temp[2], temp[3], Integer.parseInt(temp[4]));
		}
		boolean[] visited2 = new boolean[info.length];		
		for(int v = 0; v < visited2.length; v++) {
			visited2[v] = true;
		}
		
		int[] answer = new int[query.length];
		for(int i = 0; i < query.length; i++) {
			String[] temp = new String[5];
			String q = "";
			for(int t = 0; t < temp.length - 1; t++) {
				temp[t] = query[i].split(" and ")[t];
				q += temp[t] + " ";
			}
			String[] qry = q.split(" ");
			
			boolean[] visited = visited2.clone() ;
			int cnt = person.length;

			for(int j = 0; j < qry.length; j++) {
				for(int k = 0; k < person.length; k++) {
					if(qry[j].equals("-")) continue;
					if (j == 0) {
						if (visited[k]) {
							if (!qry[j].equals(person[k].language)) {
								visited[k] = false;
								cnt--;
							}
						}
					}else if (j == 1) {
						if (visited[k]) {
							if (!qry[j].equals(person[k].fb)) {
								visited[k] = false;
								cnt--;
							}
						}
					}else if (j == 2) {
						if (visited[k]) {
							if (!qry[j].equals(person[k].career)) {
								visited[k] = false;
								cnt--;
							}
						}
					}else if (j == 3) {
						if (visited[k]) {
							if (!qry[j].equals(person[k].food)) {
								visited[k] = false;
								cnt--;
							}
						}
					}else {
						if (visited[k]) {
							if (Integer.parseInt(qry[j]) > person[k].socre) {
								visited[k] = false;
								cnt--;
							}
						}
					}
				}
			}
			System.out.println(cnt);
			answer[i] = cnt;
		}
		String a = "asdf";
		
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

	}
	
}
