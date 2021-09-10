package com.gagrawal.practice.dsalgo.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Ref - https://leetcode.com/problems/subarray-sum-equals-k/
 *
 * @author Gaurav
 * 31/08/21
 */
public class SubarraySumEqualsToK {
    public static void main(String[] args) {

        int[] arr = {1,1,1};
        int K = 2;
        printOutput(arr, K);
        arr = new int[] {1,2,3};
        K = 3;
        printOutput(arr, K);
        arr = new int[]{3,4,7,2,-3,1,4,2,1};
        K = 7;
        printOutput(arr, K);
        arr = new int[]{-1,1,0};
        K = 0;
        printOutput(arr, K);

        printOutput(new int[]{1, 4, 20, 3, 10, 5}, 33);

        printOutput(new int[]{10, 2, -2, -20, 10}, -10);
    }

    private static void printOutput(int[] arr, int k) {
        System.out.println("For the array " + Arrays.toString(arr) + " number of subarrays with sum = " + k + " is : " + countSubArraySum(arr, k));
    }

    private static int countSubArraySum(int[] arr, int k) {

        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
//        int start = 0;
//        int end = -1;
        for(int num : arr) {
            sum += num;
            if(sum == k) {
                ans++;
                //start = 0;
                //end = i;
            }
            if(map.containsKey(sum-k)) {
                ans += map.get(sum-k);
                //start = sum-k+1;
                //end = i;
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            //map.put(sum, i);
        }
        return ans;
    }
}
