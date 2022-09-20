package level2;

public class 문자열압축 {
	public static void main(String[] args) {

		int a = solution("abcabcdede");
		System.out.println(a);
		
	}
    public static  int solution(String s) {
    	int answer = s.length();
    	
    	for(int i = 1; i <= s.length() / 2; i++) {
    		StringBuilder sb = new StringBuilder();
    		String cri = s.substring(0, i);
    		int cnt = 1;
    		
    		for(int j = i; j <= s.length(); j += i) {
    			String comp = s.substring(j, j+i > s.length() ? s.length() : j + i);
    			
    			if(cri.equals(comp)) {
    				cnt++;
    			}
    			else {
    				sb.append(cnt > 1 ? cnt : "").append(cri);
    				cnt = 1;
    				cri = comp;
    				
    			}
    		}
    		// 마지막 붙이기 , comp에서 s의 길이를 넘기면 나머지가 된다.
    		sb.append(cri);
    		
    		// min
    		int strLength = sb.toString().length();
    		answer = Math.min(answer, strLength);
    		
    	}
    	
        return answer;
    }	
}
