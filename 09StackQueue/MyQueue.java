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


    public class TQueue<T> implements Queue<T> {

    }

    public static void main(String[]args) {
	Random rand = new Random();
	TQueue<Integer>stack = new TQueue<>();
	MyQueue<Integer>mystack = new MyQueue<>();
	int sizey = rand.nextInt(20);
	for (int i = 0; i < sizey; i++) {
	    int r = rand.nextInt(100);
	    stack.queue(r);
	    mystack.queue(r);
	}
        for (int i = 0; i < stack.size(); i++) {
	    System.out.print(stack.dequeue()+" ");
	    i--;
	}
	System.out.println();
	for (int i = 0; i < mystack.size(); i++) {
	    System.out.print(mystack.dequeue()+" ");
	    i--;
	}
	System.out.println();
    }


}
