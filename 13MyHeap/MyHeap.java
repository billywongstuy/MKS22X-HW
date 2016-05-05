import java.util.*;

public class MyHeap<T extends Comparable<T>> {

    private T [] data;
    private boolean isMax;
    private int size = 0;

    @SuppressWarnings("unchecked")
    public MyHeap() {
	data = (T[])new Object[2];
	isMax = true;
    }

    @SuppressWarnings("unchecked")
    public MyHeap(boolean m) {
	data = (T[])new Object[2];
	isMax = m;
    }


    @SuppressWarnings("unchecked")
    private void resize() {
	T[]temp = (T[])new Object[data.length*2];
	for (int i = 1; i <= size; i++) {
	    temp[i] = data[i];
	}
	data = temp;
    }
    
    

    public void add(T value) {
	if (size+1 >= data.length) {
	    resize();
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


    public T remove(T value) {
	T store = data[1];
        data[1] = data[findSmallestIndex()];
	int p = 1;
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


    private void pushdownLeft(int i) {
	T store = data[i*2];
	data[i*2] = data[i];
	data[i] = store;
    }

    private void pushDownRight(int i) {
	T store = data[i*2+1];
	data[i*2+1] = data[i];
	data[i] = store;
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
    }
}
