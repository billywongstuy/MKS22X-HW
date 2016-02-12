public class KnightBoard {
    int[][]board;
    int [][] moves = {{-2,1},{-2,-1},{-1,-2},{1,-2},{2,-1},{2,1},{1,2},{-1,2}};
    int lastMoveIndex = 0;
    
    
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

    private boolean solveH(int row, int col, int num, int start) {

	//if n^2 == num return true;

	//for every possible movement option
	
	//if able to place at the current position
	//return solveH(row and col with add from movement option 0,num+1,

	//else remove the number

	if (num == board.length*board[0].length) {
	    return true;
	}


        //figure out curretn error
	//

	//condition for when the 8th direction of 1 is tried and not working
	
	for (int i = start; i < moves.length; i++) {
	    System.out.println((row-2)+","+(col-2));
	    board[row][col] = num;
	    printSolution();
	    System.out.println("*************************************************");
	    System.out.println("Ind " + lastMoveIndex);
	    if (canMoveTo(row+moves[i][0],col+moves[i][1])) {
		lastMoveIndex = i;
		System.out.println("Added move " + (num+1) + " in direction of " + i);
		return solveH(row+moves[i][0],col+moves[i][1],num+1,0);
	    }
	    board[row][col] = 0;
	    System.out.println("L:" + lastMoveIndex);
	    System.out.println(board[row-(moves[lastMoveIndex][0])][col-(moves[lastMoveIndex][1])]);
	    if (i == 7) {
		System.out.println((num+1) + " was not able to fit. Removing "+ (num));
		return solveH(row-(moves[lastMoveIndex][0]),col-(moves[lastMoveIndex][1]),num-1,lastMoveIndex+1);
	    }
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
	KnightBoard b = new KnightBoard(5);
	//b.printBoard();
	System.out.println("\n");
	b.solve();
	b.printSolution();
    }

}
