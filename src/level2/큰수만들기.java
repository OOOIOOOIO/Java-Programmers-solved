package level2;

import java.util.*;


public class 큰수만들기 {

	public static void main(String[] args) {
		String number = "4177252841";
		
		System.out.println(solution(number, 4));
	}
	
	public static String solution(String number, int k) {
		String answer = "";
        StringBuilder sb = new StringBuilder();
        
        int idx = 0;
        int max = 0;
        
        for(int i = 0; i < number.length() - k; i++){ // K를 뺀 횟수만큼
            max = 0;
            
            // max의 idx부터 시작하게. 초깃값! 기초기초
            for(int j = idx; j <= i + k; j++){ // k만큼씩 돌기 어쨋든 마지막까지 확인할 수 있따.
                if(max < number.charAt(j)-'0'){
                    max = number.charAt(j)-'0';
                    idx = j+1;
                }
            }
            sb.append(max);
        }
        answer = sb.toString();
        return answer;
    }

}
