package RangeSumOfBst;

public class RangeSumOfBstBranch {

    int accum = 0;

    public int rangeSumBST(TreeNode root, int low, int high) {
        dfs(root, low, high);
        return accum;
    }

    void dfs(TreeNode node, int low, int high) {
        if (node != null) {
            if (node.val < low) {
                dfs(node.right, low, high);
            } else if (node.val > high) {
                dfs(node.left, low, high);
            } else {
                dfs(node.left, low, high);
                dfs(node.right, low, high);
                accum += node.val;
            }
        }
    }
}
