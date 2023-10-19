package level1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class 문자열내림차순으로배치하기 {

    public static void main(String[] args) {
        String s = "Zbcdefg";

        // 내코드
        String collect = Arrays.stream(s.split(""))
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.joining());

        s.chars()
                .boxed()
                .sorted((v1, v2) -> v2 - v1)
                .collect(StringBuilder::new,
                        StringBuilder::appendCodePoint,
                        StringBuilder::append);

        System.out.println("collect = " + collect);
    }
    public String solution(String s) {
        String answer = "Zbcdefg";

        String collect = Arrays.stream(s.split("")).sorted(Comparator.reverseOrder()).toString();

        return collect;

    }
}
