import java.util.*;

public class MyLinkedList<T> implements Iterable<T> {

    private class LNode {
	T data;
	LNode next;
	LNode previous;
	
	public LNode() {}
	public LNode(T v) {data = v;}

	public LNode getNext() {return next;}
	public LNode getPrevious() {return previous;}
	public T getValue() {return data;}
	public void setValue(T value) {data = value;}
	public void setNext(LNode l) {next = l;}
	public void setPrevious(LNode l) {previous = l;}
    }


    public Iterator<T>iterator() {
	return new LLIterator();
    }

    public class LLIterator implements Iterator<T> {
	private LNode current;

	public LLIterator() {
	}
	
	public boolean hasNext() {
	    if (current == null) {
		return true;
	    }
	    return current.getNext() != null;
	}

	public T next() {
	    if (!hasNext()) {
		throw new NoSuchElementException();
	    }
	    if (current == null) {
		current = start;
	    }
	    else {
		current = current.getNext();		
	    }
	    return current.getValue();
	}

	public void remove() {
	    throw new UnsupportedOperationException();
	}
    }

    private LNode start;
    private int size;
    private LNode end;

    public MyLinkedList() {
	size = 0;
    }

    public boolean add(T value) {

	if (size == 0) {
	    start = new LNode(value);
	    end = start;
	}
	else {
	    end.setNext(new LNode(value));
	    end.getNext().setPrevious(end);
	    end = end.getNext();
	}
	size++;
	return true;
    }

    public boolean add(int index, T value) {
	
	if (index > size || index < 0) {
	    throw new IndexOutOfBoundsException();
	}
	else if (index == 0) {
	    LNode tmp = start;
	    start = new LNode(value);
	    tmp.setPrevious(start);
	    start.setNext(tmp);
	    size++;
	}
	else if (index == size) {
	    add(value);
	}
	else {
	    LNode current = start;
	    //move until the index before you want to add to
	    for (int i = 0; i < index-1; i++) {
		current = current.getNext();
	    }
	    LNode tmp = current.getNext();
	    current.setNext(new LNode(value));
	    tmp.setPrevious(current.getNext());
	    current.getNext().setPrevious(current);
	    current.getNext().setNext(tmp);
	    size++;
	}
	return true;
    }
    
    public T get(int index) {
	if (index >= size || index < 0) {
	    throw new IndexOutOfBoundsException();
	}
	LNode current = start;
	for (int i = 0; i < size; i++) {
	    if (i == index) {
		return current.getValue();
	    }
	    else {
		current = current.getNext();
	    }
	}
	return null;
    }

    public int size() {
	return size;
    }


    public T set(int index, T newValue) {
	if (index >= size || index < 0) {
	    throw new IndexOutOfBoundsException();
	}
	LNode current = start;
	for (int i = 0; i < index; i++) {
	    current = current.getNext();
	}
	T oldValue = current.getValue();
	current.setValue(newValue);
	return oldValue;
    }
    
    public T remove(int index) {
	if (index >= size || index < 0 ) {
	    throw new IndexOutOfBoundsException();
	}
	else if (index == 0) {
	    T removed = start.getValue();
	    start = start.getNext();
	    size--;
	    if (size > 0) {
		start.setPrevious(null);
	    }
	    return removed;
	}
	else if (index == size-1) {
	    T removed = end.getValue();
	    end = end.getPrevious();
	    size--;
	    return removed;
	}
	else {
	    
	    LNode current = start;
	    int h;
	    T removed = current.getValue();
	    //move until before to remove elemnt
	    for (h = 0; h < index-1; h++) {
		current = current.getNext();
	    }
	    removed = current.getNext().getValue();

	    current.setNext(current.getNext().getNext());
	    current.getNext().setPrevious(current);
	    size--;
	    return removed;
	}
    }

    public int indexOf(T value) {
	LNode current = start;
	for (int i = 0; i < size; i++) {
	    if (current.getValue().equals(value)) {
		return i;
	    }
	    else {
		current = current.getNext();
	    }
	}
	return -1;
    }
    
    public String toString() {
	String s = "[";
	LNode current = start;
	while (current != null) {
	    if (current.getNext() == null) {
		s += current.getValue();
	    }
	    else {
		s += (current.getValue()+",");
	    }
	    current = current.getNext();
	}
	s += "]";
	return s;
    }

    public String toString(boolean t) {
	if (t) {
	    String s = "Head: " + start.getValue();
	    LNode current = start;
	    while (current.getNext() != null) {
		current = current.getNext();
	    }
	    s += "\tTail: " + current.getValue();
	    return s;
	}
	return "";
    }


}
