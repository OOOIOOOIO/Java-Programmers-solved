package level2;

import java.util.ArrayList;
import java.util.List;

public class 모음사전 {

    private static final char[] CHARS = "AEIOU".toCharArray();
    public int solution(String word) {
        return solve2(word);
    }

    public int solve2(String word){
        List<String> words = new ArrayList<>();
        generate("", words);
        return words.indexOf(word);
    }

    private void generate(String word, List<String> words) {
        words.add(word);

        if (word.length() == 5) return;
        for (char c : CHARS) {
            generate(word + c, words);
        }
    }

}
