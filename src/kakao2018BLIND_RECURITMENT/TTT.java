package kakao2018BLIND_RECURITMENT;

import java.util.Stack;

public class TTT {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.add(1);
        stack.add(2);
        stack.add(3);
        stack.add(4);

        for (int i = 4; i > 0; i--) {
            System.out.println(stack.pop());
        }
    }
}
