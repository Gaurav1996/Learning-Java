package com.gagrawal.practice.dsalgo.arrays.sorting_algos;

import java.util.Arrays;

/**
 * @author Gaurav
 * 26/02/22
 */
public class SortRunner {

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,5,2,8};
        System.out.println("Before sorting\nArr is " + Arrays.toString(arr));
        //sort(arr, new SelectionSort());
        //sort(arr, new BubbleSort());
        //sort(arr, new InsertionSort());
        sort(arr, new MergeSort());
    }

    private static void sort(int[] arr, Sort sortAlgo) {
        sortAlgo.sort(arr);
    }
}
