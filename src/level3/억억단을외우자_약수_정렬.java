package level3;

import java.util.*;

public class 억억단을외우자_약수_정렬 {

    public static void main(String[] args) {
        int[] starts = new int[]{1, 3, 7};
        int e = 8;

        int[] starts1 =solution(e, starts);

        for (int i : starts1) {
            System.out.println("i = " + i);
        }

    }

    public static int[] solution(int e, int[] starts){
        Point[] dp = new Point[e+1];

        for(int i=0; i<=e; i++){
            dp[i] = new Point(i, 0);
        }

        //배수 세기
        for(int i=1; i<=e; i++){
            for(int j=i; j<=e; j+=i){
                dp[j].cnt++;
            }
        }

        //약수 개수 내림차순
        Arrays.sort(dp, (o1, o2) -> {
            if(o1.cnt < o2.cnt) return 1;
            else if(o1.cnt > o2.cnt){
                return -1;
            }
            else {
                //작은 숫자 반환
                if(o1.num > o2.num) return 1;
                else if(o1.num < o2.num) return -1;
                else return 0;
            }
        });

        int[] answers = new int[starts.length];

        for(int i = 0; i < starts.length; i++){
            for(int j = 0; j <= e; j++){
                if(starts[i] <= dp[j].num){
                    answers[i] = dp[j].num;
                    break;
                }
            }
        }

        return answers;
    }

    static class Point{
        int num, cnt;
        Point(int num, int cnt){
            this.num = num;
            this.cnt = cnt;
        }
    }


}
