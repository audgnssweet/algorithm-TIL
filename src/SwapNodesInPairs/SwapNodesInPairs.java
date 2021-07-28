package SwapNodesInPairs;

public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        int temp;
        ListNode left = head, right = head.next;
        while (true) {
            temp = left.val;
            left.val = right.val;
            right.val = temp;

            if (right.next == null) {
                break;
            }
            left = right.next;

            if (left.next == null) {
                break;
            }
            right = left.next;
        }

        return head;
    }
}
