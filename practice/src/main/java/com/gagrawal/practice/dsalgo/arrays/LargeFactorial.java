package com.gagrawal.practice.dsalgo.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Ref - https://practice.geeksforgeeks.org/problems/factorials-of-large-numbers2508/1#
 * @author Gaurav
 * 01/09/21
 */
public class LargeFactorial {
    public static void main(String[] args) {
        int num = 5;
        System.out.println("Factorial of " +  num + " is : ");
        List<Integer> res = largeFactorial(num);
        for(int n : res) {
            System.out.print(n);
        }
    }

    private static List<Integer> largeFactorial(int num) {
        List<Integer> ans = new ArrayList<>();
        ans.add(1);
        for(int i = 2; i <= num; i++) {
            multiply(ans, i);
        }
        return ans;
    }

    private static void multiply(List<Integer> ans, int num) {
        int len = ans.size();
        int carry = 0;
        for(int i = len-1; i >= 0; i--) {
            int temp = ans.get(i) * num + carry;
            ans.set(i, temp%10);
            carry = temp/10;
        }
        while (carry != 0) {
            ans.add(0, carry%10);
            carry = carry/10;
        }
    }
}
