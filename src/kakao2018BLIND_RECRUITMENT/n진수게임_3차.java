package kakao2018BLIND_RECRUITMENT;

public class n진수게임_3차 {

    public String solution(int n, int t, int m, int p) {


        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        // 진수 변환해서 붙이기
        for(int i = 0; sb.length() < m * t; i++){
            sb.append(Integer.toString(i, n));
        }

        // 내가 할 것만 고르기, 0 부터 시작
        for(int i = p-1; sb2.length() < t; i += m){
            sb2.append(sb.toString().charAt(i));
        }

        String answer = sb2.toString().toUpperCase();
        return answer;
    }
    public static void main(String[] args) {
        String s = Integer.toString(11, 16);
        StringBuilder sb = new StringBuilder();

        System.out.println("args = " + s);


    }
}
