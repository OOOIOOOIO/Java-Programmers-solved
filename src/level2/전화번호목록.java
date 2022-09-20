package level2;

import java.util.Arrays;

public class 전화번호목록 {
	public static void main(String[] args) {
		String[] phone_book = {"12","88","567","123","1235"};
		
		
		for(String a : phone_book) {
			System.out.println(a);
		}
		
		System.out.println();
		Arrays.sort(phone_book);
		
		
		for(String a : phone_book) {
			System.out.println(a);
		}
		
		System.out.println(solution(phone_book));
		
	}
	
	public static boolean solution(String[] phone_book) {
       boolean answer = true;
       
       Arrays.sort(phone_book);
       
       for(int i = 0; i < phone_book.length-1; i++) {
    	   
    	   String cri = phone_book[i];
    	   
    	   if(phone_book[i+1].startsWith(cri)) {
    		   answer = false;
    		   break;
    	   }
       }
       
       
       return answer;
    }
}
