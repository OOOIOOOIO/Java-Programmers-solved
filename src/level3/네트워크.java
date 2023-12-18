package level3;

import java.util.*;

public class 네트워크 {

    ArrayList<Integer>[] graph;
    boolean[] visited;

    public int solution(int n, int[][] computers) {
        int answer = 0;

        graph = new ArrayList[n];
        visited = new boolean[n];

        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }


        for(int i = 0 ; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i == j) continue;

                // 연결
                if(computers[i][j] == 1 && computers[j][i] == 1){
                    graph[i].add(j);
                    graph[j].add(i);
                }

            }
        }

        for(int i = 0; i < n; i++){
            if(!visited[i]){
                dfs(i);
                answer++;
            }
        }


        return answer;
    }

    public void dfs(int start){
        visited[start] = true;

        for(int next : graph[start]){
            if(!visited[next]){
                dfs(next);
            }
        }
    }
}
