package SerializeAndDeserializeBinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class OtherSerializeAndDeserializeBinaryTree {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        while (!queue.isEmpty()) {
            final TreeNode node = queue.pollFirst();
            if (node != null) {
                queue.add(node.left);
                queue.add(node.right);

                res.add(node.val);
            } else {
                if (!isRemain(queue)) {
                    break;
                }
                res.add(null);
            }
        }

        return res.toString();
    }

    private boolean isRemain(LinkedList<TreeNode> queue) {
        for (int i = 0; i < queue.size(); i++) {
            if (queue.get(i) != null) {
                return true;
            }
        }
        return false;
    }

    //     Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        final String[] nums = data.replaceAll("[\\[\\]\\s]", "").split(",", -1);
        System.out.println(nums.length);
        if (nums[0].equals("") || nums[0].equals("null")) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(nums[0]));
        if (nums.length == 1) {
            return root;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int idx = 1;
        while (!queue.isEmpty()) {
            final TreeNode node = queue.pollFirst();
            if (idx < nums.length && !nums[idx].equals("null")) {
                node.left = new TreeNode(Integer.parseInt(nums[idx]));
                queue.add(node.left);
            }
            idx += 1;

            if (idx < nums.length && !nums[idx].equals("null")) {
                node.right = new TreeNode(Integer.parseInt(nums[idx]));
                queue.add(node.right);
            }
            idx += 1;
        }
        return root;
    }
}
