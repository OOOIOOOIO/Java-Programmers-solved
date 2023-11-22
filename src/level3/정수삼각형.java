package level3;

import java.util.*;

public class 정수삼각형 {


    static int[][] dp = new int[501][501];

    public int solution(int[][] triangle) {
        int answer = 0;

        for(int[] row : dp){
            Arrays.fill(row, -1);
        }


        return move(0, 0, triangle);

    }

    public int move(int idx, int depth, int[][] triangle){

        if(depth == triangle.length) return 0;//종료

        if(dp[depth][idx] != -1) return dp[depth][idx];



        return dp[depth][idx] = triangle[depth][idx] + Math.max(move(idx, depth+1, triangle), move(idx+1, depth+1, triangle));


    }
}
