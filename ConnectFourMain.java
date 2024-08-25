package connectFourProgram;

import java.util.Scanner;

public class ConnectFourMain{
	public static void main(String[] args) {
		//	create object for user input
		Scanner scanner = new Scanner(System.in);
		
		// establish instances
		GameBoard board = new GameBoard();
        GamePrinter printer = new GamePrinter();
		Player redPlayer = new HumanPlayer();
		Player yellowPlayer = new ComputerPlayer();
		
		// initialize player colors
		redPlayer.init(true);
		yellowPlayer.init(false);
		
		// controls the game loop
		boolean gameWin = false;
		boolean redTurn = true;
		
		while(!gameWin && !board.isFull()) {
			printer.printBoard(board);
			
			Player currentPlayer = redTurn ? redPlayer : yellowPlayer;
            System.out.println(currentPlayer.name() + "'s turn (" + (redTurn ? "Red" : "Yellow") + ")");

            int column;
            boolean validMove;
            do {
                column = currentPlayer.move();
                validMove = board.makeMove(column, redTurn);
                if (!validMove) {
                    System.out.printf("\nInvalid move. Try again.");
                }
            } while (!validMove);
            
            // informs opponent's move
            if (redTurn) {
                yellowPlayer.inform(column);
            } else {
                redPlayer.inform(column);
            }
            
            // checks for game win
            gameWin = board.checkWin();
            
            if (gameWin) {
                printer.printBoard(board);
                System.out.println(currentPlayer.name() + " wins!");
            }

            redTurn = !redTurn;            
		}
		
		if (!gameWin) {
            printer.printBoard(board);
            System.out.printf("\nIt's a tie!");
        }	
		scanner.close();
	}
}