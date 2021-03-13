package de.globuwe.sudoku;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Bijection {

	public final List<Alternatives> alternatives;
	public final UnitType unitType;
	public final int unitNumber;

	public Bijection(UnitType unitType, int unitNumber, List<Alternatives> alternatives) {
		this.unitType = unitType;
		this.unitNumber = unitNumber;
		this.alternatives = Collections.unmodifiableList(alternatives);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return alternatives.toString();
	}

	/**
	 * 
	 * @return
	 */
	public Set<Integer> getUnionSet() {
		return buildUnion(alternatives);
	}
	
	/**
	 * 
	 * @param trial
	 * @return
	 */
	private Set<Integer> buildUnion(List<Alternatives> trial) {
		Set<Integer> result = new HashSet<Integer>();
		for (Alternatives a : trial) {
			result.addAll(a.set);
		}
		return result;
	}

	/**
	 * 
	 * @return
	 */
	public int size() {
		return alternatives.size();
	}

	/**
	 * 
	 * @return
	 */
	public Set<Integer> getElementIndexs() {
		Set<Integer> result = new HashSet<Integer>();
		for (int i = 0; i < alternatives.size(); i++) {
			Alternatives alt = alternatives.get(i);
			result.add(alt.z * 10 + alt.s);
		}
		return result;
	}


	
}
