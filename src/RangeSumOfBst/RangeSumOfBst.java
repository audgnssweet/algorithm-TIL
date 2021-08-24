package RangeSumOfBst;

public class RangeSumOfBst {

    int accum = 0;

    public int rangeSumBST(TreeNode root, int low, int high) {
        dfs(root, low, high);
        return accum;
    }

    void dfs(TreeNode node, int low, int high) {
        if (node != null) {
            dfs(node.left, low, high);
            dfs(node.right, low, high);
            if (node.val >= low && node.val <= high) {
                accum += node.val;
            }
        }
    }
}
