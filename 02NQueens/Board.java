public class Board {
    int[][]board;
    
    public Board(int n) {
	board = new int[n][n];
        clear();
    }


    void clear() {
	for (int i = 0; i < board.length; i++) {
	    for (int j = 0; j < board[i].length; j++) {
		board[i][j] = 0;
	    }
	}
    }

    void addQueen(int r, int c) {
	board[r][c] = 1;
	for (int i = c+1; i < board[r].length; i++) {
	    board[r][i]--;
	}
	int currentRow = r+1;
	for (int j = c+1; currentRow < board.length && j < board[r].length; j++) {
	    board[currentRow][j]--;
	    currentRow++;
	}
	currentRow = r-1;
	for (int k = c+1; currentRow >= 0 && k < board[r].length; k++) {
	    board[currentRow][k]--;
	    currentRow--;
	}	
    }

    void removeQueen(int r, int c) {
	board[r][c] = 0;
	for (int i = c+1; i < board[r].length; i++) {
	    board[r][i]++;
	}
	int currentRow = r+1;
	for (int j = c+1; currentRow < board.length && j < board[r].length; j++) {
	    board[currentRow][j]++;
	    currentRow++;
	}
	currentRow = r-1;
	for (int k = c+1; currentRow >= 0 && k < board[r].length; k++) {
	    board[currentRow][k]++;
	    currentRow--;
	}

    }

    void printBoard() {
	for (int i = 0; i < board.length; i++) {
	    for (int j = 0; j < board[i].length; j++) {
		System.out.print(board[i][j] + " | ");
	    }
	    System.out.println("\n");
	}
    }
    
    public static void main(String[]args) {
	Board b = new Board(4);
	b.addQueen(1,0);
	b.printBoard();
	System.out.println("\n");
	b.addQueen(3,1);
	b.printBoard();
	System.out.println("\n");
	b.removeQueen(3,1);
	b.printBoard();
    }
}
