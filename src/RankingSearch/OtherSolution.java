package RankingSearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class OtherSolution {

    static Map<String, List<Integer>> map = new HashMap<>();
    static Set<String> sorted = new HashSet<>();

    public static int[] solution(String[] info, String[] query) {
        int[] res = new int[query.length];
        int resIdx = 0;

        for (String i : info) {
            String[] split = i.split(" ");
            combination(new String[]{"-", "-", "-", "-"}, 0, split);
        }

        for (String q : query) {
            String[] s = q.split(" ");
            String condition = Arrays.toString(new String[]{s[0], s[2], s[4], s[6]});
            int goe = Integer.parseInt(s[7]);

            List<Integer> list = map.getOrDefault(condition, new ArrayList<>());
            int idx = 0;

            if (list.size() != 0) {
                if (!sorted.contains(condition)) {
                    Collections.sort(list);
                    sorted.add(condition);
                }

                idx = Collections.binarySearch(list, goe);
                if (idx >= 0) {
                    while (idx > 0 && list.get(idx - 1) >= goe) {
                        idx -= 1;
                    }
                } else {
                    idx = Math.abs(idx + 1);
                }
            }

            res[resIdx++] = list.size() - idx;
        }

        return res;
    }

    static void combination(String[] temp, int start, String[] split) {
        String condition = Arrays.toString(temp.clone());
        map.computeIfAbsent(condition, absent -> new ArrayList<>()).add(Integer.parseInt(split[4]));

        for (int i = start; i < split.length - 1; i++) {
            temp[i] = split[i];
            combination(temp, i + 1, split);
            temp[i] = "-";
        }
    }
}
