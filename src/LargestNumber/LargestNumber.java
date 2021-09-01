package LargestNumber;

import java.util.PriorityQueue;

public class LargestNumber {

    public String largestNumber(int[] nums) {
        PriorityQueue<String> pq = new PriorityQueue<>((o1, o2) -> (o1 + o2).compareTo(o2 + o1) * -1);

        for (int i : nums) {
            pq.add(String.valueOf(i));
        }

        StringBuilder res = new StringBuilder("");
        while (!pq.isEmpty()) {
            res.append(pq.poll());
        }

        return res.charAt(0) == '0' ? "0" : res.toString();
    }

}
