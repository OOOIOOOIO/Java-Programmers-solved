package level3;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class TEST {
	
	public static void main(String[] args) {
		String d = "abc";
		
		String[] operations = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
		
		int a = Arrays.asList(operations).indexOf("D 1");
		System.out.println(a);
		
//		int[] a = solution(operations);
//		
//		for(int b : a) {
//			System.out.println(b);
//		}
		
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

/*
 * hit - dot 비교
 * 비교해서 다른 자리가 cog와 같은지 비교 / 비교하고 같은 자리수 2개인 경우에만 dfs 돌리기 --> 이게 틀렸음
 * 만약 같다면 바꾸기
 * 이거 반복
 *  
 */


