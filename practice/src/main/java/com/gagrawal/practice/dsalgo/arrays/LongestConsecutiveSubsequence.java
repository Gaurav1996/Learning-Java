package com.gagrawal.practice.dsalgo.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Ref - https://leetcode.com/problems/longest-consecutive-sequence/
 * @author Gaurav
 * 04/09/21
 */
public class LongestConsecutiveSubsequence {
    public static void main(String[] args) {
        printOutput(new int[]{2,6,1,9,4,5,3});
        printOutput(new int[]{1,9,3,10,4,20,2});
    }

    private static void printOutput(int[] arr) {
        System.out.println("Longest consecutive subsequence for the arr " + Arrays.toString(arr) + " is : " + longestConSeq(arr));
    }

    private static int longestConSeq(int[] arr) {

        int longestStreak = 1;
        Set<Integer> set = new HashSet<>();
        for(int num :  arr) {
            set.add(num);
        }
        for(int num : arr) {
            if(!set.contains(num-1)) {
                int currNum = num;
                int currStreak = 1;
                while(set.contains(currNum+1)) {
                    currNum++;
                    currStreak++;
                }
                longestStreak = Math.max(currStreak, longestStreak);
            }
        }
        return longestStreak;
    }
}
