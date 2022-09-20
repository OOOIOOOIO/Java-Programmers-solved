package level2;

import java.util.*;

public class 프린터 {

	public static void main(String[] args) {
		int[] priorites = {2, 1, 3, 2};
		
		
		System.out.println(solution(priorites, 2));
	}
	
	public static int solution(int[] priorites, int location) {
		int answer = 0;
		Queue<int[]> queue = new LinkedList<>();
		
		
		
		//[중요도, 위치]
		for(int i = 0; i < priorites.length; i++) {
			queue.offer(new int[] {priorites[i], i});
			
		}
		
		while(!(queue.isEmpty())) {
			
			// 맨 앞에 있는 아이의 중요도
			int[] first = queue.poll();
			
			// 큰지 작은지 확인
			boolean flag = true;
			
			// 남은 애들 빼서 돌려막기
			// 만약 큰 애가 있으면 다시 offer
			// 아니면 그대로 poll
			for(int[] item : queue) {
				// first가 작다면
				if(first[0] < item[0]) {
					flag = false;
					break;
				}
			}
			
			// 제일 큰 아이라면 그대로 poll
			if(flag) {
				answer++;
				
				if(location == first[1]) {
					break;
				}
			}
			else {
				queue.offer(first);
			}
			
		}
			
		return answer;
	}
	
}
