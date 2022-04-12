import java.util.Scanner;
import java.time.Duration;
import java.time.Instant;

public class NCCalculator {
	private int reactorLength;
	private int reactorWidth;
	private int reactorHeight;

	private static String confirmation = "n";
	
	public NCCalculator() {
		
	}
	
	public void calculate() {
		
	}

	public static void main(String[] args) {
		NCCalculator c = new NCCalculator();
		System.out.println("Welcome to the reactor configuration calculator for NuclearCraft, specifically in the Enigmatica 2 Expert modpack!");
		System.out.println("We highly recommend making your reactor a cube (ex. 10x10x10, 8x8x8, 24x24x24).");

		Scanner userInput = new Scanner(System.in);
		try {
			System.out.println("Please enter the length of your reactor: ");
			c.reactorLength = Integer.parseInt(userInput.nextLine());

			System.out.println("Please enter the width of your reactor: ");
			c.reactorWidth = Integer.parseInt(userInput.nextLine());

			System.out.println("Please enter the height of your reactor: ");
			c.reactorHeight = Integer.parseInt(userInput.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("That is not a number! Please only enter the number associated with the dimension.");
			e.printStackTrace();
		}
		System.out.println("We currently have your reactor as a " + c.reactorLength + "x" + c.reactorWidth + "x" + c.reactorHeight + " reactor");
		
		System.out.println("Beginning calculations...");
		long start1 = System.currentTimeMillis();
		c.calculate();
		long end1 = System.currentTimeMillis();
		System.out.println("Elapsed Time in milli seconds: " + (start1-end1));
	}

}
