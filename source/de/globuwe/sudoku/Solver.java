package de.globuwe.sudoku;

import java.util.List;

public interface Solver {

	/**
	 * 
	 * @param sudoku
	 * @return
	 */
	List<List<Move>> findAllSolutions(Sudoku sudoku);

	/**
	 * 
	 * @param sudoku
	 * @return
	 */
	List<Move> findSolution(Sudoku sudoku);

}