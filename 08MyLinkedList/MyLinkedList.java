public class MyLinkedList<T> {

    private class LNode {
	T data;
	LNode next;	
	
	public LNode() {}
	public LNode(T v) {data = v;}

	public LNode getNext() {return next;}
	public T getValue() {return data;}
	public void setValue(T value) {data = value;}
	public void setNext(LNode l) {next = l;}
    }

    LNode start;
    int size;
    LNode end;

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
	    LNode current = start;
	    start = new LNode(value);
	    start.setNext(current);
	    size++;
	}
	else if (index == size) {
	    add(value);
	}
	else {
	    LNode current = start;
	    for (int i = 0; i < index-1; i++) {
		current = current.getNext();
	    }
	    LNode tmp = current.getNext();
	    current.setNext(new LNode(value));
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
	    return removed;
	}
	else {
	    
	    LNode current = start;
	    int h;
	    T removed = current.getValue();
	    for (h = 0; h < index-1; h++) {
		current = current.getNext();
	    }
	    if (index == size-1) {
		end = current;
	    }
	    removed = current.getNext().getValue();

	    current.setNext(current.getNext().getNext());
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

    public static void main(String [] args) {	
        MyLinkedList<Integer>l = new MyLinkedList<Integer>();
	l.add(4);
        l.add(8);
	l.add(9);
	l.add(7);
	l.add(12);
	System.out.println(l);
	//System.out.println(l.indexOf(9));
	System.out.println("element at 3 is: " + l.get(3));
	//System.out.println(l.set(2,99));
	l.set(2,99);
	//System.out.println(l);
	l.add(3,23);
	System.out.println(l);
	System.out.println("Removed: " + l.remove(4));
	System.out.println(l);
	//l.add(20);
	//System.out.println(l);
	MyLinkedList<String> z = new MyLinkedList<String>();
	z.add(new String("a"));
	z.add(new String("b"));
	z.add(new String("c"));
	System.out.println(z);
    }

}
