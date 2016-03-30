import java.util.*;

public class MyQueue<T> {
    /**
     * Adds the given item to the rear of the queue.
     */

    private MyLinkedList<T> queue;
    
    public MyQueue() {
	queue = new MyLinkedList<T>();
    }

    /**
     * Adds the given item to the rear of the queue.
     */
    void enqueue(T item) {
	queue.add(item);
    }

    /**
     * Removes the front item from the queue and returns it.
     * @exception java.util.NoSuchElementException if the queue is empty.
     */
    T dequeue() {
	if (isEmpty()) {
	    throw new NoSuchElementException();
	}
	T tmp = queue.get(0);
	queue.remove(0);
	return tmp;
    }

    /**
     * Returns the front item from the queue without popping it.
     * @exception java.util.NoSuchElementException if the queue is empty.
     */
    T peek() {
	if (isEmpty()) {
	    throw new NoSuchElementException();
	}
	return queue.get(0);
    }

    /**
     * Returns the number of items currently in the queue.
     */
    int size() {
	return queue.size;
    }

    /**
     * Returns whether the queue is empty or not.
     */
    boolean isEmpty() {
	return size() == 0;
    }



    public static void main(String[]args) {
	Random rand = new Random();
        Queue<Integer> queue = new LinkedList<Integer>();
	MyQueue<Integer>myqueue= new MyQueue<>();
	int sizey = rand.nextInt(20);
	for (int i = 0; i < sizey; i++) {
	    int r = rand.nextInt(100);
	    myqueue.enqueue(r);
	    queue.add(r);
	}

		for (int i = 0; i < 4000; i++) {
	    int t = rand.nextInt(2);
	    if (queue.size() == 0) {
		queue.add(i);
		myqueue.enqueue(i);
	    }
	    else if (t == 0) {
		int s = queue.remove();
		int m = myqueue.dequeue();
		if (s != m) {
		    System.out.println("Non-matching elements removed " + s + " " + m);
		    System.exit(i);
		}
	    }
	    else if (t == 1) {
		queue.add(i);
		myqueue.enqueue(i);
	    }
	}
    }


}
