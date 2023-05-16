package level2;

public class 두원사이의정수쌍 {
    public static void main(String[] args) {
        System.out.println((int)Math.sqrt(2));
        int r1 = 1;
        int r2 = 1;
        // (x-a)^2 + (y-b)^2 = r^2 원의 방정식
        long answer = 0;
        // 2중 포문으로 했는데 시간초과 나와서 뒤적거리다 이게 젤 나이스한 풀이갔아서 가져옴
        for (int i=1; i<=r2; i++) { // 1부터 시작하여 상하 중복 없앰, 테두리 체크를 올림 내림으로 함
            long maxJ = (int) Math.floor(Math.sqrt(1.0*r2*r2 - 1.0*i*i));
            long minJ = (int) Math.ceil(Math.sqrt(1.0*r1*r1 - 1.0*i*i));

            answer += (maxJ - minJ + 1);

        }


    }


}

