package de.globuwe.sudoku;

public class InvalidMoveException extends IllegalArgumentException {

	
	private Move move;

	public InvalidMoveException(Move move) {
		this.move = move;
	}

	/* (non-Javadoc)
	 * @see java.lang.Throwable#getMessage()
	 */
	@Override
	public String getMessage() {
		return "Illegal move: " + move;
	}
	
	

}
