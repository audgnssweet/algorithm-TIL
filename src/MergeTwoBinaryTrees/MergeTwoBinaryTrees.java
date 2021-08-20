package MergeTwoBinaryTrees;

public class MergeTwoBinaryTrees {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return dfs(root1, root2);
    }

    private TreeNode dfs(TreeNode n1, TreeNode n2) {
        if (n1 == null) {
            return n2;
        }
        if (n2 == null) {
            return n1;
        }
        n1.left = dfs(n1.left, n2.left);
        n1.right = dfs(n1.right, n2.right);

        n1.val += n2.val;
        return n1;
    }
}
