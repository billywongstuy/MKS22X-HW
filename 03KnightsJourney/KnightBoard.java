public class KnightBoard {
    int[][]board;
    int [][] moves = {{-2,1},{-2,-1},{-1,-2},{1,-2},{2,-1},{2,1},{1,2},{-1,2}};
    boolean closed = false;
    boolean DEBUG = false;
    
    public KnightBoard(int cols, int rows) {
	//Make 2 extra outsides for out of bounds
	board = new int[rows+4][cols+4];
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


    public KnightBoard(int size) {
	this(size,size);
    }

    public boolean solve() {
	return solveH(2,2,1);
    }

    private boolean solveH(int row, int col, int num) {

	
	if (num > (board.length-4)*(board[0].length-4)) {
	    return true;
	}



	if (!canMoveTo(row,col)) {
	    return false;
	}
	
	if (canMoveTo(row,col)) {
	    board[row][col] = num;
	    
	    if (num == (board.length-4)*(board[0].length-4)) {

		//System.out.println((row-2)+","+(col-2));
		
		if (closed && !canLoopAround(row,col)) {
		    
		    //printSolution();
		    board[row][col] = 0;
		    return false;
		}
	    }
	    
	    /*if (solveH(row-2,col+1,num+1)) {
	      return true;
	      }
	      else if (solveH(row+1,col+2,num+1)) {
	      return true;
	      }
	      else if (solveH(row-1,col-2,num+1)) {
	      return true;
	      }
	      else if (solveH(row+1,col-2,num+1)) {
	      return true;
	      }
	      else if (solveH(row+2,col-1,num+1)) {
	      return true;
	      }
	      else if (solveH(row+2,col+1,num+1)) {
	      return true;
	      }
	      else if (solveH(row-2,col-1,num+1)) {
	      return true;
	      }
	      else if (solveH(row-1,col+2,num+1)) {
	      return true;
	      }*/	

	    for (int i = 0; i < moves.length; i++) {
		if (solveH(row+moves[i][0],col+moves[i][1],num+1)) {
		    return true;
		}
	    }


	    //if you make the function never return true, using below provides all solutions

	    //if (num == 25) {	
	    //	printSolution();
	    // };

	    
	
	    board[row][col] = 0;
	}
	
	return false;
    }


    private boolean canLoopAround(int row, int col) {
	//System.out.println((row+2)+","+(col-2));
	//System.out.println(board[row][col]);
	for (int i = 0; i < moves.length; i++) {
	    if (board[row+moves[i][0]][col+moves[i][1]] == 1) {
		//System.out.println("hey");
		return true;
	    }
	}
	return false;
    }

    private boolean canMoveTo(int row, int col) {
	//System.out.println("Can I move to " + (row)+","+(col));
	if (board[row][col] != 0) {
	    return false;
	}
	return true;
    }
    
    public void printSolution() {
	for (int i = 0; i < board.length; i++) {
	    for (int j = 0; j < board[i].length; j++) {
		if (board[i][j] != -1) {
		    System.out.print((board[i][j] + "    ").substring(0,3));
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


    private void debug(String s) {
	if (DEBUG == true) {
	    System.out.println(s);
	}
    }

    public static void main(String[]args) {
	int r = 5;
	int c = 5;
	if ((args.length == 1 && !args[0].equals("closed")) || (args.length == 2 && args[1].equals("closed"))) {
	    r = Integer.parseInt(args[0]);
	    c = r;
	}
	else if (args.length >= 2) {
	    c = Integer.parseInt(args[0]);
	    r = Integer.parseInt(args[1]);
	}
	KnightBoard b = new KnightBoard(c,r);
	if (args.length > 0 && args[args.length-1].equals("closed")) {
	    b.closed = true;
	    //System.out.println(b.closed);
        }
	b.solve();
	b.printSolution();
    }



    /*	OLD CODE
	for (int i = start; i < moves.length; i++) {
	System.out.println((row)+","+(col));
	System.out.println(board[row][col]);
	board[row][col] = num;
	printBoard();
	//System.out.println("*************************************************");
	//System.out.println("Ind " + lastMoveIndex);
	if (canMoveTo(row+moves[i][0],col+moves[i][1])) {
	previousMove = lastMoveIndex;
	lastMoveIndex = i;
	//System.out.println("Added move " + (num+1) + " in direction of " + i);
	return solveH(row+moves[i][0],col+moves[i][1],num+1,0);
	}
	board[row][col] = 0;

	//System.out.println("L:" + lastMoveIndex);
	//System.out.println(board[row-(moves[lastMoveIndex][0])][col-(moves[lastMoveIndex][1])]);
	//if (i == 7) {
	//	System.out.println((num+1) + " was not able to fit. Removing "+ (num) + "at " + row+","+col);
	//	System.out.println("Starting on " + (board[row-(moves[lastMoveIndex][0])][col-(moves[lastMoveIndex][1])]) + "at " + (row-(moves[lastMoveIndex][0]))+","+(col-(moves[lastMoveIndex][1])) );
	//	return solveH(row-(moves[lastMoveIndex][0]),col-(moves[lastMoveIndex][1]),num-1,lastMoveIndex+1);
	//	    }
	}

	System.out.println((num+1) + " was not able to fit. Removing "+ (num) + "at " + row+","+col);
	System.out.println("Starting on " + (board[row-(moves[lastMoveIndex][0])][col-(moves[lastMoveIndex][1])]) + "at " + (row-(moves[lastMoveIndex][0]))+","+(col-(moves[lastMoveIndex][1])) );
	
	if (num > 1) {
	return solveH(row-(moves[lastMoveIndex][0]),col-(moves[lastMoveIndex][1]),num-1,lastMoveIndex+1);
	}
    */	



    
}
