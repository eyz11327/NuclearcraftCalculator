import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class NCCalculator {
	private int reactorLength; // row
	private int reactorWidth; // col
	private int reactorHeight; // layer

	private static ArrayList<ArrayList<ArrayList<Block>>> reactor;

	public NCCalculator() {
		super();
	}

	public void calculate() {
		reactor = calculatorHelper.fillInitialReactor(reactorLength, reactorWidth, reactorHeight);
		calculatorHelper.printReactor(reactor);
		calculatorHelper.findPossibleReactors(reactor, 1, 0, 1, reactorLength - 2, reactorWidth - 2, reactorHeight - 2);
	}

	
	
	public static Block getBlock(int row, int col, int layer) {
		return reactor.get(layer).get(row).get(col);
	}

	public static void main(String[] args) throws IOException {
		NCCalculator c = new NCCalculator();
		System.out.println("Welcome to the reactor configuration calculator for NuclearCraft, specifically in the Enigmatica 2 Expert modpack!");
		System.out.println("We highly recommend making your reactor a cube (ex. 10x10x10, 8x8x8, 24x24x24).");
		System.out.println();

		Scanner userInput = new Scanner(System.in);
		try {
			System.out.println("Please enter the length of your reactor: ");
			c.reactorLength = Integer.parseInt(userInput.nextLine());

			System.out.println("Please enter the width of your reactor: ");
			c.reactorWidth = Integer.parseInt(userInput.nextLine());

			System.out.println("Please enter the height of your reactor: ");
			c.reactorHeight = Integer.parseInt(userInput.nextLine());
			
			userInput.close();

			System.out.println();
			System.out.println("Beginning calculations...");
			System.out.println();
		} catch (NumberFormatException e) {
			System.out.println("That is not a number! Please only enter the number associated with the dimension.");
			e.printStackTrace();
		}

		long start1 = System.currentTimeMillis();
		c.calculate();
		long end1 = System.currentTimeMillis();
		System.out.println("Elapsed Time in milli seconds: " + calculatorHelper.myFormat.format((end1-start1)));
		System.out.println("Total iterations calculated: " + calculatorHelper.myFormat.format(calculatorHelper.iterations));
		
		System.out.println("Valid Reactors: " + calculatorHelper.myFormat.format(calculatorHelper.validReactors.size()));
		
		FileOutputStream outputStream = null;
        // Step 1:  Create an object of FileOutputStream
        outputStream = new FileOutputStream("validReactors.txt");
	    StringBuilder outputString = new StringBuilder();
	    int reactorNumber = 1;
        
		for (String reactor : calculatorHelper.validReactors) {
            // Step 2: Write into the file
			
			outputString.append("Reactor #" + reactorNumber + "\n" + reactor + "\n\n");
			reactorNumber++;
		}
		
        outputStream.write(outputString.toString().getBytes());

        // Step 3: Close the object
        if (outputStream != null) {
            // Second try catch block ensures that the file is closed even if an error occurs
	        try {
	            // Closing the file connections if no exception has occurred
	            outputStream.close();
	        }
	        catch (IOException e) {
	            // Display exceptions if occurred
	            System.out.print(e.getMessage());
	        }
        }
	}
}
