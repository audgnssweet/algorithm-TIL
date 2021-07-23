package ThreeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ThreeSum {

    Set<List<Integer>> result = new HashSet<>();
    List<Integer> route = new ArrayList<>();

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        final List<Integer> sorted = Arrays.stream(nums).boxed()
            .sorted()
            .collect(Collectors.toList());

        for (int i = 0; i < sorted.size() - 2; i++) {
            if (sorted.get(i) <= 0) {
                dfs(sorted, 1, 0, i);
            }
        }
        return new ArrayList<>(result);
    }

    private void dfs(List<Integer> sorted, int count, int sum, int now) {
        sum += sorted.get(now);
        route.add(sorted.get(now));
        if (count <= 3 && sum <= 0) {
            if (count == 3 && sum == 0) {
                result.add(new ArrayList<>(route));
            } else if (count < 3) {
                for (int i = now + 1; i < sorted.size(); i++) {
                    dfs(sorted, count + 1, sum, i);
                }
            }
        }
        route.remove(sorted.get(now));
    }

}
