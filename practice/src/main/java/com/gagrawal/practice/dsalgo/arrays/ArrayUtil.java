package com.gagrawal.practice.dsalgo.arrays;

/**
 * @author Gaurav
 * 08/08/21
 */
public class ArrayUtil {
    private ArrayUtil() {

    }
    public static void mergeSort(int[] arr, int left, int right) {
        if(left >= right) {
            return;
        }
        int mid = left + (right-left) /2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    private static void merge(int[] arr, int left, int mid, int right) {

        int[] temp = new int[right - left + 1] ;
        int i = left;
        int j = mid + 1;
        int k = 0;
        while(i <= mid && j <= right) {
            if(arr[i] <= arr[j]) {
                temp[k] = arr[i];
                i++;
            }
            else {
                temp[k] = arr[j];
                j++;
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
    }

    public static void swap(int[] arr, int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }
}
