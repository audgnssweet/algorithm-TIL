package QueueReconstructionByHeight;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class QueueReconstructionByHeight {

    public int[][] reconstructQueue(int[][] people) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1[1] < o2[1]) {
                return -1;
            } else if (o1[1] > o2[1]) {
                return 1;
            } else if (o1[0] < o2[0]) {
                return -1;
            } else {
                return 1;
            }
        });
        LinkedList<int[]> res = new LinkedList<>();

        for (int[] p : people) {
            pq.offer(p);
        }

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int cnt = 0, idx = 0;

            while (idx < res.size()) {
                if (res.get(idx)[0] >= cur[0]) {
                    cnt += 1;
                }

                if (cnt > cur[1]) {
                    res.add(idx, cur);
                    break;
                }
                idx += 1;
            }
            if (cnt <= cur[1]) {
                res.add(cur);
            }
        }

        return res.toArray(new int[0][]);
    }
}
