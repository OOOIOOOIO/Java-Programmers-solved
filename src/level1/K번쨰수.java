package level1;

import java.util.Arrays;

public class K번쨰수 {

    public static void main(String[] args) {

    }

    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int i = 0; i < commands.length; i++){
            int[] command = commands[i];

            int from = command[0]-1;
            int to = command[1]-1;
            int findIdx = command[2]-1;

            int[] copy = Arrays.copyOfRange(array, from, to);
            Arrays.sort(copy);

            answer[i] = copy[findIdx];
        }

        return answer;
    }
}
