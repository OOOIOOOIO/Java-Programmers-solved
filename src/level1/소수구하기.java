package level1;

public class 소수구하기 {
	public static void main(String[] args) {
		
		System.out.println(solution(10));
	}
	
	// 에라토스테네스 기법으로 소수 구하기
	// 탐색 범위는 시작 ~ target의 제곱근
	// 왜 루트target이냐면 만약 target의 약수가 있다면 무조건 제곱근 보다 작거나 같은 것이기 때문이다.(2 제외) target = 9, 루트target은 3 
	// 그리고 boolean 타입의 배열을 생성해 숫자의 배수 또한 거른다.
	
	public static int solution(int n) {
        int answer = 0;
        boolean[] prime = new boolean[n+1];
		
		prime[0] = true;
		prime[1] = true;

		
		for(int i = 2; i <= Math.sqrt(n); i++) {
			
			if(prime[i]) continue;
			
			for(int j = i * i; j <= n; j += i) {
				prime[j] = true;
			}
			
		}
		
		for(int i = 0; i <= n; i++) {
			if(!prime[i]) {
				answer++;
			}
		}
        
        return answer;
		
	}
}
