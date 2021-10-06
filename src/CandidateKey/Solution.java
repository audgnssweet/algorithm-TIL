package CandidateKey;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {

    static List<Integer> nums;
    static LinkedList<List<Integer>> combs = new LinkedList<>();
    static Map<String, Integer> map;

    public static int solution(String[][] relation) {
        int res = 0;
        nums = new LinkedList<>();
        for (int i = 0; i < relation[0].length; i++) {
            nums.add(i);
        }
        combination(new LinkedList<>(), 0, 0);
        combs.sort((l1, l2) -> {
            if (l1.size() == l2.size()) {
                return l1.toString().compareTo(l2.toString());
            } else if (l1.size() < l2.size()) {
                return -1;
            } else {
                return 1;
            }
        });

        for (int i = 1; i <= relation[0].length; i++) {

            while (!combs.isEmpty()) {
                map = new HashMap<>();
                List<Integer> cur = combs.pollFirst();

                for (String[] record : relation) {
                    StringBuilder sb = new StringBuilder("");
                    for (int idx : cur) {
                        sb.append(record[idx]);
                    }
                    map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
                }

                boolean isValid = true;
                for (int value : map.values()) {
                    if (value != 1) {
                        isValid = false;
                        break;
                    }
                }

                if (isValid) {
                    res += 1;
                    for (int j = 0; j < combs.size(); j++) {
                        if (combs.get(j).containsAll(cur)) {
                            combs.remove(j);
                            --j;
                        }
                    }
                }
            }
        }

        return res;
    }

    public static void combination(LinkedList<Integer> temp, int curPos, int start) {
        if (curPos != 0) {
            combs.add(new ArrayList<>(temp));
        }
        for (int i = start; i < nums.size(); i++) {
            temp.add(nums.get(i));
            combination(temp, curPos + 1, i + 1);
            temp.removeLast();
        }
    }

}
