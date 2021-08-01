package com.gagrawal.practice.dsalgo.graphs;

import java.util.*;

/**
 * Ref - https://leetcode.com/problems/snakes-and-ladders/
 * @author Gaurav
 * 21/07/21
 */
public class SnakeAndLadder {
    public static void main(String[] args) {
//        int[][] board = {
//                {-1,-1,-1,46,47,-1,-1,-1},
//                {51,-1,-1,63,-1,31,21,-1},
//                {-1,-1,26,-1,-1,38,-1,-1},
//                {-1,-1,11,-1,14,23,56,57},
//                {11,-1,-1,-1,49,36,-1,48},
//                {-1,-1,-1,33,56,-1,57,21},
//                {-1,-1,-1,-1,-1,-1,2,-1},
//                {-1,-1,-1,8,3,-1,6,56}
//        };
        //int[][] board = {{-1,1,1},{-1,-1,8},{-1,4,-1}};
        int[][] board = {{-1,1,1,1},{-1,7,1,1},{16,1,1,1},{-1,1,9,1}};
        System.out.println("Minimum steps to finish the game = " + snakesAndLadders(board));
    }

    private static int snakesAndLadders(int[][] board) {

        int n = board.length;
        if(board[0][0] != -1 || board[n-1][0] != -1) {
            return -1;
        }
        int dest = n*n;
        Map<Integer, Integer> map = populateMap(board);
        Queue<Integer> q = new LinkedList<>();
        q.add(1);

        Set<Integer> visited = new HashSet<>();
        visited.add(1);
        int steps = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int square = q.poll();
                if(square == dest) {
                    return steps;
                }
                for(int j = 1; j <= 6; j++) {
                    int newSquare = square + j;
                    if(newSquare > dest) {
                        break;
                    }
                    if(!visited.contains(newSquare)) {
                        if(map.containsKey(newSquare)) {
                            int val = map.get(newSquare);
                            q.add(val);
                        }
                        else {
                            q.add(newSquare);
                        }
                        visited.add(newSquare);
                    }
                }
            }
            steps++;
        }
        return -1;
    }

    private static Map<Integer, Integer> populateMap(int[][] board) {

        int n = board.length;
        Map<Integer, Integer> jumpMap = new HashMap<>();
        int dir = 0;
        int sqNum = 1;
        for(int i = n-1; i >= 0; i--) {
            if(dir%2 == 0) {
                for(int j = 0; j < n; j++) {
                    if(board[i][j] != -1) {
                        jumpMap.put(sqNum, board[i][j]);
                    }
                    sqNum++;
                }
            }
            else {
                for(int j = n-1; j >= 0; j--) {
                    if(board[i][j] != -1) {
                        jumpMap.put(sqNum, board[i][j]);
                    }
                    sqNum++;
                }
            }
            dir++;
        }
        System.out.println("Map is = " + jumpMap);
        return jumpMap;
    }
}
