package LetterConbinationsOfAPhoneNumber;

import java.util.LinkedList;
import java.util.List;

public class LetterConbinationsOfAPhoneNumber {

    String[][] keyPad = {
        null,
        null,
        {"a", "b", "c"},
        {"d", "e", "f"},
        {"g", "h", "i"},
        {"j", "k", "l"},
        {"m", "n", "o"},
        {"p", "q", "r", "s"},
        {"t", "u", "v"},
        {"w", "x", "y", "z"},
    };
    List<String> res = new LinkedList<>();
    LinkedList<String> temp = new LinkedList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new LinkedList<>();
        }

        LinkedList<Integer> seq = new LinkedList<>();
        for (Character ch : digits.toCharArray()) {
            seq.add(ch - '0');
        }

        for (String now : keyPad[seq.getFirst()]) {
            dfs(now, 1, seq);
        }

        return res;
    }

    private void dfs(String now, int length, List<Integer> seq) {
        temp.add(now);
        if (length == seq.size()) {
            String tmp = "";
            for (String str : temp) {
                tmp += str;
            }
            res.add(tmp);
        } else {
            for (String next : keyPad[seq.get(length)]) {
                dfs(next, length + 1, seq);
            }
        }

        temp.removeLast();
    }

}
