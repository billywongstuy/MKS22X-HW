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
	size = array.length;
	isMax = true;
	heapify();	
    }
    
    public MyHeap(boolean isMax) {
	data = (T[])new Comparable[2];
	this.isMax = isMax;
    }


    public MyHeap(T[] array, boolean isMax) {
	data = array;
	size = array.length;
	this.isMax = isMax;
	heapify();
    }


    //compare
    //if isMax returns if first is less than second
    
    private void heapify() {
	T [] temp = (T[])new Comparable[data.length*2+1];
	int start = size/2;
	for (int i = 0; i < data.length; i++) {
	    temp[i+1] = data[i];
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
	    T store = data[k/2];
	    data[k/2] = data[k];
	    data[k] = store;
	    k = k/2;
	}
    }

    private void pushDown(int k) {
	T store = data[k];
        while (k <= size/2 && (compare(data[k].compareTo(data[k*2])) || compare(data[k].compareTo(data[k*2+1])))) {
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
	//MyHeap<Integer> a = new MyHeap<>();
	MyHeap<Integer> a = new MyHeap<>(false);
	a.add(56);
	System.out.println(a);
	a.add(40);
	a.add(35);
	a.add(87);
	a.add(7);
	a.add(27);
	a.add(18);
	System.out.println(a);
	a.delete();
	System.out.println(a);
	//Integer [] r = {7,18,27,35,40,56,87};
	Integer [] r= {10,15,9,2000,2,6,7,5000,60,3,15,100,20,3,1};
	MyHeap<Integer> b = new MyHeap<>(r);
	System.out.println(b);
    }
}
