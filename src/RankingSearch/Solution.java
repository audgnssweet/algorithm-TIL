package RankingSearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    static Map<String, List<Integer>> map = new HashMap<>();
    static List<Node> nodes = new ArrayList<>();
    static List<String[]> level = new ArrayList<>();

    static {
        map.put("cpp", new ArrayList<>());
        map.put("java", new ArrayList<>());
        map.put("python", new ArrayList<>());
        map.put("backend", new ArrayList<>());
        map.put("frontend", new ArrayList<>());
        map.put("junior", new ArrayList<>());
        map.put("senior", new ArrayList<>());
        map.put("chicken", new ArrayList<>());
        map.put("pizza", new ArrayList<>());

        level.add(new String[]{"cpp", "java", "python"});
        level.add(new String[]{"backend", "frontend"});
        level.add(new String[]{"junior", "senior"});
        level.add(new String[]{"chicken", "pizza"});
    }

    public static int[] solution(String[] info, String[] query) {
        init(info);
        int[] res = new int[query.length];
        int index = 0;

        for (String q : query) {
            String[] s = q.split(" ");
            String[] split = new String[]{s[0], s[2], s[4], s[6]};

            int goe = Integer.parseInt(s[7]);
            int count = 0;
            int add = 0;

            Map<Integer, Integer> temp = new HashMap<>();

            for (int i = 0; i < split.length; i++) {
                if (!split[i].equals("-")) {
                    count += 1;
                    for (int idx : map.get(split[i])) {
                        temp.put(idx, temp.getOrDefault(idx, 0) + 1);
                    }
                } else {
                    for (String cur : level.get(i)) {
                        for (int idx : map.get(cur)) {
                            temp.put(idx, temp.getOrDefault(idx, 0));
                        }
                    }
                }
            }

            for (int key : temp.keySet()) {
                if (temp.get(key) == count && nodes.get(key).num >= goe) {
                    add += 1;
                }
            }

            res[index++] = add;
        }

        return res;
    }

    static void init(String[] info) {
        for (int i = 0; i < info.length; i++) {
            String[] split = info[i].split(" ");
            int num = Integer.parseInt(split[4]);
            for (int j = 0; j < split.length - 1; j++) {
                map.get(split[j]).add(i);
            }
            nodes.add(new Node(i, num));
        }
    }

    static class Node {

        int idx;
        int num;

        public Node(int idx, int num) {
            this.idx = idx;
            this.num = num;
        }
    }
}
