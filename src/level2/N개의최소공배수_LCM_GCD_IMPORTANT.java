package level2;

public class N개의최소공배수_LCM_GCD_IMPORTANT {
	
	public static void main(String[] args) {
		int[] arr = {2,6,8,14};
	
		System.out.println(solution(arr));
	}
	
	
	/*
	 * lcm, 연제법
	 * 최소공배수 구하기
	 * 
	 * 로직
	 * answer == max
	 * 1. 우선 최댓값을 찾는다.
	 * 2. 그 최댓값을 모든 요소들로 나누어 나머지가 0인지 확인한다.
	 * 3. 만약 0이라면 그 수의 약수이므로 true
	 * 4. 만약 아니라면 그 수의 약수가 아니므로 최소공배수의 조건이 되지 못한다.
	 * 5. 모든 요소가 약수가 되는 값을 찾을 때까지 max값을 1씩 증가시킨다!
	 */
	
    public static int solution(int[] arr) {
		int answer = 0;
		boolean flag = false;
		
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] > answer) answer = arr[i];
		}
		
		while(true) {
			for(int i = 0; i < arr.length; i++) {
				if(answer % arr[i] == 0) {
					flag = true;
				}
				else {
					flag = false;
					break;
				}
			}
			
			if(flag) break;
			
			answer++;
		}
    
		return answer;
    }
    
	/* gcd, 연제법
	 * 
	 * 로직
	 * 
	 * 1. 두 정수 또는 두 정식인 a와 b가 있을 때
	 * 2. a를 b로 나눈 나머지 a'로 b를 나누고
	 * 3. 그 나머지로 a'를 나누는 일을 완전히 나누어질 때까지 계속하여 a와 b의 최대 공약수를 구한다. 
	 * 
	 * 단, a, b가 자연수일 때  a > b, 다항식일 때는 a의 차수가 b의 차수 이상이어야 한다.
	 * 
	 */
	public static int gcd(int a, int b) {
		if(b == 0) {
			return a;
		}
		else {
			return gcd(b, a % b);
		}
	}
	
	/*
	 * 둘이 짝
	 * input data는 1차원 배열
	 * 
	 * 로직
	 * 
	 * 1. lcm2
	 * 2. gcd2
	 * 3. 빠밤!
	 */
	
	public static int gcd2(int a, int b){
	    if(a > b) return (a % b == 0) ? b : gcd(b, a % b);
	    else return (b % a == 0) ? a : gcd(a, b % a);
	}
	
	public int lcm2(int[] num) {
        int answer = num[0];
    	int g = 0;
        
        for(int i = 1; i < num.length;i++){
        	g = gcd2(answer, num[i]);
            answer = g * (answer / g) * (num[i] / g);
        }
        
        return answer;
    }
		
		
}
