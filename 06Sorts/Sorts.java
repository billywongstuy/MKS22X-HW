import java.util.*;

public class Sorts {

    
    public static void insertionSort(int[]data) {
	for (int i = 1; i < data.length; i++) {
	    int k;
	    int value = data[i];
	    for (k = i - 1; k >= 0 && data[k] > value; k--) {
		data[k+1] = data[k];		
	    }
	    data[k+1] = value;
	}
    }

    public static void selectionSort(int[]data) {
	int start = 0;
	int lowestIndex = 0;
	while (start < data.length-1) {
	    int lowest = data[start];
	    for (int i = start; i < data.length; i++) {
		if (data[i] < lowest) {
		    lowest = data[i];
		    lowestIndex = i;
		}
	    }
	    data[lowestIndex] = data[start];
	    data[start] = lowest;
	    start++;
	}
    }

    public static void bubbleSort(int[]data) {
	int end = data.length;
	while (end > 0) {
	    for (int i = 0; i < end-1; i++) {
		int toSwap;
		if (data[i+1] < data[i]) {
		    toSwap = data[i];
		    data[i] = data[i+1];
		    data[i+1] = toSwap;
		}
	    }
	    end--;
	}
    }


    
    public static void mergeSort(int[]data) {
	//printArray(data);
	int [] newer = mSortHelper(data);
	for (int i = 0; i < data.length; i++) {
	    data[i] = newer[i];
	}
	//printArray(data);
    }


    public static int[] mSortHelper(int[]data) {
	if (data.length == 1) {
	    debug("yello " + Arrays.toString(data));
	    return data;
	}

	int end1 = (int)(data.length/2);
	int start2 = end1;
	int [] ary1 = Arrays.copyOfRange(data,0,end1);
	int [] ary2 = Arrays.copyOfRange(data,start2,data.length);

	//debug("C: " + Arrays.toString(data));
	
        int [] newer = merge(mSortHelper(ary1),mSortHelper(ary2));

	debug("D: " + Arrays.toString(newer));
	
	return newer;
	
    }
    


    /*public static void mergeSort(int [] data) {
	int end1 = (int)(data.length/2);
	int [] ary1 = Arrays.copyOfRange(data,0,end1);
	int [] ary2 = Arrays.copyOfRange(data,end1,data.length);

	if (ary1.length > 1) {
	    mergeSort(ary1);
	}
	if (ary2.length > 1) {
	    mergeSort(ary2);
	}

	data = merge(ary1,ary2);
	
	
	//merge(mergeSort(ary1),mergeSort(ary2));
    }*/

    public static int[] merge(int[]data1,int[]data2) {
	int [] newer = new int[data1.length+data2.length];
	int index1 = 0;
	int index2 = 0;
	int i;
	for (i = 0; i < newer.length && index1 < data1.length && index2 < data2.length; i++) {
	    if (data1[index1] > data2[index2]) {
		newer[i] = data2[index2];
		index2++;
	    }
	    else {
		newer[i] = data1[index1];
		index1++;
	    }
	}
	int [] unfinished = data1;
	int unfin = index1;
	if (index1 == data1.length) {
	    unfinished = data2;
	    unfin = index2;
	}
	for (int j = unfin; j < unfinished.length; j++) {
	    newer[i] = unfinished[j];
	    i++;
	}

	debug("GYO: " +  Arrays.toString(newer));
	return newer;
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


    public static void swap (int[] data, int x, int y) {
	int store = data[x];
	data[x] = data[y];
	data[y] = store;
    }


    public static void debug(String s) {
	boolean DEBUG = false;
	if (DEBUG) {
	    System.out.println(s);
	}
    }


    public static void main(String[]args) {
	int[]testArray = new int[(int)(Math.random()*10+1)];
	fillRandom(testArray);
	System.out.print("Original:  ");
	printArray(testArray);
	int[]copy = Arrays.copyOf(testArray,testArray.length);
	Arrays.sort(copy);
	System.out.print("Sorted:    ");
	printArray(copy);
	System.out.print("Your Sort: ");
	//insertionSort(testArray);
	//selectionSort(testArray);
	//bubbleSort(testArray);

	mergeSort(testArray);
	printArray(testArray);

        //int[]a = {-3,5,8,10,78,102};
	//int[]b = {-2,5,9,30,56,99,180,205,999};
	//printArray(merge(a,b));
	
    }
    
}
