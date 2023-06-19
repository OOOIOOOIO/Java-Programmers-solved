package kakao2019개발자겨울인턴십;
import java.util.*;
import java.util.stream.Collectors;

public class 튜플 {
    public static void main(String[] args) {
        String aa = "{{20,111},{111}}";
        aa.replace("},{", "-");
        ArrayList<Integer> solution = Solution.solution("{{20,111},{111}}");
//        int[] solution = Solution.solution("{{123}}");
//        int[] solution = Solution.solution("{{4,2,3},{3},{2,3,4,1},{2,3}}");
//        int[] solution = Solution.solution("{{2},{2,1},{2,1,3},{2,1,3,4}}");

        System.out.println(solution);
    }



    static class Solution {
        public static ArrayList<Integer> solution(String s) {

            ArrayList<Integer> list = new ArrayList<>();

            s = s.substring(2, s.length()-2); // 앞뒤 {{ }} 제거
            s = s.replace("},{", "-"); // { 이거 split 안됨 -> replace로 바꿈

            String[] temp = s.split("-"); // 1,2,3 형태

            Arrays.sort(temp, (o1, o2) -> o1.length() - o2.length());

            for(String str : temp){
                for(String curr : str.split(",")){
                    if(!list.contains(Integer.parseInt(curr))){
                        list.add(Integer.parseInt(curr));
                    }
                }
            }

            return list;
        }
    }

}
