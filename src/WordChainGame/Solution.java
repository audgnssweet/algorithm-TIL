package WordChainGame;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static int[] solution(int n, String[] words) {
        Set<String> duplicate = new HashSet<>();
        String last = String.valueOf(words[0].charAt(0));
        int count = 0;
        for (String word : words) {
            count += 1;
            if (duplicate.contains(word) || last.charAt(last.length() - 1) != word.charAt(0)) {
                int rotate = count % n == 0 ? count / n : (count / n) + 1;
                int who = count % n == 0 ? n : count % n;
                return new int[]{who, rotate};
            }
            duplicate.add(word);
            last = word;
        }

        return new int[]{0, 0};
    }

}
