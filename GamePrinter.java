package connectFourProgram;

//	class handles logic for displaying game board
public class GamePrinter {
	public void printBoard(GameBoard board) {
		int[][] grid = board.getBoard();

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    System.out.print(" 1  ");  // red chip
                } else if (grid[row][col] == -1) {
                    System.out.print(" 0  ");  // yellow chip
                } else {
                    System.out.print(" [] ");  // empty spot
                }
            }
            System.out.println();
        }
        System.out.printf("___________________________"
        		+ "\n 0   1   2   3   4   5   6 \n");  // column labels
	}
}
