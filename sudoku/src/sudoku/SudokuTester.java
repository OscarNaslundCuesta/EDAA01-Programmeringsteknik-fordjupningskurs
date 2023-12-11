package sudoku;

import static org.junit.Assert.*;

import javax.swing.JTextField;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SudokuTester {
	private static int[][] board;
	private static SudokuSolver solver;
	
	
	@Before
    public void setUp() throws Exception {
		board = new int[9][9];
		solver = new SudokuSolver(board);
	}
	
	@After
	public void tearDown() throws Exception {
		board = null;
		solver = null;
	}
	
	@Test
	public void testEmpty() {
		board = new int[][] { 
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
		solver = new SudokuSolver(board);
		assertTrue(solver.solve());
	}
	
	@Test
	public void testDuplicate1() {
		board = new int[][] { 
			{ 5, 5, 0, 0, 0, 0, 0, 0, 0 }, 
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 5, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
		solver = new SudokuSolver(board);
		assertFalse(solver.solve());
	}
	
	@Test
	public void testDuplicate2() {
		board = new int[][] { 
			{ 5, 0, 0, 0, 0, 0, 0, 0, 0 }, 
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 5, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
		solver = new SudokuSolver(board);
		assertFalse(solver.solve());
	}
	
	@Test
	public void testDuplicate3() {
		board = new int[][] { 
			{ 5, 0, 0, 0, 0, 0, 0, 0, 0 }, 
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 5, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
		solver = new SudokuSolver(board);
		assertFalse(solver.solve());
	}
	
	@Test
	public void testImpossible() {
		board = new int[][] { 
			{ 1, 2, 3, 0, 0, 0, 0, 0, 0 }, 
			{ 4, 5, 6, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 7, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
		solver = new SudokuSolver(board);
		assertFalse(solver.solve());
	}
	
	@Test
	public void testPossible() {
		board = new int[][] { 
			{ 1, 2, 3, 0, 0, 0, 0, 0, 0 }, 
			{ 4, 5, 6, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
		solver = new SudokuSolver(board);
		assertTrue(solver.solve());
	}
	
	@Test
	public void testClear() {
		board = new int[][] { 
			{ 5, 0, 0, 0, 0, 0, 0, 0, 5 }, 
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
		solver = new SudokuSolver(board);
		assertFalse(solver.solve());
		
		solver.clearAll();
		assertTrue(solver.solve());
	}
	
	@Test
	public void testPossible2() {
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
		assertTrue(solver.solve());
	}
	
	/*
	@Test
	public void testInvalidInput() {
		
		solver = new SudokuSolver(board);
		SudokuGUI gui = new SudokuGUI(solver);
		JTextField[][] grid = gui.grid;
		grid[3][3].setText("a");
		

		assertFalse(gui.readGrid());
	}
	*/

}
