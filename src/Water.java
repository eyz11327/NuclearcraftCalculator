
public class Water extends Block {

	public Water(char blockChar, int row, int col, int layer) {
		super(blockChar, row, col, layer);
		super.setCellType(CellType.WATER);
	}

	@Override
	public boolean checkIsValid() {
		if (NCCalculator.getBlock(getRow()+1, getCol(), getLayer()).getCellType() == CellType.CELL) {
			return true;
		}
		else if (NCCalculator.getBlock(getRow()-1, getCol(), getLayer()).getCellType() == CellType.CELL) {
			return true;
		}
		else if (NCCalculator.getBlock(getRow(), getCol()+1, getLayer()).getCellType() == CellType.CELL) {
			return true;
		}
		else if (NCCalculator.getBlock(getRow(), getCol()-1, getLayer()).getCellType() == CellType.CELL) {
			return true;
		}
		else if (NCCalculator.getBlock(getRow(), getCol(), getLayer()+1).getCellType() == CellType.CELL) {
			return true;
		}
		else if (NCCalculator.getBlock(getRow(), getCol(), getLayer()-1).getCellType() == CellType.CELL) {
			return true;
		}
		
		return false;
	}

	@Override
	public boolean checkComplete() {
		// check all adjacent cells and see if they are no open spots
		if ((NCCalculator.getBlock(getRow()+1, getCol(), getLayer()) != null) && (NCCalculator.getBlock(getRow()-1, getCol(), getLayer()) != null) && (NCCalculator.getBlock(getRow(), getCol()+1, getLayer()) != null) && (NCCalculator.getBlock(getRow(), getCol()-1, getLayer()) != null) && (NCCalculator.getBlock(getRow(), getCol(), getLayer()+1) != null) && (NCCalculator.getBlock(getRow(), getCol(), getLayer()-1) != null)){
			
			// If there are no open spots (nulls), then check if the cell is valid
			if (this.checkIsValid()) {
				return true;
			}		
			
		}
		
		return false;
	}

}
