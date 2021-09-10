package com.gagrawal.practice.dsalgo.arrays;

import java.util.Arrays;

/**
 * Ref - https://leetcode.com/problems/trapping-rain-water/
 * @author Gaurav
 * 09/09/21
 */
public class TrappingRainWater {
    public static void main(String[] args) {
        int[] arr = {3,0,0,2,0,4};
        printOutput(arr);
        printOutput(new int[] {7,4,0,9});
        printOutput(new int[]{6,9,9});
    }

    private static void printOutput(int[] arr) {
        System.out.println("Total rain water that can be trapped for the array " + Arrays.toString(arr) + " is : "
                + rainWaterTrap(arr));
    }

    private static int rainWaterTrap(int[] arr) {
        int res = 0;
        if(arr == null || arr.length < 2) {
            return res;
        }
        int left = 0;
        int right = arr.length - 1;
        int maxLeft = 0;
        int maxRight = 0;
        while (left <= right) {
            if(arr[left] <= arr[right]) {
                if(arr[left] >= maxLeft) {
                    maxLeft = arr[left];
                }
                else {
                    res += maxLeft - arr[left];
                }
                left++;
            }
            else {
                if(arr[right] >= maxRight) {
                    maxRight = arr[right];
                }
                else {
                    res += maxRight - arr[right];
                }
                right--;
            }
        }
        return res;
    }
}
