package com.gagrawal.practice.dsalgo.arrays.sorting_algos;

import java.util.Arrays;

/**
 * @author Gaurav
 * 26/02/22
 */
public class MergeSort implements Sort{

    @Override
    public void sort(int[] arr) {
        System.out.println("Merge sort Algo");
        mergeSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    private void mergeSort(int[] arr, int left, int right) {
        if(left >= right) {
            return;
        }
        int mid = left + (right-left)/2;
        mergeSort(arr, left, mid);
        mergeSort(arr,mid + 1, right);
        merge(arr, left, mid, right);
    }

    private void merge(int[] arr, int left, int mid, int right) {

        int[] temp = new int[right - left + 1];
        int l = left;
        int r = mid + 1;
        int k = 0;
        while (l <= mid && r <= right) {
            if(arr[l] <= arr[r]) {
                temp[k] = arr[l];
                l++;
            }
            else {
                temp[k] = arr[r];
                r++;
            }
            k++;
        }
        while (l <= mid) {
            temp[k++] = arr[l++];
        }
        while (r <= right) {
            temp[k++] = arr[r++];
        }
        for(int i = left; i<= right; i++) {
            arr[i] = temp[i-left];
        }
    }
}
