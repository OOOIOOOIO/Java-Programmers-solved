package level1;

import java.util.*;
import java.util.stream.*;

public class 중복된문자제거 {

    public String solution(String my_string) {

        Set<String> link = new LinkedHashSet<>();

        for(String str : my_string.split("")){
            link.add(str);
        }
        String answer = link.stream()
                .collect(Collectors.joining());

        return answer;
    }

}
