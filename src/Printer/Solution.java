package Printer;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Solution {

    public static int solution(int[] priorities, int location) {
        Deque<Integer> queue = new LinkedList<>();

        int[] newarr = Arrays.copyOf(priorities, priorities.length);
        Arrays.sort(newarr);
        int ptr = newarr.length - 1;

        for (int i = 0; i < priorities.length; i++) {
            queue.add(priorities[i]);
        }

        int temp = priorities[location];
        int count = 1;
        while (!queue.isEmpty()) {
            if (location == 0 && newarr[ptr] == temp) {
                count += 1;
                break;
            }

            if (newarr[ptr] == queue.peekFirst()) {
                ptr -= 1;
                queue.pollFirst();
                count += 1;
            } else {
                queue.addLast(queue.pollFirst());
            }

            location = location == 0 ? queue.size() - 1 : location -1;
        }

        return count;
    }

    public static void main(String[] args) {
        solution(new int[]{2,1,3,2}, 2);
    }
}
