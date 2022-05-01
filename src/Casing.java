
public class Casing extends Block {
	
	public Casing(char blockChar, int row, int col, int layer) {
		super(blockChar, row, col, layer);
		super.setCellType(CellType.CASING);
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
