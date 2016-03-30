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

    public String toString() {
	return queue.toString();
    }

    public static void main(String[]args) {
	Random rand = new Random();
	Stack<Integer>stack = new Stack<>();
	MyStack<Integer>mystack = new MyStack<>();
	int sizey = rand.nextInt(20);
	for (int i = 0; i < sizey; i++) {
	    int r = rand.nextInt(100);
	    stack.push(r);
	    mystack.push(r);
	}
        for (int i = 0; i < stack.size(); i++) {
	    System.out.print(stack.pop()+" ");
	    i--;
	}
	System.out.println();
	for (int i = 0; i < mystack.size(); i++) {
	    System.out.print(mystack.pop()+" ");
	    i--;
	}
	System.out.println();
    }

}
