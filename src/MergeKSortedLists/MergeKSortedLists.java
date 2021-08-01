package MergeKSortedLists;

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        } else if (lists.length == 1) {
            return lists[0];
        }

        ListNode std= null, l2, temp;
        int idx = 0;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                std = lists[i];
                idx = i + 1;
                break;
            }
        }
        ListNode root = new ListNode(-1, std);

        for (int i = idx; i < lists.length; i++) {
            if (lists[i] == null) {
                continue;
            }
            l2 = lists[i];
            root.next = std.val <= l2.val ? std : l2;
            temp = root;
            while (std != null && l2 != null) {
                if (std.val <= l2.val) {
                    while (std != null && std.val <= l2.val) {
                        std = std.next;
                        temp = temp.next;
                    }
                    temp.next = l2;
                } else {
                    while (l2 != null && l2.val <= std.val) {
                        l2 = l2.next;
                        temp = temp.next;
                    }
                    temp.next = std;
                }
            }
            std = root.next;
        }
        return root.next;
    }
}
