package MenuRenewal;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {

    static Map<String, Integer> map = new HashMap<>();
    static Set<Integer> set = new HashSet<>();
    static boolean[] visited;
    static char[] temp;

    public static String[] solution(String[] orders, int[] course) {

        for (int i = 0; i < course.length; i++) {
            set.add(course[i]);
        }

        for (String order : orders) {
            for (int len : course) {

                //dfs로 집어넣기
                visited = new boolean[order.length()];
                temp = new char[order.length()];


            }
        }

        List<String> res = new LinkedList<>();
        for (int i = 0; i < course.length; i++) {
            int len = course[i];

            int curMax = 0;
            List<String> strs = new LinkedList<>();
            for (String s : map.keySet()) {
                if (s.length() == len) {
                    int count = map.get(s);

                    if (curMax < count) {
                        strs.clear();
                        strs.add(s);
                        curMax = s.length();
                    } else if (curMax == count) {
                        strs.add(s);
                    }
                }
            }

            res.addAll(strs);
        }

        Collections.sort(res);
        return res.toArray(new String[0]);
    }

    public static void main(String[] args) {
        solution(new String[]{
            "ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"
        }, new int[]{2, 3, 4});
    }
}
