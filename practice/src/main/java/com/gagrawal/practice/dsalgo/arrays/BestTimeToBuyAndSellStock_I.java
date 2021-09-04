package com.gagrawal.practice.dsalgo.arrays;

/**
 * Refer - https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * @author Gaurav
 * 30/08/21
 */
public class BestTimeToBuyAndSellStock_I {
    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};
        arr = new int[]{2, 4, 1};
        System.out.println("Maximum profit is : " + maxProfit(arr));
    }

    private static int maxProfit(int[] prices) {
        int min = prices[0];
        int profit = 0;
        for(int num : prices) {
            if(num < min) {
                min = num;
            }
            else {
                profit = Math.max(profit, num - min);
            }
        }
        return profit;
    }
}
