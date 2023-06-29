package kakao2021채용연계형인턴십;

import java.util.*;

public class 거리두기확인하기 {

    class Cordi{
        int y;
        int x;

        public Cordi(int y, int x){
            this.y = y;
            this.x = x;
        }
    }

    int[] dy = {-1, 0, 1, 0};
    int[] dx = {0, -1, 0, 1};



    public int[] solution(String[][] places) {
        int[] result = new int[places.length];
        for(int i = 0; i < places.length; i++){
            result[i] = isCorrext(places[i]);
        }
        return result;
    }

    public int isCorrext(String[] map) {
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[i].length(); j++){
                if(map[i].charAt(j) == 'P') {
                    if(!bfs(map, i, j)) return 0;
                }
            }
        }
        return 1;
    }

    public boolean bfs(String[] board, int y, int x) {
        Queue<Cordi> q = new LinkedList<>();
        boolean[][] visited = new boolean[board.length][board.length];
        q.offer(new Cordi(y, x));
        visited[y][x] = true;

        while(!q.isEmpty()) {
            Cordi curr = q.poll();

            for(int i = 0; i < 4; i++) {
                int nextY = curr.y + dy[i];
                int nextX = curr.x + dx[i];
                int manhattan = Math.abs(x - nextX) + Math.abs(y - nextY);

                if(nextX < 0 || nextY < 0 || nextX >= board.length || nextY >= board.length) continue;
                if(visited[nextY][nextX] || manhattan > 2) continue;

                visited[nextY][nextX] = true;
                if(board[nextY].charAt(nextX) == 'X') continue;
                else if(board[nextY].charAt(nextX) == 'P') return false;
                else q.offer(new Cordi(nextY, nextX));
            }
        }
        return true;
    }

    public static void main(String[] args) {

            String[][] places = {
                    {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                    {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                    {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                    {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                    {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
            };

        거리두기확인하기 test = new 거리두기확인하기();
        int[] solution = test.solution(places);
        for (int i : solution) {
            System.out.println("i = " + i);
        }
    }
}
