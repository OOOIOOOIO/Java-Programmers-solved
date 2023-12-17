package kakao2019BLIND_RECRUITMENT;

import java.util.*;
public class 실패율 {

    class Failure{
        int idx;
        double score;

        public Failure(int idx, double score){
            this.idx = idx;
            this.score = score;
        }
    }
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];

        int[] temp = new int[N+2];
        ArrayList<Failure> list = new ArrayList<>();

        for(int stage : stages){ // 멈춘stage 구함
            temp[stage]++;
        }

        int totalPlayer = stages.length;

        for(int i = 1; i <= N; i++){
            if(totalPlayer > 0){
                System.out.println(i + " : " + temp[i] + " | " + totalPlayer);
                System.out.println(i + " : " +(double)temp[i] / (double)totalPlayer);
                list.add(new Failure(i, (double)temp[i] / (double) totalPlayer));
                totalPlayer -= temp[i];


            }
            else{
                System.out.println(i + " : " + temp[i] + " | " + totalPlayer);
                list.add(new Failure(i, 0));
            }

        }

        Collections.sort(list, (o1, o2) -> {
            if(o1.score == o2.score){
                return o1.idx - o2.idx;
            }
            else{
                return Double.compare(o2.score, o1.score);
            }
        });


        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i).idx;
        }
        return answer;
    }


    public static void main(String[] args) {
        실패율 test = new 실패율();

        int[] stages = new int[]{2, 1, 2, 6, 2, 4, 3, 3};
        int N = 5;

        int[] solution = test.solution(N, stages);


    }
}
