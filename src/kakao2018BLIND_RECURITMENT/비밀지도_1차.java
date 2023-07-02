package kakao2018BLIND_RECURITMENT;

import java.util.*;

public class 비밀지도_1차 {
    public int[] parsing(int n, int num){
        int[] map = new int[n];

        for(int i = n-1; i >= 0; i--){
            int q = num % 2;
            num /= 2;
            map[i] = q;

        }
        System.out.println();
        for(int i = 0; i < n; i++){
            System.out.print(map[i]);
        }

        return map;

    }

    public String printMap(int n, int[] map1, int[] map2){
        StringBuilder sb = new StringBuilder();


        for(int i = 0; i < n; i++){

            if(map1[i] == 1 || map2[i] == 1){
                sb.append("#");
            }
            else{
                sb.append(" ");
            }

        }

        return sb.toString();
    }



    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        int idx = 0;

        for(int i = 0; i < n; i++){

            int[] map1 = parsing(n, arr1[i]);
            int[] map2 = parsing(n, arr2[i]);

            String str = printMap(n, map1, map2);
            answer[i] = str;
        }




        return answer;
    }

    public static void main(String[] args) {

    }
}
