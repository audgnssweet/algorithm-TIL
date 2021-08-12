package ReconstructItinerary;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ReconstructItinerary {

    Map<String, LinkedList<String>> map = new HashMap<>();
    LinkedList<String> res = new LinkedList<>();
    boolean isEnd = false;

    public List<String> findItinerary(List<List<String>> tickets) {
        for (int i = 0; i < tickets.size(); i++) {
            String key = tickets.get(i).get(0); // 키
            String value = tickets.get(i).get(1); // 밸류
            if (map.containsKey(key)) {
                map.get(key).addLast(value);
            } else {
                LinkedList<String> tmp = new LinkedList<>();
                tmp.add(value);
                map.put(key, tmp);
            }
        }

        for (String key : map.keySet()) {
            map.get(key).sort(String::compareTo);
        }

        res.add("JFK");
        dfs("JFK", tickets.size() + 1);

        return res;
    }

    private void dfs(String start, int len) {
        if (res.size() == len) {
            isEnd = true;
        } else {
            List<String> nextList = map.get(start);
            if (nextList != null) {
                for (int i = 0; i < nextList.size(); i++) {
                    String next = nextList.remove(i);
                    res.add(next);
                    dfs(next, len);
                    if (isEnd) {
                        break;
                    }
                    res.removeLast();
                    nextList.add(i, next);
                }
            }
        }
    }
}
