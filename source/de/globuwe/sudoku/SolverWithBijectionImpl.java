package de.globuwe.sudoku;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

public class SolverWithBijectionImpl implements Solver {

	private Logger log = Logger.getLogger(SolverWithBijectionImpl.class.getName());

	/**
	 * 
	 * @param sudoku
	 * @return
	 */
	@Override
	public List<List<Move>> findAllSolutions(final Sudoku sudoku) {
		List<List<Move>> result = new ArrayList<List<Move>>();

		if (sudoku.isComplete()) {
			return result;
		}

		Sudoku work = new Sudoku(sudoku);

		List<Move> solution = findSolution(work);
		if (solution == null) {
			return result;
		}
		
		work.applyMoves(solution);
		
		if (work.isComplete()) {
			result.add(solution);
		} else {
			List<Move> guesses = findGuesses(work);
			for (int i = 0; i < guesses.size(); i++) {
				Sudoku trial = new Sudoku(work);
				Move trialMove = guesses.get(i);
				trial.applyMove(trialMove);
				List<List<Move>> help = findAllSolutions(trial);
				for (int j = 0; j < help.size(); j++) {
					List<Move> s = new ArrayList<Move>(solution);
					s.add(trialMove);
					s.addAll(help.get(j));
					result.add(s);
				}
			}
		}

		return result;
	}

	/**
	 * 
	 * @param trial
	 * @return
	 */
	private List<Move> findGuesses(Sudoku trial) {
		List<Move> result = new ArrayList<Move>();
		Set<Integer>[][] choices = trial.getAlternatives();
		int minZ = 0;
		int minS = 0;
		boolean first = true;
		for (int z = 0; z < 9; z++) {
			for (int s = 0; s < 9; s++) {
				if (first) {
					if (choices[z][s].size() != 0) {
						minZ = z;
						minS = s;
						first = false;
					}
				} else {
					if (choices[z][s].size() != 0 && choices[z][s].size() < choices[minZ][minS].size()) {
						minZ = z;
						minS = s;
					}
				}
			}
		}
		if (!first) {
			for (Integer value : choices[minZ][minS]) {
				result.add(new Move(minZ, minS, value));
			}
		}
		return result;
	}

	/**
	 * 
	 * @param sudoku
	 * @return
	 */
	@Override
	public List<Move> findSolution(final Sudoku sudoku) {

		List<Move> result = new ArrayList<Move>();

		Sudoku work = new Sudoku(sudoku);

		Move[] moves = findUnambiguousMoves(work);
		while (moves.length > 0) {
			for (int i = 0; i < moves.length; i++) {
				if (!work.isValid(moves[i])) {
					return null;
				}
				work.applyMove(moves[i]);
				result.add(moves[i]);
			}
			moves = findUnambiguousMoves(work);
		}

		return result;
	}

	/**
	 * 
	 */
	public void solve(Sudoku sudoku) {

		List<Move> solution = findSolution(sudoku);
		if (solution != null) {
			for (Move move : solution) {
				sudoku.applyMove(move);
			}
		}

	}

	private Move[] findUnambiguousMoves(Sudoku sudoku) {

		if (sudoku.isComplete()) {
			return new Move[0];
		}

		Set<Integer>[][] choices = sudoku.getAlternatives();

		Move[] mandatoryMoves = findSingleAlternatives(choices);
		if (mandatoryMoves.length == 0) {
			log.fine("No posible moves found, computing bijections...");
			List<Bijection> bijections = findBijections(choices);
			excludeBijections(choices, bijections);
			mandatoryMoves = findSingleAlternatives(choices);
		}
		return mandatoryMoves;
	}

	/**
	 * 
	 * @param choices
	 * @return
	 */
	private Move[] findSingleAlternatives(Set<Integer>[][] choices) {
		List<Move> result = new ArrayList<Move>();
		for (int z = 0; z < 9; z++) {
			for (int s = 0; s < 9; s++) {
				if (choices[z][s].size() == 1) {
					result.add(new Move(z, s, choices[z][s].iterator().next()));
				}
			}
		}
		return result.toArray(new Move[result.size()]);
	}

