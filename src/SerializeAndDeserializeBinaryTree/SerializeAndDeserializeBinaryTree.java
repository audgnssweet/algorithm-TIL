package SerializeAndDeserializeBinaryTree;

import java.util.LinkedList;
import java.util.List;

public class SerializeAndDeserializeBinaryTree {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<Integer> res = new LinkedList<>();

        LinkedList<TreeNode> list = new LinkedList<>();
        list.addLast(root);
        while (!list.isEmpty()) {
            final TreeNode node = list.pollFirst();
            if (node == null) {
                if (!list.isEmpty() && isAllNull(list)) {
                    break;
                } else {
                    res.add(null);
                }
            } else {
                res.add(node.val);
                list.addLast(node.left);
                list.addLast(node.right);
            }
        }

        return res.toString();
    }

    private boolean isAllNull(LinkedList<TreeNode> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != null) {
                return false;
            }
        }
        return true;
    }

    //     Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        final String[] nums = data.replaceAll("[\\[\\]\\s]", "").split(",", -1);
        TreeNode[] nodes = new TreeNode[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            if (!nums[i].equals("null")) {
                nodes[i + 1] = new TreeNode(Integer.parseInt(nums[i]));
            }
        }

        int next = 2;
        int i = 1;
        while (nodes.length != 2) {
            if (nodes[i] != null) {
                try {
                    nodes[i].left = nodes[next];
                    nodes[i].right = nodes[next + 1];
                    next += 2;
                } catch (ArrayIndexOutOfBoundsException e) {
                    break;
                }
            }
            i++;
        }

        return nodes[1];
    }
}
