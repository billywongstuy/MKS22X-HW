import java.util.*;

public class MyStack<T> {

    
    private MyLinkedList<T> queue;


    public MyStack() {
        queue = new MyLinkedList<T>();
    }
    
    /**
     * Adds the given item to the top of the stack.
     */
    void push(T item) {
	queue.add(0,item);
    }

    /**
     * Removes the top item from the stack and returns it.
     * @exception java.util.NoSuchElementException if the queue is empty.
     */
    T pop() {
	if (isEmpty()) {
	    throw new NoSuchElementException();
	}
	T tmp = queue.get(0);
	queue.remove(0);
	return tmp;
    }

    /**
     * Returns the top item from the stack without popping it.
     * @exception java.util.NoSuchElementException if the queue is empty.
     */
    T peek() {
	if (isEmpty()) {
	    throw new NoSuchElementException();
	}
	return queue.get(0);
    }

    /**
     * Returns the number of items currently in the stack.
     */
    int size() {
	return queue.size;
    }

    /**
     * Returns whether the stack is empty or not.
     */
    boolean isEmpty() {
	return size() == 0;
    }
}
