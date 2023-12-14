package sudoku;

import java.util.Arrays;

public class SudokuSolver implements SudokuSolverInterface {
    private int[][] grid;

    public SudokuSolver(int[][] input_grid) {
    	this.grid = input_grid;
    }

	
    @Override
    public boolean solve() {
    	return solve_h(0, 0);
    }
    
    private boolean solve_h(int row, int col) {
    	if (row == 9) {
            return true;
        }

        int nextRow = (col == 8) ? row + 1 : row;	//advance if at last
        int nextCol = (col == 8) ? 0 : col + 1;

        if (grid[row][col] != 0) {
            return solve_h(nextRow, nextCol);
        }

        for (int number = 1; number <= 9; number++) {
            if (isValid(row, col, number)) {
                grid[row][col] = number;

                if (solve_h(nextRow, nextCol)) {
                    return true;
                }

                grid[row][col] = 0;
            }
        }

        return false;
    }

    @Override
    public void set(int row, int col, int digit) {
        if (row < 0 || row >= 9 || col < 0 || col >= 9 || digit < 0 || digit > 9) {
            throw new IllegalArgumentException();
        }
        grid[row][col] = digit;
    }

    @Override
    public int get(int row, int col) {
        return grid[row][col];
    }

    @Override
    public void clear(int row, int col) {
        set(row, col, 0);
    }

    @Override
    public void clearAll() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                grid[i][j] = 0;
            }
        }
    }

    @Override
    public boolean isValid(int row, int col) {
        int num = grid[row][col];
        return isValid(row, col, num);
    }

    private boolean isValid(int row, int col, int num) {
        // Check row
        for (int i = 0; i < 9; i++) {
            if (grid[row][i] == num && i != col) {
                return false;
            }
        }

        // Check col
        for (int i = 0; i < 9; i++) {
            if (grid[i][col] == num && i != row) {
                return false;
            }
        }

        // Check if num in 3x3
        int startRow = row - row % 3;  //modulo 3 to find start of 3x3
        int startCol = col - col % 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
            	
                if (grid[i][j] == num && i != row && j != col) {
                    return false;
                }
            }
        }

        return true;
    }

    @Override
    public boolean isAllValid() {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (grid[row][col] != 0 && !isValid(row, col)) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void setGrid(int[][] matrix) {
        if (matrix.length != 9 || matrix[0].length != 9) {
            throw new IllegalArgumentException("Grid must be 9x9");
        }
        for (int[] row : matrix) {
            for (int digit : row) {
                if (digit < 0 || digit > 9) {
                    throw new IllegalArgumentException("Values must be between 0 and 9");
                }
            }
        }
        this.grid = matrix;
    }

    @Override
    public int[][] getGrid() {
    	int[][] copy = new int[grid.length][];
        for (int i = 0; i < grid.length; i++) {
            copy[i] = Arrays.copyOf(grid[i], grid[i].length);
        }
        return copy;
    }
}
