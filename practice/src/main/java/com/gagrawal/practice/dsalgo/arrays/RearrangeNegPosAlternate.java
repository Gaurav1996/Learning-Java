package com.gagrawal.practice.dsalgo.arrays;

import java.util.Arrays;

/**
 * Ref - https://www.geeksforgeeks.org/rearrange-array-alternating-positive-negative-items-o1-extra-space/
 *
 * Video explanation - https://youtu.be/V_QB59AaeCk
 * @author Gaurav
 * 31/08/21
 */
public class RearrangeNegPosAlternate {
    public static void main(String[] args) {
        int[] arr = {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8};
        rearrangeArray(arr);
        System.out.println("Array after rearranging is : " + Arrays.toString(arr));
    }

    private static void rearrangeArray(int[] arr) {

        int n = arr.length;
        int i = 0; //for -ve values
        int j = 0; //for +ve values
        int k = 0; //for traversing
        //-ve number is at even index, +ve number is at odd index
        while(i < n && j < n && k < n) {

            if(k%2 == 0) {
                //if +ve number at even index then we need to do some operation
                if(arr[k] >= 0) {
                    i = k;
                    j = k;
                    //find first -ve number
                    while(i < n && arr[i] >= 0) {
                        i++;
                    }
                    if(i >= n) {
                        break;
                    }
                    rotateRightByOne(arr, j, i);
                }
            }
            else {
                //if -ve number at odd index then we need to do some operation
                if(arr[k] < 0) {
                    i = k;
                    j = k;
                    //find first +ve number
                    while(j < n && arr[j] < 0) {
                        j++;
                    }
                    if(j >= n) {
                        break;
                    }
                    rotateRightByOne(arr, i, j);
                }
            }
            k++;
        }
    }

    private static void rotateRightByOne(int[] arr, int start, int end) {
        int temp = arr[end];
        for(int i = end - 1; i >= start; i--) {
            arr[i+1] = arr[i];
        }
        arr[start] = temp;
    }
}
