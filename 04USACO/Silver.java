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
	try {
	    Scanner s = new Scanner(new File("ctravel.in"));
	    int rows = s.nextInt();
	    int cols = s.nextInt();
	    steps = s.nextInt();
	    int total = 0;
	    field = new int[rows][cols];
	    for (int i = 0; i < rows; i++) {
	        String next = s.next();
		for (int j = 0; j < next.length(); j++) {
		    if (next.charAt(j) == '*') {
			field[i][j] = -1;
		    }
		    else {
			field[i][j] = 0;
		    }
		}
	    }
	    r1 = s.nextInt()-1;
	    c1 = s.nextInt()-1;
	    r2 = s.nextInt()-1;
	    c2 = s.nextInt()-1;
	    field[r1][c1] = 1;
	}
	catch (FileNotFoundException e) {

	}
    }


    public String solve() {
	for (int i = 0; i < steps; i++) {
	    //ask every space if it is greater than 0 then add the number to all 
	    //possible nearby
	    //make marker to indicate that those new numbers cannot be dealt with
	    for (int j = 0; j < field.length; j++) {
		for (int k = 0; k < field[j].length; k++) {
		    if (field[j][k] > 0) {
			neighborsSet(j,k);
		    }
		}
	    }
	    sweepNegatives();
	    //System.out.println(this);
	    
	}
	//System.out.println(r2 + " " + c2);
	return (field[r2][c2])+",7,Wong,Billy";
    }

    
    public void neighborsSet(int row, int col) {
	if (col > 0 && (field[row][col-1] >= 0 || field[row][col-1] <= -2)) {
	    field[row][col-1] += -2*field[row][col];
	    //System.out.println("left");
	}
	if (col < field[0].length-1 && (field[row][col+1] >= 0 || field[row][col+1] <= -2)) {
	    field[row][col+1] += -2*field[row][col];
	    //System.out.println("down");
	}
	if (row > 0 && (field[row-1][col] >= 0 || field[row-1][col] <= -2)) {
	    field[row-1][col] += -2*field[row][col];
	    //System.out.println("up");
	}
	if (row < field.length-1 && (field[row+1][col] >= 0 || field[row+1][col] <= -2)) {
	    field[row+1][col] += -2*field[row][col];
	    //System.out.println("right");
	}
	field[row][col] = 0;
    }


    public String toString() {
	String str = "";
	for (int i = 0; i < field.length; i++) {
	    for (int j = 0; j < field[i].length; j++) {
		str += (field[i][j] + " ");
	    }
	    str += "\n";
	}
	return str;
    }

    public void sweepNegatives() {
	for (int i = 0; i < field.length; i++) {
	    for (int j = 0; j < field[i].length; j++) {
		if (field[i][j] < -1) {
		    field[i][j] = -1*(field[i][j]/2);
		}
	    }
	}
    }

    public static void main(String[]args) {
	Silver s = new Silver();
	//System.out.println(Arrays.deepToString(s.field));
	System.out.println(s.solve());
    }
}
