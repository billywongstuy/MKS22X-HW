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
	heapify();
	isMax = true;
    }
    
    public MyHeap(boolean m) {
	data = (T[])new Comparable[2];
	isMax = m;
    }


    private void heapify() {
	
    }

    private void doubleSize() {
	T[]temp = (T[])new Comparable[data.length*2];
	for (int i = 1; i <= size; i++) {
	    temp[i] = data[i];
	}
	data = temp;
    }
    
    

    public void add(T value) {
	if (size+1 >= data.length) {
	    doubleSize();
	}
	data[size+1] = value;
	size++;
	int p = size;
	while (p > 1 && compare(data[p].compareTo(data[p/2]))) {
	    pushup(p);
	    p = p/2;
	}
 	//while p is supposed to be above parent && it has parent
	//pushup
    }


    public T delete(T value) {
	T store = data[1];
        data[1] = data[findSmallestIndex()];
	int p = 1;
	while (p <= size/2 && (compare(data[p].compareTo(data[p*2])) || compare(data[p].compareTo(data[p*2])))) {
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
	for (int i = 0; i <= size; i++) {
	    if (compare(data[i].compareTo(data[min]))) {
		min = i;
	    }
	}
	return min;
    }

    private void pushup(int i) {
	T store = data[i/2];
	data[i/2] = data[i];
	data[i] = store;
    }

    private void pushDown(int i) {
	T store = data[i];
	if (compare(data[i*2+1].compareTo(data[i*2]))) {
	    data[i] = data[i*2];
	    data[i*2] = store;
	}
	else {
	    data[i] = data[i*2+1];
	    data[i*2+1] = store;
	    
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
	MyHeap<Integer> a = new MyHeap<>();
	a.add(56);
	System.out.println(a);
	System.out.println(a.compare(new Integer(1).compareTo(new Integer(2))));
    }
}
