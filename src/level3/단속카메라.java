package level3;

import java.util.*;
public class 단속카메라 {
    public int solution(int[][] routes) {
        Arrays.sort(routes, Comparator.comparingInt(route -> route[1]));

        // for(int i = 0; i < routes.length; i++){
        //     System.out.println(routes[i][0] + " " + routes[i][1]);
        // }

        int count = 0;
        int last = Integer.MIN_VALUE;

        for (int[] route : routes) {
            // System.out.println(last);
            if (last >= route[0] && last <= route[1]) continue;
            last = route[1];
            count++;
        }
        return count;
    }
}
