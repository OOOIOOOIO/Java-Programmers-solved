package kakao2021채용연계형인턴십;

import java.util.*;


public class 표편집 {

    Stack<Integer> deleteStack = new Stack<>();
    StringBuilder builder = new StringBuilder();

    public String  logic(int n, int k, String[] cmd){
        int currPointer = k;
        int tableSize = n;

        for(int i = 0; i < cmd.length; i++) {
            char c = cmd[i].charAt(0);

            if(c == 'D')
                currPointer += Integer.parseInt(cmd[i].substring(2));
            else if(c == 'U')
                currPointer -= Integer.parseInt(cmd[i].substring(2));
            else if(c == 'C') {
                deleteStack.add(currPointer);
                tableSize--;
                if(currPointer == tableSize) currPointer--;
            }
            else if(c=='Z') {
                if(deleteStack.pop() <= currPointer) currPointer++;

                tableSize++;
            }
        }

        // 생성
        for(int i = 0; i < tableSize; i++)
            builder.append("O");

        while(!deleteStack.isEmpty())
            builder.insert(deleteStack.pop().intValue(), "X");

        return builder.toString();
    }


    public String solution(int n, int k, String[] cmd) {



        return logic(n, k, cmd);



    }

    public static void main(String[] args) {
        표편집 test = new 표편집();
        String solution = test.solution(8, 2, new String[]{"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z"});
        System.out.println("solution = " + solution);
        System.out.println();
        String a = "111";
        System.out.println((a.charAt(1) - '0') + 10 + 200);
        HashMap<Integer, Integer> id = new HashMap<>();

    }
}
