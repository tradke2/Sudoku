package de.globuwe.sudoku;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class SolverStraightImpl implements Solver {

	private Logger log = Logger
			.getLogger(SolverWithBijectionImpl.class.getName());

	@Override
	public List<List<Move>> findAllSolutions(Sudoku sudoku) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Move> findSolution(Sudoku sudoku) {

		if (sudoku.isComplete()) {
			return new ArrayList<Move>();
		}

		Sudoku work = new Sudoku(sudoku);

		List<List<Move>> solutions = bruteForceSearch(work);
		if (solutions.isEmpty()) {
			log.fine("no solution found with brute force ...");
			return null;
		}
		if (solutions.size() > 1) {
			log.info(solutions.size() + " solutions found");
		}

		return solutions.get(0);
	}

	private List<List<Move>> bruteForceSearch(Sudoku sudoku) {
		ArrayList<List<Move>> result = new ArrayList<List<Move>>();

		List<Alternatives> alternatives = computeAlternatives(sudoku).stream()
				.filter(a -> sudoku.getElement(a.z, a.s) == 0)
				.collect(toList());

		if (alternatives.isEmpty()) {
			return result;
		}

		Optional<Alternatives> firstTry = alternatives.stream()
				.sorted((a1, a2) -> Integer.compare(a1.set.size(), a2.set.size()))
				.findFirst();
		if (firstTry.isEmpty()) {
			return result;
		}
		Alternatives a = firstTry.get();
		Iterator<Integer> values = a.set.iterator();
		while (values.hasNext()) {
			Move move = new Move(a.z, a.s, values.next());
			Sudoku work = new Sudoku(sudoku);
			work.applyMove(move);
			if (work.isComplete()) {
				result.add(Arrays.asList(move));
			} else {
				List<List<Move>> rest = bruteForceSearch(work);
				rest.forEach(restSolution -> result.add(prependMove(move, restSolution)));
			}
		}

		return result;
	}

	private List<Move> prependMove(Move move, List<Move> restSolution) {
		List<Move> newSolution = new ArrayList<>();
		newSolution.add(move);
		newSolution.addAll(restSolution);
		return newSolution;
	}

	private List<Alternatives> computeAlternatives(Sudoku sudoku) {
		List<Alternatives> alternatives = new ArrayList<Alternatives>();
		Set<Integer>[][] choices = sudoku.getAlternatives();
		for (int z = 0; z < 9; z++) {
			for (int s = 0; s < 9; s++) {
				alternatives.add(new Alternatives(z, s, choices[z][s]));
			}
		}
		return alternatives;
	}

}
