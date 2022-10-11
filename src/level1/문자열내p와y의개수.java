package level1;

public class 문자열내p와y의개수 {
	
	static int yCnt;
	static int pCnt;
	
	public static void main(String[] args) {
		
	}
	
    static boolean solution(String s) {
        boolean answer = false;

        for(int i = 0; i < s.length(); i++) {
        	char temp = s.charAt(i);
        	
        	if(temp == 'o') continue;
        	
        	if(temp == 'y' || temp == 'Y') {
        		yCnt++;
        	}
        	if(temp == 'p' || temp == 'P') {
        		pCnt++;
        	}
        	
        	
        }
        
        if(yCnt == pCnt) answer = true;
        return answer;
    }
}
