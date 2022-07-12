import java.util.ArrayList;

public class calculatorHelper {

	public static int iterations = 0;
	
	// Create the initial reactor with walls filling the bottom and top layers, along with encompassing an empty center on the inner layers.
	public static ArrayList<ArrayList<ArrayList<Block>>> fillInitialReactor(int row, int col, int layer) {
		ArrayList<ArrayList<ArrayList<Block>>> current3d = new ArrayList<ArrayList<ArrayList<Block>>>();
		
		for (int i = 0; i < layer; i++) {
			ArrayList<ArrayList<Block>> current2d = new ArrayList<ArrayList<Block>>();

			for (int j = 0; j < row; j++) {
				ArrayList<Block> currentRow = new ArrayList<Block>();

				for (int k = 0; k < col; k++) {
					
					// fill the top and bottom layers with casing cells
					if (i == 0) {
						currentRow.add(new Casing('|', j, k, i));
					}
					else if (i == (layer - 1)) {
						currentRow.add(new Casing('|', j, k, i));
					}
					
					// fill the first and last rows with casing cells
					else if (j == 0) {
						currentRow.add(new Casing('|', j, k, i));
					}
					else if (j == (row - 1)) {
						currentRow.add(new Casing('|', j, k, i));
					}
					
					// fill the first and last column spots with casing cells
					
					else if (k == 0) {
						currentRow.add(new Casing('|', j, k, i));
					}
					else if (k == (col - 1)) {
						currentRow.add(new Casing('|', j, k, i));
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

	public static ArrayList<ArrayList<ArrayList<Block>>> findPossibleReactors(ArrayList<ArrayList<ArrayList<Block>>> reactor, int row, int col, int layer, int internalRowSize, int internalColSize, int internalLayerSize){
		// base case returns valid reactors
		if (checkReactorValidity(reactor)) {
			System.out.println("Valid reactor found!");
			printReactor(reactor);
			
			return reactor;
		}
		
		if (iterations != 0) {
			System.out.println("This reactor was invalid, trying all combinations from here...");
			System.out.println();
		}
		
		ArrayList<ArrayList<ArrayList<Block>>> recursiveReactor = reactor;
		if (!checkReactorCompleteness(reactor)) {
			iterations++;
			
			// columns +1 -> rows +1 -> layers +1
			if (col + 1 <= internalColSize) {
				System.out.println("Testing with a new water cooler");
				recursiveReactor.get(layer).get(row).set(col + 1, new Water('W', row, col + 1, layer)); 
				printReactor(recursiveReactor);
				findPossibleReactors(recursiveReactor, row, col + 1, layer, internalRowSize, internalColSize, internalLayerSize);
				
				System.out.println("Testing with an empty cell");
				recursiveReactor.get(layer).get(row).set(col + 1, new Empty(' ', row, col + 1, layer)); 
				printReactor(recursiveReactor);
				findPossibleReactors(recursiveReactor, row, col + 1, layer, internalRowSize, internalColSize, internalLayerSize);
			}
			else if (row + 1 <= internalRowSize) {
				col = 1; // reset column to restart left to right
				
				System.out.println("Testing with a new water cooler");
				recursiveReactor.get(layer).get(row + 1).set(col, new Water('W', row + 1, col, layer)); 
				printReactor(recursiveReactor);
				findPossibleReactors(recursiveReactor, row + 1, col, layer, internalRowSize, internalColSize, internalLayerSize);
				
				System.out.println("Testing with an empty cell");
				recursiveReactor.get(layer).get(row + 1).set(col, new Empty(' ', row + 1, col, layer)); 
				printReactor(recursiveReactor);
				findPossibleReactors(recursiveReactor, row + 1, col, layer, internalRowSize, internalColSize, internalLayerSize);
			}
			else {
				// reset row and column to restart left to right and top to bottom
				row = col = 1;

				System.out.println("Testing with a new water cooler");
				recursiveReactor.get(layer + 1).get(row).set(col, new Water('W', row, col, layer + 1)); 
				printReactor(recursiveReactor);
				findPossibleReactors(recursiveReactor, row, col, layer + 1, internalRowSize, internalColSize, internalLayerSize);
				
				System.out.println("Testing with an empty cell");
				recursiveReactor.get(layer + 1).get(row).set(col, new Empty(' ', row, col, layer + 1)); 
				printReactor(recursiveReactor);
				findPossibleReactors(recursiveReactor, row, col, layer + 1, internalRowSize, internalColSize, internalLayerSize);
			}
			
		}
		return null;
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
		boolean valid = false;
		
		for (ArrayList<ArrayList<Block>> layer : reactor) {
			for (ArrayList<Block> row : layer) {
				for (Block block : row) {
					
					if (block == null) {
						return false;
					}
					
//					if (block.checkComplete() && block.checkIsValid()) {
//						valid = true;
//					}
					
				}
			}
		}
		
		return valid;
	}
	
	// checks if the reactor has any null blocks
	public static boolean checkReactorCompleteness(ArrayList<ArrayList<ArrayList<Block>>> reactor) {
		boolean complete = true;
		
		for (ArrayList<ArrayList<Block>> layer : reactor) {
			for (ArrayList<Block> row : layer) {
				for (Block block : row) {
					if (block == null) {
						return false;
					}
				}
			}
		}
		
		return complete;
	}

}
