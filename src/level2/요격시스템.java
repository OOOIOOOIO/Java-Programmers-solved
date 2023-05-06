package level2;

import java.util.Comparator;
import java.util.PriorityQueue;

public class 요격시스템 {

    public static void main(String[] args) {
        int[][] targets = new int[][] {{4,5}, {4,8},{10,14},{11,13},{5,12},{3,7},{1,4}};

        int solution = solution(targets);
        System.out.println("solution = " + solution);
    }

    public static int solution(int[][] targets) {
        int answer = 0;

        /**
         * 끝나는 위치로 정렬시키기
         */
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> {
            if(o1[1] == o2[1]) return o1[0]-o2[0];
            return o1[1] - o2[1];
        });

        /**
         * 추가
         */
        for (int[] ar : targets) {
            queue.offer(ar);
        }

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            System.out.println("poll = " + poll[0] + " " + poll[1]);
        }
        /**
         * 비교 후 같거나 작다면 +1 아니라면 계속 돌리기
         */
        int[] before = queue.poll(); // 첫번째
        answer++;
        while(!queue.isEmpty()){


            if (!queue.isEmpty()) {
                int[] after = queue.poll();

                if (before[1] <= after[0]) {
                    answer++;
                    before = after;

                }
            }
        }

        return answer;
    }
}
