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
	    return queue.remove();
	}
	else {
	    return null;
	}
    }

    public boolean hasNext() {
	if (queue.isEmpty()) {
	    return false;
	}
	return true;
    }


    public T remove() {
	return queue.remove();
    }
    
}
