package level3;

public class 순위 {

    public int solution(int n, int[][] results) {
        int answer = 0;

        //플로이드 와샬
        return floyd(n, results);



        // return answer;
    }

    private int floyd(int n, int[][] results){
        int[][] graph = new int[n][n];

        int answer = 0;

        for(int[] arr : results){
            graph[arr[0]-1][arr[1]-1] = 1;
            graph[arr[1]-1][arr[0]-1] = -1;

        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                for(int k = 0; k < n; k++){
                    if(graph[i][k] == 1 && graph[k][j] == 1){ //이기는거
                        graph[i][j] = 1;
                        graph[j][i] = -1;
                    }
                    else if(graph[i][k] == -1 && graph[k][j] == -1){ // 지는거
                        graph[i][j] = -1;
                        graph[j][i] = 1;
                    }
                }
            }
        }

        for(int[] arr : graph){
            int cnt = 0;
            for(int i = 0; i < n; i++){
                if(arr[i] != 0) cnt++;
            }
            // System.out.println("cnt : " +cnt);

            if(n == cnt+1) answer++;
        }

        return answer;
    }
}
