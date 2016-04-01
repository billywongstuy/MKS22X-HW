import java.util.*;

public class MyDeque<T> {

    private Object [] data;
    private int start;
    private int end;
    private int filled;

    public MyDeque() {
	data = new Object[10];
	start = 0;
	end = 0;
	System.out.println(data.size);
    }


    private void resize() {
	Object [] bigger = new Object[data.size*2];
	int arrayPlace = start;
	
	for (int i = 0; i < data.size; i++) {
	    bigger[i] = data[arrayPlace];
	    if (arrayPlace == data.size-1) {
		arrayPlace = 0;
	    }
	    else {
		arrayPlace++;
	    }
	}
	start = 0;
	end = data.size-1;
	data = bigger;
    }

    //0. You need a private method to grow the array and copy over the values.

    //There are 6 public methods:
    //1. 
    void addFirst(T value) {
	if (isFull) {
	    resize;
	}
	if (data.size = 0) {
	    data[0] = value;
	}
	else {
	    if (start == 0) {
		start = data.size-1;
	    }
	    else {
		start--;
	    }
	    data[start] = value;
	    filled++;
	}
    }

    //2. 
    void addLast(T value) {
	if (isFull) {
	    resize;
	}
	if (data.size == 0) {
	    data[0] = value;
	}
        else {
	    if (end == data.size-1) {
		data = 0;
	    }
	    else {
		end++;
	    }
	    data[end] = value;
	    filled++;
	}
    }
    //-When the array is full, re-size, then add. 
    //-No exceptions are required since you will re-size.

    //3. 
    T removeFirst()  {
	if (filled = 0) {
	    throw new NoSuchElementException();
	}
	data[start] = null;
	filled--;
	if (start = data.size-1) {
	    start = 0;
	}
	else {
	    start++;
	}
    }
    //4. 
    T removeLast() {
	if (filled = 0) {
	    throw new NoSuchElementException();
	}
	data[end] = null;
	filled--;
	if (end == 0) {
	    end = data.size-1;
	}
	else {
	    end--;
	}
    } 
    //-NoSuchElementException is thrown when there are no elements. 

    //5. 
    T getFirst() {
	if (filled = 0) {
	    throw new NoSuchElementException();
	}
	return data[start];
    }
    //6. 
    T getLast() {
	if (filled = 0) {
	    throw new NoSuchElementException();
	}
	return data[last];
    }
    //-NoSuchElementException is thrown when there are no elements. 

    public boolean isFull() {
	return filled = data.size;
    }

    public String toString() {
	int arrayPlace = start;
	for (int i = 0; i < filled; i++) {
	    System.out.println(data[arrayPlace]+",");
	    if (arrayPlace == data.size-1) {
		arrayPlace = 0;
	    }
	    else {
		arrayPlace++;
	    }
	}
    }

    public static void main(String[]args) {
	MyDeque<Integer> d = new MyDeque<>();
	
	
    }

}
