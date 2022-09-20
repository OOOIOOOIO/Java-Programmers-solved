package level2;

public class _124나라의숫자 {

	public static void main(String[] args) {
		System.out.println(solution(10));
	}
	
    public static String solution(int n) {
        String answer = "";
        String[] rest = {"4", "1", "2"};
        
        while(n > 0){
            int r = n % 3;
            n = n / 3;
            
            // 나머지 없이 딱 나누어 떨어지면 몫을 -1 해준다. 이거 때문에 1시간 날림 
            if(r == 0) n--;
            
            answer = rest[r] + answer;
        }
        
        return answer;
    }
}
