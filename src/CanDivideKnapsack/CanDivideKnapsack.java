package CanDivideKnapsack;

import java.util.PriorityQueue;

public class CanDivideKnapsack {

    public static double knapsack(int[][] cargo, int capacity) {
        double res = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if (((double) o1[0] / o1[1]) > ((double) o2[0] / o2[1])) {
                return -1;
            } else {
                return 1;
            }
        });

        for (int[] c : cargo) {
            pq.offer(c);
        }

        while (capacity > 0) {
            if (pq.isEmpty()) {
                break;
            }

            int[] cur = pq.poll();
            double pricePerWeight = (double) cur[0] / cur[1];
            if (cur[1] > capacity) {
                res += (pricePerWeight * capacity);
                capacity = 0;
            } else {
                capacity -= cur[1];
                res += cur[0];
            }
        }

        return res;
    }
}
