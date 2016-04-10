import java.util.*;

public class FrontierStack<T> implements Frontier<T>{
    /***Make This Work This Weekend!***/
    /***You can use your classes or built in ones***/
    /***You can extend another class OR wrap around it***/

    private Stack<T> stack;

    public FrontierStack() {
	stack = new Stack<>();
    }

    public void add(T element) {
	stack.add(element);
    }

    public T next() {
	return stack.peek();
    }

    public boolean hasNext() {
        try {
	    stack.peek();
	    return true;
	}
	catch (NoSuchElementException e) {
	    return false;
	}
    }

}
