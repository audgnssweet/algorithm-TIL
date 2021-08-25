package ConstructBinaryTreeFromPreorderAndInorderTraversal;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    int idx = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return dfs(preorder, inorder, 0, preorder.length - 1);
    }

    private TreeNode dfs(int[] preorder, int[] inorder, int start, int end) {
        if (start > end) {
            return null;
        }

        TreeNode left, right;
        TreeNode node = new TreeNode(preorder[idx]);
        int mid = find(inorder, preorder[idx]);
        idx += 1;

        node.left = dfs(preorder, inorder, start, mid - 1);
        node.right = dfs(preorder, inorder, mid + 1, end);

        return node;
    }

    private int find(int[] inorder, int val) {
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == val) {
                return i;
            }
        }
        return -1;
    }

}

