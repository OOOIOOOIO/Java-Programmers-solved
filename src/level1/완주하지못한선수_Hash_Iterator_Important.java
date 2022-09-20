package level1;

import java.util.*;
public class 완주하지못한선수_Hash_Iterator_Important {

	public static void main(String[] args) {
		String[] participant = {"mislav", "stanko", "mislav", "ana"};
		String[] completion = {"stanko", "ana", "mislav"};
		
		System.out.println(solution(participant, completion));
		
		
	}
	
    public static String solution(String[] participant, String[] completion) {
    	String answer = "";
    	Map<String, Integer> map = new HashMap<String, Integer>();
    	
    	// map.getOrDefault 
    	// key가 있다면 value return, 만약 key가 없다면 defaultValue return
    	// 동일인이라면 1, 2, 3, value가 늘어날 것
    	for(String name : participant) {
    		map.put(name, map.getOrDefault(name, 0) + 1);
    	}
    	
    	// 완주자 삭제
    	for(String name : completion) {
    		map.put(name, map.get(name)-1);
    	}
    	
    	
    	
    	// 그냥 for문으로는 remove하지 못하기 때문에
    	// iterator로 만들어줘야 한다.
    	Iterator<Map.Entry<String, Integer>> iter = map.entrySet().iterator();
    	
    	while(iter.hasNext()) {
    		Map.Entry<String, Integer> player = iter.next();
    		if(player.getValue() != 0) {
    			answer =  player.getKey();
    			break;
    		}
    		
    	}
        return answer;
    }
		
	
}
