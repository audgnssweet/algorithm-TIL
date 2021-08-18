package MaximumDepthOfBinaryTree;

public class MaximumDepthOfBinaryTree {

    int maxDepth = 0;

    public int maxDepth(TreeNode root) {
        recurse(root, 1);

        return maxDepth;
    }

    private void recurse(TreeNode root, int depth) {
        if (root != null) {
            maxDepth = Math.max(maxDepth, depth);
            recurse(root.left, depth + 1);
            recurse(root.right, depth + 1);
        }
    }
}
