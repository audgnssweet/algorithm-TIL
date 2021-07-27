package AddTwoNumbers;

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode result = null, ptr = null;
        int up = 0, sum;
        while (l1 != null || l2 != null || up != 0) {
            if (l1 == null && l2 == null) {
                sum = 1;
            } else if (l2 == null) {
                sum = l1.val + up;
            } else if (l1 == null) {
                sum = l2.val + up;
            } else {
                sum = l1.val + l2.val + up;
            }
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
            up = 0;
            if (sum >= 10) {
                sum -= 10;
                up = 1;
            }
            if (ptr == null) {
                result = new ListNode(sum);
                ptr = result;
            } else {
                ptr.next = new ListNode(sum);
                ptr = ptr.next;
            }
        }
        return result;
    }

}
