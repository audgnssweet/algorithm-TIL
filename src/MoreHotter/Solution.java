package MoreHotter;

import java.util.PriorityQueue;

public class Solution {

    public static int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < scoville.length; i++) {
            pq.add(scoville[i]);
        }

        int res = 0;
        while (true) {
            if (pq.isEmpty()) {
                break;
            }
            if (pq.peek() >= K) {
                break;
            }
            int first = pq.poll();

            if (pq.isEmpty()) {
                break;
            }
            int second = pq.poll();

            int newNum = first + (second * 2);
            pq.add(newNum);
            res += 1;
        }

        if (pq.isEmpty()) {
            return -1;
        }

        return res;
    }

    public static void main(String[] args) {
        solution(new int[]{1, 2, 3}, 11);
    }
}
