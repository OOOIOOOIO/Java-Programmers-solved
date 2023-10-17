package level3;

import java.util.ArrayList;
import java.util.List;

public class 하노이의탑 {

    public static void main(String[] args) {
        List<int[]> process = new ArrayList<>();
        process.toArray(new int[0][]);
        System.out.println();
    }

    public int[][] solution(int n) {
        int[][] answer = {};
        List<int[]> process = new ArrayList<>();

        hanoi(n, 1, 3, process);

        return process.toArray(new int[0][]); // 2차원 배열로 전환

    }

    private void hanoi(int n, int from, int to, List<int[]> process){
        if(n == 1){
            System.out.println("n : " + n + " from : " + from + " to : " + to);
            process.add(new int[]{from, to});
            return;
        }

        int empty = 6 - from - to;
        hanoi(n-1, from, empty, process);
        hanoi(1, from, to, process);
        hanoi(n-1, empty, to, process);

    }
}
