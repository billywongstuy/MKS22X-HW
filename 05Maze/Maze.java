import java.util.*;
import java.io.*;

public class Maze{

    private char[][]maze;
    private int startx,starty;
    private boolean animate;
    private boolean DEBUG = false;

    /*Constructor loads a maze text file.
      1. The file contains a rectangular ascii maze, made with the following 4 characters:
      '#' - locations that cannot be moved onto
      ' ' - locations that can be moved onto
      'E' - the location of the goal (only 1 per file)
      'S' - the location of the start(only 1 per file)

      2. The maze has a border of '#' around the edges. So you don't have to check for out of bounds!

      3. When the file is not found, print an error and exit the program.
    */
    public Maze(String filename, boolean ani){
	try {
	    animate = ani;
	    int rows = 0;
	    int cols = 0;
	    String mazey = "";
	    Scanner s = new Scanner(new File(filename));
	    while (s.hasNextLine()) {
	        String line = s.nextLine();
		//System.out.println(line);
		mazey += line;
		rows++;
		cols = line.length();
	    }
	    maze = new char[rows][cols];
	    int currentRow = 0;
	    int currentCol = 0;
	    for (int i = 0; i < mazey.length(); i++) {
		//System.out.println(i +  " " + i%cols);
	    	if (i% cols == 0 && i != 0) {
	    	    currentRow++;
	    	    currentCol = 0;
		}
		//System.out.println(currentCol);
	    	maze[currentRow][currentCol] = mazey.charAt(i);
		if (mazey.charAt(i) == 'S') {
		    startx = currentRow;
		    starty = currentCol;
		}
	    	currentCol++;
	    }
	    //System.out.println(Arrays.deepToString(maze));
	}
	catch (FileNotFoundException e) {
	    
	}

        //COMPLETE CONSTRUCTOR
    }


    /*Main Solve Function

      Things to note:
      When no S is contained in maze, print an error and return false.
    */
    public boolean solve(){
        if(startx < 0){
            System.out.println("No starting point 'S' found in maze.");
            return false;
        }else{
            maze[startx][starty] = ' ';
            return solve(startx,starty);
        }
    }

    /*
      Recursive Solve function:

      A solved maze has a path marked with '@' from S to E.
      The S is replaced with '@' but the 'E' is not.

      Postcondition:
      Returns true when the maze is solved,
      Returns false when the maze has no solution.

      All visited spots that were not part of the solution are changed to '.'
      All visited spots that are part of the solution are changed to '@'

    */
    private boolean solve(int x, int y){
        if(animate){
            System.out.println(this);
            wait(50);  //orig is 20
        }

	debug("hello");
	
	if (maze[x][y] == 'E') {
	    debug("ahsh");
	    return true;
	}
	if (maze[x][y] != ' ') {
	    debug("noo");
	    return false;
	}

	debug("begin");
	maze[x][y] = '@';
	//maze[x][y] = '.';
	if (solve(x+1,y)) {
	    debug("a");
	    return true;
	}
	if (solve(x-1,y)) {
	    debug("b");
	    return true;
	}
        if (solve(x,y+1)) {
	    debug("c");
	    return true;
	}
	if (solve(x,y-1)) {
	    debug("d");
	    return true;
	}
        debug("end");
	maze[x][y] = '.';

        //COMPLETE SOLVE
        return false; //so it compiles
    }


    private void debug(String s) {
	if (DEBUG) {
	    System.out.println(s);
	}
    }

    //FREE STUFF!!! *you should be aware of this*

    public void clearTerminal(){
        System.out.println(CLEAR_SCREEN);
    }

    public String toString(){
        int maxx = maze.length;
        int maxy = maze[0].length;
        String ans = "";
        if(animate){
            ans = "Solving a maze that is " + maxx + " by " + maxy + "\n";
        }
        for(int i = 0; i < maxx * maxy; i++){
            if(i % maxx == 0 && i != 0){
                ans += "\n";
            }
	    
            char c =  maze[i %  maxx][i / maxx];
            if(c == '#'){
                ans += color(38,47)+c;
            }else{
                ans += color(32,40)+c;
            }
        }
        return HIDE_CURSOR + go(0,0) + ans + "\n" + SHOW_CURSOR + color(37,40);
    }

    //MORE FREE STUFF!!! *you can ignore all of this*
    //Terminal keycodes to clear the terminal, or hide/show the cursor
    private static final String CLEAR_SCREEN =  "\033[2J";
    private static final String HIDE_CURSOR =  "\033[?25l";
    private static final String SHOW_CURSOR =  "\033[?25h";
    //terminal specific character to move the cursor
    private String go(int x,int y){
        return ("\033[" + x + ";" + y + "H");
    }

    private String color(int foreground,int background){
        return ("\033[0;" + foreground + ";" + background + "m");
    }

    private void wait(int millis){
        try {
            Thread.sleep(millis);
        }
        catch (InterruptedException e) {
        }
    }

    
    //END FREE STUFF



}
