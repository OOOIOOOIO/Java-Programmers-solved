package level3;

import java.util.Collections;
import java.util.LinkedList;

	
public class 이중우선순위큐 {
	public static void main(String[] args) {
		String d = "abc";
		
		String[] operations = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
		
		int[] a = solution(operations);
		
		for(int b : a) {
			System.out.println(b);
		}
		
	}
	
    public static int[] solution(String[] operations) {
    	LinkedList<Integer> queue = new LinkedList<Integer>();
    	
    	for(String oper : operations) {
    		
    		int val = Integer.parseInt(oper.substring(2));
    		
    		// I or D
    		// I : 추가
    		if(oper.substring(0, 1).equals("I")) {
    			
    			queue.offer(val);
    			
    			// 정렬
    			Collections.sort(queue);
    		}
    		// D : 삭제
    		else {
    			// 비어있지 않다면
    			if(!queue.isEmpty()) {
    				// 최대
    				if(oper.substring(2).equals("1")){
    					queue.pollLast();
    				}
    				// 최소
    				else {
    					queue.pollFirst();
    				}
    				
    			}
    			
    		}
    	}
    	
    	// 비어있을 때
    	if(queue.isEmpty()) {
            int[] answer = {0, 0};
            return answer;
    	}
    	else {
    		int[] answer = {queue.peekLast(), queue.peekFirst()};
    		return answer;
    		
    	}

    }
   
}


