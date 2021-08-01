package com.gagrawal.practice.dsalgo.trees;

import java.util.*;

/**
 * @author Gaurav
 * 28/06/21
 */
public class FindModeInBST {
    static int mode = 0;
    public static void main(String[] args) {
        TreeNode root = TreeUtil.createBST(Arrays.asList(2,2,3,4,5));
        root = TreeUtil.createTree(new int[] {6,2,8,0,4,7,9,2,6});
        System.out.println("Level order traversal is : ");
        System.out.println(TreeUtil.levelOrderTraversalAsArr(root));
        int[] arr = findMode(root);
        for(int num : arr) {
            System.out.println(num);
        }
    }
    private static int[] findMode(TreeNode root) {

        if(root == null) {
            return new int[]{};
        }
        mode = 1;
        System.out.println("Mode is " + fillMode(root, null, 1));
        List<Integer> out = new ArrayList<>();
        findMode(root, null, out, 1);
        int[] arr = new int[out.size()];
        int i = 0;
        for(int n : out) {
            arr[i++] = n;
        }
        return arr;
    }

    private static int findMode(TreeNode root, TreeNode prev, List<Integer> arr, int cnt) {
        if(root == null) {
            return cnt;
        }

        if(prev != null && prev.val == root.val) {
            cnt++;
        }
        else {
            cnt = 1;
        }
        if(cnt == mode) {
            arr.add(root.val);
        }
        prev = root;
        cnt = findMode(root.left, prev, arr, cnt);
        cnt = findMode(root.right, prev, arr, cnt);
        return cnt;
    }
    private static int fillMode(TreeNode root, TreeNode prev, int cnt) {
        if(root == null) {
            return cnt;
        }
        if(prev != null && prev.val == root.val) {
            cnt++;
            mode = Math.max(mode, cnt);
        }
        prev = root;
        cnt = fillMode(root.left, prev, cnt);
        cnt = fillMode(root.right, prev, cnt);
        return cnt;
    }
}
