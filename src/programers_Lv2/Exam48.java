package programers_Lv2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Exam48 {
	//static String[] files = { "img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG" };
	static String[] files = { "F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"};
	//static String[] files = { "foo010bar020.zip"};
	//static String[] files = {"F-15"};

	public static void main(String[] args) {
		ArrayList<FileClass> fileList = new ArrayList<FileClass>();
		
		for(int i =0 ; i < files.length; i++) {
			String temp = files[i];
			String head = "";
			String number = "";
			String tail = "";
			int k = 0;
			for(int j = 0; j < temp.length(); j++) {
				if(Character.isDigit(temp.charAt(j))) {
					head = temp.substring(0, j);
					k = j;
					break;
				}
			}
			for(int j = k; j < temp.length(); j++) {
				if(!Character.isDigit(temp.charAt(j))){
					number = temp.substring(k, j);
					tail = temp.substring(j, temp.length());
					break;
				}
				// 만약 테일이 없는 경우도 있기때문에 끝까지 for문이 진행되면 number에 값을 준다
				number = temp.substring(k, temp.length());
			}
			fileList.add(new FileClass(head, number, tail));
		}
		System.out.println(fileList);
		Collections.sort(fileList, new Comparator<FileClass>() {
			@Override
			public int compare(FileClass o1, FileClass o2) {
				//head가 같으면 숫자로 비교
				if(o1.head.toLowerCase().equals(o2.head.toLowerCase())) {
					return Integer.parseInt(o1.number) - Integer.parseInt(o2.number);
				}	
				// 파일명은 우선 HEAD 부분을 기준으로 사전 순으로 정렬한다. 이때, 문자열 비교 시 대소문자 구분을 하지 않는다.
				// 라는 기준으로 소문자로 변경했을때 정렬해도 무방하다
				return o1.head.toLowerCase().compareTo(o2.head.toLowerCase());
			}
			
		});
		System.out.println(fileList);
		String[] answer = new String[fileList.size()];
		for(int i = 0; i < answer.length; i++) {
			answer[i] = fileList.get(i).getFileName();
		}
		
	}

	static class FileClass  {
		private String head = "";
		private String number = "";
		private String tail = "";

		public FileClass(String head, String number, String tail) {
			super();
			this.head = head;
			this.number = number;
			this.tail = tail;
		}
		
		public String getFileName() {
			return this.head + this.number + this.tail;
		}

		@Override
		public String toString() {
			return "FileClass [head=" + head + ", number=" + number + ", tail=" + tail + "]";
		}


	}
}
