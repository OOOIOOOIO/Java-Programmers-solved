package level3;

import java.util.*;

public class 게임맵최단거리 {

    class State{
        int y;
        int x;
        int cnt;

        public State(int y, int x, int cnt){
            this.y = y;
            this.x = x;
            this.cnt = cnt;
        }

    }

    int[] dx = new int[]{0, -1, 0, 1};
    int[] dy = new int[]{-1, 0, 1, 0};

    public int solution(int[][] maps) {
        int answer = 0;
        int N = maps.length; //행
        int M = maps[0].length; //열

        return bfs(new State(0, 0, 1), maps, N, M);

    }


    public int bfs(State state, int[][] map, int N, int M){

        Queue<State> queue = new LinkedList<State>();
        queue.offer(state);

        while(!(queue.isEmpty())){
            State curr = queue.poll();

            if(curr.y == N-1 && curr.x == M-1){
                return map[curr.y][curr.x];
            }

            //이동
            for(int i = 0; i < 4; i++){
                int nextY = curr.y + dy[i];
                int nextX = curr.x + dx[i];
                // System.out.println("==nextY : " + nextY + " | nextX : " + nextX);


                if(nextY >= 0 && nextY < N && nextX >= 0 && nextX < M){
                    // System.out.println("nextY : " + map[nextY] + " | nextX : " + map[nextX]);
                    if(map[nextY][nextX] == 0) continue;

                    if(map[nextY][nextX] == 1){
                        // System.out.println("nextY : " + nextY + " | nextX : " + nextX);
                        map[nextY][nextX] = curr.cnt + 1;
                        queue.offer(new State(nextY, nextX, curr.cnt+1));
                    }
                }


            }

        }

        return -1;

    }
}
