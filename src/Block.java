
public abstract class Block {
	
	private char blockChar;
	private CellType cellType;
	private int row, col, layer;

	
	public Block(char blockChar, int row, int col, int layer) {
		super();
		this.blockChar = blockChar;
		this.setRow(row);
		this.setCol(col);
		this.setLayer(layer);
	}

	
	abstract public boolean checkIsValid();
	
	abstract public boolean checkComplete();

	public char getChar() {
		return blockChar;
	}


	public CellType getCellType() {
		return cellType;
	}


	public void setCellType(CellType cellType) {
		this.cellType = cellType;
	}


	public int getRow() {
		return row;
	}


	public void setRow(int row) {
		this.row = row;
	}


	public int getCol() {
		return col;
	}


	public void setCol(int col) {
		this.col = col;
	}


	public int getLayer() {
		return layer;
	}


	public void setLayer(int layer) {
		this.layer = layer;
	}
}
