package kakao2018BLIND_RECRUITMENT;


import java.util.*;
public class 뉴스클러스터링_1차 {

    public ArrayList<String> divide(String str){
        ArrayList<String> list = new ArrayList<>();

        for(int i = 0; i < str.length()-1; i++){
            char first = str.charAt(i);
            char second = str.charAt(i+1);

            if(first >= 'a' && first <= 'z'){
                if(second >= 'a' && second <= 'z'){
                    String temp = str.substring(i, i+2);
                    list.add(temp);
                }
                else{
                    i++;
                }
            }

        }

        return list;
    }
    public int solution(String str1, String str2) {
        ArrayList<String> union = new ArrayList<>();
        ArrayList<String> intersection = new ArrayList<>();
        int answer = 0;

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();



        ArrayList<String> list1 = divide(str1);
        ArrayList<String> list2 = divide(str2);

        // 중복 원소 처리를 위해 두 집합 정렬
        Collections.sort(list1);
        Collections.sort(list2);

        // 교집합 구하기
        for(String s : list1) {
            if(list2.remove(s)) { // 집합1에 집합2가 포함된다면 삭제후, 교집합에 추가
                intersection.add(s);
            }
            union.add(s);
        }

        // 합집합 구하기
        for(String s : list2) { // 교집합에서 제외된 것 뺀 나머지 합집합에 추가
            union.add(s);
        }

        // 자카드 유사도 구하기
        double a = intersection.size();
        double b = union.size();

        double jakard = 0;

        if(union.size() == 0)
            jakard = 1;	// 공집합일 경우 1
        else
            jakard = (double) intersection.size() / (double) union.size();

        return (int) (jakard * 65536);
    }

    public static void main(String[] args) {

//        String str1 ="AAbbaa_AAbb";
//        String str2="BBB";
        String str1 = "abab"; // ab ba ab == 3
        String str2 = "baba"; // ba ab ba == 3

        뉴스클러스터링_1차 test = new 뉴스클러스터링_1차();

        int solution = test.solution(str1, str2);
        System.out.println("solution = " + solution);

    }
}
