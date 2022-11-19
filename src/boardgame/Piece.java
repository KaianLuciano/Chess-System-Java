package boardgame;

public abstract class Piece {
	
	protected Position position;
	private Board board;

	public Piece(Board board) {
		this.board = board;
		position = null;
	}

	protected Board getBoard() {
		return board;
	}
	
	public abstract boolean[][] possibleMoves();
	
	public  boolean possibleMove(Position position) {
		return possibleMoves()[position.getRow()][position.getColumns()];
	}
	
	public boolean isThereAnyPossibleMove() {
		boolean[][] mat =  possibleMoves();

		for(int counterRow = 0 ; counterRow < mat.length; counterRow++) {
			
			for(int counterColumn = 0; counterColumn < mat.length; counterColumn++) {
				if(mat[counterRow][counterColumn]) {
					return true;
				}
			}
		}
		return false;
	}
	
}