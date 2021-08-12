package ReconstructItinerary;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class OtherReconstructItinerary {

    Map<String, PriorityQueue<String>> map = new HashMap<>();
    LinkedList<String> res = new LinkedList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> fromTo : tickets) {
            String from = fromTo.get(0), to = fromTo.get(1);
            map.computeIfAbsent(from, absent -> new PriorityQueue<>()).offer(to);
        }

        dfs("JFK");
        return res;
    }

    private void dfs(String from) {
        Queue<String> toList = map.get(from);
        if (toList != null) {
            while (!toList.isEmpty()) {
                String to = toList.poll();
                dfs(to);
            }
        }
        res.add(0, from);
    }
}
