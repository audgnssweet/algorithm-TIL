package InsertionSortList;

public class OtherInsertionSortList {

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode root = new ListNode(-10), pre = root;
        ListNode cur = head, next;

        while (cur != null) {
            if (pre.next != null && pre.next.val >= cur.val) {
                pre = root;
            }
            while (pre.next != null && pre.next.val < cur.val) {
                pre = pre.next;
            }
            next = cur.next;
            cur.next = pre.next;
            pre.next = cur;

            cur = next;
        }
        return root.next;
    }
}
