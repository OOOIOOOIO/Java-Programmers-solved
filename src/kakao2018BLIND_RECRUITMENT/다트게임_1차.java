package kakao2018BLIND_RECRUITMENT;

import java.util.*;

public class 다트게임_1차 {

    public int solution(String dartResult) {
        int answer = 0;
        int idx = 0;

        HashMap<Integer, Integer> scoreMap = new HashMap<>();
        int prevIdx = -1;

        for (int i = 0; i < dartResult.length(); i++) {
            char curr = dartResult.charAt(i); //현재 문자

            int currScore = 0;
            boolean flag = false;


            if (curr == 'S') { // ^1
                currScore = (int) Math.pow(Integer.parseInt(dartResult.substring(prevIdx+1, i)), 1);
                flag = true;

            } else if (curr == 'D') { // ^2
                currScore = (int) Math.pow(Integer.parseInt(dartResult.substring(prevIdx+1, i)), 2);
                flag = true;

            } else if (curr == 'T') { // ^3
                currScore = (int) Math.pow(Integer.parseInt(dartResult.substring(prevIdx+1, i)), 3);
                flag = true;

            } else if (curr == '*') { // 현재, 이전 *2
                currScore = scoreMap.get(idx-1);
                if (idx-1 == 0) { // 처음이라면
                    scoreMap.put(idx-1, currScore * 2);
                } else {
                    int prevScore = scoreMap.get(idx - 2);
                    scoreMap.put(idx-1, currScore * 2);
                    scoreMap.put(idx - 2, prevScore * 2);
                }
                prevIdx = i;

            } else if (curr == '#') { // 현재 * -1
                currScore = scoreMap.get(idx-1) * -1;
                scoreMap.put(idx-1, currScore);
                prevIdx = i;

            }
            if(flag){
                System.out.println("currScore = " + currScore);
                scoreMap.put(idx, currScore);
                prevIdx = i;
                idx++;
            }



        }

        for (int key : scoreMap.keySet()) {
            System.out.println(key +":" +scoreMap.get(key));
            answer += scoreMap.get(key);
        }

        return answer;
    }

    public static void main(String[] args) {
        다트게임_1차 test = new 다트게임_1차();
        int solution = test.solution("1D2S#10S");
        System.out.println("solution = " + solution);



    }
}
