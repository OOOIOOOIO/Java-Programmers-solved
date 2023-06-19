package kakao2019개발자겨울인턴십;

import java.util.*;

public class 징검다리건너기 {

    public static int solution(int[] stones, int k){
        int min = 1;
        int max = 200000000;

        for (int stone : stones) {
            min = Math.min(min, stone);
            max = Math.max(max, stone);
        }

        // 이분탐색으로 최댓값을 구한다 -> min이 올라완다
        while(min < max){
            int mid = (min + max + 1) / 2;

            if (isPossible(mid, k, stones)) {
                min = mid;
            }
            else{
                max = mid -1;
            }
        }

        return max;

    }

    public static boolean isPossible(int mid, int k, int[] stones){
        int cnt = 0;
        for (int stone : stones) {
            // 0보다 작다면 넘을 수 없는 징검다리
            // 0이거나 0보다 크다면 mid번째는 건널 수 있다는 뜻
            if(stone - mid < 0){
                cnt++;
            }
            else{
                cnt = 0;
            }

            if(cnt == k){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
        int k = 3;

        int solution = solution(stones, k);
        System.out.println("solution = " + solution);
    }


}
