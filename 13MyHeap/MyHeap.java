import java.util.*;

@SuppressWarnings("unchecked")
public class MyHeap<T extends Comparable<T>> {

    private T [] data;
    private boolean isMax;
    private int size = 0;
   
    public MyHeap() {
	data = (T[])new Comparable[2];
	isMax = true;
    }


    public MyHeap(T [] array) {
	data = array;
	size = array.length-1;
	isMax = true;
	heapify();	
    }
    
    public MyHeap(boolean isMax) {
	data = (T[])new Comparable[2];
	this.isMax = isMax;
    }


    public MyHeap(T[] array, boolean isMax) {
	data = array;
	size = array.length-1;
	this.isMax = isMax;
	heapify();
    }


    //compare
    //if isMax returns if first is less than second
    
    private void heapify() {
	T [] temp = (T[])new Comparable[data.length*2+1];
	int start = size/2;
	for (int i = 1; i < data.length; i++) {
	    temp[i] = data[i];
	}	
	data = temp;
	for (int i = start; i >= 1; i--) {
	    if (compare(data[i].compareTo(data[i*2])) || compare(data[i].compareTo(data[i*2+1]))) {
		pushDown(i);
	    }
	}
	//for (int i = size; i > 1; i--) {
	//   if (compare(data[i/2].compareTo(data[i]))) {
	//	pushUp(i);
	//    }
	//}
	
    }

    private void doubleSize() {
	T[]temp = (T[])new Comparable[data.length*2];
	for (int i = 1; i <= size; i++) {
	    temp[i] = data[i];
	}
	data = temp;
    }
    
    

    public void add(T x) {
	if (size+1 >= data.length) {
	    doubleSize();
	}
	data[size+1] = x;
	size++;
	int p = size;
	pushUp(p);
    }


    
    public T delete() {
	if (size == 0) {
	    throw new NoSuchElementException();
	}
	T store = data[1];
	int index = size;
	data[1] = data[index];
	int p = 1;
	pushDown(p);
	//System.out.println("afb: " + Arrays.toString(data));
	for (int i = index+1; i <= size; i++) {
	    data[i-1] = data[i];
	}
	size--;
	return store;
    }


    private boolean compare(int n) {
	if (isMax) {
	    return n < 0;
	}
	return n > 0;
    }


    private void pushUp(int k) {
	while (k > 1 && compare(data[k/2].compareTo(data[k]))) {
	    //System.out.println("s: " + Arrays.toString(data));
	    T store = data[k/2];
	    data[k/2] = data[k];
	    data[k] = store;
	    k = k/2;
	}
    }

    
    //what if size = 6 and k = 3
    private void pushDown(int k) {
	T store = data[k];
        while (k <= size/2 && (compare(data[k].compareTo(data[k*2])) || (k <= size/2-1 && compare(data[k].compareTo(data[k*2+1]))))) {
	    //System.out.println("l: " + Arrays.toString(data));
	    if (size >= k*2+1) {
		if (compare(data[k*2].compareTo(data[k*2+1]))) {
		    data[k] = data[k*2+1];
		    data[k*2+1] = store;
		    k = k*2+1;
		}
		else {
		    data[k] = data[k*2];
		    data[k*2] = store;
		    k = k*2;
		}
	    }
	    else {
		data[k] = data[k*2];
		data[k*2] = store;
		k = k*2;
	    }
	    

	    /*
	    if (size >= k*2+1 && compare(data[k*2+1].compareTo(data[k*2]))) {
		data[k] = data[k*2];
		data[k*2] = store;
		k = k*2;
	    }
	    else {
		data[k] = data[k*2+1];
		data[k*2+1] = store;
		k = k*2+1;
	    }
	    */
	}
    
    }

    public T peek() {
	if (size == 0) {
	    throw new NoSuchElementException();
	}
	return data[1];
    }
    
    public int size() {
	return size;
    }


    public String toString() {
        String s = "[";
	for (int i = 1; i <= size; i++) {
	    if (i == size) {
		s += data[i];
	    }
	    else {
		s += (data[i] + ", ");
	    }
	}
	s += "]";
	return s;
    }



    public static void main(String[]args) {
      
	MyHeap<Integer> a = new MyHeap<>(false);
	int [] a_vals = {56,40,35,87,7,27,18};
	int ai = a_vals.length;
	for (int i = 0; i < ai; i++) {
	    a.add(a_vals[i]);
	    System.out.println(a);
	}

	for (int i = 0; i < ai; i++) {
	    a.delete();
	    System.out.println(a);
	}
	

	MyHeap<Integer> b = new MyHeap<>(r);
	Integer [] r= {null,10,15,9,2000,2,6,7,5000,60,3,15,100,20,3,1};
	System.out.println(b);
	int s = b.size();
	for (int i = 0; i < s; i++) {
	    b.delete();
	    System.out.println(b);
	}
    }
}


/*
smallest heap


SWAP IF LOWER INDEX IS GREATER
[null,null]
[null,56]
[null,56,40] (compare 1 and 2)--> [null,40,56]  
[null,40,56,35] (compare 1 and 3)--> [null,35,56,40]
[null,35,56,40,87] (compare 2 and 4)
[null,35,56,40,87,7] (compare 2 and 5)--> [null,35,7,40,87,56] (compare 1 and 2) --> [null,7,35,40,87,56]
[null,7,35,40,87,56,27] (compare 3 and 6)--> [null,7,35,27,87,56,40] (compare 1 and 3)
[null,7,35,27,87,56,40,18] (compare 3 and 7)--> [null,7,35,18,87,56,40,27]


//SWAP IF LOWER INDEX IS GREATER
//delete loops until condition or k > size/2 (3)
//k starts at 1 
//if k*2+1 >= size, swap k and k*2
//else swap k and k*2+1


[40,80,120,160]
[160,80,120,160]


[80,120,160,160]



[null,7,35,18,87,56,40,27] --> [null,27,35,18,87,56,40,27] 

[null,27,35,18,87,56,40,27] (compare 1 and 2), (compare 1 and 3)--> [null,18,35,27,87,56,40,27] (compare 3 and 6)

[null,18,35,27,87,56,40] 

[null,40,35,27,87,56,40] (compare 1 and 2)--> [null,27,35,40,87,56,40] (compare 3 and 6)

*/
