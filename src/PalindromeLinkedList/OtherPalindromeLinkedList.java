package PalindromeLinkedList;

class ListNode {

    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class OtherPalindromeLinkedList {

    public static boolean isPalindrome(ListNode head) {
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

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);

        isPalindrome(head);
    }
}
