package com.gagrawal.practice.dsalgo.arrays;

/**
 * Ref - https://leetcode.com/problems/jump-game-ii/
 * (or)
 * https://practice.geeksforgeeks.org/problems/minimum-number-of-jumps-1587115620/1#
 * @author Gaurav
 * 01/08/21
 */
public class MinimumNumberOfJumps {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        //int[] arr = {2,3,1,1,4};
        int minJumps = minJumps(arr);
        System.out.println("Minimum number of jumps to reach the end of the array is : " + minJumps);
    }

    private static int minJumps(int[] arr) {
        if(arr[0] == 0) {
            return -1;
        }
        int n = arr.length;
        if(n < 2) {
            return 0;
        }
        int maxR = arr[0];
        int count = maxR - 0;
        int jumps = 1;
        for(int i = 1; i < n; i++) {
            if(i == n-1) {
                return jumps;
            }
            maxR = Math.max(maxR, i + arr[i]);
            count--;
            if(count == 0) {
                jumps++;
                if(i >= maxR) {
                    return -1;
                }
                count = maxR - i;
            }
        }
        return -1;
    }
}
