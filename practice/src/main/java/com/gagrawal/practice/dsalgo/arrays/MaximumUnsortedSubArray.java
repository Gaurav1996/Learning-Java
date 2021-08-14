package com.gagrawal.practice.dsalgo.arrays;

import java.util.Arrays;

/**
 * Ref - https://www.interviewbit.com/problems/maximum-unsorted-subarray/
 *
 * @author Gaurav
 * 14/08/21
 */
public class MaximumUnsortedSubArray {
    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 4, 5};
        nums = new int[]{5,6,3,2,1,4};
        int[] index = subUnsort(nums);
        System.out.println("unsorted index = " + Arrays.toString(index));
    }

    private static int[] subUnsort(int[] nums) {
        int n = nums.length;
        int startIndex = -1;
        int endIndex = -1;
        for(int i = 0; i < n-1; i++) {
            if(nums[i] > nums[i+1]) {
                startIndex = i;
                break;
            }
        }
        if(startIndex == -1) {
            return new int[]{startIndex};
        }
        for(int i = n-2; i>= 0; i--) {
            if(nums[i] > nums[i+1]) {
                endIndex = i;
                break;
            }
        }
        int minVal = Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE;
        for(int i = startIndex; i <= endIndex; i++) {
            minVal = Math.min(minVal, nums[i]);
            maxVal = Math.max(maxVal, nums[i]);
        }
        for(int i = 0; i < startIndex; i++) {
            //we assume A[0] to A[start] should be sorted which means any value before startIndex should be less than minValue
            //if anyValue is greater than minValue then that array is unsorted, and we need to start from there
            if(nums[i] > minVal) {
                startIndex = i;
                break;
            }
        }
        for(int i = n-1; i > endIndex; i--) {
            if(nums[i] < maxVal) {
                endIndex = i;
                break;
            }
        }
        return new int[]{startIndex, endIndex};
    }
}
