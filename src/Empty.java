
public class Empty extends Block {

	public Empty(char blockChar, int row, int col, int layer) {
		super(blockChar, row, col, layer);
		super.setCellType(CellType.EMPTY);
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
