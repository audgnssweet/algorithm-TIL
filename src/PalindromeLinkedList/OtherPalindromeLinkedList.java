package PalindromeLinkedList;

public class OtherPalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        ListNode slow, fast, rev = null;
        slow = fast = head;

        while (fast != null && fast.next != null) {
            rev = new ListNode(slow.val, rev);

            fast = fast.next.next;
            slow = slow.next;
        }

        if (fast != null) {
            slow = slow.next;
        }

        while (slow != null) {
            if (slow.val != rev.val) {
                return false;
            }
            slow = slow.next;
            rev = rev.next;
        }

        return true;
    }

}
