package connectFourProgram;

public class GameBoard {	
	//	establishes constants and variables
	private final int [][]board;
	private final int ROWS = 6;
	private final int COLS = 7;
	
	//	function initializes board
	public GameBoard() {
		board = new int[ROWS][COLS];
	}
	
	//	function responsible for making a move
	public boolean makeMove(int column, boolean isRed) {
		if(column < 0 || column >= COLS)
			return false;
		
		for(int row = ROWS - 1; row >= 0; row--) {
			if(board[row][column] == 0) {
				board[row][column] = isRed ? 1 : -1;
				return true;
			}
		}
		
		//	returns if full
		return false;
	}
	
	//	function checks for a position to win
	public boolean checkWin() {
		//	checks horizontal, vertical, and diagnal lines
		for(int row = 0; row < ROWS; row++) {
			for(int col = 0; col < COLS; col++) {
				if(board[row][col] != 0 &&
						(checkDirection(row,col,0,1) ||	// checks vertical(x,y+1)
						checkDirection(row,col,1,0) ||	// checks horizontal(x+1,y)
						checkDirection(row,col,1,1) ||	// checks diagnal down-right(x+1,y+1)
						checkDirection(row,col,1,-1)))	// checks diagnal down-left(x+1,y-1)
					{
					return true;
				}
			}
		}
		return false;
	}
	
	//	function checks the direction
	private boolean checkDirection(int row, int col, int rowDir, int colDir) {
        int color = board[row][col];
        for (int i = 1; i < 4; i++) {
            int newRow = row + i * rowDir;
            int newCol = col + i * colDir;
            if (newRow < 0 || newRow >= ROWS || newCol < 0 || newCol >= COLS || board[newRow][newCol] != color) {
                return false;
            }
        }
        return true;
    }
	
	//	function checks if board is full
	public boolean isFull() {
		for(int col = 0; col < COLS; col++) {
			if(board[0][col] == 0) {
				return false;
			}
		}
		return true;
	}
	
	//	function gets the board to display
	public int[][] getBoard() {
		return board;
	}
}
