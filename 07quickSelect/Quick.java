import java.util.*;


public class Quick {

    //ivate void swap(int [] data, int i, int j) {
    //	int v = data[i];
    //	data[i] = data[j];
    //	data[j] = v;
    //}
    
    private static int partition(int[]data, int left, int right) {

	System.out.println(Arrays.toString(data));

	int r1 = (int)(Math.random()*(right-left))+left;
	int r2 = (int)(Math.random()*(right-left))+left;
	int r3 = (int)(Math.random()*(right-left))+left;
	System.out.println(r1 + " " + r2 + " " + r3);
	int random = r1;

	if ((data[r1] > data[r2] && data[r1] > data[r3]) || (data[r1] < data[r2] && data[r1] < data[r3])) {
	    if (data[r3] > data[r2]) {
		random = r3;
	    }
	    else {
		random = r2;
	    }
	}
	
	int value = data[random];

        data[random] = data[right];
	data[right] = value;

	right--;

	System.out.println(Arrays.toString(data));

	while (left < right) {
	    if (data[left] > value) {
	        int t = data[right];
		data[right] = data[left];
		data[left] = t;
		right--;
		System.out.println(Arrays.toString(data));
	    }
	    else {
		left++;
		System.out.println(Arrays.toString(data));
	    }
	}
	
	int i;
	
	for (i = data.length-1; i > 0 && data[i-1] > value; i--) {
	    data[i] = data[i-1];
	}

	data[i] = value;

	return i;
    }


    //Quick Select will now give the kth smallest value, so the k corresponds to the index of the array! Save you one subtraction!
    
    public static int quickselect(int[]data, int k)  {
	//return the kth smallest value.
	// when k = 0 return the smallest.
	// 0 <= k < data.length
	return 0;
    }


    private static int quickselect(int[]data, int k, int left, int right) {
	//return the kth smallest value in the given left/right range 
	// left <= k <= right
	//start by calling the helper as follows:
	// quickselect(data,k,0,data.length-1)
	return 0;
    }


    public static void main(String[]args) {
	//int[]d = {6,2,-23,99,7,4,8,56,-8,4,26,96,88,4,28,30,21,0};
	int[]d={6,10,8,7,19,4};
	System.out.println(partition(d,0,d.length-1));
	System.out.println(Arrays.toString(d));
			   
    }
    
    
}
