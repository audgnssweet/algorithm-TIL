package RemoveDuplicateLetters;

import java.util.TreeSet;

public class RemoveDuplicateLetters {

    public String removeDuplicateLetters(String s) {
        return backTrack(s);
    }

    public String backTrack(String suffix) {
        TreeSet<Character> treeSet = getSuffix(suffix);

        for (Character ch : treeSet) {
            String substring = suffix.substring(suffix.indexOf(ch));
            if (getSuffix(substring).equals(treeSet)) {
                return ch + backTrack(substring.replace(String.valueOf(ch), ""));
            }
        }

        return "";
    }

    private TreeSet<Character> getSuffix(String s) {
        char[] chars = s.toCharArray();
        TreeSet<Character> treeSet = new TreeSet<>();

        for (int i = 0; i < chars.length; i++) {
            treeSet.add(chars[i]);
        }

        return treeSet;
    }

}
