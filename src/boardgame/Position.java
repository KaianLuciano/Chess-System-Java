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

	public int getColumns() {
		return columns;
	}
	
	protected void setValues(int row, int column) {
		this.row += row;
		this.columns += column;
	}
	
}
