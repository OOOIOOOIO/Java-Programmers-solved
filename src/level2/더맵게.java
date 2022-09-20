package level2;

import java.util.*;


public class 더맵게 {
	
	public static void main(String[] args) {
		int[] scoville = {1, 2, 3, 9, 10 ,12};
		
		System.out.println(solution(scoville, 7));
		
	}
	
	public static int solution(int[] scoville, int K) {
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        int answer = 0;
        
		// 넣기
		for(int item : scoville) {
			queue.offer(item);
		}
		
		while(!queue.isEmpty()) {
			int newFood = 0;
			
			// 모두가 스코빌 지수보다 높으면 끝~
			if(queue.peek() >= K) break;
			
			// 1개 밖에 안남았는데 K보다 작을 경우
			if(queue.size() == 1 && queue.peek() < K) {
				answer = -1;
				break;
			}
			
			
			
			// 스코빌 지수가 낮다면, 2가지 음식
			if(queue.peek() < K) {
				newFood = queue.poll() + (queue.poll() * 2);
				queue.offer(newFood);
				answer++;
			}
			
			
		}
		
        
        
        return answer;
    }

}
