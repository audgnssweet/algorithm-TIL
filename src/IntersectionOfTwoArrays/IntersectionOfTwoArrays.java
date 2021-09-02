package IntersectionOfTwoArrays;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> res = new HashSet<>();

        for (int i : nums1) {
            set.add(i);
        }

        for (int i : nums2) {
            if (set.contains(i)) {
                res.add(i);
            }
        }

        int[] real = new int[res.size()];
        int idx = 0;
        for (int i : res.toArray(new Integer[0])) {
            real[idx++] = i;
        }

        return real;
    }
}
