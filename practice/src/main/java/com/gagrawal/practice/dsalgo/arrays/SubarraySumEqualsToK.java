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
        System.out.println("For the array " + Arrays.toString(arr) + " number of subarrays with sum = " + K + " is : " + countSubArraySum(arr, K));
        arr = new int[] {1,2,3};
        K = 3;
        System.out.println("For the array " + Arrays.toString(arr) + " number of subarrays with sum = " + K + " is : " + countSubArraySum(arr, K));
        arr = new int[]{3,4,7,2,-3,1,4,2,1};
        K = 7;
        System.out.println("For the array " + Arrays.toString(arr) + " number of subarrays with sum = " + K + " is : " + countSubArraySum(arr, K));
        arr = new int[]{-1,1,0};
        K = 0;
        System.out.println("For the array " + Arrays.toString(arr) + " number of subarrays with sum = " + K + " is : " + countSubArraySum(arr, K));
    }

    private static int countSubArraySum(int[] arr, int k) {

        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for(int num : arr) {
            sum += num;
            if(sum == k) {
                ans++;
            }
            if(map.containsKey(sum-k)) {
                ans += map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }
}
