package com.gagrawal.practice.quick;

/**
 * I/p
 * ----
 * 123
 * 456
 * 789
 * ----
 * LEFT
 * ----
 * 369
 * 258
 * 147
 */
public class RotateMatrix {
    public static void main(String[] args) {
        int A[][] = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        int rows = 3;
        int columns = 3;
        String direction = "Left";
        A = transpose(A,rows,columns);
        System.out.println("Before rotate");
        printMatrix(A,3,3);
        System.out.println("----------");
        if(direction.equals("Right")) {
            A=interchangeRows(A,rows,columns);
        }
        else {
            A = interChangeColumns(A,rows,columns);
        }
        printMatrix(A,rows,columns);
    }

    private static void printMatrix(int[][] a, int rows, int columns) {
        for(int i = 0;i<rows;i++) {
            for(int j=0;j<columns;j++) {
                System.out.print(a[i][j]);
            }
            System.out.println();
        }
    }

    private static int[][] interChangeColumns(int[][] a, int rows, int columns) {
        for(int i=0;i<columns;i++) {
            int t = a[0][i];
            a[0][i] = a[rows-1][i];
            a[rows-1][i] = t;
        }
        return a;
    }

    private static int[][] interchangeRows(int[][] a, int rows, int columns) {
        for(int i=0;i<rows;i++) {
            int t = a[i][0];
            a[i][0] = a[i][columns - 1];
            a[i][columns-1] = t;
        }
        return a;
    }

    private static int[][] transpose(int[][] a, int rows, int columns) {
        for(int i=0;i<rows;i++) {
            for(int j=i;j<columns;j++) {
                int t = a[i][j];
                a[i][j] = a[j][i];
                a[j][i] = t;
            }
        }
        return a;
    }
}
