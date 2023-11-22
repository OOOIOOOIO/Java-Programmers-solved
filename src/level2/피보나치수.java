package level2;

import java.util.*;

public class 피보나치수 {

    static int[] dp = new int[100001];
    public int solution(int n) {

        Arrays.fill(dp, -1); // 중복검사 차단

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;

        for(int i = 2; i < n; i++){ // 값이 너무 클 경우 미리 메모이제이션
            fibo(n);
        }
        return fibo(n);


    }

    public int fibo(int n){
        if(dp[n] != -1) return dp[n]; // 중복 차단
        if(n == 0 || n == 1 || n == 2) return dp[n];

        return dp[n] = (fibo(n-2) + fibo(n-1)) % 1234567;

    }

}
