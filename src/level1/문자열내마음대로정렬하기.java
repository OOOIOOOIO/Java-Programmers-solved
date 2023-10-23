package level1;

import java.util.*;

public class 문자열내마음대로정렬하기 {
	public static void main(String[] args) {
		
		String[] strings = {"abce","abca","abcb","abcc","abcf", "abcd", "cdx"};
		
		String[] answer = solution(strings, 2);
			
		
		for(String a : answer) {
			System.out.println(a);
		}
		
	}

	public static String[] solve2(String[] strings, int n) {

		//1
		Arrays.sort(strings, (s1, s2) -> {
			if(s1.charAt(n) - s2.charAt(n) < 0) return -1;
			else if(s1.charAt(n) - s2.charAt(n) > 0) return 1;
			else return s1.compareTo(s2);
		});

		Arrays.sort(strings, (s1, s2) -> {
			if(s1.charAt(n) != s2.charAt(n)) return s1.charAt(n) - s2.charAt(n);
			else return s1.compareTo(s2);
		});

		return strings;


	}
	
	public static String[] solution(String[] strings, int n) {
		String[] answer = new String[strings.length];
		
		for(int i = 0; i < strings.length; i++) {
			answer[i] = strings[i].charAt(n) + strings[i];
		}
		
		Arrays.sort(answer);
		
		
		
		for(int i = 0; i < strings.length; i++) {
			answer[i] = answer[i].substring(1);
		}
		
		return answer;
		
	}

}
