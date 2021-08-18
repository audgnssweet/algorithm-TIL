package DiameterOfBinaryTree;

public class DiameterOfBinaryTree {

    int maxlen = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        search(root);

        return maxlen;
    }

    private int search(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = search(root.left);
        int right = search(root.right);

        maxlen = Math.max(maxlen, left + right);
        return Math.max(left, right) + 1;
    }
}
