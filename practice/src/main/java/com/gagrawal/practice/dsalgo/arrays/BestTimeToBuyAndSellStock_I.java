package com.gagrawal.practice.dsalgo.arrays;

import java.util.Arrays;

/**
 * Refer - https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 *
 * Only 1 transaction allowed
 * @author Gaurav
 * 30/08/21
 */
public class BestTimeToBuyAndSellStock_I {
    public static void main(String[] args) {
        //int[] arr = {7,1,5,3,6,4};
        printOutput(new int[]{7,1,5,3,6,4});
        printOutput(new int[]{2, 4, 1});
    }

    private static void printOutput(int[] arr) {
        System.out.println("Maximum profit with one transaction " + Arrays.toString(arr) + " is : " + maxProfit(arr));
    }

    private static int maxProfit(int[] prices) {
        int minBuy = prices[0];
        int maxProfit = 0;
//        for(int num : prices) {
//            if(num < minBuy) {
//                minBuy = num;
//            }
//            else {
//                maxProfit = Math.max(maxProfit, num - minBuy);
//            }
//        }
        for(int num : prices) {
            minBuy = Math.min(num, minBuy);
            maxProfit = Math.max(maxProfit, num-minBuy);
        }
        return maxProfit;
    }
}
