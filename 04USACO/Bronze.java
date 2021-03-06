import java.util.*;
import java.io.*;

public class Bronze {

    public static String makeLake() {
	int[][]field;
	try {
	    Scanner s = new Scanner(new File("makelake.in"));
	    int rows = s.nextInt();
	    int cols = s.nextInt();
	    field = new int[rows][cols];
	    int waterElevation = s.nextInt();
	    int numberStomps = s.nextInt();
	    s.nextLine();
	    for (int i = 0; i < rows; i++) {
	        for (int j = 0; j < cols; j++) {
		    field[i][j] = s.nextInt();
		}
	    }

	    for (int i = 0; i < numberStomps; i++) {
	        int r = s.nextInt()-1;
		int c = s.nextInt()-1;
		int d = s.nextInt();
	        field[r][c] -= d;
		for (int j = r; j <  r+3; j++) {
		    for (int k = c; k < c+3; k++) {
			//System.out.println(j+","+k);
			if (field[j][k] > field[r][c]) {
			    field[j][k] = field[r][c];
			}
		    }
		}
	    }

	    for (int i = 0; i < rows; i++) {
		for (int j = 0; j < cols; j++) {
		    if (field[i][j] < waterElevation) {
			field[i][j] = waterElevation - field[i][j];
		    }
		    else {
			field[i][j] = 0;
		    }
		}
	    }
	    //System.out.println(Arrays.deepToString(field));

	    int sum = arraySum(field);
	    return sum*72*72 +",7,Wong,Billy";
	}
	catch (FileNotFoundException e) {
	    System.out.println(e);
	}
	
	return "7,Wong,Billy";
    }


    public static int arraySum(int[][]a) {
	int sum = 0;
	for (int i = 0; i < a.length; i++) {
	    for (int j = 0; j < a[i].length; j++) {
		sum += a[i][j];
	    }
	}
	return sum;
    }

    public static void main(String[]args) {
	System.out.println(makeLake());
    }
    
}
