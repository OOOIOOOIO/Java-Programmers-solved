package level2;

import java.util.*;

public class 주식가격 {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();



        for(int i = 0; i < prices.length; i++){

            while(!stack.isEmpty() && prices[stack.peek()] > prices[i]){ //더 클 경우
                int idx = stack.pop();
                answer[idx] = i - idx;

            }

            stack.add(i);

        }

        fill(stack, prices, answer);

        return answer;
    }

    private void fill(Stack<Integer> stack, int[] prices, int[] answer){
        while(!stack.isEmpty()){
            int idx = stack.pop();
            answer[idx] = prices.length - idx - 1;
        }
    }
}
