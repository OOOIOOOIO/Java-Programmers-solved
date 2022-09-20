package level1;

import java.util.*;

public class 정수내림차순으로배치하기 {

	public static void main(String[] args) {
		long n = 118372;
		System.out.println(solution(n));
		
		
	}
	
    public static long solution(long n) {
        long answer = 0;
		ArrayList<Long> list = new ArrayList<>();
		
		
		while(true) {
			long q = n / 10;
			long r = n % 10;
			n = q;
			// 2자리 이상
			if(q != 0) {
				list.add(r);
			}
			// 1 자리
			else {
				list.add(r);
				break;
			}
			
		}
		
		Collections.sort(list);
		
		for(int i = list.size(); i > 0; i--) {
			 answer += list.get(i-1) * (int)Math.pow(10, i-1);
		}
        
        
        
        return answer;
    }
		
	
}
