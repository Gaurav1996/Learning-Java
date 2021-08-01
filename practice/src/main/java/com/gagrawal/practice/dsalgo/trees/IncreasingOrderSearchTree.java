package com.gagrawal.practice.dsalgo.trees;

import java.util.Arrays;

/**
 * @author Gaurav
 * 26/06/21
 */
public class IncreasingOrderSearchTree {
    public static void main(String[] args) {
        TreeNode root = TreeUtil.createBST(Arrays.asList(1,9,7));
        TreeUtil.levelOrderTraversal(increasingBST(root));
    }

    private static TreeNode increasingBST(TreeNode root) {
        if(root == null) {
            return null;
        }
        return increasingBST(root, null);
    }

    private static TreeNode increasingBST(TreeNode root, TreeNode head) {
        if(root == null) {
            return head;
        }
        head = increasingBST(root.left, head);
        if(head == null) {
            head = root;
        }
//        else {
//            TreeNode tmp = (head.right != null) ? head.right : head;
//            tmp.right = root;
//        }
        head = increasingBST(root.right, head);
        return head;
    }
}
