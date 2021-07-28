package SwapNodesInPairs;

public class OtherSwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        return swap(head);
    }

    private ListNode swap(ListNode head) {
        ListNode ptr = head;
        if (head != null && head.next != null) {
            ptr = head.next;
            head.next = swap(ptr.next);
            ptr.next = head;
        }
        return ptr;
    }
}
