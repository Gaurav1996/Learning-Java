package com.gagrawal.practice.dsalgo.arrays;

/**
 * Ref- https://leetcode.com/problems/container-with-most-water/
 * @author Gaurav
 * 20/06/21
 */
public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] nums = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(nums));
    }

    private static int maxArea(int[] height) {
        int n = height.length;
        int i = 0;
        int j = n-1;
        int area = Integer.MIN_VALUE;
        while(i < j) {
            area = Math.max(area, (j-i) * Math.min(height[i], height[j]));
           if(height[i] < height[j]) {
               i++;
           }
           else {
               j--;
           }
        }
        return area;
    }
}
