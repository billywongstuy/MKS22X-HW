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
	if (hasNext()) {
	    return stack.pop();
	}
	else {
	    return null;
	}
    }

    public boolean hasNext() {
        if (stack.isEmpty()) {
	    return false;
	}
	return true;
    }

    public T remove() {
	return stack.pop();
    }

}
