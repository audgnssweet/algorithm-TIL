package ReverseLinkedList2;

public class ReverseLinkedList2 {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head.next == null || left == right) {
            return head;
        }

        ListNode newHead = null, tmp, ptr = head;
        int cnt = 1;
        while (ptr != null && cnt <= right) {
            if (cnt >= left) {
                tmp = new ListNode(ptr.val, newHead);
                newHead = tmp;
            }
            ++cnt;
            ptr = ptr.next;
        }

        ListNode l = head, r = head;
        cnt = 1;
        if (left == 1) {
            //newHead가 처리
            ptr = newHead;
            while (ptr.next != null) {
                ptr = ptr.next;
            }
            while (cnt <= right) {
                r = r.next;
                ++cnt;
            }
            ptr.next = r;
            return newHead;
        } else {
            //left를 찾음
            ptr = head;
            while (cnt != left - 1) {
                ptr = ptr.next;
                ++cnt;
            }
            l = ptr;
            r = ptr.next;
            ++cnt;
            l.next = newHead;
            while (cnt <= right) {
                r = r.next;
                ++cnt;
            }
            while (newHead.next != null) {
                newHead = newHead.next;
            }
            newHead.next = r;
            return head;
        }
    }

}
