package sudoku;

public interface SudokuSolverInterface {
	/**
	 * Solves the sudoku.
	 * 
	 * @return true if the sudoku is solveable
	 */
	boolean solve();

	/**
	 * Puts digit in the box row, col.
	 * 
	 * @param row   The row
	 * @param col   The column
	 * @param digit The digit to insert in box row, col
	 * @throws IllegalArgumentException if row, col or digit is outside the range
	 *                                  [0..9]
	 */
	void set(int row, int col, int digit);

	/**
	 * Returns the int at a given row and column.
	 * 
	 * @param row   The row
	 * @param col   The column
	 */
	int get(int row, int col);

	/**
	 * Clears digit in the box row, col.
	 * 
	 * @param row   The row
	 * @param col   The column
	 * @throws IllegalArgumentException if row, col or digit is outside the range
	 *                                  [0..9]
	 */
	void clear(int row, int col);

	/**
	 * Clears all digits in the sudoku.
	 */
	void clearAll();

	/**
	 * Checks that the digit in the box row, col follows the sudoku rules.
	 * 
	 * @param row The row
	 * @param col The column
	 * @throws IllegalArgumentException if row, col or digit is outside the range
	 *                                  [0..9]
	 * @return true if the digit in the box row, col follows the sudoku rules.
	 */
	boolean isValid(int row, int col);

	/**
	 * Checks that the grid follows the sudoku rules.
	 * 
	 * @throws IllegalArgumentException if row, col or digit is outside the range
	 *                                  [0..9] anywhere in the grid.
	 * @return true if the grid follows the sudoku rules.
	 */
	boolean isAllValid();

	/**
	 * Fills the grid with the digits in m. The digit 0 represents an empty box.
	 * 
	 * @param m the matrix with the digits to insert
	 * @throws IllegalArgumentException if m has the wrong dimension or contains
	 *                                  values outside the range [0..9]
	 */
	void setGrid(int[][] m);

	/**
	 * Returns the grid inside of solver.

	 * @return a int[][] grid
	 */
	int[][] getGrid();
}
