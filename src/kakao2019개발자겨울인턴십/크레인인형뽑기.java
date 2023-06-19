package kakao2019개발자겨울인턴십;
import java.util.*;

public class 크레인인형뽑기 {

    static class Solution {
        static Stack<Integer> stack = new Stack<>();
        public int solution(int[][] board, int[] moves) {
            int answer = 0;

            // 뽑기
            for(int i = 0; i < moves.length; i++){
                for(int j = 0; j < board.length; j++){
                    if(board[j][moves[i] - 1] != 0){

                        // 비어있는 경우(처음)
                        if (stack.isEmpty()) {
                            stack.push(board[j][moves[i] - 1]);
                        }
                        else{
                            int before = stack.peek();

                            if (before == board[j][moves[i] - 1]) {
                                stack.pop();
                                answer += 2;

                            }
                            else{
                                // push
                                stack.push(board[j][moves[i] - 1]);

                            }
                        }
                        board[j][moves[i] - 1] = 0;
                        break;
                    }
                }
            }

            return answer;
        }

    }
}
