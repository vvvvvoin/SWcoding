package programers_Lv2;

public class Exam01 {
	static String skill = "CBD";
	static String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
	public static void main(String[] args) {
//		String[] skillTree = skill.split("");
//
//		//초기화
//		String[] temp = new String[skill_trees.length];
//		for(int i = 0; i<temp.length;i++) {
//			temp[i] = "";
//		}
//		
//		String nowSkill = "";
//		for (int i = 0; i < skill_trees.length; i++) {
//			nowSkill = skill_trees[i];
//			for (int j = 0; j < nowSkill.length(); j++) {
//				for (int k = 0; k < skillTree.length; k++) {
//					if(Character.toString(nowSkill.charAt(j)).equals(skillTree[k])) {
//						temp[i] += Character.toString(nowSkill.charAt(j));
//					}
//				}
//			}
//		}
//		
//		String str = "";
//		int index = 0;
//		int answer = temp.length;
//		for(int i = 0; i<temp.length;i++) {
//			str = temp[i];
//			for (int j = 0; j < str.length(); j++) {
//				if(!Character.toString(str.charAt(j)).equals(skillTree[index])) {
//					answer--;
//					break;
//				}
//				index++;
//			}
//			index = 0;
//		}
		int answer = 0;
		boolean flag = true;
		int cnt = 0;
		for (int i = 0; i < skill_trees.length; i++) {
			flag = true;
			String[] skills = skill_trees[i].split("");
			for(int j = 0; j <skills.length; j++) {
				if(skill.indexOf(skills[j]) == cnt) {
					cnt ++;
				}else if(skill.indexOf(skills[j]) > cnt) {
					flag = false;
					break;
				}
			}
			
			if(flag) {
				answer++;
			}
			cnt = 0;
			
			
		}
		
		System.out.println(answer);
		
	}
}
