import java.util.*;


public class Quick {

    private static void swap(int[]data,int j, int k) {
	int temp = data[j];
	data[j] = data[k];
	data[k] = temp;
    }
    
    private static int partitionOld(int[]data, int left, int right) {
	int origRight = right;       
        if (left == right) {
	    return right;
	}	
        int ind = 10;//(int)(Math.random()*(right-left))+left;
	int value = data[ind];
	swap(data,ind,right);
	right--;
	while (left < right) {
 	    if (data[left] >= value) {
		swap(data,left,right);
 		right--;
	    }
 	    else {
 		left++;
	    }
 	}
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

    public static int quickselectOld(int[]data, int k)  {
	if (k == 0) {
	    k = 1;
	}
	return quickselectOld(data,k-1,0,data.length-1);
    }


    private static int quickselectOld(int[]data, int k, int left, int right) {
	int ind = partitionOld(data,left,right);
	if (ind == k) {
	    return data[ind];
	}

	else if (ind > k) {
	    return quickselectOld(data,k,left,ind);
	}
	//if ind < k
	else {
	    return quickselectOld(data,k,ind,right);
	}
    }


    public static void quickSortOld(int[]data) {
	quickSortOld(data,0,data.length-1);
    }

    public static void quickSortOld(int[]data,int left,int right) {
	if (left < right) {
	    int index = partitionOld(data,left,right);
	    if (index > 0) {
		quickSortOld(data,left,index-1);
	    }
	    if (index < data.length-1) {
		quickSortOld(data,index+1,right);
	    }
	}	
    }

    //------------------------------------------------------------


    private static int[] partition(int[]data, int left, int right) {
	int origRight = right;       
        if (left == right) {
	    int [] bounds = {right,right};
	    return bounds;
	}	
        int ind = (int)(Math.random()*(right-left))+left;
	int value = data[ind];
	swap(data,ind,right);
	right--;

	int rightTwo = -1;
	while (left < right && (rightTwo == -1 || rightTwo > left)) {
	    //debug(left+ " " + right);
	    //printArray(data);
 	    if (data[left] > value) {
		swap(data,left,right);
 		right--;
	    }
 	    else if (data[left] < value) {
		left++;
	    }
	    else {
		if (rightTwo == -1) {
		    swap(data,left,right);
		    rightTwo = right;
		}
		else {
		    swap(data,left,rightTwo-1);
		    rightTwo--;
		}
	    }
 	}
	int rightEnd = right;
	int valueIndex = origRight;
        if (data[right] < value) {
	    swap(data,right+1,valueIndex);
	    rightEnd = right+1;
	    /*
	    int leftBound = right+1;	    
	    for (int i = right+1; data[i] == data[right+1]; i--) {
		leftBound = i;
	    }
	    int[]bounds = {leftBound,right+1};
	    return bounds;
	    */
	}
	else {
	    swap(data,right,valueIndex);
	    /*
	    int leftBound = right;
	    for (int i = right; data[i] == data[right] && i > 0; i--) {
		leftBound = i;
	    }
	    int[]bounds = {leftBound,right};
	    return bounds;
	    */
	}
	int [] bounds = {left,rightEnd};
	return bounds;
    }

    public static int quickselect(int[]data, int k)  {
	if (k == 0) {
	    k = 1;
	}
	return quickselect(data,k-1,0,data.length-1);
    }


    private static int quickselect(int[]data, int k, int left, int right) {
	int[] ind = partition(data,left,right);
	if (ind[0] == k) {
	    return data[ind[0]];
	}

	else if (ind[0] > k) {
	    return quickselect(data,k,left,ind[0]);
	}
	//if ind < k
	else {
	    return quickselect(data,k,ind[1],right);
	}
    }


    public static void quickSort(int[]data) {
	quickSort(data,0,data.length-1);
    }

    public static void quickSort(int[]data,int left,int right) {
	if (left < right) {
	    int[] index = partition(data,left,right);
	    if (index[0] > 0) {
		quickSort(data,left,index[0]-1);
	    }
	    if (index[1] < data.length-1) {
		quickSort(data,index[1]+1,right);
	    }
	}	
    }

    
    
    //-------------------------------------------------------------
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


    public static void fillRandomAny(int[]data) {
	Random generator = new Random();
	for (int i = 0; i < data.length; i++) { 
	    int sign = 1;
	    if ((int)(Math.random()*2) == 0) {
		sign = -1;
	    }
	    data[i] = sign * generator.nextInt(Integer.MAX_VALUE);
	}
    }

    public static String name() {
	return ("7,Wong,Billy");
    }


    public static void  printArray(int[]data) {
	String print = "[";
	for (int i = 0; i < data.length; i++) {
	    if (i == data.length-1) {
		print += data[i];
	    }
	    else {
		print += data[i] + ", ";
	    }
	}
	print += "]";
	System.out.println(print);
    }

    public static void main(String[]args) {
	int[]d = {6,2,-23,99,88,7,4,8,56,-8,4,26,96,88,4,28,30,21,0};
	//int[]d={6,10,8,7,19,4};
	//int [] d= {1,2,0,4,3,2,3,4,4,4,2,3,1,2,1,1,3,4};
	//System.out.println(Arrays.toString(partition(d,0,d.length-1)));
	//System.out.println(Arrays.toString(d));
	//System.out.println(quickselect(d,5));
	//quickSort(d);
	//printArray(d);

	/*
	int[]testArray = new int[(int)(Math.random()*10+1)];
	fillRandom(testArray);
	System.out.print("Orig: "); printArray(testArray);
	
	*/

	
	int choice = 0;
	if (args.length > 0) {
	    choice = Integer.parseInt(args[0]);
	}
	
	int[]testArray = new int[4000000];

	for (int i = 0; i < testArray.length; i++) {
	    testArray[i] = (int)(Math.random()*3);
	    }

	
	//fillRandomAny(testArray);
	
	if (choice == 0) {
	    quickSort(testArray);
	}
	if (choice == 1) {
	    Arrays.sort(testArray);
	}
	if (choice == 2) {
	    quickSortOld(testArray);
	}

	
	
	

	//--------------------------------
	//  FOR TESTING quickSort
	//--------------------------------
	/*
	  int[]toSort = Arrays.copyOf(testArray,testArray.length);	
	  Arrays.sort(testArray);
	  System.out.print("Sorted: "); printArray(testArray);
	  quickSort(toSort);
	  printArray(toSort);
	 */
	

	//----------------------------
	//  FOR TESTING quickselect
	//----------------------------
	/*
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
	*/


	
	
			   
    }
    
    
}
