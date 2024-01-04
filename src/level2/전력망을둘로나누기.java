package level2;

import java.util.*;

public class 전력망을둘로나누기 {

    static int[][] graph;

    public static int solution(int n, int[][] wires) {
        int answer = n;
        graph = new int[n+1][n+1];

        for(int i=0; i<wires.length; i++){
            int from = wires[i][0], to = wires[i][1];
            graph[from][to] = 1;
            graph[to][from] = 1;
        }

        for(int i=0; i<wires.length; i++){
            int from = wires[i][0], to = wires[i][1];
            graph[from][to] = 0;
            graph[to][from] = 0;

            answer = Math.min(answer, bfs(n, from));
            graph[from][to] = 1;
            graph[to][from] = 1;

        }
        return answer;
    }

    public static int bfs(int n, int x){
        boolean[] visited = new boolean[n+1];
        int count = 1;

        Queue<Integer> que = new LinkedList<Integer>();
        visited[x] = true;
        que.offer(x);

        while(!que.isEmpty()){
            int temp = que.poll();

            for(int i=1; i<=n; i++){
                if(graph[temp][i] == 1 && !visited[i]){
                    visited[i] = true;
                    que.offer(i);
                    count ++;
                }
            }
        }

        return (int)Math.abs(count-(n-count));
    }


    public static void main(String[] args) {
        int n = 9;
        int[][] wires = new int[][]{
                {1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}
        };

        int solution = solution(n, wires);
        System.out.println(solution);
    }
}
