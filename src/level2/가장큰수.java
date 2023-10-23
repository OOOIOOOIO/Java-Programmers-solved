package level2;

import java.util.Arrays;

public class 가장큰수 {

    public static void main(String[] args) {
//        int[] numbers = new int[]{3, 30, 34, 5, 9};
        int[] numbers = new int[]{3, 30, 34, 5, 9, 99, 9999, 30000, 555};

        Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .sorted((s1, s2) -> {
                    int original = Integer.parseInt(s1 + s2);
                    System.out.println("original = " + original);
                    int reversed = Integer.parseInt(s2 + s1);
                    System.out.println("reversed = " + reversed);
                    System.out.println();
                    return original - reversed;
//                    return reversed - original; // s1이 s2 보다 더 크다는 뜻... s1이 더 뒤로 정렬된다(내림차순)

                })
                .forEach(System.out::println);
    }
}

/**
 * return revered - original일 경우
 *
 * 9
 * 99
 * 9999
 * 5
 * 555
 * 34
 * 3
 * 30
 * 30000
 *
 * ==========
 *
 * return original - reveresd일 경우
 *
 * 30000
 * 30
 * 3
 * 34
 * 5
 * 555
 * 9
 * 99
 * 9999
 */