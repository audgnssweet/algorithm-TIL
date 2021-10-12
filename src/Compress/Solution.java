package Compress;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public static int[] solution(String msg) {
        Map<String, Integer> dict = new HashMap<>();
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (int i = 0; i < alphabet.length(); i++) {
            dict.put(String.valueOf(alphabet.charAt(i)), i + 1);
        }
        int dictIdx = 27;
        List<Integer> res = new ArrayList<>();

        int left = 0, right = left + 1;
        while (right <= msg.length()) {

            while (right <= msg.length() && dict.containsKey(msg.substring(left, right))) {
                ++right;
            }
            --right;

            String cur = msg.substring(left, right);
            res.add(dict.get(cur));

            if (right != msg.length()) {
                dict.put(msg.substring(left, right + 1), dictIdx++);
            }

            left = right;
            right = left + 1;
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }

}
