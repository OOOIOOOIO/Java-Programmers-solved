package level2;

import java.util.Arrays;
import java.util.Comparator;

public class T {
	
	public static void main(String[] args) {
		

        StringBuilder sb = new StringBuilder();
        sb.reverse().toString();
        System.out.println('z' - 'a');
        System.out.println('a'-'0');
        System.out.println('z'-'0');

        Integer[] integers = Arrays.stream(new int[]{1, 2, 3,})
                .boxed()
                .sorted(Comparator.reverseOrder())
                .toArray(Integer[]::new);

    }
	

		
}

