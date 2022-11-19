package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;
import chess.chessMatch;

public class King extends ChessPiece {
	
	private chessMatch chessMatch;

	public King(Board board, Color color, chessMatch chessMatch	) {
		super(board, color);
		this.chessMatch = chessMatch;
	}
	
	@Override
	public String toString() {
		return "K";
	}
	
	private boolean canMove(Position position) {
		ChessPiece p = (ChessPiece)getBoard().piece(position);
		return p == null || p.getColor() != getColor();
	}
	
	private boolean testRookCastling(Position position) {
		ChessPiece p = (ChessPiece)getBoard().piece(position);
		return p != null && p instanceof Rook && p.getColor() == getColor() && p.getMoveCount() == 0;
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRow()][getBoard().getColumn()];
		
		Position p = new Position(0,0);
		
		//above
		p.setValues(position.getRow() - 1, position.getColumns());
		if(getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumns()] = true;
		}
		
		//below
		p.setValues(position.getRow() + 1, position.getColumns());
		if(getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumns()] = true;
		}
		
		//left
		p.setValues(position.getRow(), position.getColumns() - 1);
		if(getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumns()] = true;
		}
		
		//rigth
		p.setValues(position.getRow(), position.getColumns() + 1);
		if(getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumns()] = true;
		}
		
		//NW
		p.setValues(position.getRow() - 1, position.getColumns() - 1);
		if(getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumns()] = true;
		}
		
		//NE
		p.setValues(position.getRow() - 1, position.getColumns() + 1);
		if(getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumns()] = true;
		}
		
		//SW
		p.setValues(position.getRow() + 1, position.getColumns() - 1);
		if(getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumns()] = true;
		}
		
		//SE
		p.setValues(position.getRow() + 1, position.getColumns() + 1);
		if(getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumns()] = true;
		}
		
		//#specialmove astling
		if(getMoveCount() == 0 && !chessMatch.getCheck()) {
			// #specialmove castling kingside rook
			Position positionTowerOne = new Position(position.getRow(), position.getColumns() + 3);
			if(testRookCastling(positionTowerOne)) {
				Position p1 = new Position(position.getRow(), position.getColumns() + 1);
				Position p2 = new Position(position.getRow(), position.getColumns() + 2);
				if(getBoard().piece(p1) == null && getBoard().piece(p2) == null){
					mat[position.getRow()][position.getColumns() + 2] = true;
				}
			}
			// #specialmove castling queenside rook
				Position positionTowerTwo = new Position(position.getRow(), position.getColumns() - 4);
				if(testRookCastling(positionTowerTwo)) {
					Position p1 = new Position(position.getRow(), position.getColumns() - 1);
					Position p2 = new Position(position.getRow(), position.getColumns() - 2);
					Position p3 = new Position(position.getRow(), position.getColumns() - 3);
					if(getBoard().piece(p1) == null && getBoard().piece(p2) == null && getBoard().piece(p3) == null){
						mat[position.getRow()][position.getColumns() - 2] = true;
					}
				}
		}
		return mat;
	}
	
}
