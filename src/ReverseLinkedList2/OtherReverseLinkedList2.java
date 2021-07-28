package ReverseLinkedList2;

public class OtherReverseLinkedList2 {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head.next == null || left == right) {
            return head;
        }

        ListNode root = new ListNode(0, head);
        ListNode stdL = root;
        ListNode stdR, tmp;
        int cnt = 0;
        while (cnt != left - 1) {
            ++cnt;
            stdL = stdL.next;
        }
        tmp = stdR = stdL.next;

        for (int i = 0; i < right - left; i++) {
            stdL.next = stdR.next;
            stdR.next = stdL.next.next;
            stdL.next.next = tmp;
            tmp = stdL.next;
        }

        return root.next;
    }
}
