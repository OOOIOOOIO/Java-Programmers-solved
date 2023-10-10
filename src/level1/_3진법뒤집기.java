package level1;

public class _3진법뒤집기 {

    public int solution(int n) {
        int answer = 0;

        String str = Integer.toString(n, 3); // String을 3진법으로 변환

        StringBuilder sb = new StringBuilder(str);


        String reStr = sb.reverse().toString(); // 뒤집기

        int result = Integer.valueOf(reStr, 3); // 문자열을 3진법으로 변환한 것을 10진법으로 표현

        return result;
    }

}
