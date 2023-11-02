package level1;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class A로B만들기 {

    public int solution(String before, String after) {


        return toMap(after).equals(toMap(before)) ? 1 : 0;
    }

    private static Map<Character, Integer> toMap(String word){
        Map<Character, Integer> map = new HashMap<>();

        for(char c : word.toCharArray()){
            map.putIfAbsent(c, 1);
            map.put(c, map.get(c) + 1);
        }

        //stream 이용
        Map<String, Long> collect = Arrays.stream(word.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return map;
    }

}
