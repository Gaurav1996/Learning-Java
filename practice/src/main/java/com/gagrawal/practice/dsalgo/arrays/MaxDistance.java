package com.gagrawal.practice.dsalgo.arrays;

/**
 * Ref - https://www.interviewbit.com/problems/max-distance/
 * @author Gaurav
 * 13/08/21
 */
public class MaxDistance {
    public static void main(String[] args) {
        final int[] nums = {3, 5, 4, 2};
        System.out.println("Maximum distance where j-i is greatest is : " + maximumGap(nums));
    }

    private static int maximumGap(final int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = nums[0];
        right[n-1] = nums[n-1];
        for(int i = 1; i < n; i++) {
            left[i] = Math.min(left[i-1], nums[i]);
        }
        for(int i = n-2; i >= 0; i--) {
            right[i] = Math.max(right[i+1], nums[i]);
        }
        int i = 0;
        int j = 0;
        int ans = 0;
        while(i < n && j < n) {
            if(right[j] > left[i]) {
                ans = Math.max(j-i, ans);
                j++;
            }
            else {
                i++;
            }
        }
        return ans;
    }
}
