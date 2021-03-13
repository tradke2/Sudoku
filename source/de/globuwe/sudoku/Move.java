package de.globuwe.sudoku;

public class Move {

	public final int z;
	public final int s;
	public final int value;
	
	/**
	 * 
	 * @param z
	 * @param s
	 * @param value
	 */
	public Move(int z, int s, int value) {
		this.z = z;
		this.s = s;
		this.value = value;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[").append(z).append(",").append(s).append("]=").append(value);
		return sb.toString();
	}

}
