package kakao2018BLIND_RECURITMENT;

import java.util.*;
public class 프렌즈4블록_1차 {



    public boolean check(int y, int x, char[][] map){
        char temp = map[y][x];

        if(map[y+1][x] == temp && map[y][x+1] == temp && map[y+1][x+1] == temp) return true;
        else return false;
    }

    public int deleteAndMove(int m, int n, char[][] map, boolean[][] square){
        int cnt = 0;


        for(int i = 0; i < n; i++){ // 열
            Stack<Character> stack = new Stack<>();
            for(int j = 0; j < m; j++){ // 행
                if(square[j][i]){
                    cnt++;
                    square[j][i] = false;
                }
                else{
                    stack.add(map[j][i]);
                }
                map[j][i] = '#';
            }
            int stackSize = stack.size();
            // move and delete
            for(int k = m-1; k > m - stackSize -1; k--){
                map[k][i] = stack.pop();
            }

        }

        return cnt;
    }

    public int solution(int m, int n, String[] board) {
        int answer = 0;

        char[][] map = new char[m][n];
        boolean[][] square = new boolean[m][n];

        for(int i = 0; i < board.length; i++){
            map[i] = board[i].toCharArray();
        }

        boolean flag = true;
        while(flag){

            flag = false;

            for(int i = 0; i < m-1; i++){
                for(int j = 0; j < n-1; j++){
                    if(map[i][j] == '#') continue;
                    if(check(i, j, map)){
                        square[i][j] = true;
                        square[i+1][j] = true;
                        square[i][j+1] = true;
                        square[i+1][j+1] = true;
                        flag = true;

                    }
                }

            }
            if(flag){
                answer += deleteAndMove(m, n, map, square);

                for(int i = 0; i < m; i++){
                    for(int j = 0; j < n; j++){
                        System.out.print(map[i][j] +" ");
                    }
                    System.out.println();
                }
            }

        }


        return answer;
    }

    public static void main(String[] args) {
        프렌즈4블록_1차 test = new 프렌즈4블록_1차();

//        String[] board = new String[] {"CCBDE", "AAADE", "AAABF", "CCBBF"}; // 4, 5
        String[] board = new String[] {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
        int solution = test.solution(6, 6, board);
        System.out.println("solution = " + solution);
    }
}
