package level3;

public class 연속펄스부분수열의합 {
    public static void main(String[] args) {
        int[] str = new int[] {2, 3, -6, 1, 3, -1, 2, 4};

        long solution = solution(str);
        System.out.println(solution);
    }
    public static long solution(int[] sequence) {
        long answer;

        int length = sequence.length;
        int[] a = new int[length];
        int[] b = new int[length];
        int n = 1;

        for(int i = 0; i < length; i++) {
            a[i] = sequence[i]*n;
            n *= -1;
            b[i] = sequence[i]*n;
        }

        // dp[n] = n 번째 원소를 포함했을 때의 최대값
        // dp[n] = MAX (dp[n-1] + a[n], a[n])
        long[] dpA = new long[length];
        long[] dpB = new long[length];

        dpA[0] = a[0];
        dpB[0] = b[0];
        answer = Math.max(dpA[0], dpB[0]);

        for(int i = 1; i < length; i++) {
            dpA[i] = Math.max(dpA[i-1] + a[i], a[i]);
            dpB[i] = Math.max(dpB[i-1] + b[i], b[i]);

            long max = Math.max(dpA[i], dpB[i]);
            answer = Math.max(answer, max);
        }

        return answer;
    }
}
