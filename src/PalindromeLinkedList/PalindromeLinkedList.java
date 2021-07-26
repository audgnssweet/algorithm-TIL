package PalindromeLinkedList;

import java.util.ArrayList;
import java.util.List;

public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        for (; head != null; head = head.next) {
            list.add(head.val);
        }
        int size = list.size();
        int mid = size / 2;
        for (int i = 0; i < mid; i++) {
            if (!list.get(i).equals(list.get(size - 1 - i))) {
                return false;
            }
        }
        return true;
    }
}
