package com.gagrawal.practice.dsalgo.arrays;

import java.util.Arrays;

/**
 * @author Gaurav
 * 08/08/21
 */
public class CountInversions {
    public static void main(String[] args) {
        long[] arr = {3,5,4,7};
        long ans = countInversions(arr);
        //System.out.println("Array is: " + Arrays.toString(arr));
        System.out.println("Number of inversions = " + ans);
    }

    private static long countInversions(long[] arr) {
        int left = 0;
        int right = arr.length - 1;
        return countInversions(arr, left, right);
    }

    private static int countInversions(long[] arr, int left, int right) {
        int inv = 0;
        if(left >= right) {
            return inv;
        }
        int mid = left + (right - left) / 2;
        inv += countInversions(arr, left, mid);
        inv += countInversions(arr, mid + 1, right);
        inv += merge(arr, left, mid, right);
        return inv;
    }

    private static long merge(long[] arr, int left, int mid, int right) {
        int count = 0;
        long[] temp = new long[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= right) {
            if(arr[i] <= arr[j]) {
                temp[k] = arr[i];
                i++;
            }
            else {
                temp[k] = arr[j];
                j++;
                count += (mid + 1 - i);
            }
            k++;
        }
        while (i <= mid) {
            temp[k] = arr[i];
            k++;
            i++;
        }
        while (j <= right) {
            temp[k] = arr[j];
            k++;
            j++;
        }
        for(int s = left; s <= right; s++) {
            arr[s] = temp[s - left];
        }
        return count;
    }
}
