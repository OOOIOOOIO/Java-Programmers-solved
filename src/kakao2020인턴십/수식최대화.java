package kakao2020인턴십;
import java.util.*;

public class 수식최대화 {

    static class Solution{
        static ArrayList<String> expList = new ArrayList<String>();
        static String[][] priority = {
                {"+", "-", "*"},
                {"+", "*", "-"},
                {"-", "+", "*"},
                {"_", "*", "+"},
                {"*", "-", "+"},
                {"*", "+", "-"},
        };


        public static long solution(String expression){
            System.out.println(priority[0].length);
            System.out.println(priority.length);
            long answer = 0;


            // 파싱
            int front = 0;
            for(int i = 0; i < expression.length(); i++){
                char temp = expression.charAt(i);

                if(temp == '+' || temp == '-' || temp == '*'){
                    expList.add(expression.substring(front, i)); // 앞 숫자
                    expList.add(expression.substring(i, i+1)); // 연산자

                    front = i+1;
                }

            }
            // 맨 마지막 숫자
            expList.add(expression.substring(front, expression.length()));

            // 검사
            Long max = Long.MIN_VALUE;
            for(int i = 0 ; i < priority.length; i++){

                ArrayList<String> cloneList = new ArrayList<String>(expList); // 복사해주기
                for(int j = 0; j < priority[0].length; j++){
                    for(int k = 0; k < cloneList.size(); k++){ // k = 0 해주자, k -1
                        if(cloneList.get(k).equals(priority[i][j])){ // 우선순위 연산자라면
                            String result = cal(cloneList.get(k-1), cloneList.get(k), cloneList.get(k+1));
                            cloneList.remove(k);
                            cloneList.remove(k); // 하나씩 땡겨지니까 그대로
                            cloneList.set(k-1, result); // replace랑 같음
                            k -= 1;

                        }
                    }
                }
                max = Math.max(max, Math.abs(Long.parseLong(cloneList.get(0))));
            }


            answer = max;
            return answer;

        }

        static String cal(String num1, String op, String num2){
            long n1 = Long.parseLong(num1);
            long n2 = Long.parseLong(num2);

            if(op.equals("+")){
                return String.valueOf(n1 + n2);
            }
            else if(op.equals("-")){

                return String.valueOf(n1 - n2);
            }


            return String.valueOf(n1 * n2);
        }


    }

    public static void main(String[] args) {
        long solution = Solution.solution("100-200*300-500+20");

        System.out.println("solution = " + solution);
    }

}


