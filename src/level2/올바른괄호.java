package level2;

import java.util.*;

public class 올바른괄호 {
    boolean solution(String s) {


        Stack<Character> bracketStack = new Stack<>();

        for(char bracket : s.toCharArray()){ // split 보다 toCharArray가 더 빠르네
            if(bracket == '(') bracketStack.add('(');
            else{
                if(bracketStack.isEmpty()) return false;

                bracketStack.pop();

            }
        }

        if(!bracketStack.isEmpty()) return false;


        return true;
    }
}
