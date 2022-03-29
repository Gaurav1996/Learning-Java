package com.gagrawal.practice.dsalgo.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Gaurav
 * 21/02/22
 */
public class MissingRanges {
    public static void main(String[] args) {
        int[] nums = {0,1,3,50,75};
        int lower = 0;
        int upper = 99;
        System.out.println("Missing range is " + missingRanges(nums, lower, upper));
        nums = new int[0];
        lower = 1;
        upper = 1;
        System.out.println("Missing range is " + missingRanges(nums, lower, upper));
        lower = -3;
        upper = -1;
        System.out.println("Missing range is " + missingRanges(nums, lower, upper));
        nums = new int[]{-1};
        lower = -1;
        upper = -1;
        System.out.println("Missing range is " + missingRanges(nums, lower, upper));
        nums = new int[]{-1};
        lower = -2;
        upper = -1;
        System.out.println("Missing range is " + missingRanges(nums, lower, upper));
        nums = new int[]{-1};
        lower = -1;
        upper = 0;
        System.out.println("Missing range is " + missingRanges(nums, lower, upper));
    }

    private static List<String> missingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        if(nums.length == 0) {
            if(lower == upper) {
                res.add(lower + "");
            }
            else {
                res.add(lower + "->" + upper);
            }
            return res;
        }
        int expected = lower;
        for(int num : nums) {
            if(num - expected == 1) {
                res.add(expected + "");
            }
            else if(num - expected > 1) {
                res.add(expected + "->" + (num-1));
            }
            expected = num+1;
        }
        if(expected <= upper) {
            if(expected == upper) {
                res.add(expected + "");
            }
            else {
                res.add(expected + "->" + upper);
            }
        }
        return res;
    }
}
