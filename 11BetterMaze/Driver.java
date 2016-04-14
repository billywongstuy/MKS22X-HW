import java.util.*;

public class Driver {
    public static void main(String[]args) {
	String maze = "data4.dat";
	BetterMaze m = new BetterMaze(maze);
	m.setAnimate(true);
	System.out.println(m.solveBFS());
	//System.out.println(m.solveDFS());
	System.out.println(Arrays.toString(m.solutionCoordinates()));
	System.out.println(m);
	
    }
}
