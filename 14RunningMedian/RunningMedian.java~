public class HeapMedian {

    private MyHeap<Integer>min;
    private MyHeap<Integer>max;
    private int median;
    
    public HeapMedian() {
	min = new MyHeap<>(false);
	max = new MyHeap<>();
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
