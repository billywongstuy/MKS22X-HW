public class KnightBoard {
    int[][]board;
    int [][] moves = {{-2,1},{-2,-1},{-1,-2},{1,-2},{2,-1},{2,1},{1,2},{-1,2}};

    
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
		board[board.length-1-i][j] = -1;
	    }
	}
	for (int i = 2; i < board.length; i++) {
	    for (int j = 0; j < 2; j++) {
		board[i][j] = -1;
		board[i][board[i].length-1-j] = -1;
	    }
	}
    }

    public boolean solve() {
	return solveH(2,2,1,0);
    }

    private boolean solveH(int row, int col, int num, int moveSlot) {

	//if n^2 == num return true;

	//for every possible movement option
	
	//if able to place at the current position
	//return solveH(row and col with add from movement option 0,num+1,

	//else remove the number
	
	if (canMoveTo(row,col)) {
	    board[row][col] = num;
	    solveH(row+(moves[moveSlot])[0],col+(moves[moveSlot])[1],num+1,0);
	}
	
	return false;
    }


    private boolean canMoveTo(int row, int col) {
	if (board[row][col] != 0) {
	    return false;
	}
	return true;
    }
    
    public void printSolution() {
	for (int i = 0; i < board.length; i++) {
	    for (int j = 0; j < board[i].length; j++) {
		if (board[i][j] != -1) {
		    System.out.print(board[i][j] + " ");
		}
	    }
	    System.out.println("\n");
	}
    }

    public void printBoard() {
	for (int i = 0; i < board.length; i++) {
	    for (int j = 0; j < board[i].length; j++) {
		System.out.print(board[i][j] + " ");
	    }
	    System.out.println("\n");
	}
    }

    public static void main(String[]args) {
	KnightBoard b = new KnightBoard(4);
	b.printBoard();
	System.out.println("\n");
	b.printSolution();
    }

}
