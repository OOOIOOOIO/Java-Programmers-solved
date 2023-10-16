package level2;
import java.util.PriorityQueue;
import java.util.Queue;

public class 카펫 {


	public static void main(String[] args) {
		Queue<Integer> highQueue = new PriorityQueue<Integer>((o1, o2) -> (o1 - o2 > 0 ? -1 : 1));
		
		
		highQueue.offer(1);
		highQueue.offer(8);
		highQueue.offer(6);
		highQueue.offer(10);
		highQueue.offer(5);
		
//		for(int i : highQueue) {
//			System.out.println(i);
//		}
		solution(18, 6);
	}

	public static int[] solve2(int brown, int yellow){

		for(int width = 3; width <= 5000; width++){
			for(int height = 3; height <= width; height++){
				int brownCnt = (2*width) + (2*height) - 4;
				int yellowCnt = (width-2) * (height-2);

				if(brownCnt == brown && yellowCnt == yellow){
					return new int[]{width, height};
				}

			}
		}

		return null;
	}


	public static int[] solution(int brown, int yellow) {
		Queue<Integer> rowQueue = new PriorityQueue<Integer>((o1, o2) -> (o1 - o2 > 0 ? -1 : 1));
		Queue<Integer> highQueue = new PriorityQueue<Integer>();
		
		
		// 우선 약수들을 다 구해서
		// 이분탐색으로 가운데이 있는 둘을 꺼낸다?
		int sum = brown + yellow;
		
		for(int i = 1; i <= Math.sqrt(sum); i++) {
			
			// 나누어 떨어지면
			//  row	  /  high
			// 3 2 1  / 4 6 12
			
			
			int r = sum % i;
			
			if(r == 0) {
				int q = sum / i;
				rowQueue.offer(i);
				highQueue.offer(q);
			}
			
		}
		
		System.out.println(highQueue.peek());
		System.out.println(rowQueue.peek());
		
		
		// 검증
        // 가운데 노란색 개수
		while(true) {
			int row = highQueue.peek();
			int column = rowQueue.peek();
			
			if((row - 2)*(column - 2) == yellow) {
				int[] answer = {highQueue.peek(), rowQueue.peek()}; 
				return answer;
			}
			else {
				rowQueue.poll();
				highQueue.poll();
			}
			
		}
		
	}
}
