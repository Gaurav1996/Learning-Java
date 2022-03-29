package com.gagrawal.practice.dsalgo.arrays.sorting_algos;

import java.util.Arrays;

import static com.gagrawal.practice.dsalgo.arrays.ArrayUtil.swap;

/**
 * @author Gaurav
 * 26/02/22
 */
public class SelectionSort implements Sort{

    @Override
    public void sort(int[] arr) {
        System.out.println("Selection sort Algo");
        int n = arr.length;
        for(int i = 0; i < n-1; i++) {
            int minIdx = i;
            for(int j = i+1; j < n; j++) {
                if(arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            swap(arr, i, minIdx);
        }
        System.out.println(Arrays.toString(arr));
    }
}
