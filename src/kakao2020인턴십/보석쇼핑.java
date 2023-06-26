package kakao2020인턴십;

import java.util.*;

public class 보석쇼핑 {

    static class Solution{
        static HashSet<String> gemType;
        static  HashMap<String, Integer> gemCnt = new HashMap<>();
        static int front = 0;
        static int rear = 0;
        static int start = 0;
        static int end = 0;
        static int len = Integer.MAX_VALUE;

        public static int[] solution(String[] gems){

            gemType = new HashSet<>(Arrays.asList(gems));

            // 보석 종류
            for(String gem : gems){
                if(gemType.contains(gem)) continue;
                gemType.add(gem);
            }



            while(true){

                if(gemCnt.size() == gemType.size()){ // 개수가 같다는 것은 다 찾았다는 뜻 -> front 한 칸 이동
                    gemCnt.put(gems[front], gemCnt.get(gems[front]) -1);
                    if(gemCnt.get(gems[front]) == 0){
                        gemCnt.remove(gems[front]); // 없으니 삭제
                    }

                    front++; //이동

                }
                else if(rear == gems.length){ // 끝까지 갔으면 끝
                    break;
                }
                else{ // 추가하기
                    gemCnt.put(gems[rear], gemCnt.getOrDefault(gems[rear++], 0) + 1);
                }

                if(rear - front < len && gemCnt.size() == gemType.size()){ // 최소 길이 구간 + 새로운 구간
                    len = rear - front;
                    start = front + 1; // 1부터 시작
                    end = rear;
                }


            }

            return new int[]{start, end};
        }


    }

    public static void main(String[] args) {
//        String[] gems = {"A", "B" ,"B", "C", "A", "B", "C", "A","B","C"};
        String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
        int[] solution = Solution.solution(gems);

        for (int i : solution) {
            System.out.println("i = " + i);
        }
    }

}


