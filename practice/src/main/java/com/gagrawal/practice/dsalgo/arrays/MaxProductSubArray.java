package com.gagrawal.practice.dsalgo.arrays;

import java.util.Arrays;

/**
 * Ref - https://practice.geeksforgeeks.org/problems/maximum-product-subarray3604/1#
 * @author Gaurav
 * 01/09/21
 */
public class MaxProductSubArray {

    public static void main(String[] args) {
        int[] arr = {6, -3, -10, 0, 2};
        System.out.println("Maximum product sub array for the arr : " + Arrays.toString(arr) + " is : " + maxProductSubArray(arr));
    }

    private static long maxProductSubArray(int[] arr) {
        long minVal = Long.valueOf(arr[0]);
        long maxVal = Long.valueOf(arr[0]);
        long maxProduct = Long.valueOf(arr[0]);
        for(int i = 1; i < arr.length; i++) {
            int num = arr[i];
            if(num < 0) {
                long temp = maxVal;
                maxVal = minVal;
                minVal = temp;
            }
            maxVal = Math.max(num, maxVal * num);
            minVal = Math.min(num, minVal * num);
            maxProduct = Math.max(maxProduct, maxVal);
        }
        return maxProduct;
    }
}
