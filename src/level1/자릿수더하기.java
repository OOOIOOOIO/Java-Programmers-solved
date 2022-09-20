package level1;

public class 자릿수더하기 {


	public static void main(String[] args) {
		String n= "a134";
		System.out.println(solution(n));
		
	}
	
    public static boolean solution(String s) {
    	
    	if(s.length() == 4 || s.length() == 6) {
    	 
    		for (int i = 0; i < s.length(); i++) {
    			char ch = s.charAt(i);
 				
 				if(ch < '0' || ch > '9') return false;
 			}
 			
 			return true;
 			
 		}
    	else return false;
    }
		
	
}
