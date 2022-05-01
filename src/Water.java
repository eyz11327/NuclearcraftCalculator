
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
		// if the current cell is valid, then it must be complete
		if (this.checkIsValid() == true) {
			return true;
		}
		
		// check if there are any open spots
		else if ((NCCalculator.getBlock(getRow()+1, getCol(), getLayer()).getCellType() == null) || (NCCalculator.getBlock(getRow()-1, getCol(), getLayer()).getCellType() == null) || (NCCalculator.getBlock(getRow(), getCol()+1, getLayer()).getCellType() == null) || (NCCalculator.getBlock(getRow(), getCol()-1, getLayer()).getCellType() == null) || (NCCalculator.getBlock(getRow(), getCol(), getLayer()+1).getCellType() == null) || (NCCalculator.getBlock(getRow(), getCol(), getLayer()-1).getCellType() == null)){
			return false;
		}
		
		// check all adjacent cells and see if they are no open spots
		else if ((NCCalculator.getBlock(getRow()+1, getCol(), getLayer()).getCellType() != null) && (NCCalculator.getBlock(getRow()-1, getCol(), getLayer()).getCellType() != null) && (NCCalculator.getBlock(getRow(), getCol()+1, getLayer()).getCellType() != null) && (NCCalculator.getBlock(getRow(), getCol()-1, getLayer()).getCellType() != null) && (NCCalculator.getBlock(getRow(), getCol(), getLayer()+1).getCellType() != null) && (NCCalculator.getBlock(getRow(), getCol(), getLayer()-1).getCellType() != null)){
			return true;
		}

		
		return false;
	}

}
