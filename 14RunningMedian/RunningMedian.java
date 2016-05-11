import java.util.*;
public class RunningMedian {

    private MyHeap<Integer>min;
    private MyHeap<Integer>max;
    
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
	else if ((min.size()+max.size()%2 == 0)) {
	    return (min.peek()+max.peek())/2;
	}
	else {
	    if (min.size() > max.size()) {
		return min.peek();
	    }
	    return max.peek();
	}
    }

    public void add(int x) {
        if (min.size() == 0 && max.size() == 0) {
	    min.add(x);
	}
	else if (x < getMedian()) {
	    min.add(x);
	}
	else {
	    max.add(x);
	}
	if (max.size() - min.size() >= 2) {
	    min.add(max.delete());
	}
	if (min.size()-max.size() >= 2) {
	    max.add(min.delete());
	}
	    
    }

    
}
