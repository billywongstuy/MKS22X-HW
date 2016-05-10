import java.util.*;
public class RunningMedian {

    private MyHeap<Integer>min;
    private MyHeap<Integer>max;
    private int median;
    
    public RunningMedian() {
	//small values are a max heap
	//big values are a min heap
	min = new MyHeap<>();
	max = new MyHeap<>(false);
    }

    public int getMedian() {
	if (min.size() == 0 && max.size() == 0) {
	    throw new NoSuchElementException();
	}
	return median;
    }

    public void add(int n) {
	if (min.size() == 0 && max.size() == 0) {
	    median = n;
	    min.add(n);
	}
	else if (min.size() == 1 && max.size() == 0) {
	    max.add(n);
	    median = (min.peek()+max.peek())/2;
	}
	else {
	    //if size differs by 1 take the top and move it over
	    if ((min.size()+max.size)%2 == 1) {
		m
	    }
	}

    }


    private int properAdd(int n) {
	if (n < median) {
	    min.add(n);
	    return -1;
	}
	else {
	    max.add(n);
	    return 1;
	}	 
    }
    
}
