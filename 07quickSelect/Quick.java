import java.util.*;


public class Quick {

    //ivate void swap(int [] data, int i, int j) {
    //	int v = data[i];
    //	data[i] = data[j];
    //	data[j] = v;
    //}
    
    private static int partition(int[]data, int left, int right) {

	//System.out.println(Arrays.toString(data));
	debug("L R: " + left + " " + right);

	int r1 = (int)(Math.random()*(right-left))+left;
	int r2 = (int)(Math.random()*(right-left))+left;
	int r3 = (int)(Math.random()*(right-left))+left;
	int random = r1;

	if ((data[r1] > data[r2] && data[r1] > data[r3]) || (data[r1] < data[r2] && data[r1] < data[r3])) {
	    if (data[r3] > data[r2]) {
		random = r3;
	    }
	    else {
		random = r2;
	    }
	}
	
	debug("Random: " + random);

	int value = data[random];

        data[random] = data[right];
	data[right] = value;

	right--;

	//System.out.println(Arrays.toString(data));

	//put x to end/beginning
	//copy things to left if they are smaller than x
	//copy things to right if they are bigger than x
	//put x to original spot later (or middle)

	int t = 0;
	while (left <= right) {
	    if (data[left] >= value) {
	        t = data[left];
		data[left] = data[right];
		data[right] = t;
		right--;
		//System.out.println(Arrays.toString(data));
	    }
	    else if (data[left] < value) {
		left++;
	    }
	}
	
	int i;
	
	for (i = data.length-1; i > 0 && data[i-1] > value; i--) {
	   data[i] = data[i-1];
	}

	data[right] = t;

	debug(Arrays.toString(data));

	return right;
    }


    //Quick Select will now give the kth smallest value, so the k corresponds to the index of the array! Save you one subtraction!
    
    public static int quickselect(int[]data, int k)  {
	//return the kth smallest value.
	// when k = 0 return the smallest.
	// 0 <= k < data.length
	return quickselect(data,k,0,data.length-1);
	    //return 0;
    }


    private static int quickselect(int[]data, int k, int left, int right) {
	//return the kth smallest value in the given left/right range 
	// left <= k <= right
	//start by calling the helper as follows:
	// quickselect(data,k,0,data.length-1)
	
	debug(left + " " + right);
	if (left == right) {
	    return data[left];
	}

	int part = partition(data,left,right);
	debug("P: " + part);

	debug("----------------------------------------");
	

	quickselect(data,k,left,part);
	
	return 0;
    }


    private static void debug(String s) {
	boolean DEBUG = true;
	if (DEBUG) {
	    System.out.println(s);
	}
    }

    public static void main(String[]args) {
	//int[]d = {6,2,-23,99,7,4,8,56,-8,4,26,96,88,4,28,30,21,0};
	int[]d={6,10,8,7,19,4};
	System.out.println(partition(d,0,d.length-1));
	System.out.println(Arrays.toString(d));
	//System.out.println(quickselect(d,0));
			   
    }
    
    
}
