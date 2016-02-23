import java.util.*;
import java.io.*;

public class Silver {
    
    public int cowTravel() {
	String[][]field;
	Scanner s = new Scanner(new File("ctravel.in"));
	int rows = s.nextInt();
	int cols = s.nextInt();
	int steps = s.nextInt();
	field = new String[rows][cols];
	for (int i = 0; i < rows; i++) {
	    for (int j = 0; j < cols; j++) {
		field[i][j] = s.nextInt();
	    }
	}
	int r1 = s.nextInt();
	int c1 = s.nextInt();
	int r2 = s.nextInt();
	int c2 = s.nextInt();
	int ways = wanderAround(r1,c1,r2,c2,steps);
	//6 steps = 6 * big number that depends on # of steps
    }


    public int wanderAround(int r1,int c1,int r2,int c2, int steps) {
	
    }

    public static void main(String[]args) {

    }
}
