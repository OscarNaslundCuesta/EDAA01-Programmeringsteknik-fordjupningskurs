package sudoku;

public class SudokuApplication {
	private static int[][] board;
	private static SudokuSolver solver;
    private static SudokuGUI gui;

	public static void main(String[] args) {
		board = new int[][] {
				{ 0, 0, 8, 0, 0, 9, 0, 6, 2 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 5 },
				{ 1, 0, 2, 5, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 2, 1, 0, 0, 9, 0 },
				{ 0, 5, 0, 0, 0, 0, 6, 0, 0 },
				{ 6, 0, 0, 0, 0, 0, 0, 2, 8 },
				{ 4, 1, 0, 6, 0, 8, 0, 0, 0 },
				{ 8, 6, 0, 0, 3, 0, 1, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 4, 0, 0 } };
		
        solver = new SudokuSolver(board);
        gui = new SudokuGUI(solver);
	}
}
