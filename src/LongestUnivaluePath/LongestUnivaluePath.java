package LongestUnivaluePath;

public class LongestUnivaluePath {

    int longest = 0;

    public int longestUnivaluePath(TreeNode root) {
        dfs(root);

        return longest;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return -1;
        }

        int left = dfs(node.left);
        int right = dfs(node.right);

        int tmp = 0;
        int now = 0;
        if (left != -1 && node.val == node.left.val) {
            now += left + 1;
            tmp = Math.max(tmp, left + 1);
        }
        if (right != -1 && node.val == node.right.val) {
            now += right + 1;
            tmp  = Math.max(tmp, right + 1);
        }

        longest = Math.max(longest, now);

        return tmp;
    }
}
