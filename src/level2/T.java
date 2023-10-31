package level2;

import java.util.*;

public class T {
	
	public static void main(String[] args) {

        Map<String, List<Integer>> list = new HashMap<>();

        StringBuilder sb = new StringBuilder();
        sb.reverse().toString();
        System.out.println('z' - 'a');
        System.out.println('a'-'0');
        System.out.println('z'-'0');

        Integer[] integers = Arrays.stream(new int[]{1, 2, 3,})
                .boxed()
                .sorted(Comparator.reverseOrder())
                .toArray(Integer[]::new);


//        int[] aaa = new int[]{5,4,3,2,1,0};
        int[] aaa = new int[]{0,1,2,3,4,5};

         int i = Arrays.binarySearch(aaa, 6);
         System.out.println("==== i : " + i);
//       System.out.println("==== i : " + integers[i]);

        System.out.println(Math.pow(2, 60));

    }
	

		
}

