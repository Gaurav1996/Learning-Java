package com.gagrawal.practice.dsalgo.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Ref - https://practice.geeksforgeeks.org/problems/triplet-sum-in-array-1587115621/1
 * Also ref - https://leetcode.com/explore/interview/card/top-interview-questions-medium/103/array-and-strings/776/
 * @author Gaurav
 * 09/09/21
 */
public class TripletEqualToGivenSum {
    public static void main(String[] args) {
        int[] arr = {-1,0,1,2,-1,-4};
        int sum = 0;
        printOutput(arr, sum);
        arr = new int[]{1, 4, 45, 6, 10, 8};
        sum = 13;
        printOutput(arr, sum);
        arr = new int[] {1, 2, 4, 3, 6};
        sum = 10;
        printOutput(arr, sum);
    }

    private static void printOutput(int[] arr, int sum) {

        List<List<Integer>> triplets = threeSum(arr, sum);
        System.out.println("For the array " + Arrays.toString(arr) + " following are the triplets with sum = " + sum);
        for(List<Integer> triple : triplets) {
            System.out.println(triple);
        }
    }

    private static List<List<Integer>> threeSum(int[] arr, int sum) {

        List<List<Integer>> output = new ArrayList<>();
        if(arr == null || arr.length < 3) {
            return output;
        }
        Arrays.sort(arr);
        for(int i = 0; i < arr.length - 2; i++) {
            if(i == 0 || arr[i] != arr[i-1]) {
                int sumToFind = sum - arr[i];
                int low = i + 1;
                int  high = arr.length - 1;
                while(low < high) {
                    int currSum = arr[low] + arr[high];
                    if(currSum == sumToFind) {
                        output.add(Arrays.asList(arr[i], arr[low], arr[high]));
                        while (low < high && arr[low] == arr[low + 1]) {
                            low++;
                        }
                        while (low < high && arr[high] == arr[high-1]) {
                            high--;
                        }
                        low++;
                        high--;
                    }
                    else if(currSum < sumToFind) {
                        low++;
                    }
                    else {
                        high--;
                    }
                }
            }
        }
        return output;
    }
}
