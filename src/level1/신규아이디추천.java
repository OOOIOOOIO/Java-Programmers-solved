package level1;

public class 신규아이디추천 {
	public static void main(String[] args) {
				
		String str = "...!@BaT#*..y.abcdefghijklm";
		System.out.println(solution(str));
	}

	public static String solve2(String new_id){

		//1단계
		new_id = new_id.toLowerCase();
		System.out.println(new_id);

		//2단계, -는 escape sequence니까 \\ 붙인다.
		new_id = new_id.replaceAll("[^a-z0-9\\-_.]", "");
		System.out.println(new_id);

		//3단계
		new_id = new_id.replaceAll("\\.+", ".");
		System.out.println(new_id);

		//4단계, . escape sequence이지만 위에는 내부의 문자 중 1개라는 의미에서 \\를 안붙이고 여긴 .밖에 없으니 \\을 붙인다.
		new_id = new_id.replaceAll("^\\.+|\\.+$", "");
		System.out.println(new_id);

		//5단계
		if(new_id.equals("")) new_id = "a";
		System.out.println(new_id);

		//6단계
		if(new_id.length() >= 16){
			new_id = new_id.substring(0, 15);
			new_id = new_id.replaceAll("\\.+$", "");

		}
		System.out.println(new_id);
		//7단계
		while(new_id.length() < 3){
			new_id += new_id.charAt(new_id.length()-1);
		}
		System.out.println(new_id);

		return new_id;

	}
	 public static String solution(String new_id) {
	        String answer;
	        
	        // 1단계
	        String step1 = new_id.toLowerCase();

	        // 2단계
	        char[] step1_arr = step1.toCharArray();
	        StringBuilder step2 = new StringBuilder();
	        for (char c : step1_arr) {
	            if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9') || c == '-' || c == '_' || c == '.') {
	                step2.append(c);
	            }
	        }

	        // 3단계
	        String step3 = step2.toString().replace("..", ".");
	        while (step3.contains("..")) {
	            step3 = step3.replace("..", ".");
	        }

	        // 4단ㅋ
	        String step4 = step3;
	        if (step4.length() > 0) {
	            if (step4.charAt(0) == '.') {
	                step4 = step4.substring(1, step4.length());
	            }
	        }
	        if (step4.length() > 0) {
	            if (step4.charAt(step4.length() - 1) == '.') {
	                step4 = step4.substring(0, step4.length() - 1);
	            }
	        }

	        // 5단계
	        String step5 = step4;
	        if (step5.equals("")) {
	            step5 = "a";
	        }

	        // 6단계
	        String step6 = step5;
	        if (step6.length() >= 16) {
	            step6 = step6.substring(0, 15);

	            if (step6.charAt(step6.length() - 1) == '.') {
	                step6 = step6.substring(0, step6.length() - 1);
	            }
	        }

	        // 7단계
	        StringBuilder step7 = new StringBuilder(step6);
	        if (step7.length() <= 2) {
	            char last = step7.charAt(step7.length() - 1);

	            while (step7.length() < 3) {
	                step7.append(last);
	            }
	        }
	        System.out.println(step1);
	        System.out.println(step2);
	        System.out.println(step3);
	        System.out.println(step4);
	        System.out.println(step5);
	        System.out.println(step6);
	        System.out.println(step7);
	        answer = String.valueOf(step7);
	        return answer;
	    }
}
