package level1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Test {

    public static void main(String[] args) throws IOException {
        String s = "pypypyp";

        String p = s.replace("p", "");
        String p1 = s.replace('p', 'a');
        String pp = s.replaceAll("p", "a");
        System.out.println(p);
        System.out.println(p1);
        System.out.println(pp);

    }
}