	/**
	 * 
	 * @param unitType
	 * @param unitNumber
	 * @param unitChoices
	 * @param bijectionSize
	 */
	private List<Bijection> findBijections(UnitType unitType, int unitNumber, List<Alternatives> unitChoices,
			List<Alternatives> union) {

		List<Bijection> result = new ArrayList<Bijection>();

		if (unitChoices.size() == 0) {
			return result;
		}

		for (int i = 0; i < unitChoices.size(); i++) {
			List<Alternatives> trial = new ArrayList<Alternatives>(union);
			trial.add(unitChoices.get(i));
			log.finest("trying " + trial);
			Bijection bijection = new Bijection(unitType, unitNumber, trial);
			Set<Integer> unionSet = bijection.getUnionSet();
			if (unionSet.size() == trial.size()) {
				result.add(bijection);
			}
			List<Alternatives> leftChoices = new ArrayList<Alternatives>();
			for (int j = i + 1; j < unitChoices.size(); j++) {
				leftChoices.add(unitChoices.get(j));
			}
			result.addAll(findBijections(unitType, unitNumber, leftChoices, trial));
		}
		return result;
	}

	/**
	 * 
	 * @param choices
	 * @param bijections
	 */
	private void excludeBijections(Set<Integer>[][] choices, List<Bijection> bijections) {

		for (int i = 0; i < bijections.size(); i++) {
			Bijection bijection = bijections.get(i);
			Set<Integer> unionSet = bijection.getUnionSet();
			Set<Integer> indexes = bijection.getElementIndexs();
			switch (bijection.unitType) {
			case ROW:
				int z = bijection.unitNumber;
				for (int j = 0; j < 9; j++) {
					if (!indexes.contains(z * 10 + j)) {
						choices[z][j].removeAll(unionSet);
					}
				}
				break;
			case COLUMN:
				int s = bijection.unitNumber;
				for (int j = 0; j < 9; j++) {
					if (!indexes.contains(j * 10 + s)) {
						choices[j][s].removeAll(unionSet);
					}
				}
				break;
			case QUADRANT:
				int q = bijection.unitNumber;
				for (int j = 0; j < 9; j++) {
					int zz = 3 * (q / 3) + j / 3;
					int ss = 3 * (q % 3) + j % 3;
					if (!indexes.contains(zz * 10 + ss)) {
						choices[zz][ss].removeAll(unionSet);
					}
				}
				break;
			}
		}
	}

	/**
	 * 
	 * @param choices
	 */
	private List<Bijection> findBijections(Set<Integer>[][] choices) {

		List<Bijection> result = new ArrayList<Bijection>();

		for (int z = 0; z < 9; z++) {
			log.finest("Computing bijections for row " + z);
			List<Alternatives> unitChoices = new ArrayList<Alternatives>();
			for (int i = 0; i < 9; i++) {
				if (choices[z][i].size() > 1) {
					unitChoices.add(new Alternatives(z, i, choices[z][i]));
				}
			}
			result.addAll(findUsefulBijections(UnitType.ROW, z, unitChoices));
		}

		for (int s = 0; s < 9; s++) {
			log.finest("Computing bijections for column " + s);
			List<Alternatives> unitChoices = new ArrayList<Alternatives>();
			for (int i = 0; i < 9; i++) {
				if (choices[i][s].size() > 1) {
					unitChoices.add(new Alternatives(i, s, choices[i][s]));
				}
			}
			result.addAll(findUsefulBijections(UnitType.COLUMN, s, unitChoices));
		}

		for (int q = 0; q < 9; q++) {
			log.finest("Computing bijections for quadrant " + q);
			List<Alternatives> unitChoices = new ArrayList<Alternatives>();
			for (int i = 0; i < 9; i++) {
				int z = 3 * (q / 3) + i / 3;
				int s = 3 * (q % 3) + i % 3;
				if (choices[z][s].size() > 1) {
					unitChoices.add(new Alternatives(z, s, choices[z][s]));
				}
			}
			result.addAll(findUsefulBijections(UnitType.QUADRANT, q, unitChoices));
		}

		return result;
	}

	/**
	 * 
	 * @param unitType
	 * @param unitNumber
	 * @param unitChoices
	 * @return
	 */
	private List<Bijection> findUsefulBijections(UnitType unitType, int unitNumber, List<Alternatives> unitChoices) {

		List<Bijection> result = findBijections(unitType, unitNumber, unitChoices, new ArrayList<Alternatives>());

		log.finest("Bijections found: " + result);
		log.finest("Removing useless bijections ...");
		Iterator<Bijection> iter = result.iterator();
		while (iter.hasNext()) {
			Bijection bijection = iter.next();
			if (bijection.size() == unitChoices.size()) {
				iter.remove();
			}
		}
		log.finest("Bijections remaining: " + result);

		return result;
	}

}
