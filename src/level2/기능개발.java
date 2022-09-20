package level2;

import java.util.*;

public class 기능개발 {

	public static void main(String[] args) {
		int[] progresses = {95, 90, 99, 99, 80, 99};
		int[] speeds = {1, 1, 1, 1, 1, 1};
//		int[] progresses = {93, 30, 55};
//		int[] speeds = {1, 30, 5};
		
//		System.out.println(7 / 1);
		
		int[] a = solution(progresses, speeds);
		
		for(int item : a) {
			System.out.println(item);
		}
	}
	
	static public int[] solution(int[] progresses, int[] speeds) {
	        Queue<Integer> queue = new LinkedList<Integer>();
	        ArrayList<Integer> list = new ArrayList<Integer>();
	        
	        // 베포일 넣기
	        for(int i = 0; i < speeds.length; i++){
	            int rest = 100 - progresses[i];
	            
	            // 딱 나누어 지면 -> 몫만
	            if(rest % speeds[i] ==0) {
	            	queue.offer(rest / speeds[i]);
	            }
	            else {
	            	queue.offer((rest / speeds[i]) + 1);
	            }
	            
	        }
	        
	        for(int item : queue) {
	        	System.out.println(item);
	        }
	        
	        // 비교하여 베포 기능 개수 세기
	        while(!queue.isEmpty()){
	            int cnt = 0;
	        
	            int curr = queue.poll();
	            cnt++;
	            
	            while(!queue.isEmpty()){
	                if(queue.peek() <= curr){
	                	queue.poll();
	                    cnt++;
	                }
	                else break;
	            }
	            
	            list.add(cnt);
	        }
	       
	         
//	        for(int a : list) {
//	        	System.out.println(a);
//	        }
	        
	        
	        int[] answer = list.stream().mapToInt(Integer::intValue).toArray();
	        
	        
	        return answer;
	    }
	
}
