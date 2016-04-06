import java.util.*;

public class MyDeque<T> {

    private T [] data;
    private int start;
    private int end;
    private int filled;

    @SuppressWarnings("unchecked")
    public MyDeque() {
        data = (T[]) new Object[10];
	start = 0;
	end = 0;
    }

    @SuppressWarnings("unchecked")
    private void resize() {
	T [] bigger = (T[])new Object[data.length*2];
	int arrayPlace = start;
	
	for (int i = 0; i < data.length; i++) {
	    bigger[i] = data[arrayPlace];
	    if (arrayPlace == data.length-1) {
		arrayPlace = 0;
	    }
	    else {
		arrayPlace++;
	    }
	}
	start = 0;
	end = data.length-1;
	data = bigger;
    }

    //0. You need a private method to grow the array and copy over the values.

    //There are 6 public methods:
    //1. 
    void addFirst(T value) {
	if (isFull()) {
	    resize();
	}
	if (filled == 0) {	    
	    data[0] = value;
	}
	else {
	    if (start == 0) {
		start = data.length-1;
	    }
	    else {
		start--;
	    }
	    data[start] = value;
	}
	filled++;
    }

    //2. 
    void addLast(T value) {
	if (isFull()) {
	    resize();
	}
	if (filled == 0) {
	    data[0] = value;
	}
        else {
	    if (end == data.length-1) {
		end = 0;
	    }
	    else {
		end++;
	    }
	    data[end] = value;
	}
	filled++;
    }
    //-When the array is full, re-length, then add. 
    //-No exceptions are required since you will re-size.

    //3. 
    T removeFirst()  {
	if (filled == 0) {
	    throw new NoSuchElementException();
	}
	T tmp = data[start];
	data[start] = null;
	filled--;
	if (start == data.length-1) {
	    start = 0;
	}
	else {
	    start++;
	}
	return tmp;
    }
    //4. 
    T removeLast() {
	if (filled == 0) {
	    throw new NoSuchElementException();
	}
	T tmp = data[end];
	data[end] = null;
	filled--;
	if (end == 0) {
	    end = data.length-1;
	}
	else {
	    end--;
	}
	return tmp;
    } 
    //-NoSuchElementException is thrown when there are no elements. 

    //5. 
    T getFirst() {
	if (filled == 0) {
	    throw new NoSuchElementException();
	}
	return data[start];
    }
    //6. 
    T getLast() {
	if (filled == 0) {
	    throw new NoSuchElementException();
	}
	return data[end];
    }
    //-NoSuchElementException is thrown when there are no elements. 

    public boolean isFull() {
	return filled == data.length;
    }

    public String toString() {
	int arrayPlace = start;
	String s = "";
	for (int i = 0; i < filled; i++) {
	    //System.out.print(data[arrayPlace] + "(" + arrayPlace + ") ");
	    if (i == filled-1) {
		s += data[arrayPlace];
	    }
	    else {
		s += (data[arrayPlace]+",");
	    }
	    if (arrayPlace == data.length-1) {
		arrayPlace = 0;
	    }
	    else {
		arrayPlace++;
	    }
	}
	System.out.println();
	return s;
    }

    public int size() {
	return filled;
    }

    public static void main(String[]args) {
	MyDeque<Integer> d = new MyDeque<>();
	d.addFirst(3);  //3
	d.addFirst(4);  //4,3
	System.out.println(d.getFirst());
	d.addLast(1);   //4,3,1
	System.out.println(d.getLast());
	d.addLast(6);  //4,3,1,6
	System.out.println(d.getLast());
	d.addFirst(9);  //9,4,3,1,6
	d.addLast(54);  //9,4,3,1,6,54
	d.addLast(5);  //9,4,3,1,6,54,5
	d.addLast(10);  //9,4,3,1,6,54,5,10
	d.addLast(44);  //9,4,3,1,6,54,5,10,44
	d.addLast(34);  //9,4,3,1,6,54,5,10,44,34
	d.addFirst(90);  //90,9,4,3,1,6,54,5,10,44,34
	d.removeLast();  //90,9,4,3,1,6,54,5,10,44
	d.removeFirst();  //9,4,3,1,6,54,5,10,44
	
	//d.addLast(58);  //9,4,3,1,6,54,5,10,44,34,58
	System.out.println(d);
	
    }

}
