package level2;

import java.util.*;

public class 괄호회전하기 {
    static Stack<Character> bStack = new Stack<>();

    public int solution(String s) {
        int answer = 0;

        int zero = 0;
        char[] brackets = s.toCharArray();
        int end = s.length();

        for(int start = 0; start < s.length(); start++){
            if(isRight(brackets, start, zero, end)) answer++;
        }


        return answer;
    }

    //문자열이 알맞은 괄호인지
    private boolean isRight(char[] brackets, int start, int zero, int end){
        // start ~ end
        for(int i = start; i < end; i++){
            if(brackets[i] == '('){
                bStack.add(')');
            }
            else if(brackets[i] == '['){
                bStack.add(']');
            }
            else if(brackets[i] == '{'){
                bStack.add('}');
            }
            else{
                if(bStack.isEmpty()) return false;

                char temp = bStack.pop();
                if(temp != brackets[i]) return false;
            }
        }

        // zero ~ start
        for(int i = zero; i < start; i++){
            if(brackets[i] == '(' || brackets[i] == '[' || brackets[i] == '{') bStack.add(brackets[i]);
            else{
                if(bStack.isEmpty()) return false;

                bStack.pop();
            }
        }

        if(!bStack.isEmpty()) return false;

        return true;
    }
}
