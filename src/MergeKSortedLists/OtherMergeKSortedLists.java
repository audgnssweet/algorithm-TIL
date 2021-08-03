package MergeKSortedLists;

import java.util.PriorityQueue;

public class OtherMergeKSortedLists {

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (ListNode listNode : lists) {
            while (listNode != null) {
                queue.add(listNode.val);
                listNode = listNode.next;
            }
        }

        ListNode result = new ListNode(-1);
        ListNode temp = result;
        while (!queue.isEmpty()) {
            temp.next = new ListNode(queue.poll());
            temp = temp.next;
        }

        return result.next;
    }
}
