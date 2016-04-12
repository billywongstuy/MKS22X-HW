import java.util.*;

public class FrontierQueue<T> implements Frontier<T>{
    /***Make This Work This Weekend!***/
    /***You can use your classes or built in ones***/
    /***You can extend another class OR wrap around it***/

    private Queue<T> queue;

    public FrontierQueue() {
	queue = new LinkedList<>();
    }

    public void add(T element) {
	queue.add(element);
    }

    public T next() {
        if (hasNext()) {
	    return queue.peek();
	}
	else {
	    return null;
	}
    }

    public boolean hasNext() {
        try {
	    queue.peek();
	    return true;
	}
	catch (NoSuchElementException e) {
	    return false;
	}
    }


    public T remove() {
	return queue.remove();
    }
    
}
