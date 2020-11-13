package line;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Line06 {
	static String[] companies = {"A fabdec 2", "B cebdfa 2", "C ecfadb 2"};
	static String[] applicants = {"a BAC 1", "b BAC 3", "c BCA 2", "d ABC 3", "e BCA 3", "f ABC 2"};
	
//	static String[] companies = {"A abc 2", "B abc 1"};
//	static String[] applicants = {"a AB 1", "b AB 1", "c AB 1"};
	public static void main(String[] args) {
		ArrayList<Company> companyList = new ArrayList<Company>();
		ArrayList<Volunteer> volunteerList = new ArrayList<Volunteer>();
		
		for(int i = 0; i < companies.length; i++) {
			String[] temp = companies[i].split(" ");
			companyList.add(new Company(temp[0], temp[1], Integer.parseInt(temp[2]), new HashSet<String>()));
		}
		
		for(int i = 0; i < applicants.length; i++) {
			String[] temp = applicants[i].split(" ");
			volunteerList.add(new Volunteer(temp[0], temp[1].substring(0, Integer.parseInt(temp[2])), 0));
		}
		boolean flag = false;
		boolean flag2 = true;
		while(true) {
			ArrayList<String> fail = new ArrayList<String>();
			
			System.out.println(volunteerList);
			if (flag2) {
				flag2 = false;
				for (int i = 0; i < volunteerList.size(); i++) {
					for (int j = 0; j < companyList.size(); j++) {
						if (volunteerList.get(i).want < volunteerList.get(i).company.length()) {
							String c = volunteerList.get(i).company.charAt(volunteerList.get(i).want) + "";
							if (c.equals(companyList.get(j).cName)) {
								companyList.get(j).volunteer.add(volunteerList.get(i).vName);
							}
						} else {
							continue;
						}
					}
				}
			}else {
				for (int i = 0; i < volunteerList.size(); i++) {
					for (int j = 0; j < companyList.size(); j++) {
						if (volunteerList.get(i).want < volunteerList.get(i).company.length() &&volunteerList.get(i).fail ) {
							String c = volunteerList.get(i).company.charAt(volunteerList.get(i).want) + "";
							if (c.equals(companyList.get(j).cName)) {
								companyList.get(j).volunteer.add(volunteerList.get(i).vName);
							}
						} else {
							continue;
						}
					}
				}
			}
			
			
			System.out.println(companyList);
			for(int i = 0; i < companyList.size(); i++) {
				for(int j = companyList.get(i).want.length - 1; j >= 0; j--) {
					if(companyList.get(i).volunteer.size() <= companyList.get(i).n) break;
					if(companyList.get(i).volunteer.contains(companyList.get(i).want[j])) {
						fail.add(companyList.get(i).want[j]);						
						for(int k = 0; k < volunteerList.size(); k++) {
							if(volunteerList.get(k).vName.equals(companyList.get(i).want[j])) {
								volunteerList.get(k).fail = true;
							}
						}
						companyList.get(i).volunteer.remove(companyList.get(i).want[j]);
					}
				}
			}
			
			for(int i = 0; i < fail.size(); i++) {
				for(int j = 0; j < volunteerList.size(); j++) {
					if(volunteerList.get(j).vName.equals(fail.get(i))) {
						volunteerList.get(j).want += 1;
					}

				}
			}
			System.out.println(fail);
			if(fail.size() == 0) {
				flag = true;
			}
			if(flag)break;
		} 
		String[] answer = new String[companies.length];
		for(int i = 0; i < companyList.size(); i++) {
			String str = companyList.get(i).cName;
			str += "_";
			String temp = "";
			for(String a : companyList.get(i).volunteer) {
				temp += a;
			}
			char[] temp2 = temp.toCharArray();
			Arrays.sort(temp2);
			for(int j = 0; j < temp2.length; j++) {
				str += temp2[j];
			}
			answer[i] = str;
			System.out.println(str);
		}
	}
	
	static class Company{
		private String cName;
		private String[] want;
		private int n;
		private HashSet<String> volunteer;
		
		public Company(String cName, String want, int n, HashSet<String> volunteer) {
			super();
			this.cName = cName;
			this.want = change(want);
			this.n = n;
			this.volunteer = volunteer;
		}

		private String[] change(String want2) {
			String[] str = new String[want2.length()];
			for(int i = 0; i < str.length; i++) {
				str[i] = want2.charAt(i) + "";
			}
			return str;
		}

		@Override
		public String toString() {
			return "Company [cName=" + cName + ", want=" + Arrays.toString(want) + ", n=" + n + ", volunteer="
					+ volunteer + "]";
		}
		
		//어레이 리스트에 더하고 n보다 클때 선호도로 제거
		//제거된 인원을 조회해서 라운드 진행시킬지 
		
	}
	
	static class Volunteer{
		private String vName;
		private String company;
		private int want;
		private boolean fail = false;
		public Volunteer(String name, String caompany, int want) {
			super();
			this.vName = name;
			this.company = caompany;
			this.want = want;
		}
		
		@Override
		public String toString() {
			return "volunteer [vName=" + vName + ", company=" + company + ", want=" + want + "]";
		}	
	}
}
