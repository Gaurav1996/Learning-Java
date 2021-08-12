package com.gagrawal.practice.dsalgo.arrays;

import java.util.*;

/**
 * Ref - https://leetcode.com/problems/merge-intervals/
 * @author Gaurav
 * 08/08/21
 */
public class MergeIntervals {
    public static void main(String[] args) {

        int[][] intervals = {
                {1,3},
                {2,6},
                {8,10},
                {15,18}
        };
        intervals = new int[][]{{1,9},{2,5},{19,20},{10,11},{12,20},{0,3},{0,1},{0,2}};
        System.out.println("Input is : ");
        System.out.println(Arrays.deepToString(intervals));
        int[][] answer = merge(intervals);
        System.out.println("Output is : ");
        System.out.println(Arrays.deepToString(answer));
    }

    private static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        Deque<int[]> merged = new LinkedList<>();

        for(int[] currentInterval : intervals) {
            if(merged.isEmpty() || currentInterval[0] > merged.getLast()[1]) {
                merged.add(currentInterval);
            }
            else {
                merged.getLast()[1] = Math.max(currentInterval[1], merged.getLast()[1]);
            }
        }
        return merged.toArray(new int[0][]);
    }
}
