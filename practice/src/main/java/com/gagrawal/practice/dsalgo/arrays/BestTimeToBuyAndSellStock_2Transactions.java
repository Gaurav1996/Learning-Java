package com.gagrawal.practice.dsalgo.arrays;

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
        printOutput(new int[]{10, 22, 5, 75, 65, 80});
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
            //Traverse from right
            /* Get the maximum profit with only one transaction allowed. After this loop,
            profit[i] contains maximum profit from price[i..n-1] using at most one trans. */
            max = Math.max(arr[i], max);
            int profit = max - arr[i];
            dp[i] = Math.max(dp[i+1], profit);
        }
        for(int i = 1; i < n; i++) {
            //Traverse from left
            // Maximum profit is maximum of:
            // a) previous maximum, i.e., profit[i-1]
            // b) (Buy, Sell) at (min_price, price[i]) and
            // add
            // profit of other trans.
            // stored in profit[i]
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
            minBuy2 = Math.min(minBuy2, num - profitAfter1stTransaction); // cost of current buy - prev profit
            profitAfter2ndTransaction = Math.max(profitAfter2ndTransaction, num - minBuy2);
        }
        return profitAfter2ndTransaction;
    }
}
