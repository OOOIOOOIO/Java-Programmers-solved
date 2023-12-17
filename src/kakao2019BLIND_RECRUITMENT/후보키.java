package kakao2019BLIND_RECRUITMENT;

import java.util.*;

/**
 * 비트마스크
 */
public class 후보키 {
    //비트를 담는 list.
    List<Integer> answer = new ArrayList<>();

    public int solution(String[][] relation) {
        int n = relation.length;
        int m = relation[0].length;

        //조합을 만들어내는 for loop
        for (int i = 1; i < 1 << m; i++) { // 컬럼 수만큼
            Set<String> set = new HashSet<>();
            //배열의 전체를 도는 for loop
            for(int j = 0; j < n; j++){ // 행
                String temp = "";
                //배열의 요소를 도는 for loop
                for(int k = 0; k < m; k++){ // 열
                    if((i & 1 << k) > 0){
                        temp += (relation[j][k]);
                    }
                }
                set.add(temp);
            }
            //유일성을 만족하고 최소성을 만족한다면
            if(set.size() == n && check(i)){
                answer.add(i);
            }
        }
        return answer.size();
    }
    boolean check(int i) {
        for (int j : answer) {
            // i & j == j의 의미는 i가 j의 부분집합인지에 대한 여부를 묻는 것.
            if ((i & j) == j) return false;
        }
        return true;
    }


}
