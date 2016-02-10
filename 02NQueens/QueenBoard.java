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
	System.out.println("col: " + col);
        int row = 0;
	boolean queenAdded = false;
	while (row < board.length && !queenAdded) {
	    System.out.println("Row: " + row);
	    if (addQueen(row,col)) {
		queenAdded = true;
	    }
	    row++;
	}
	if (col == board[0].length-1 && allZeroes()) {
	    return false;
	}
	if (col == board[0].length-1 && !allZeroes()) {
	    return true;
	}

	if (col == 0 && row == board.length-1) {
	    return false;
	}
	if (row == board.length-1 && !queenAdded) {
	    //remove the queen from the previous row and start adding queens in the next row
	    return solveH(col-1);
	}
	return true && solveH(col+1);
    }


    public boolean allZeroes() {
	for (int i = 0; i < board.length; i++) {
	    for (int j = 0; j < board[i].length; j++) {
		if (board[i][j] != 0) {
		    return false;
		}
	    }
	}
	return true;
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
		System.out.print(board[i][j] + " | ");
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
	QueenBoard b = new QueenBoard(6);
        /*System.out.println(b);
	b.addQueen(3,0);
	b.addQueen(0,1);
        System.out.println(b);
	b.removeQueen(3,0);
        System.out.println(b);*/
	b.solve();
	b.printSolution();
    }
    
    
}
