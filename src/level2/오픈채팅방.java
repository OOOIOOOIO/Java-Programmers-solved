package level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class 오픈채팅방 {
 
    
    public static void main(String[] args) {
		String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		
		String[] result = solution(record);
		
		for(String item : result) {
			System.out.println(item);
		}
		
	}
    
	public static String[] solution(String[] record) {
		
		int length = record.length;
		Map<String, String> map = new HashMap<String, String>();
		ArrayList<String> list = new ArrayList<String>();
		
		// 유저 수만큼
		for(int i = 0; i < length; i++) {
			
			// 유저 정보 및 유저 추가
			String[] userInfo = record[i].split(" ");
			
			// Enter
			if(userInfo[0].equals("Enter")) {
				map.put(userInfo[1], userInfo[2]);
				list.add(userInfo[1]+"님이 들어왔습니다.");
			}
			// Leave
			else if(userInfo[0].equals("Leave")) {
				list.add(userInfo[1]+"님이 나갔습니다.");
			}
			// Change
			else {
				map.put(userInfo[1], userInfo[2]);
			}
				
		}
		
		String[] result = new String[list.size()];
		int i = 0;
		for(String str : list) {
			int cri = str.indexOf("님");
			String user_id = str.substring(0, cri);
			
			String user_name = map.get(user_id);
			
			result[i++] = user_name + str.substring(cri, str.length());
			
		}
		
		String[] answer = result;
		
        
        return answer;
    }

}
