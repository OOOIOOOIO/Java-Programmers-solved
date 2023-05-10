package level3;

public class 아방가르드 {

    // https://velog.io/@song961003/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%95%84%EB%B0%A9%EA%B0%80%EB%A5%B4%EB%93%9C-%ED%83%80%EC%9D%BC-JS
    public static void main(String[] args) {
        int answer = 0;
        int n = 6;
        int[] dp = new int[100001];
        int mod = 1000000007;
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 3;
        dp[3] = 10;
        dp[4] = 23;
        dp[5] = 62;

        for (int i = 6; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] * 2 + dp[i - 3] * 6 + dp[i - 4] - dp[i - 6] + mod) % mod;
        }

        System.out.println(dp[n]);
    }
    // 틀림 나중에 다시
}
