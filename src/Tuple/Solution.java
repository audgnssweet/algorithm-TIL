package Tuple;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

    public static int[] solution(String s) {
        Pattern compile = Pattern.compile("[0-9]+");
        Matcher matcher = compile.matcher(s);

        Map<String, Integer> map = new HashMap<>();

        while (matcher.find()) {
            String group = matcher.group();
            map.put(group, map.getOrDefault(group, 0) + 1);
        }

        int size = map.size();
        int[] answer = new int[size];

        for (String key : map.keySet()) {
            answer[size - map.get(key)] = Integer.parseInt(key);
        }

        return answer;
    }
}
