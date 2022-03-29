package com.gagrawal.practice.dsalgo.arrays.sorting_algos;

import java.util.Arrays;

import static com.gagrawal.practice.dsalgo.arrays.ArrayUtil.swap;

/**
 * @author Gaurav
 * 26/02/22
 */
public class BubbleSort implements Sort{

    @Override
    public void sort(int[] arr) {

        System.out.println("Bubble sort Algo");
        int n = arr.length;
        for(int i = 0; i < n-1; i++) {
            boolean flag = false;
            for(int j = 0; j < n-i-1; j++) {
                if(arr[j] > arr[j+1]) {
                    flag = true;
                    swap(arr, j, j+1);
                }
            }
            if(!flag) break;
        }
        System.out.println(Arrays.toString(arr));
    }
}
