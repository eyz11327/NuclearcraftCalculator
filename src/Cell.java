
public class Cell extends Block {

	public Cell(char blockChar, int row, int col, int layer) {
		super(blockChar, row, col, layer);
		super.setCellType(CellType.CELL);
	}

	@Override
	public boolean checkIsValid() {
		return true;
	}

	@Override
	public boolean checkComplete() {
		return true;
	}

}
