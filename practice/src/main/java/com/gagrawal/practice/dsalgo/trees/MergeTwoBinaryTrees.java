package com.gagrawal.practice.dsalgo.trees;

/**
 * Ref - https://leetcode.com/problems/merge-two-binary-trees/
 * @author Gaurav
 * 25/06/21
 */
public class MergeTwoBinaryTrees {

    public static void main(String[] args) {

        TreeNode root1 = TreeUtil.createTree(new int[]{1});
        //TreeUtil.levelOrderTraversal(root1);
        TreeNode root2 = TreeUtil.createTree(new int[]{1,2});
        TreeUtil.levelOrderTraversal(mergeTrees(root1, root2));
    }

    private static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {

        if(root1 == null && root2 == null) {
            return null;
        }
        TreeNode root = new TreeNode();
        if(root1 == null) {
            root.val = root2.val;
            root.left = mergeTrees(null, root2.left);
            root.right = mergeTrees(null, root2.right);
        }
        else if(root2 == null) {
            root.val = root1.val;
            root.left = mergeTrees(root1.left, null);
            root.right = mergeTrees(root1.right, null);
        }
        else {
            root.val = root1.val + root2.val;
            root.left = mergeTrees(root1.left, root2.left);
            root.right = mergeTrees(root1.right, root2.right);
        }
        return root;
    }
}
