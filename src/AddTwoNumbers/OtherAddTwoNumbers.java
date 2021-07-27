package AddTwoNumbers;

public class OtherAddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode start = new ListNode(0);
        ListNode end = start;
        int sum, up = 0;
        while (l1 != null || l2 != null || up != 0) {
            sum = up;
            up = 0;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            if (sum >= 10) {
                sum -= 10;
                up = 1;
            }

            end.next = new ListNode(sum);
            end = end.next;
        }
        return start.next;
    }

}
