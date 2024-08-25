package connectFourProgram;

import java.util.Random;

//implements logic for computer player
public class ComputerPlayer implements Player {
	
	//establish variables & objects
	private Boolean isRed;
	private int[][] boardState;
	private final Random random = new Random();
	
//	function for choosing color
	public void init(Boolean color) {
		this.isRed = color;
		boardState = new int[6][7];
	}
	
	//	function logic for displaying computer
	public String name() {
		return isRed ? "Red AI" : "Yellow AI";
	}
	
	//	function for moving computer
	public int move() {
		//
		for(int col = 0; col < 7; col++) {
			if(isValMove(col)) {
				//
				if(canWin(col)) {
					return col;
				}
			}
		}
		
		//	picks random valid column
		int col;
		do {
			col = random.nextInt(7);
		}
		while(!isValMove(col));
		
		return col;		
	}
	
	//	function for updating board state
	public void inform(int column) {
		for (int row = 5; row >= 0; row--) {
            if (boardState[row][column] == 0) {
                boardState[row][column] = isRed ? -1 : 1;
                break;
            }
        }
	}
	
	private boolean isValMove(int column) {
		return boardState[0][column] == 0;
	}
	
	private boolean canWin(int column) {
		//	checks if a move leads to win
		for(int row = 5; row >= 0; row--) {
			if(boardState[row][column] == 0) {
				boardState [row][column] = isRed ? 1 : -1;	// simulate a move
				boolean win = checkWin(row, column);
				boardState [row][column] = 0;	//move undo
				return win;
			}
		}
		return false;
	}
	
	//	function checks for a win
	private boolean checkWin(int row, int col) {
		int color = boardState[row][col];
		return 	checkDirection(row, col, 0, 1, color) ||	// checks vertical (x,y+1)
				checkDirection(row, col, 1, 0, color) ||	// checks horizontal (x+1,y)
				checkDirection(row, col, 1, -1, color) ||	// checks down-left diagnal  (x+1,y-1)
				checkDirection(row, col, 1, 1, color);	// checks down-right diagnal (x+1,y+1)		
	}
	
	//	function checks the direction
	private boolean checkDirection(int row, int col, int rowDir, int colDir, int color) {
		int count = 0;
		for (int i = -3; i <= 3; i++) {
            int newRow = row + i * rowDir;
            int newCol = col + i * colDir;
            if (newRow >= 0 && newRow < 6 && newCol >= 0 && newCol < 7 && boardState[newRow][newCol] == color) {
                count++;
                if (count >= 4) return true;
            } else {
                count = 0;
            }
        }
		return false;
	}
}
