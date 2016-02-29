import java.util.*;
import java.io.*;

public class Silver {

    int field[][];
    int steps;
    int r1;
    int c1;
    int r2;
    int c2;
    
    public Silver() {
	Scanner s = new Scanner(new File("ctravel.in"));
	int rows = s.nextInt();
	int cols = s.nextInt();
	steps = s.nextInt();
	int total = 0;
	field = new String[rows][cols];
	for (int i = 0; i < rows; i++) {
	    for (int j = 0; j < cols; j++) {
	        if (s.next().equals("*")) {
		    field[i][j] = -1;
		}
		else {
		    field[i][j] = 0;
		}
	    }
	}
	r1 = s.nextInt();
	c1 = s.nextInt();
	r2 = s.nextInt();
	c2 = s.nextInt();
	field[r1][c1] = 1;
    }


    public int solve() {
	for (int i = 0; i < steps; i++) {
	    //ask every space if it is greater than 0 then add the number to all 
	    //possible nearby
	    //make marker to indicate that those new numbers cannot be dealt with
	    
	}
	return field[r2][c2];
    }

    public static void main(String[]args) {

    }
}
