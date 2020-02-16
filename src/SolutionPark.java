import java.util.ArrayList;
import java.util.List;

public class SolutionPark {
    int currentValue = 1;

    int numberAmazonTreasureTrucks(int rows, int column, List<List<Integer>> grid) {
        int[][] newGrid = new int[rows][column];
        newGrid = initializeGrid(rows, column, newGrid, 0);
        int[][] mGrid = convertGrid(rows, column, grid);

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < column; c++) {
                int value = mGrid[r][c];
                if (value == 0) {
                    newGrid[r][c] = 0;
                } else {
                    newGrid[r][c] = checkAdjacentValues(mGrid, newGrid, r, c, rows, column);
                }
            }
        }

        return countNumbers(newGrid, rows, column);
    }

    private int countNumbers(int[][] grid, int rows, int columns) {
        ArrayList<Integer> numbers = new ArrayList<>();

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                int value = grid[r][c];
                if (!numbers.contains(value) && value != 0) {
                    numbers.add(value);
                }
            }
        }

        return numbers.size();
    }

    private int checkAdjacentValues(int [][] grid, int[][] newGrid, int r, int c, int rows, int columns) {
        int compareUp = Integer.MAX_VALUE;
        int compareLeft = Integer.MAX_VALUE;

        // check up
        if (r - 1 >= 0) {
            compareUp = grid[r - 1][c];
        }

        // check left
        if (c - 1 >= 0) {
            compareLeft = grid[r][c - 1];
        }

        if (compareLeft == Integer.MAX_VALUE && compareUp == Integer.MAX_VALUE) {
            currentValue += 1;
            return currentValue;
        }

        if (compareLeft == 0 && compareUp == 0) {
            currentValue += 1;
            return currentValue;
        }

        if (compareLeft == 0 && compareUp == Integer.MAX_VALUE) {
            currentValue += 1;
            return currentValue;
        }

        if (compareLeft == Integer.MAX_VALUE && compareUp == 0) {
            currentValue += 1;
            return currentValue;
        }

        if (    compareLeft != 0 &&
                compareUp != 0 &&
                compareLeft != Integer.MAX_VALUE &&
                compareUp != Integer.MAX_VALUE
        ) {
            newGrid = changeGridNumber(newGrid, rows, columns, Math.max(newGrid[r][c - 1], newGrid[r -  1][c]), Math.min(newGrid[r][c - 1], newGrid[r -  1][c]));
            return Math.min(newGrid[r][c - 1], newGrid[r -  1][c]);
        }

        if (compareLeft != 0 && compareLeft != Integer.MAX_VALUE) {
            return newGrid[r][c - 1];
        } else {
            return newGrid[r -  1][c];
        }
    }

    private int[][] changeGridNumber(int[][] grid, int rows, int column, int oldValue, int newValue) {
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < column; c++) {
                if (grid[r][c] == oldValue) {
                    grid[r][c] = newValue;
                }
            }
        }

        return grid;
    }

    private int[][] initializeGrid(int rows, int columns, int[][] grid, int initValue) {
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                grid[r][c] = initValue;
            }
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
}
