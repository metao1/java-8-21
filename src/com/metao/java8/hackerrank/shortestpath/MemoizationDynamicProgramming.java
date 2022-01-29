package com.metao.java8.hackerrank.shortestpath;

public class MemoizationDynamicProgramming {

    public static void main(String[] args) {
        boolean[][] grid = new boolean[][]
                {
                        new boolean[]{true, false, true, true},
                        new boolean[]{true, false, true, true},
                        new boolean[]{true, true, true, true},
                        new boolean[]{true, true, true, true}
                };
        int paths = countPaths(grid, 0, 0, new int[4][4]);
        System.out.println("paths = " + paths);
    }

    static int countPaths(boolean[][] grid, int row, int col, int[][] paths) {
        if (row > 3 || col > 3) return 0;
        if (isAtTheEnd(row, col)) return 1;
        if (!validSquare(grid, row, col)) return 0;
        if (paths[row][col] == 0) {
            paths[row][col] = countPaths(grid, row + 1, col, paths) + countPaths(grid, row, col + 1, paths);
        }
        return paths[row][col];
    }

    private static boolean validSquare(boolean[][] grid, int row, int col) {
        return grid[row][col];
    }

    private static boolean isAtTheEnd(int row, int col) {
        return row == 3 && col == 3;
    }
}
