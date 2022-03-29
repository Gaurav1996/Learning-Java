package com.gagrawal.practice.dsalgo.arrays.sorting_algos;

import java.util.Arrays;

/**
 * @author Gaurav
 * 26/02/22
 */
public class InsertionSort implements Sort{

    @Override
    public void sort(int[] arr) {
        System.out.println("Insertion sort Algo");
        int n = arr.length;
        for(int i = 1; i < n; i++) {
            int value = arr[i];
            int hole = i;
            while(hole > 0 && arr[hole-1] > value) {
                arr[hole] = arr[hole-1];
                hole = hole - 1;
            }
            arr[hole] = value;
        }
        System.out.println(Arrays.toString(arr));
    }
}
