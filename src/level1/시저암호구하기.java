package level1;

public class 시저암호구하기 {

    public String solution(String s, int n) {
        // 공백 검사
        char[] arr = s.toCharArray();


        String solve = solve2(arr, n);

        return solve;
    }

    public String solve2(char[] arr, int n){
        StringBuilder sb = new StringBuilder();
        for(char c : arr){
            if(Character.isAlphabetic(c)){
                int offset = Character.isUpperCase(c) ? 'A' : 'a'; // 기준 구하기 : 대문자면 A시작, 소문자면 a시작
                int position = c - offset; // 현재 위치 구하기
                position = (position + n) % ('Z' - 'A' + 1); // 이동

                char curr = (char)(offset + position); // 변환

                sb.append(curr);
            }
            else{
                sb.append(" ");
            }


        }

        return sb.toString();
    };



    public String solve1(char[] arr, int n){
        StringBuilder sb = new StringBuilder();


        for(char item : arr) {
            if(item ==  ' ') {
                sb.append(" ");
                continue;
            }
            else {
                // 소문자
                if(122 >= item && item >= 97) {
                    // 범위를 벗어날 경우
                    if(item + n > 122) {
                        sb.append((char)(item - 26 + n));
                    }
                    else {
                        sb.append((char)(item + n));
                    }
                }
                // 대문자
                else if(90 >= item && item >= 65) {
                    // 범위를 벗어날 경우
                    if(item + n > 90) {
                        sb.append((char)(item - 26 + n));
                    }
                    else {
                        sb.append((char)(item + n));
                    }
                }
            }
        }

        return sb.toString();

    }

}
