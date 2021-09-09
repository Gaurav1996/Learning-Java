package com.gagrawal.practice.dsalgo.dp;

import java.util.Arrays;

/**
 * Ref - https://www.geeksforgeeks.org/maximum-profit-by-buying-and-selling-a-share-at-most-twice/
 * YouTube - https://youtu.be/kSfPhRHULgs (Only DP video explanation)
 * @author Gaurav
 * 09/09/21
 */
public class BestTimeToBuyAndSellStock_2Transactions {
    public static void main(String[] args) {
        printOutput(new int[]{2, 30, 15, 10, 8, 25, 80});
    }

    private static void printOutput(int[] arr) {
        System.out.println("**Simple approach**");
        System.out.println("Maximum profit with two transaction " + Arrays.toString(arr) + " is : " + maxProfitSimpleApproach(arr));
        System.out.println("**DP approach**");
        System.out.println("Maximum profit with two transaction " + Arrays.toString(arr) + " is : " + maxProfitDPApproach(arr));
    }

    private static int maxProfitDPApproach(int[] arr) {

        int n = arr.length;
        int[] dp = new int[n];
        int max = arr[n-1];
        int min = arr[0];
        for(int i = n-2; i >=0; i--) {
            //from the right store the profit got after doing 1 transaction
            max = Math.max(arr[i], max);
            int profit = max - arr[i];
            dp[i] = Math.max(dp[i+1], profit);
        }
        for(int i = 1; i < n; i++) {
            min = Math.min(arr[i], min);
            int currentProfit = arr[i] - min;
            int profit = dp[i] + currentProfit;
            dp[i] = Math.max(dp[i-1], profit);
        }
        return dp[n-1];
    }

    private static int maxProfitSimpleApproach(int[] arr) {

        int minBuy1 = Integer.MAX_VALUE;
        int minBuy2 = Integer.MAX_VALUE;
        int profitAfter1stTransaction = 0;
        int profitAfter2ndTransaction = 0;
        for(int num : arr) {
            minBuy1 = Math.min(minBuy1, num);
            profitAfter1stTransaction = Math.max(profitAfter1stTransaction, num - minBuy1);
            minBuy2 = Math.min(minBuy2, num - profitAfter1stTransaction);
            profitAfter2ndTransaction = Math.max(profitAfter2ndTransaction, num - minBuy2);
        }
        return profitAfter2ndTransaction;
    }
}
