package kakao2018BLIND_RECRUITMENT;

import java.util.*;
public class 캐시_1차 {

    public int solution(int cacheSize, String[] cities) {
        int answer = 0;

        if(cacheSize == 0){
            return 5 * cities.length;
        }

        LinkedList<String> cacheList = new LinkedList<>();

        for(String rawCity : cities){
            String city = rawCity.toLowerCase();

            if(cacheList.size() < cacheSize){
                if(cacheList.contains(city)){
                    cacheList.remove(city);
                    cacheList.add(city);
                    answer += 1;
                }
                else{
                    cacheList.add(city);
                    answer += 5;
                }


            }
            else{
                if(cacheList.contains(city)){
                    cacheList.remove(city);
                    cacheList.add(city);
                    answer += 1;
                }
                else{
                    cacheList.remove(0);
                    cacheList.add(city);

                    answer += 5;

                }

            }


        }





        return answer;
    }

    public static void main(String[] args) {
        LinkedList<String> test2 = new LinkedList<>();
        test2.add("1");
        test2.add("2");
        test2.add("3");

        String a = "aa";
        a.toLowerCase();

        test2.remove("2");
        test2.add("2");

        for(int i = 0; i < test2.size(); i++){
            System.out.println("test2.get(i) = " + test2.get(i));
//            System.out.println(test2.peek());
        }

    }
}
