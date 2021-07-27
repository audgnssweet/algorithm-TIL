package MergeTwoSortedLists;

public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }

        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }

        ListNode result = l1.val <= l2.val ? l1 : l2;
        ListNode temp1 = l1, temp2 = l2, temp = null;

        while (temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val) {
                while (temp1 != null && temp1.val <= temp2.val) {
                    temp = temp1;
                    temp1 = temp1.next;
                }
                temp.next = temp2;
            } else {
                while (temp2 != null && temp2.val <= temp1.val) {
                    temp = temp2;
                    temp2 = temp2.next;
                }
                temp.next = temp1;
            }
        }

        return result;
    }

}
