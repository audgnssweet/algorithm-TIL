package Camouflage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    static int res = 1;
    static Map<String, List<String>> map = new HashMap<>();

    public static int solution(String[][] clothes) {
        for (String[] cloth : clothes) {
            map.computeIfAbsent(cloth[1], absent -> new ArrayList<>()).add(cloth[0]);
        }

        for (String key : map.keySet()) {
            res *= map.get(key).size() + 1;
        }

        return res - 1;
    }

}
