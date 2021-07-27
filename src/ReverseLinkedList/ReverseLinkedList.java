package ReverseLinkedList;

public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        if (head == null) return null;

        ListNode result = null;
        ListNode ptr;
        while (head != null) {
            ptr = new ListNode(head.val);
            ptr.next = result;
            result = ptr;
            head = head.next;
        }
        return result;
    }

}
