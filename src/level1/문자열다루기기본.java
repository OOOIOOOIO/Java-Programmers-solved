package level1;

public class 문자열다루기기본 {

    public static boolean solve(String s){
        return s.matches("[0-9]{4}|[0-9]{6}");
    }

    public static boolean solve2(String s){

        if(s.length() == 4 || s.length() == 6) {

            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);

                if(ch < '0' || ch > '9') return false;
            }

            return true;

        }
        else return false;


    }

}
