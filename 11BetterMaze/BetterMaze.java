import java.util.*;
import java.io.*;

public class BetterMaze{
    private class Node{
	private Coordinate location;
	private Node previous;
	private int chain;

	public Node(Coordinate l, Node p) {
	    location = l;
	    previous = p;
	    if (p != null) {
		chain = 1+previous.getChain();
	    }
	    else {
		chain = 1;
	    }
	    //System.out.println("chain: " + chain);
	}


	public int getChain() {
	    return chain;
	}
	
	public Node getPrevious() {
	    return previous;
	}

	public Coordinate getValue() {
	    return location;
	}

	public Coordinate getLocation() {
	    return getValue();
	}
	
    }

    private char[][] maze;
    private int[]    solution;
    private int      startRow,startCol;
    private Frontier<Node> placesToGo;
    private boolean  animate;//default to false

    /**return a COPY of solution.
     *This should be : [x1,y1,x2,y2,x3,y3...]
     *the coordinates of the solution from start to end.
     *Precondition : one of the solveXXX methods has already been 
     * called (solveBFS OR solveDFS OR solveAStar)
     *(otherwise an empty array is returned)
     *Postcondition:  the correct solution is in the returned array
     **/
    public int[] solutionCoordinates(){
        /** IMPLEMENT THIS **/
        return solution;
    }    


    /**initialize the frontier as a queue and call solve
     **/
    public boolean solveBFS(){  
        /** IMPLEMENT THIS **/   
	placesToGo = new FrontierQueue<>();
        return solve();
    }   


    /**initialize the frontier as a stack and call solve
     */ 
    public boolean solveDFS(){  
        /** IMPLEMENT THIS **/  
	placesToGo = new FrontierStack<>();
        return solve();
    }    

    /**Search for the end of the maze using the frontier. 
       Keep going until you find a solution or run out of elements on the frontier.
    **/
    private boolean solve(){  
        /** IMPLEMENT THIS **/

	//System.out.println(startRow + " " + startCol);
	
	placesToGo.add(new Node(new Coordinate(startRow,startCol),null));

	maze[startRow][startCol] = '@';
	
	//for everything in there
        while (placesToGo.hasNext()) {

	    if (animate) {
		clearTerminal();
		System.out.println(this);
		wait(100);
	    }
	    
	    Node current = placesToGo.next();
	    int x = current.getLocation().getX();
	    int y = current.getLocation().getY();

	    //System.out.println("X:" + x + ", Y:" + y);
	    //System.out.println(maze[x][y]);
	    //System.out.println(maze[5][1]);
	    
	    if (maze[x][y] == 'E') {
		//something about the length to the array
		//also need to set the previous ones to stars
		solution = new int[current.getChain()*2];
		for (int i = solution.length-1; i >= 3; i = i-2) {
		    solution[i] = y;
		    solution[i-1] = x;
		    maze[x][y] = '@';
		    current = current.getPrevious();
		    x = current.getLocation().getX();
		    y = current.getLocation().getY();
		}
		solution[0] = startRow;
		solution[1] = startCol;
		return true;
	    }


	    //if it's E then don't set it
	    if (x > 0 && (maze[x-1][y] == ' ' || maze[x-1][y] == 'E')) {
		placesToGo.add(new Node(new Coordinate(x-1,y),current));
		if (maze[x-1][y] != 'E') {
		    maze[x-1][y] = '.';
		}
	    }
	    if (x < maze.length && (maze[x+1][y] == ' '  || maze[x+1][y] == 'E')) {
		placesToGo.add(new Node(new Coordinate(x+1,y),current));
		if (maze[x+1][y] != 'E') {
		    maze[x+1][y] = '.';
		}
	    }
	    if (y > 0 && (maze[x][y-1] == ' '  || maze[x][y-1] == 'E')) {
		placesToGo.add(new Node(new Coordinate(x,y-1),current));
		if (maze[x][y-1] != 'E') {
		    maze[x][y-1] = '.';
		}
	    }
	    if (y < maze[0].length && (maze[x][y+1] == ' '  || maze[x][y+1] == 'E')) {
		placesToGo.add(new Node(new Coordinate(x,y+1),current));
		if (maze[x][y+1] != 'E') {
		    maze[x][y+1] = '.';
		}
	    }

	    

	}
	return false;
    }    
     
    /**mutator for the animate variable  **/
    public void setAnimate(boolean b){  /** IMPLEMENT THIS **/ animate = b;}    


    public BetterMaze(String filename){
	animate = false;
	int maxc = 0;
	int maxr = 0;
	startRow = -1;
	startCol = -1;
	//read the whole maze into a single string first
	String ans = "";
	try{
	    Scanner in = new Scanner(new File(filename));

	    //keep reading next line
	    while(in.hasNext()){
		String line = in.nextLine();
		if(maxr == 0){
		    //calculate width of the maze
		    maxc = line.length();
		}
		//every new line add 1 to the height of the maze
		maxr++;
		ans += line;
	    }
	}
	catch(Exception e){
	    System.out.println("File: " + filename + " could not be opened.");
	    e.printStackTrace();
	    System.exit(0);
	}
	System.out.println(maxr+" "+maxc);
	maze = new char[maxr][maxc];
	for(int i = 0; i < ans.length(); i++){
	    char c = ans.charAt(i);
	    maze[i / maxc][i % maxc] = c;
	    if(c == 'S'){
		startCol = i % maxc;
		startRow = i / maxc;
	    }
	}
    }







    private static final String CLEAR_SCREEN =  "\033[2J";
    private static final String HIDE_CURSOR =  "\033[?25l";
    private static final String SHOW_CURSOR =  "\033[?25h";
    private String go(int x,int y){
	return ("\033[" + x + ";" + y + "H");
    }
    private String color(int foreground,int background){
	return ("\033[0;" + foreground + ";" + background + "m");
    }

    public void clearTerminal(){
	System.out.println(CLEAR_SCREEN);
    }

    public void wait(int millis){
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
    }


    public String toString(){
	int maxr = maze.length;
	int maxc = maze[0].length;
	String ans = "";
	if(animate){
	    ans = "Solving a maze that is " + maxr + " by " + maxc + "\n";
	}
	for(int i = 0; i < maxc * maxr; i++){
	    if(i % maxc == 0 && i != 0){
		ans += color(37,40) + "\n";
	    }
	    char c =  maze[i / maxc][i % maxc];
	    if(c == '#'){
		ans += color(38,47)+c;
	    }else{
		ans += color(33,40)+c;
	    }
	}
	//nice animation string
	if(animate){
	    return HIDE_CURSOR + go(0,0) + ans + color(37,40) +"\n"+ SHOW_CURSOR + color(37,40);
	}else{
	    return ans + color(37,40) + "\n";
	}
    } 
   
             

}
