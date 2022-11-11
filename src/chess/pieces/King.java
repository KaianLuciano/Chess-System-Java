package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {

	public King(Board board, Color color) {
		super(board, color);
	}
	
	@Override
	public String toString() {
		return "K";
	}
	
	private boolean canMove(Position position) {
		ChessPiece p = (ChessPiece)getBoard().piece(position);
		return p == null || p.getColor() != getColor();
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
		
		return mat;
	}
	
}
