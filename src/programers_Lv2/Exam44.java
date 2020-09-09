package programers_Lv2;

import java.util.ArrayList;
import java.util.HashMap;

public class Exam44 {
	 // 바뀌는 아이디, 닉네임 HashMap에 계속 업데이트한다
    // ArrayList<Object>로 아이디 변경을 제외한 아이디와 목적을 담는다
    // 마지막으로 ArrayList를 array로 변환하면서
    // id는 HashMap에서 찾아서 매핑시키고 목적에 담긴 내용을 넣어준다
	static String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
	public static void main(String[] args) {
		HashMap<String, String> idMap = new HashMap<>();
        ArrayList<WhatDo>  arrayList = new ArrayList<>();
        
        for(String value : record){
            String[] str = value.split(" ");
            if(str[0].equals("Enter")){
                arrayList.add(new WhatDo(str[1], "in"));
                idMap.put(str[1], str[2]);
            }else if(str[0].equals("Leave")){
                arrayList.add(new WhatDo(str[1], "out"));
            }else{
                idMap.put(str[1], str[2]);
            }
        }
        
        String[] answer = new String[arrayList.size()];
        for(int i = 0; i < arrayList.size(); i++){
            if(arrayList.get(i).purpose.equals("in")){
                answer[i] = idMap.get(arrayList.get(i).id) + "님이 들어왔습니다.";
                System.out.println(answer[i]);
            }else{
                answer[i] = idMap.get(arrayList.get(i).id) + "님이 나갔습니다.";
                System.out.println(answer[i]);
            }
        }
	}
	
	static class WhatDo{
        private String id;
        private String purpose;
        
        public WhatDo(String id, String purpose){
            this.id = id;
            this.purpose = purpose;
        }
    }
}
