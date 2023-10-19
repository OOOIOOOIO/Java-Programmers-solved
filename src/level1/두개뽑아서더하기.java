package level1;

import java.util.*;

public class 두개뽑아서더하기 {

    public int[] solution(int[] numbers) {

        Set<Integer> saveSet = new HashSet<>();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                saveSet.add(numbers[i] + numbers[j]);
            }
        }

        // 평균 7ms
        // int[] ints = saveSet.stream()
        // .mapToInt(Integer::intValue)
        // .sorted()
        // .toArray();

        // 아래가 더 빠르네 평균 2ms, mapToInt하면 평균 3.5ms
        List<Integer> saveList = new ArrayList<>(saveSet);
        Collections.sort(saveList);
        // Integer[] integers = saveList.toArray(Integer[]::new);

        int[] objects = saveList.stream().mapToInt(Integer::intValue).toArray();
        // int[] objects = saveList.stream().toArray(Integer[]::new);

        return objects;
        // return integers;
        // return ints;
    }

}
