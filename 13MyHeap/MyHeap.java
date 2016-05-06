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
	heapify();
	isMax = true;
    }
    
    public MyHeap(boolean isMax) {
	data = (T[])new Comparable[2];
	this.isMax = isMax;
    }


    public MyHeap(T[] array, boolean isMax) {
	data = array;
	this.isMax = isMax;
    } 
    
    private void heapify() {
	T [] temp = (T[])new Comparable[data.length*2+1];
	int start = size/2-1;	
	for (int i = start; i > 1; i--) {
	    //System.out.println(i);
	    if (compare(data[i].compareTo(data[i/2]))) {
		pushDown(i);
	    }
	}
	for (int i = 0; i < data.length; i++) {
	    temp[i+1] = data[size-i-1];
	}
	data = temp;
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
	while (p > 1 && compare(data[p/2].compareTo(data[p]))) {
	    pushUp(p);
	    p = p/2;
	}
 	//while p is supposed to be above parent && it has parent
	//pushup
    }


    
    public T delete() {
	T store = data[1];
	int index = size;
	data[1] = data[index];
	int p = 1;
	while (p <= size/2 && (compare(data[p].compareTo(data[p*2])) || compare(data[p].compareTo(data[p*2+1])))) {
	    pushDown(p);
	    if (compare(data[p*2+1].compareTo(data[p*2]))) {
		p = p*2;
	    }
	    else {
		p = p*2+1;
	    }
	}
	//while: data[p] doesn't belong compared to children && it has children
	//if left is greater do pushdownleft
	//then p = p*2
	//if right is greater do pushdownleft
	//then p = p*2+1
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

    private int findSmallestIndex() {
        int min = 1;
	for (int i = 1; i <= size; i++) {
	    if (compare(data[i].compareTo(data[min]))) {
		min = i;
	    }
	}
	return min;
    }

    private void pushUp(int k) {
	T store = data[k/2];
	data[k/2] = data[k];
	data[k] = store;
    }

    private void pushDown(int k) {
	T store = data[k];
	//System.out.println(size);
	if (size >= k*2+1 && compare(data[k*2+1].compareTo(data[k*2]))) {
	    data[k] = data[k*2];
	    data[k*2] = store;
	}
	else {
	    data[k] = data[k*2+1];
	    data[k*2+1] = store;
	    
	}
    }

    public T peek() {
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
	Integer [] r = {7,18,27,35,40,56,87};
	MyHeap<Integer> b = new MyHeap<>(r);
	System.out.println(b);
    }
}
