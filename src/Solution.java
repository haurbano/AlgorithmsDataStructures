// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
import kotlin.Pair;

import java.util.List;
// CLASS BEGINS, THIS CLASS IS REQUIRED
public class Solution
{
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    int minimumDays(int rows, int columns, List<List<Integer> > grid)
    {
        int days = 0;
        int[][] currentGrid = convertGrid(rows, columns, grid);

        return calculateDays(days, rows, columns, currentGrid);

    }

    private int calculateDays(int days, int rows, int columns, int[][] currentGrid) {
        while (isThereMoreZero(currentGrid)){
            days += 1;
            int[][] nextGrid = new int[rows][columns];
            initializeGrid(rows, columns, nextGrid, 0);

            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < columns; c++) {
                    int currentValue = currentGrid[r][c];
                    if (currentValue == 1) {
                        nextGrid[r][c] = 1;
                        marcAdjacentCells(nextGrid, r, c);
                    }
                }
            }
            currentGrid = nextGrid.clone();
        }
        return days;
    }

    private boolean isThereMoreZero(int[][] grid) {
        for (int[] array: grid){
            for (int i = 0; i < grid.length; i++) {
                if (array[i] == 0) return true;
            }
        }
        return false;
    }

    private int[][] marcAdjacentCells(int[][] grid, int r, int c ) {
        // check up
        if (r-1 >= 0){
            grid[r - 1][c] = 1;
        }

        // check down
        if (r + 1 < grid.length) {
            grid[r + 1][c] = 1;
        }

        // check right
        if (c + 1 < grid[0].length) {
            grid[r][c+1] = 1;
        }

        // check left
        if (c - 1>= 0) {
            grid[r][c - 1] = 1;
        }

        return grid;
    }

    private int[][] convertGrid(int rows, int columns, List<List<Integer> > grid) {
        int[][] newGrid = new int[rows][columns];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                newGrid[r][c] = grid.get(r).get(c);
            }
        }
        return newGrid;
    }

    private int[][] initializeGrid(int rows, int columns, int[][] grid, int initValue) {
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                grid[r][c] = initValue;
            }
        }
        return grid;
    }
    // METHOD SIGNATURE ENDS
}
