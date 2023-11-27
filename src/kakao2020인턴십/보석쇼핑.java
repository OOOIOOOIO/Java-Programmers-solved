package kakao2020인턴십;

import java.util.*;

public class 보석쇼핑 {

    class Solution {

        int front = 0;
        int rear = 0;
        int start = 0;
        int end = 0;
        int length = Integer.MAX_VALUE;

        public int[] solution(String[] gems) {


            Set<String> gemType = new HashSet<>(Arrays.asList(gems));
            Map<String, Integer> gemCount = new HashMap<>();


            return find(gems, gemType, gemCount);


        }

        public int[] find(String[] gems, Set<String> gemType, Map<String, Integer> gemCount){


            while(true){
                if(gemType.size() == gemCount.size()){// 새로운 구조 찾기 위해 움직이기
                    String currGem = gems[front];

                    gemCount.put(currGem, gemCount.get(currGem) -1);

                    if(gemCount.get(currGem) == 0){
                        gemCount.remove(currGem);
                    }

                    front++; // 움직이기

                }
                else if(rear == gems.length){ // 종료
                    break;
                }
                else{ // 추가
                    gemCount.put(gems[rear], gemCount.getOrDefault(gems[rear], 0) +1);
                    rear++; // 움직이기
                }

                //길 다 찾으면 기록하기, 이때 길이 확인 -> 최소길이
                if(rear - front < length && gemType.size() == gemCount.size()){
                    length = rear - front;
                    start = front+1;
                    end = rear;
                }

            }

            return new int[]{start, end};

        }


    }

    public static void main(String[] args) {
//        String[] gems = {"A", "B" ,"B", "C", "A", "B", "C", "A","B","C"};
        String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
    }

}


