package CourseSchedule;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CourseSchedule {

    Map<Integer, List<Integer>> map = new HashMap<>();
    Set<Integer> traced = new HashSet<>();
    Set<Integer> visited = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for (int[] lastFirst : prerequisites) {
            map.get(lastFirst[0]);
            map.computeIfAbsent(lastFirst[0], absent -> new LinkedList<>()).add(lastFirst[1]);
        }

        for (Integer last : map.keySet()) {
            if (!dfs(last)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int last){
        if (traced.contains(last)) {
            return false;
        }
        if (visited.contains(last)) {
            return true;
        }

        traced.add(last);
        List<Integer> firsts = map.get(last);
        if (firsts != null) {
            for (Integer first : firsts) {
                if (!dfs(first)) {
                    return false;
                }
            }
        }
        traced.remove(last);
        visited.add(last);

        return true;
    }
}
