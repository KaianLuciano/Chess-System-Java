package boardgame;

public class Position {
	
	private int row;
	private int columns;
	
	public Position() {
	}

	public Position(int row, int columns) {
		super();
		this.row = row;
		this.columns = columns;
	}

	public int getRow() {
		return row;
	}
	
	public void setRow(int row) {
		this.row = row;
	}

	public int getColumns() {
		return columns;
	}
	public void setColumns(int columns) {
		this.columns = columns;
	}
	
	public void setValues(int row, int column) {
		this.row = row;
		this.columns = column;
	}
	
}
