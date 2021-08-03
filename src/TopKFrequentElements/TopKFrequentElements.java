package TopKFrequentElements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements {

    public static int[] topKFrequent(int[] nums, int k) {
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0, right = 0;
        while (right < nums.length) {
            if (nums[left] != nums[right]) {
                map.put(nums[left], right - left);
                left = right;
            }
            ++right;
        }
        map.put(nums[left], right - left);

        List<Integer>[] list = new List[nums.length + 1];
        for (Integer key : map.keySet()) {
            int freq = map.get(key);
            if (list[freq] == null) {
                list[freq] = new ArrayList<>();
            }
            list[freq].add(key);
        }

        List<Integer> result = new ArrayList<>();
        int last = nums.length;
        while (k > result.size()) {
            if (list[last] != null) {
                result.addAll(list[last]);
            }
            --last;
        }

        int[] res = new int[k];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }

        return res;
    }
}
