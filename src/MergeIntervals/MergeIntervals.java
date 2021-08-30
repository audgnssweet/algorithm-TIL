package MergeIntervals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class MergeIntervals {

    final int start = 0;
    final int end = 1;

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparing(o -> o[0]));

        LinkedList<int[]> lists = new LinkedList<>();

        int left = 0, right = 1;
        while (right < intervals.length) {
            if (intervals[left][end] >= intervals[right][start]) {
                intervals[left][end] = Math.max(intervals[left][end], intervals[right][end]);
                ++right;
                continue;
            }
            --right;

            lists.add(new int[]{intervals[left][start], Math.max(intervals[left][end], intervals[right][end])});
            left = right + 1;
            right += 2;
        }

        --right;
        lists.add(new int[]{intervals[left][start], Math.max(intervals[left][end], intervals[right][end])});

        return lists.toArray(new int[0][]);
    }

}
