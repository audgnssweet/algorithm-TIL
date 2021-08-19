package InvertBinaryTree;

public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        return dfs(root);
    }

    private TreeNode dfs(TreeNode node) {
        if (node == null) {
            return null;
        }

        dfs(node.left);
        dfs(node.right);

        TreeNode tmp;
        tmp = node.left;
        node.left = node.right;
        node.right = tmp;

        return node;
    }
}
