package connectFourProgram;

import java.util.Scanner;

//	implements logic for human player
public class HumanPlayer implements Player {
	//	establish variables
	private Boolean isRed;
	
	//	object for user input
	private final Scanner scanner = new Scanner(System.in);
	
	//	function for choosing color
	public void init(Boolean color) {
		this.isRed = color;
	}
	
	//	function logic for displaying player
	public String name() {
		return isRed ? "\nRed Player" : "\nYellow Player";
	}
	
	//	function for moving
	public int move() {
		System.out.printf("Enter the column between 0 and 6 where you want to place your chip: ");
		return scanner.nextInt();
	}
	
	//	function for informing 
	public void inform(int column) {
		// logic can be created later since can share computer screen
	}
}
