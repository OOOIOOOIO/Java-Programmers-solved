package level2;

public class 이진변환반복하기 {

    static int cnt = 0;
    static int changeCnt = 0;

    public int[] solution(String s) {
        int[] answer = {};

        deleteZero(s);

        answer = new int[]{changeCnt, cnt};

        return answer;


    }

    private static void deleteZero(String s){
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '0') cnt++;
            else sb.append("1");
        }
        changeCnt++;
        change(sb.toString());

    }

    private static void change(String s){

        if(s.length() == 1) return;
        else{
            String str = Integer.toString(s.length(), 2);

            deleteZero(str);
        }

    }

}
