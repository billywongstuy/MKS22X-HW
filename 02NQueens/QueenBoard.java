public class QueenBoard{
    private int[][]board;
    
    public QueenBoard(int size){
	board = new int[size][size];
    }

    /**
     *precondition: board is filled with 0's only.
     *postcondition: 
     *-return false, and board is still filled
     *with 0's for a board that cannot be solved.
     *-return true, and board is filled with the 
     *final configuration of the board after adding 
     *all n queens.
     */
    public boolean solve() {
	if (!allZeroes()) {
	    return false;
	}
	return solveH(0);
    }

    /**
     *Helper method fr solve. 
     */
    private boolean solveH(int col){
	
	//System.out.println("col: " + col);

        
	
        int row = 0;
	boolean queenAdded = false;
	while (row < board.length && !queenAdded) {
	    if (addQueen(row,col)) {
		queenAdded = true;
		//System.out.println("Queen added to row " + row + ", col " + col);
	    }
	    row++;
	}

	row--; //remove the extra gain

	//System.out.println("Queen added: " + queenAdded);
	//System.out.println(board.length-1);
	//System.out.println("Row: " + (row));
	//System.out.println(row == board.length-1 && !queenAdded);    


	//printBoard();
	//printSolution();

	
	//System.out.println("Filled? " + allRowsFull());
	    
	
	//ending statements when it reaches the end
	if (firstColNoRoom() && col == board[0].length-1) {
	    return false;
	}
	if (allRowsFull() &&  col == board[0].length-1) {
	    return true;
	}

	
	//if you can't fit it at all (stops when last row in first column cannot fit anything)
	if (col == 0 && row == board.length-1 && !queenAdded) {
	    System.out.println("No fit");
	    return false;
	}

	//if it's in the middle and you can't fit 
	if (row == board.length-1 && !queenAdded) {
	    //System.out.println("Backtracking...");
	    //System.out.println("##############################################");
	    //remove the queen from the previous row and start adding queens in the next row
	    int prevRowQueen = previousQueenRow(col);
	    //System.out.println("Prev Row: " + previousQueenRow(col));
	    //System.out.println("Prev Col: " + (col-1));
	    //System.out.println(board[1][2]);


	    //System.out.println("Value at position: " + board[row][col] + "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

	    
	    //printBoard(); System.out.println("\n");
	    removeQueen(previousQueenRow(col),col-1);
	    if (col <= board[0].length - 2){
		//System.out.println(col);
		for (int i = 0; i < board.length; i++) {
		    if (board[i][col] < -1*board.length) {
			board[i][col] = 0;
		    }
		}
	    }
	    //if you remove something change the -absurbs 2 col to the right to 0
	    
	    board[prevRowQueen][col-1] = -1*board.length-board.length;
	    //resetCol(col);
	    //System.out.println("############################################");
	    //printBoard();

	    //System.out.println("*************************************************");

	    
	    return solveH(col-1);
	}

	//System.out.println("her");

	//System.out.println("****************************************");
	
	return true && solveH(col+1);
    }


    private int previousQueenRow(int col) {
	if (col == 0) {
	    return 0;
	}
	for (int i = 0; i < board.length; i++) {
	    if (board[i][col-1] == 1) {
		return i;
	    }
	}
	return 0;
    }


    public void resetCol(int col) {
	for (int i = 0; i < board.length; i++) {
	    board[i][col] = 0;
	}
    }

    public boolean allZeroes() {
	for (int i = 0; i < board.length; i++) {
	    for (int j = 0; j < board[i].length; j++) {
		if (board[i][j] > 0) {
		    return false;
		}
	    }
	}
	return true;
    }

    public boolean firstColNoRoom() {
	if (board[board.length-1][0] < 0) {
	    return true;
	}
	return false;
    }

    public boolean allRowsFull() {
	boolean CompletelyFull = true;
	for (int i = 0; i < board.length; i++) {
	    boolean RowFull = false;
	    for (int j = 0; j < board[i].length; j++) {
		if (board[i][j] > 0) {
		    RowFull = true;
		}
	    }
	    CompletelyFull = RowFull && CompletelyFull;
	}
	return CompletelyFull;
    }

    
    public void printSolution(){
	for (int i = 0; i < board.length; i++) {
	    for (int j = 0; j < board[i].length; j++) {
		if (board[i][j] == 1) {
		    System.out.print("Q ");
		}
		else {
		    System.out.print("_ ");
		}
	    }
	    System.out.println("\n");
	}
	/**Print the board like toString, except
	   all negative numbers, and 0's are replaced with '_'
	   and all 1's are replaced with 'Q'
	 */
    }


    public void printBoard() {
	for (int i = 0; i < board.length; i++) {
	    for (int j = 0; j < board[i].length; j++) {
		if (board[i][j] == 1) {
		    System.out.print(" @  | ");
		}
		else {System.out.print((board[i][j] + "   ").substring(0,3) + " | ");}
	    }
	    System.out.println("\n");
	}
    }

    /********Do Not Edit Below This Line**********************************/

    private boolean addQueen(int row, int col){
	if(board[row][col] != 0){
	    return false;
	}
	board[row][col] = 1;
	int offset = 1;
	while(col+offset < board[row].length){
	    board[row][col+offset]--;
	    if(row - offset >= 0){
		board[row-offset][col+offset]--;
	    }
	    if(row + offset < board.length){
		board[row+offset][col+offset]--;
	    }
	    offset++;
	}
	return true;
    }

    private boolean removeQueen(int row, int col){
	if(board[row][col] != 1){
	    return false;
	}
	board[row][col] = 0;
	int offset = 1;
	while(col+offset < board[row].length){
	    board[row][col+offset]++;
	    if(row - offset >= 0){
		board[row-offset][col+offset]++;
	    }
	    if(row + offset < board.length){
		board[row+offset][col+offset]++;
	    }
	    offset++;
	}
	return true;
    }

    public String  toString(){
	String ans = "";
	for(int r = 0; r < board.length; r++){
	    for(int c = 0; c < board[0].length; c++){
		ans+= board[r][c]+"\t";
	    }
	    ans+="\n";
	}
	return ans;
    }
    
    public static void main(String[]args){
	QueenBoard b = new QueenBoard(12);
        /*System.out.println(b);
	b.addQueen(3,0);
	b.addQueen(0,1);
        System.out.println(b);
	b.removeQueen(3,0);
        System.out.println(b);*/
	System.out.println(b.solve());
	b.printSolution();
    }
    
    
}
