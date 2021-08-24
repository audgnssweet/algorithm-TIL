package MinimumDistanceBetweenBstNodes;

public class MinimumDistanceBetweenBstNodes {

    int res = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root) {
        dfs(root);

        return res;
    }

    void dfs(TreeNode node) {
        if (node != null) {
            if (node.left != null) {
                dfs(node.left);
                int leftmax = max(node.left);
                res = Math.min(res, node.val - leftmax);
            }

            if (node.right != null) {
                dfs(node.right);
                int rightmin = min(node.right);
                res = Math.min(res, rightmin - node.val);
            }
        }
    }

    int min(TreeNode node) {
        if (node.left == null) {
            return node.val;
        }
        return min(node.left);
    }

    int max(TreeNode node) {
        if (node.right == null) {
            return node.val;
        }
        return max(node.right);
    }
}
