package level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class 위장 {
	
	public static void main(String[] args) {
		String[][] clothes = {
				{"yellow_hat", "headgear"}, 
				{"blue_sunglasses", "eyewear"}, 
				{"green_turban", "headgear"}};
	
		System.out.println(solution(clothes));
	}
	
	
    public static int solution(String[][] clothes) {
    	Map<String, Integer> map = new HashMap<String, Integer>();
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	int answer = 1;
    	
    	for(String[] cloth : clothes) {
    		// 이미 key가 있다면
    		if(map.containsKey(cloth[1])) {
    			map.put(cloth[1], map.get(cloth[1])+1);
    		}
    		//없다면 1개 추가1
    		else {
    			map.put(cloth[1], 1);
    		}
    	}
    	
    	// 아무것도 입지 않는 경우 추가 +1
    	for(String key : map.keySet()) {
    		answer *= (map.get(key) + 1);
    	}
    	
    	// 아무것도 입지 않는 경우 -1
    	return answer-1;
    	
    }
		
		
}
