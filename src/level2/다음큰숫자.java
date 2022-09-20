package level2;

public class 다음큰숫자 {
	
	public static void main(String[] args) {
		
		
		System.out.println(solution(78));
	}
	
	
    public static int solution(int n) {
        int answer = n+1;
        
        // 2진수로 변환 후 1의 개수를 구한다.
//      long n_binary = Integer.toBinaryString(n).chars().filter(a -> a == '1').count(); // stream을 사용해봄
        int n_binary = Integer.bitCount(n);
        
        while(true) {
        	
        	
//        	long answer_binary = Integer.toBinaryString(answer).chars().filter(a -> a == '1').count();
        	int answer_binary = Integer.bitCount(answer);
        	if(n_binary == answer_binary) {
        		break;
        	}
        	answer++;
        }
        
        return answer;
    }
		
		
}
