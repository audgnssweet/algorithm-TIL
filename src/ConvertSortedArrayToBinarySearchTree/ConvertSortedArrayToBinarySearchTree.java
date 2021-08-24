package ConvertSortedArrayToBinarySearchTree;

public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        int start = 0, end = nums.length - 1;

        return dfs(nums, start, end);
    }

    private TreeNode dfs(int[] nums, int start, int end) {
        if (end < start) {
            return null;
        }

        int mid = (start + end) / 2;

        TreeNode node = new TreeNode(nums[mid]);
        node.left = dfs(nums, start, mid - 1);
        node.right = dfs(nums, mid + 1, end);

        return node;
    }
}
