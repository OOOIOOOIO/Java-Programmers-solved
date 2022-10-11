package level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class 최댓값과최솟값 {
	public static void main(String[] args) {
		
//		String s = "1 2 3 4";
		String s = "-1 -1";
		System.out.println(solution(s));
	}
	
    private static String solution(String s) {
        String[] temp = s.split(" ");
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        for(String c : temp) {
        	list.add(Integer.parseInt(c));
        }
    	
        // 1. Stream 사용
        // 없다면 null 이기에 orElese
        int streamMax = list.stream().max(Integer::compare).orElse(-1);
        int streamMin = list.stream().min(Integer::compare).orElse(-1);
        
        // 2. Collection 사용
        int collectMax = list.isEmpty() ? -1 : Collections.max(list);
        int collectMin = list.isEmpty() ? -1 : Collections.min(list);
        
    	String answer = streamMin+" "+ streamMax;
        
        return answer;
    
    }
}
