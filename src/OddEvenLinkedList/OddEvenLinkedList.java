package OddEvenLinkedList;

public class OddEvenLinkedList {

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        ListNode odd = head, even = head.next, evenFirst = head.next;

        while (true) {
            if (even.next == null) {
                odd.next = evenFirst;
                break;
            }
            odd.next = even.next;
            odd = odd.next;
            if (odd.next == null) {
                odd.next = evenFirst;
                even.next = null;
                break;
            }
            even.next = odd.next;
            even = even.next;
        }

        return head;
    }
}
