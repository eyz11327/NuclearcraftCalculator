import java.util.ArrayList;

public class calculatorHelper {

	public static ArrayList<ArrayList<ArrayList<Block>>> fillInitialReactor(int row, int col, int layer) {
		ArrayList<ArrayList<ArrayList<Block>>> current3d = new ArrayList<ArrayList<ArrayList<Block>>>();
		
		for (int i = 0; i < layer; i++) {
			ArrayList<ArrayList<Block>> current2d = new ArrayList<ArrayList<Block>>();

			for (int j = 0; j < row; j++) {
				ArrayList<Block> currentRow = new ArrayList<Block>();

				for (int k = 0; k < col; k++) {
					
					// fill the top and bottom layers with casing cells
					if (i == 0) {
						currentRow.add(new Casing('W', j, k, i));
					}
					else if (i == (layer - 1)) {
						currentRow.add(new Casing('W', j, k, i));
					}
					
					// fill the first and last rows with casing cells
					else if (j == 0) {
						currentRow.add(new Casing('W', j, k, i));
					}
					else if (j == (row - 1)) {
						currentRow.add(new Casing('W', j, k, i));
					}
					
					// fill the first and last column spots with casing cells
					
					else if (k == 0) {
						currentRow.add(new Casing('W', j, k, i));
					}
					else if (k == (col - 1)) {
						currentRow.add(new Casing('W', j, k, i));
					}
					
					else{
						currentRow.add(null);
					}
					
				}
				
				current2d.add(currentRow);
			}
			current3d.add(current2d);
		}
		
		return current3d;
		
	}

	
	
	public static void printReactor(ArrayList<ArrayList<ArrayList<Block>>> reactor) {
		int layer = 1;
		for (ArrayList<ArrayList<Block>> threeD : reactor) {
			System.out.println("Layer: " + layer);

			for (ArrayList<Block> twoD : threeD) {

				System.out.print("[");
				for (Block block : twoD) {

					if (block == null) {
						System.out.print(" -");
					}
					else {
						System.out.print(" " + block.getChar());
					}

				}
				System.out.println(" ]");

			}
			layer++;
			System.out.println();

		}
	}
	
	public static boolean checkReactorValidity(ArrayList<ArrayList<ArrayList<Block>>> reactor) {
		boolean valid = true;
		
		for (ArrayList<ArrayList<Block>> layer : reactor) {
			for (ArrayList<Block> row : layer) {
				for (Block block : row) {
					if (block == null) {
						valid = false;
					}
				}
			}
		}
		
		return valid;
	}
	
	public static boolean checkReactorCompleteness(ArrayList<ArrayList<ArrayList<Block>>> reactor) {
		boolean complete = true;
		
		for (ArrayList<ArrayList<Block>> layer : reactor) {
			for (ArrayList<Block> row : layer) {
				for (Block block : row) {
					if (block == null) {
						complete = false;
					}
				}
			}
		}
		
		return complete;
	}

}
