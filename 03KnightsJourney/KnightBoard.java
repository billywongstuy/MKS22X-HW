public class KnightBoard {
    int[][]board;

    public KnightBoard(int size) {
	//Make 2 extra outsides for out of bounds
	board = new int[size+4][size+4];
	for (int i = 0; i < board.length; i++) {
	    for (int j = 0; j < board[i].length; j++) {
		board[i][j] = 0;
	    }
	}
	for (int i = 0; i < 2; i++) {
	    for (int j = 0; j < board[i].length; j++) {
		board[i][j] = -1;
	    }
	}
	for (int i = board.length-3; i < board.length; i++) {
	    for (int j = 0; j < board[i].length; j++) {
		board[i][j] = -1;
	    }
	}
    }

    public boolean solve() {
	return solevH(0,0,1);
    }

    public boolean solveH(int row, int col, int num) {
	board[row][col] = num;
	return false;
    }

    public printSolution() {
	
    }

    public printBoard() {
	for (int i = 0; i < board.length; i++) {
	    for (int j = 0; j < board[i].length; j++) {
		System.out.println(board[i][j] + " ");
	    }
	    System.out.println("\n");
	}
    }

    public static void main(String[]args) {
	KnightBoard b = new KnightBoard(4);
	b.printBoard();
    }

}
