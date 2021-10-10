package GenerateBigNumber;

import java.util.PriorityQueue;

public class Solution {

    static class Node {

        char num;
        int idx;

        public Node(char num, int idx) {
            this.num = num;
            this.idx = idx;
        }
    }

    public static String solution(String number, int k) {
        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> {
            if (n1.num == n2.num) {
                return (n1.idx - n2.idx);
            } else {
                return (n1.num - n2.num) * -1;
            }
        });

        int len = number.length() - k;
        int idx = k;

        for (int i = 0; i <= number.length() - len; i++) {
            pq.offer(new Node(number.charAt(i), i));
        }

        StringBuilder sb = new StringBuilder("");
        int maxIdx = -1;
        while (idx < number.length() && !pq.isEmpty()) {
            Node best = pq.poll();
            if (best.idx <= maxIdx) {
                continue;
            } else {
                maxIdx = best.idx;
                sb.append(best.num);
            }
            idx += 1;
            if (idx < number.length()) {
                pq.add(new Node(number.charAt(idx), idx));
            }
        }

        return sb.toString();
    }
}
