package de.globuwe.sudoku;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Sudoku {

	private static final Set<Integer> ALL_VALUES = new HashSet<Integer>(
			Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }));

	private int[][] el = new int[9][9];

	private Set<Integer>[][] alternatives = null;

	/**
	 * 
	 */
	public Sudoku() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				el[i][j] = 0;
			}
		}
	}

	/**
	 * 
	 * @param original
	 */
	public Sudoku(Sudoku original) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				el[i][j] = original.el[i][j];
			}
		}
	}

	/**
	 * 
	 * @param z
	 * @param s
	 * @param value
	 */
	public void setElement(int z, int s, int value) {
		if (value < 0 || value > 9) {
			throw new IllegalArgumentException("Value " + value + " out of range. Valid values: 1..9");
		}
		el[z][s] = value;
		alternatives = null;
	}

	/**
	 * 
	 * @param z
	 * @param s
	 * @return
	 */
	public int getElement(int z, int s) {
		return el[z][s];
	}

	/**
	 * 
	 */
	@SuppressWarnings("unchecked")
	public Set<Integer>[] getCollisionSets() {

		Set<Integer>[] collSets = new HashSet[9];
		for (int i = 0; i < collSets.length; i++) {
			collSets[i] = new HashSet<Integer>();
		}

		for (int z = 0; z < 9; z++) {
			for (int s = 0; s < 9; s++) {
				int val = el[z][s];
				if (val == 0) {
					continue;
				}
				for (int i = z + 1; i < 9; i++) {
					int v = el[i][s];
					if (v == val) {
						collSets[val - 1].add(10 * z + s);
						collSets[val - 1].add(10 * i + s);
					}
				}
				for (int i = s + 1; i < 9; i++) {
					int v = el[z][i];
					if (v == val) {
						collSets[val - 1].add(10 * z + s);
						collSets[val - 1].add(10 * z + i);
					}
				}
				int k = z / 3;
				int l = s / 3;
				for (int i = 0; i < 3; i++) {
					int zz = 3 * k + i;
					if (zz <= z) {
						continue;
					}
					for (int j = 0; j < 3; j++) {
						int ss = 3 * l + j;
						if (ss <= s) {
							continue;
						}
						int v = el[zz][ss];
						if (v == val) {
							collSets[val - 1].add(10 * z + s);
							collSets[val - 1].add(10 * zz + ss);
						}
					}
				}
			}
		}
		return collSets;

	}

	/**
	 * 
	 * @return
	 */
	public boolean isComplete() {
		boolean result = true;

		all: for (int z = 0; z < 9; z++) {
			for (int s = 0; s < 9; s++) {
				if (el[z][s] == 0) {
					result = false;
					break all;
				}
			}
		}

		return result;
	}

	/**
	 * 
	 * @param move
	 * @param choices
	 */
	void applyMove(Move move) {

		if (!isValid(move)) {
			throw new InvalidMoveException(move);
		}

		int z = move.z;
		int s = move.s;
		int value = move.value;
		el[z][s] = value;
		for (int i = 0; i < 9; i++) {
			getAlternatives()[i][s].remove(value);
			getAlternatives()[z][i].remove(value);
		}
		int k = z / 3;
		int l = s / 3;
		for (int i = 0; i < 3; i++) {
			int zz = 3 * k + i;
			for (int j = 0; j < 3; j++) {
				int ss = 3 * l + j;
				getAlternatives()[zz][ss].remove(value);
			}
		}

	}

	/**
	 * 
	 * @param move
	 * @return
	 */
	public boolean isValid(Move move) {
		for (int i = 0; i < 9; i++) {
			if (el[move.z][i] == move.value) {
				return false;
			}
			if (el[i][move.s] == move.value) {
				return false;
			}
		}
		int k = move.z / 3;
		int l = move.s / 3;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (el[3 * k + i][3 * l + j] == move.value) {
					return false;
				}
			}
		}
		return true;
	}

	public boolean isValid() {
		for (int z = 0; z < 9; z++) {
			Set<Integer> allowedValues = new HashSet<Integer>(ALL_VALUES);
			for (int s = 0; s < 9; s++) {
				int value = el[z][s];
				if (value == 0) {
					continue;
				}
				if (allowedValues.contains(value)) {
					allowedValues.remove(value);
				} else {
					return false;
				}
			}
		}
		for (int s = 0; s < 9; s++) {
			Set<Integer> allowedValues = new HashSet<Integer>(ALL_VALUES);
			for (int z = 0; z < 9; z++) {
				int value = el[z][s];
				if (value == 0) {
					continue;
				}
				if (allowedValues.contains(value)) {
					allowedValues.remove(value);
				} else {
					return false;
				}
			}
		}
		for (int bz = 0; bz < 3; bz++) {
			for (int bs = 0; bs < 3; bs++) {
				Set<Integer> allowedValues = new HashSet<Integer>(ALL_VALUES);
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						int value = el[3 * bz + i][3 * bs + j];
						if (value == 0) {
							continue;
						}
						if (allowedValues.contains(value)) {
							allowedValues.remove(value);
						} else {
							return false;
						}
					}
				}
			}
		}
		return true;
	}

	/**
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private void computeAlternatives() {

		Set<Integer>[][] choices = new HashSet[9][9];

		for (int z = 0; z < 9; z++) {
			for (int s = 0; s < 9; s++) {
				choices[z][s] = new HashSet<Integer>(ALL_VALUES);
			}
		}

		for (int z = 0; z < 9; z++) {
			for (int s = 0; s < 9; s++) {
				if (el[z][s] != 0) {
					choices[z][s].clear();
					continue;
				}
				for (int i = 0; i < 9; i++) {
					int v = el[i][s];
					if (v != 0) {
						choices[z][s].remove(v);
					}
				}
				for (int i = 0; i < 9; i++) {
					int v = el[z][i];
					if (v != 0) {
						choices[z][s].remove(v);
					}
				}
				int k = z / 3;
				int l = s / 3;
				for (int i = 0; i < 3; i++) {
					int zz = 3 * k + i;
					for (int j = 0; j < 3; j++) {
						int ss = 3 * l + j;
						int v = el[zz][ss];
						if (v != 0) {
							choices[z][s].remove(v);
						}
					}
				}
			}
		}
		this.alternatives = choices;
	}

	/**
	 * 
	 * @return
	 */
	public Set<Integer>[][] getAlternatives() {
		if (alternatives == null) {
			computeAlternatives();
		}
		return alternatives;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		for (int i = 0; i < 9; i++) {
			if (i > 0) {
				sb.append(",");
			}
			sb.append(Arrays.toString(el[i]));
		}
		sb.append("]");
		return sb.toString();
	}

	/**
	 * 
	 * @param solution
	 */
	public void applyMoves(List<Move> solution) {
		if (solution == null) {
			return;
		}
		for (Move move : solution) {
			applyMove(move);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.deepHashCode(el);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sudoku other = (Sudoku) obj;
		if (!Arrays.deepEquals(el, other.el))
			return false;
		return true;
	}

}
