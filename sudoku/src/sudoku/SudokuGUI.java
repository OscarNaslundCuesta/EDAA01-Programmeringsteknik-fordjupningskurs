package sudoku;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SudokuGUI extends JFrame {

    public JTextField[][] grid; // 9x9 grid of text fields
    private int[][] num_grid;
    private SudokuSolver solver;
    private JButton solveButton;
    private JButton clearButton;

    public SudokuGUI(SudokuSolver solver) {
        this.grid = new JTextField[9][9];
        this.solver = solver;
        num_grid = solver.getGrid();
        solveButton = new JButton("Solve");
        clearButton = new JButton("Clear");


        initializeLayout();
        setUpListeners();
        
        setTitle("Sudoku");
        setSize(400, 400);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void initializeLayout() {
        setLayout(new BorderLayout());
        JPanel gridPanel = new JPanel(new GridLayout(9, 9));
        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                grid[i][j] = new JTextField();
                
                if (num_grid[i][j] != 0) {
                    grid[i][j].setText(String.valueOf(num_grid[i][j]));
                }
                
                grid[i][j].setHorizontalAlignment(JTextField.CENTER);
                // if statement for the colouring
                if (i < 3 && j < 3 || i < 3 && j > 5 || (2 < i && i < 6) && (2 < j && j < 6) || i > 5 && j < 3 || i > 5 && j > 5) {
                	grid[i][j].setBackground(Color.ORANGE);
                }
                gridPanel.add(grid[i][j]);
            }
        }
        add(gridPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(solveButton);
        buttonPanel.add(clearButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // Configure frame
        setTitle("Sudoku Game");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private void updateGrid() {
    	num_grid = solver.getGrid();
    	for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
            	if (num_grid[i][j] == 0) {
                    grid[i][j].setText("");
                } else {
                    grid[i][j].setText(String.valueOf(num_grid[i][j]));
                }
            }
        }
    }
    
    boolean readGrid() {
        boolean invalidInput = false;
        
    	for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
            	String cellValue = grid[i][j].getText().trim();
            	
                try {
                	//parse value in jtextfield
                	int value;
                    if (cellValue.isEmpty()) {
                        value = 0; 
                    } else {
                        value = Integer.parseInt(cellValue);
                    }
                    
                    //check if input value is correct
                    if (value > 0 && value <= 9 || cellValue.isEmpty()) {
                        num_grid[i][j] = value;
                    } else {
                        num_grid[i][j] = 0;
                        grid[i][j].setText("");
                        invalidInput = true;
                    }
                    
                } catch (NumberFormatException e) {
                	grid[i][j].setText("");
                    num_grid[i][j] = 0;
                    invalidInput = true;
                }
            }
        }
    	if (invalidInput) {
            JOptionPane.showMessageDialog(this, "Invalid input detected. Please enter numbers between 1 and 9.", "Input Error", JOptionPane.ERROR_MESSAGE);
            invalidInput = false;
            return false;
    	} else {
    		solver.setGrid(num_grid);	// set grid inside of solver
    		return true;
    	}

    }

    private void setUpListeners() {
    	solveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	if (readGrid()) {  			// only call solve is input grid is correct
            		if(!solver.solve()) {
                        JOptionPane.showMessageDialog(SudokuGUI.this, "Unsolvable sudoku!", "Error", JOptionPane.ERROR_MESSAGE);            		}
                    updateGrid();
            	}
            }
        });

    	clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                solver.clearAll();
                updateGrid();
            }
        });
    }
}
