import java.util.*;

public class 과일장수 {
        public int solution(int k, int m, int[] score) {
            int answer = 0;
            
            Integer[] temp = Arrays.stream(score)
                    .boxed()
                    .toArray(Integer[]::new);

            Arrays.sort(temp, (a, b) -> b-a);

            int boxNum = temp.length / m;

            Integer[][] box = new Integer[boxNum][m];



            int n = 0;
            for(int i = 0; i < boxNum; i++){
                for(int j = 0; j < m; j++){
                    box[i][j] = temp[n];
                    n++;
                }
            }



            for(int i = 0; i < boxNum; i++){
                    answer += (box[i][m-1] * m);
            }

            return answer;
        }
}
