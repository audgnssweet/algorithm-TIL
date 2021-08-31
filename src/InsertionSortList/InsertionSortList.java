package InsertionSortList;

public class InsertionSortList {

    public static ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode root = new ListNode(), now = head.next, ptr, tmp;
        root.next = head;
        tmp = root.next;
        boolean isInsert;

        while (now != null) {
            isInsert = false;
            ptr = root;

            while (ptr.next != now) {
                if (ptr.next.val > now.val) {
                    tmp.next = now.next;
                    now.next = ptr.next;
                    ptr.next = now;
                    isInsert = true;
                }

                if (isInsert) {
                    now = tmp.next;
                    break;
                }
                ptr = ptr.next;
            }

            if (!isInsert) {
                tmp = now;
                now = now.next;
            }
        }

        return root.next;
    }


}
