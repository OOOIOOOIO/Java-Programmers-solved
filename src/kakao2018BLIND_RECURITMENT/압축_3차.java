package kakao2018BLIND_RECURITMENT;

import java.util.*;
public class 압축_3차 {

    class Solution {
        public int[] solution(String msg) {
            ArrayList<Integer> compress = new ArrayList<>();
            HashMap<String, Integer> dic = new HashMap<>();

            initDic(dic);

            int dicIdx = 27;
            boolean isEnd = false;

            for(int idx = 0 ; idx < msg.length() ; ++idx) {
                String word = msg.charAt(idx) + "";

                while(dic.containsKey(word)){
                    idx++;
                    if(idx == msg.length()) {
                        isEnd = true;
                        break;
                    }
                    word += msg.charAt(idx);
                }

                if(isEnd) {
                    compress.add(dic.get(word));
                    break;
                }

                compress.add(dic.get(word.substring(0, word.length() - 1)));
                dic.put(word, dicIdx++);

                idx--;
            }

            int[] answer = new int[compress.size()];
            for(int i = 0 ; i < answer.length ; ++i){
                answer[i] = compress.get(i);
            }

            return answer;
        }

        public void initDic(HashMap<String, Integer> dic) {
            char ch = 'A';

            for(int i = 1 ; i < 27 ; ++i){
                dic.put(ch + "", i);
                ch += 1;
            }
        }
    }

    public static void main(String[] args) {

    }
}
