import java.util.*;


public class Quick {

    private static void swap(int[]data,int j, int k) {
	int temp = data[j];
	data[j] = data[k];
	data[k] = temp;
    }
    
    private static int partition(int[]data, int left, int right) {

	int origRight = right;
        
	//debug("L R: " + left + " " + right);
        if (left == right) {
	    return right;
	}
	
        int ind = (int)(Math.random()*(right-left))+left;
	
	//debug("Random: " + ind);

	int value = data[ind];

	swap(data,ind,right);

	right--;

	//System.out.println(Arrays.toString(data));

	//put x to end/beginning
	//copy things to left if they are smaller than x
	//copy things to right if they are bigger than x
	//put x to original spot later (or middle)


	while (left < right) {
 	    if (data[left] >= value) {
		swap(data,left,right);
 		right--;
	    }
 	    else {
 		left++;
	    }
 	}

	//debug(left+"");
	//debug(Arrays.toString(data));
	//debug(value + "");

	//int valueIndex = Arrays.asList(data).indexOf(value);
	int valueIndex = origRight;
	
        if (data[left] < value) {
	    swap(data,right+1,valueIndex);
	    return right+1;
	}
	else {
	    swap(data,left,valueIndex);
	    return left;
	}

    }


    //Quick Select will now give the kth smallest value, so the k corresponds to the index of the array! Save you one subtraction!
    
    public static int quickselect(int[]data, int k)  {
	//return the kth smallest value.
	// when k = 0 return the smallest.
	// 0 <= k < data.length
	if (k == 0) {
	    k = 1;
	}
	return quickselect(data,k-1,0,data.length-1);
	    //return 0;
    }


    private static int quickselect(int[]data, int k, int left, int right) {
	//return the kth smallest value in the given left/right range 
	// left <= k <= right
	//start by calling the helper as follows:
	// quickselect(data,k,0,data.length-1)
	
	//debug(left + " " + right);


	int ind = partition(data,left,right);

	//debug("P: " + ind);

	//debug("----------------------------------------");
	
	if (ind == k) {
	    return data[ind];
	}

	else if (ind > k) {
	    return quickselect(data,k,left,ind);
	}

	//if ind < k
	else {
	    return quickselect(data,k,ind,right);
	}
	
	

    }


    //quicksort
    //parition of left and right
    //if there's more than 1 element do the algorithm
    //what if part == 0? or data.length-1
    //then quicksort(left,part-1), quicksort(part+1,right)


    private static void debug(String s) {
	boolean DEBUG = true;
	if (DEBUG) {
	    System.out.println(s);
	}
    }


    public static void fillRandom(int[]data) {
	Random generator = new Random();
	for (int i = 0; i < data.length; i++) { 
	    int sign = 1;
	    if ((int)(Math.random()*2) == 0) {
		sign = -1;
	    }
	    data[i] = sign * generator.nextInt(100);
	}
    }


    public static void  printArray(int[]data) {
	String print = "[";
	for (int i = 0; i < data.length; i++) {
	    if (i == data.length-1) {
		print += data[i];
	    }
	    else {
		print += data[i] + ",";
	    }
	}
	print += "]";
	System.out.println(print);
    }

    public static void main(String[]args) {
	//int[]d = {6,2,-23,99,7,4,8,56,-8,4,26,96,88,4,28,30,21,0};
	//int[]d={6,10,8,7,19,4};
	//System.out.println(partition(d,0,d.length-1));
	//System.out.println(Arrays.toString(d));
	//System.out.println(quickselect(d,5));

	int[]testArray = new int[(int)(Math.random()*10+1)];
	fillRandom(testArray);
	System.out.print("Orig: "); printArray(testArray);
        Arrays.sort(testArray);
	System.out.print("Sorted: "); printArray(testArray);
	int k = (int)(Math.random()*testArray.length);
	int value = quickselect(testArray,k);
	boolean equal = false;
	
	System.out.println("The " + k + "th smallest value is " + value);
	if (testArray.length == 1) {
	    equal = true;
	}
	else if (k == 0) {
	    equal = (testArray[0] == value);
	}
	else if (testArray[k-1] == value) {
	    equal = true;
	}
	System.out.println(equal);
			   
    }
    
    
}
