package PalindromePairs;

import java.util.LinkedList;
import java.util.List;

public class PalindromePairs {

    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new LinkedList<>();

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (j != i && isPalindrome(words, i, j)) {
                    res.add(List.of(i, j));
                }
            }
        }
        return res;
    }

    boolean isPalindrome(String[] words, int first, int second) {
        String word = words[first] + words[second];
        int len = word.length(), mid = len / 2;

        for (int i = 0; i < mid; i++) {
            if (word.charAt(i) != word.charAt(len - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
