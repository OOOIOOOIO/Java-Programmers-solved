package level1;

import java.util.Arrays;


public class 이상한문자만들기_split_limit_Important {
	
	public static void main(String[] args) {
//		String s = "try hello world";
		String s = "  gi oo  a  aa   ep   ";

		// split(String regex, limit) : lmit이 음수일 경우 모든 공백도 살린다. 만약 양수일 경우 return 할 배열의 길이를 의미한다.
		for(String a : s.split(" ", 2)) {
			System.out.println(a);
		}
		
		
//		System.out.println(solution(s));
		
	}
	
	
    public static String solution(String s) {
    	StringBuilder sb = new StringBuilder();
        
		s = s.toUpperCase();
		
		String[] arr = s.split(" ", -1);
		
		for(String str : arr) {
			
			for(int i = 0; i < str.length(); i++) {
				
				// 짝수라면 대문자로
				if(i % 2 == 0) {
					sb.append(str.charAt(i));
				}
				// 홀수라면
				else {
					sb.append((char)(str.charAt(i) + 32));
					
				}
				
			}
			
			sb.append(' ');
			
		}
        String answer = sb.toString().substring(0, sb.toString().length()-1);
		
        return answer;
    }
	
  
		
		
}
