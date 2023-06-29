package kakao2021채용연계형인턴십;

import java.util.*;
public class 숫자문자열과영단어 {

    class Solution {
        public int solution(String s) {
            int answer = 0;


            HashMap<String, String> wordList = new HashMap<>();

            wordList.put("zero", "0");
            wordList.put("one", "1");
            wordList.put("two", "2");
            wordList.put("three", "3");
            wordList.put("four", "4");
            wordList.put("five", "5");
            wordList.put("six", "6");
            wordList.put("seven", "7");
            wordList.put("eight", "8");
            wordList.put("nine", "9");

            String temp = "";
            for(int i = 0; i < s.length(); i++){
                char curr = s.charAt(i);

                if(curr < 'a'){ // 숫자
                    temp += String.valueOf(curr);
                }
                else{// 문자
                    String word = "";
                    word += String.valueOf(curr);

                    for(int j = i+1; j < s.length(); j++){
                        word += String.valueOf(s.charAt(j));

                        if(wordList.containsKey(word)){ // key가 있다면
                            temp += wordList.get(word);
                            i = j;
                            break;
                        }
                    }
                }


            }

            // String -> Integer
            for(int i = 0; i < temp.length(); i++){

                answer += Integer.parseInt(String.valueOf(temp.charAt(i))) * Math.pow(10, temp.length() - i-1);
            }

            return answer;
        }


        public int solution2(String s) {

            //영단어를 담는 String 타입의 배열 생성
            //영단어와 배열의 인덱스값이 동일하다.
            String[] arr = {"zero","one","two","three","four","five","six","seven","eight","nine"};

            //반복문을 사용해 배열 안의 모든 영단어를 검사한다.
            //문자열 s에 영단어가 있다면 replace를 사용해 변환한다.
            for(int i=0;i<arr.length;i++) {
                if(s.contains(arr[i])) {
                    s = s.replace(arr[i], Integer.toString(i));
                }
            }
            return Integer.parseInt(s);
        }
    }


    public static void main(String[] args) {
        String temp = "가나다라마";
        System.out.println(temp.indexOf("나"));
        System.out.println(temp.codePointAt(0));
    }
}
