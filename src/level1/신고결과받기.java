package level1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class 신고결과받기 {
	
	public static void main(String[] args) {
		String[] id_list = {"muzi", "frodo", "apeach", "neo"};
//		String[] id_list = {"con", "ryan"};
		String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
//		String[] report = {"ryan con", "ryan con", "ryan con", "ryan con"};
		
		
		int[] result = solution(id_list, report, 2);
		
		for(int i = 0; i < id_list.length; i++) {
			System.out.println(result[i]);
		}
		
	}
	
	public static int[] solution(String[] id_list, String[] report, int k) {
		
		int[] answer = new int[id_list.length];
		
        Map<String, Integer> reported_list = new HashMap<String, Integer>();
        Map<String, Integer> user_list = new HashMap<String, Integer>();
        
        // set을 통해 중복 제거, LinkedHashSet : 순서 유지
        LinkedHashSet<String> hashSet = new LinkedHashSet<String>(Arrays.asList(report));
        String[] new_reported_list = hashSet.toArray(new String[0]);
        
        
        // 횟수 넣을 곳
        for(int i = 0; i < id_list.length; i++) {
        	reported_list.put(id_list[i], 0);
        	user_list.put(id_list[i], 0);
        }
        
        // 신고 횟수 구하기
        for(int i = 0; i < new_reported_list.length; i++) {
        	String reported_id = new_reported_list[i].split(" ")[1]; // 신고 당한 애
        	
    		int val = reported_list.get(reported_id);
    		reported_list.replace(reported_id, val+1);
        }
        
        // 결과 횟수 구하기
        for(int i = 0; i < new_reported_list.length; i++) {
        	String[] temp = new_reported_list[i].split(" ");
        	String user_id = temp[0]; // 신고자
        	String reported_id = temp[1]; // 신고 당한 애
        	int cnt = reported_list.get(reported_id); // 신고 당한 횟수
        	if(cnt >= k) {
        		int val = user_list.get(user_id);
        		user_list.replace(user_id, val+1);
        	}
        }
        for(int i = 0; i < user_list.size(); i++) {
        	answer[i] = user_list.get(id_list[i]);
        }
       
        return answer;
    }
}
