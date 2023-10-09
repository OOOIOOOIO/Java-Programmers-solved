package level2;

import java.util.ArrayList;
import java.util.List;

public class 문자열압축 {
	public static void main(String[] args) {

		int a = solve1("abcabcdede");
		int b = solve2("abcabcdede");
		System.out.println(a);
		
	}

	public static int solve2(String s){
		int min = Integer.MAX_VALUE;
		// 문자열 자르기 순회;
		for(int i = 1; i <= s.length(); i++){
			// 문자열 압축
			int result = compress(s, i);

			min = Math.min(result, min);



		}

		return min;
	}

	private static List<String> split(String s, int length){
		List<String> token = new ArrayList<>();
		int endIndex = 0;
		for(int startIndex = 0; startIndex < s.length(); startIndex += length){
			if(startIndex + length > s.length()) endIndex = s.length();
			else endIndex = startIndex + length;

			String str = s.substring(startIndex, endIndex);
			token.add(str);
		}

		return token;

	}

	private static int compress(String s, int length){
		StringBuilder sb = new StringBuilder();
		String last = "";
		int cnt = 1;

		for(String token : split(s, length)){
			if(token.equals(last)){
				cnt++;
			}
			else{
				if(cnt > 1) sb.append(cnt);
				sb.append(last);
				cnt = 1;
				last = token;
			}

		}
		// 맨 마지막 추가
		if(cnt > 1) sb.append(cnt);
		sb.append(last);

		return sb.length();
	}
    public static  int solve1(String s) {
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
