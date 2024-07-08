package kakao2021BLIND_RECRUITMENT;

import java.util.*;
import java.util.stream.*;

public class 합승택시요금 {




    static class Node{
        int num;
        int cost;


        public Node(int num, int cost){
            this.num = num;
            this.cost = cost;
        }

    }

    static final int INF = Integer.MAX_VALUE;
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();

    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = INF;

        // 초기화
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }



        // 연결
        for(int i = 0; i < fares.length; i++){

            int v1 = fares[i][0];
            int v2 = fares[i][1];
            int cost = fares[i][2];

            graph.get(v1).add(new Node(v2, cost));
            graph.get(v2).add(new Node(v1, cost));

        }

        int[] startA = new int[n+1];
        int[] startB = new int[n+1];
        int[] common = new int[n+1];

        Arrays.fill(startA, INF);
        Arrays.fill(startB, INF);
        Arrays.fill(common, INF);

        startA = dijk(a, startA);
        startB = dijk(b, startB);
        common = dijk(s, common);

        for(int i = 1; i <= n; i++){
            answer = Math.min(answer, common[i] + startA[i] + startB[i]);
        }

        return answer;
    }





    private static int[] dijk(int start, int[] dp){
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);

        //시작노드
        pq.offer(new Node(start, 0));
        dp[start] = 0;


        while(!pq.isEmpty()){

            Node curr = pq.poll();


            if(curr.cost > dp[curr.num]){
                continue;
            }

            for(Node next : graph.get(curr.num)){
                if( dp[next.num] > curr.cost + next.cost){
                    dp[next.num] = curr.cost + next.cost;

                    pq.offer(new Node(next.num, dp[next.num]));
                }
            }

        }

        return dp;
    }




}




























