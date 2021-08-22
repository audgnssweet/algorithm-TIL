package BalancedBinaryTree;

public class BalancedBinaryTree {

    boolean res = true;

    public boolean isBalanced(TreeNode root) {
        dfs(root);
        return res;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = dfs(node.left);
        int right = dfs(node.right);

        if (Math.abs(left - right) > 1) {
            res = false;
        }

        return Math.max(left, right) + 1;
    }
}
