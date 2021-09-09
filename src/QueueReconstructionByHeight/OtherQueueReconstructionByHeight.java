package QueueReconstructionByHeight;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class OtherQueueReconstructionByHeight {

    public int[][] reconstructQueue(int[][] people) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] > o2[0]) {
                return -1;
            } else if (o1[0] < o2[0]) {
                return 1;
            } else if (o1[1] < o2[1]) {
                return -1;
            } else {
                return 1;
            }
        });

        for (int[] p : people) {
            pq.offer(p);
        }
        LinkedList<int[]> res = new LinkedList<>();

        int idx = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            res.add(cur[1], cur);
        }

        return res.toArray(new int[0][]);
    }

}
