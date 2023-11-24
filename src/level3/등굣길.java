package level3;

import java.util.*;
public class 등굣길 {

    // boolean[][] isPuddle;
    private int[][] mem;
    private final int mod = 1000000007;

    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;

        // isPuddle = new boolean[n][m];
        // for(int[] puddle : puddles){
        //     isPuddle[puddle[1]][puddle[0]] = true;
        // }

        // mem = new int[n][m];

        // for(int[] arr : mem){
        //      Arrays.fill(arr, -1);
        //  }

        mem = new int[n+1][m+1];

        for(int[] puddle : puddles){
            mem[puddle[1]][puddle[0]] = -1;
        }


        mem[1][1] = 1;

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(mem[i][j] == -1) continue;

                if(mem[i - 1][j] > 0) mem[i][j] += mem[i - 1][j] % mod;
                if(mem[i][j - 1] > 0) mem[i][j] += mem[i][j - 1] % mod;
            }
        }

        return mem[n][m] % mod;
        // return count(0, 0, n, m, isPuddle);



    }

    private int count(int y, int x, int n, int m, boolean[][] isPuddle){

        if(y >= n || x >= m) return 0; // 범위를 넘어설 때
        if(isPuddle[y][x]) return 0; // 웅덩이일 때

        if(mem[y][x] != -1) return mem[y][x]; // 이미 방문했을 때

        if(y == n-1 && x == m-1) return 1; // 도착했을 때

        int total = count(y+1, x, n, m, isPuddle) + count(y, x+1, n, m, isPuddle);

        return mem[y][x] = total % 1000000007;


    }
}
