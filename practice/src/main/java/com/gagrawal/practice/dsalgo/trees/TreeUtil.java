package com.gagrawal.practice.dsalgo.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Gaurav
 * 25/06/21
 */
public class TreeUtil {
    public static TreeNode createTree(int[] arr) {
        return createTree(arr, null,0);
    }

    private static TreeNode createTree(int[] arr, TreeNode root, int i) {

        if(i >= arr.length || arr[i] == Integer.MIN_VALUE) {
            return root;
        }
        root = new TreeNode(arr[i]);
        root.left = createTree(arr, root.left, 2*i+1);
        root.right = createTree(arr, root.right, 2*i+2);
        return root;
    }

    public static void inorder(TreeNode root) {
        if(root == null) {
            return;
        }
        inorder(root.left);
        System.out.println(root.val);
        inorder(root.right);
    }

    public static void levelOrderTraversal(TreeNode root) {

        if(root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode tmp = queue.poll();
            System.out.println(tmp.val);
            if(tmp.left != null) {
                queue.add(tmp.left);
            }
            if(tmp.right != null) {
                queue.add(tmp.right);
            }
        }
    }

    public static List<List<Integer>> levelOrderTraversalAsArr(TreeNode root) {
        List<List<Integer>> arr = new ArrayList<>();
        if(root == null) {
            return arr;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int n = q.size();
            List<Integer> nodes = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                TreeNode tmp = q.poll();
                nodes.add(tmp.val);
                if(tmp.left != null) {
                    q.add(tmp.left);
                }
                if(tmp.right != null) {
                    q.add(tmp.right);
                }
            }
            arr.add(nodes);
        }
        return arr;
    }

    public static TreeNode createBST(List<Integer> arr) {

        if(!isSorted(arr)) {
            throw new RuntimeException("Array is not sorted. Cannot create a BST");
        }

        if(arr.isEmpty()) {
            return null;
        }
        int len = arr.size();
        return createBST(arr, 0, len-1);
    }

    private static TreeNode createBST(List<Integer> arr, int low, int high) {
        if(low > high) {
            return null;
        }
        int mid = low + (high - low) / 2;
        TreeNode root = new TreeNode(arr.get(mid));
        root.left = createBST(arr, low, mid - 1);
        root.right = createBST(arr, mid + 1, high);
        return root;
    }

    private static boolean isSorted(List<Integer> arr) {
        int n = arr.size();
        if(n == 0 || n == 1) {
            return true;
        }
        for(int i = 1; i < n; i++) {
            if(arr.get(i-1) > arr.get(i)) {
                return false;
            }
        }
        return true;
    }
}
