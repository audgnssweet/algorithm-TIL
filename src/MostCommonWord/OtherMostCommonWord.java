package MostCommonWord;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class OtherMostCommonWord {

    Set<String> banSet = new HashSet<>();
    Map<String, Integer> map = new HashMap<>();
    int max;
    String res;

    public String mostCommonWord(String paragraph, String[] banned) {
        banSet.addAll(Arrays.asList(banned));

        StringBuilder sb = new StringBuilder("");
        for (char ch : paragraph.toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                sb.append(ch);
            } else if (ch >= 'A' && ch <= 'Z') {
                sb.append((char) (ch + ' '));
            } else {
                process(sb);
            }
        }
        process(sb);

        return res;
    }

    private void process(StringBuilder sb) {
        if (sb.length() != 0) {
            String word = sb.toString().toLowerCase();
            sb.setLength(0);
            if (!banSet.contains(word)) {
                int count = map.getOrDefault(word, 0);
                map.put(word, ++count);
                if (count > max) {
                    max = count;
                    res = word;
                }
            }
        }
    }

}
