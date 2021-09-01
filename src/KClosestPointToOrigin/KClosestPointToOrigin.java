package KClosestPointToOrigin;

import java.util.PriorityQueue;

public class KClosestPointToOrigin {

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            int one = o1[0] * o1[0] + o1[1] * o1[1];
            int two = o2[0] * o2[0] + o2[1] * o2[1];
            if (one < two) {
                return -1;
            } else if (one > two) {
                return 1;
            }else return 0;
        });

        for (int[] p : points) {
            pq.offer(p);
        }

        int[][] res = new int[k][];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll();
        }

        return res;
    }
}
