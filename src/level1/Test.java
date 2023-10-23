package level1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) throws IOException {
        int[] test = new int[]{5,4,2,6,8,2,10};
        int[][] test2 = new int[][]{
                {10,2,7,},
                {8,5,13},
                {5,3,1}
        };

        //1차원 int -> Integer 내침사준정렬
        Integer[] integers = Arrays.stream(test)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .toArray(Integer[]::new);

        //2차원 int 배열

//        Arrays.sort(test2, (o1, o2) -> o2[0] - o1[0]);
        Arrays.sort(test2, (o1, o2) -> o1[2] - o2[2]);

        for(int i = 0; i < test2.length; i++){
            for(int j = 0; j < test2[0].length; j++){
                System.out.print(test2[i][j]+" ");
            }
            System.out.println();
        }

        System.out.println();
        for (Integer integer : integers) {
            System.out.println("integer = " + integer);
        }

        System.out.println();
        String[] strings = new String[]{"aasdfafd", "sbdbfb", "2eqwr", "azxc", "Asdag"};


        String[] strings1 = Arrays.stream(strings)
                .sorted()
                .toArray(String[]::new);

        for (String s : strings1) {
            System.out.println("s = " + s);
        }

        System.out.println();

        System.out.println("A".compareTo("B"));
        System.out.println("B".compareTo("B"));
        System.out.println("B".compareTo("A"));

        System.out.println();

        System.out.println(Integer.compare(1, 2));
        System.out.println(Integer.compare(1, 1));
        System.out.println(Integer.compare(2, 1));

        System.out.println();

        System.out.println("9".compareTo("34"));
        System.out.println("1".compareTo("2"));


    }
}
