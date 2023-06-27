package kakao2020인턴십;
import java.util.*;
public class 경주로건설 {
    class Node{
        int y;
        int x;
        int cost;
        int prevWay;

        public Node(int y, int x, int cost, int prevWay){
            this.y = y;
            this.x = x;
            this.cost = cost;
            this.prevWay = prevWay;
        }
    }

    int[] dy = {0, -1, 0, 1};
    int[] dx = {-1, 0, 1, 0}; // 0, 2 = 좌우
    boolean[][][] visited;
    int N;

    public int solution(int[][] board) {

        N = board.length;
        visited = new boolean[N][N][4]; // 4방향(동서남북에서 오는 것 체크)

        int answer = move(0, 0, board);


        return answer;
    }

    public int move(int y, int x, int[][] board){

        Queue<Node> queue = new LinkedList<>();

        queue.offer(new Node(y, x, 0, -1));
        // visited[0][0][0] = 0;

        int minCost = Integer.MAX_VALUE;

        while(!queue.isEmpty()){
            Node curr = queue.poll();
            int currY = curr.y;
            int currX = curr.x;

            if(currY == N-1 && currX == N-1){
                minCost = Math.min(minCost, curr.cost);
            }

            for(int i = 0; i < 4; i++){
                int nextY = dy[i] + currY;
                int nextX = dx[i] + currX;

                if(nextX >= 0 && nextY >= 0 && nextX < N && nextY < N){
                    if(board[nextY][nextX] != 1){
                        int nextCost = 0;

                        if(curr.prevWay == -1 || curr.prevWay == i){ // 처음 혹은 이전과 방향이 같다면
                            nextCost = curr.cost + 100;
                        }
                        else{
                            nextCost = curr.cost + 600;
                        }

                        // 방문하지 않았거나 비용이 이상이라면(중복이동)
                        if(!visited[nextY][nextX][i] || board[nextY][nextX] >= nextCost){
                            queue.offer(new Node(nextY, nextX, nextCost, i));
                            visited[nextY][nextX][i] = true;
                            board[nextY][nextX] = nextCost;
                        }
                    }
                }

            }


        }

        return minCost;

    }





    public static void main(String[] args) {
        경주로건설 test = new 경주로건설();

        int[][] board = new int[][]{{0,0,0,0,0,0,0,1},
            {0,0,0,0,0,0,0,0},
            {0,0,0,0,0,1,0,0},
            {0,0,0,0,1,0,0,0},
            {0,0,0,1,0,0,0,1},
            {0,0,1,0,0,0,1,0},
            {0,1,0,0,0,1,0,0},
            {1,0,0,0,0,0,0,0}}; // 3800


//        int[][] board = new int[][]{
//                {0,0,0},
//                {0,0,0},
//                {0,0,0}}; // 900

        test.solution(board);
    }



}
























