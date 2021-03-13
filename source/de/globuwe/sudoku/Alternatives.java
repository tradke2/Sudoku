package de.globuwe.sudoku;

import java.util.Collections;
import java.util.Set;

public class Alternatives {

	public final int z;
	public final int s;
	public final Set<Integer> set;

	public Alternatives(int z, int s, Set<Integer> set) {
		this.z = z;
		this.s = s;
		this.set = Collections.unmodifiableSet(set);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(set.toString()).append("@[").append(z).append(",").append(s).append("]");
		return sb.toString();
	}


}
