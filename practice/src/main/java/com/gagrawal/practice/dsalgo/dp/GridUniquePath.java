package com.gagrawal.practice.dsalgo.dp;

/**
 * Ref - https://www.interviewbit.com/problems/grid-unique-paths/
 * @author Gaurav
 * 14/08/21
 */
public class GridUniquePath {
    public static void main(String[] args) {
        int A = 100;
        int B = 5;
        System.out.println("Recursive - Number of unique paths to reach the bottom is : " + recursiveSolution(A, B));
        System.out.println("DP - Number of unique paths to reach the bottom is : " + dpSolution(A,B));
        System.out.println("Combinatorics - Number of unique paths to reach the bottom is : " + combinatoricsSolution(A, B));
    }

    private static int combinatoricsSolution(int rows, int cols) {
        //m-1 + n-1 = m+n-2
        int n = rows + cols -2;
        int r = Math.min(rows, cols) -1;
        //ncr formula
        int res = 1;
        for(int i = 1; i <= r; i++) {
            res = res * (n-r+i)/i;
        }
        return res;
    }

    private static int recursiveSolution(int rows, int cols) {
        return recursiveSolution(0, 0, rows, cols);
    }

    private static int recursiveSolution(int i, int j, int rows, int cols) {
        if(i == rows - 1 && j == cols - 1) {
            return 1;
        }
        if(i >= rows || j >= cols) {
            return 0;
        }
        return recursiveSolution(i+1, j, rows, cols) + recursiveSolution(i, j+1, rows, cols);
    }

    private static int dpSolution(int rows, int cols) {
        int[][] dp = new int[rows][cols];
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                dp[i][j] = -1;
            }
        }
        return dpSolution(0, 0, dp, rows, cols);
    }

    private static int dpSolution(int i, int j, int[][] dp, int rows, int cols) {
        if(i == rows - 1 && j == cols - 1) {
            return 1;
        }
        if(i >= rows || j >= cols) {
            return 0;
        }
        if(dp[i][j] != -1) {
            return dp[i][j];
        }
        dp[i][j] = dpSolution(i+1, j, dp, rows, cols) + dpSolution(i, j+1, dp, rows, cols);
        return dp[i][j];
    }
}
