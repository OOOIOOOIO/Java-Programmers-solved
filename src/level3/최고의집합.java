package level3;

import java.util.Arrays;

public class 최고의집합 {
	public static void main(String[] args) {
		int n = 2;
		int s = 9;
		
		
		int[] arr =solution(n, s);
        
        for(int a : arr) {
        	System.out.println(a);
        }
        
	}
	
	
	
    public static int[] solution(int n, int s) {
        
        // -1일 경우
        if(n > s) {
        	return new int[] {-1};
        }
        
		int q = s / n;
        int r = s % n;
        
        
        int[] answer = new int[n];

        Arrays.fill(answer, q);
        
        for(int i = 0; i < r; i++) {
        	answer[i]++;
        }
        
        int idx = n-1;
        
        while(r-- > 0) {
        	answer[idx]++;
        	idx--;
        }
        
        return answer;
    }
}
