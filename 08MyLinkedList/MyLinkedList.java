public class MyLinkedList {

    private class LNode {
	int data;
	LNode next;	
	
	public LNode() {}
	public LNode(int v) {data = v;}

	public LNode getNext() {return next;}
	public int getValue() {return data;}
	public void setValue(int value) {data = value;}
	public void setNext(LNode l) {next = l;}
    }

    LNode start;
    int size;

    public MyLinkedList() {
	size = 0;
	start = new LNode();
    }

    public boolean add(int value) {
	LNode current = start;
	while (current.getNext() != null) {
	    if (current.getNext().getNext() == null) {
		current.getNext().setValue(value);
	    }
	    current = current.getNext();
	}
	if (size == 0) {
	    start.setValue(value);
	}
	
	current.setNext(new LNode());
	size++;
	return true;
    }

     public boolean add(int index, int value) {
	if (index >= size) {
	    add(value);
	}
	else {
	    LNode current = start;
	    for (int i = 0; i < index; i++) {
		current = current.getNext();
	    }
	    add(get(size-1));
	    for (int i = size-1; i > index; i--) {
		set(i,get(i-1));
	    }
	    current.setValue(value);
	}
	return true;
    }
    
    public int get(int index) {
	if (index >= size) {
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
	return -1*Integer.MAX_VALUE;
    }

    public int size() {
	return size;
    }


    public int set(int index, int newValue) {
	if (index >= size) {
	    throw new IndexOutOfBoundsException();
	}
	LNode current = start;
	for (int i = 0; i < index; i++) {
	    current = current.getNext();
	}
	int oldValue = current.getValue();
	current.setValue(newValue);
	return oldValue;
    }
    
    //
    public int remove(int index) {
	if (index >= size) {
	    throw new IndexOutOfBoundsException();
	}
	LNode current = start;
	int h;
	for (h = 0; h < index; h++) {
	    current = current.getNext();
	}
	int removed = get(index);
	for (int i = h; i < size-1; i++) {
	    set(i,get(i+1));
	    current = current.getNext();
	}
	current = null;
	size--;
	return removed;
    }

    public int indexOf(int value) {
	LNode current = start;
	for (int i = 0; i < size; i++) {
	    if (current.getValue() == value) {
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
	int n = 0;
	while (n < size) {
	    if (n == size-1) {
		s += current.getValue();
	    }
	    else {
		s += (current.getValue()+",");
	    }
	    current = current.getNext();
	    n++;
	}
	s += "]";
	return s;
    }

    public static void main(String [] args) {
	MyLinkedList l = new MyLinkedList();
	System.out.println(l);
	l.add(4);
	System.out.println(l);
        l.add(8);
	System.out.println(l);
	l.add(9);
	l.add(7);
	l.add(12);
	System.out.println(l);
	System.out.println(l.indexOf(9));
	System.out.println(l.get(3));
	System.out.println(l.set(2,99));
	System.out.println(l);
	l.add(3,23);
	System.out.println(l);
	System.out.println(l.remove(2));
	System.out.println(l);
    }

}
