package BinarySearchTreeToGreaterSumTree;

public class BinarySearchTreeToGreaterSumTree {

    int accum = 0;

    public TreeNode bstToGst(TreeNode root) {
        dfs(root);
        return root;
    }

    void dfs(TreeNode node) {
        if (node != null) {
            dfs(node.right);
            accum += node.val;
            node.val = accum;
            dfs(node.left);
        }
    }
}
