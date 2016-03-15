public class MyLinkedList {

    public class LNode {
	int data;
	LNode next;	

	public LNode() {

	}

	public LNode getNext() {
	    return next;
	}

	public int getValue() {
	    System.out.println("V: " + data);
	    return data;
	}
	
	public void setValue(int value) {
	    data = value;
	}


    }


    LNode start;
    int size;

    public MyLinkedList() {
	size = 0;
	start = new LNode();
    }

    public boolean add(int value) {
	LNode current = start;
	System.out.println("First current: " + current);

	//how do i reassign the value right before it moves to the next inner Lnode
	while (current != null) {
	    current = current.getNext();
	}
	//System.out.println("FFFF");
	System.out.println("Current now: " + current);
	current = new LNode();
	System.out.println("Rewriten current: " + current);
	current.setValue(value);
	//System.out.println("Value curr: " + current.getValue());
	size++;
	return true;
    }

    public int get(int index) {
	return 0;
    }


    public String toString() {
	String s = "[";
	LNode current = start;
	System.out.println("Value c: " + current.getValue());
	while (current != null) {
	    s += (current.getValue()+",");
	    current = current.getNext();
	}
	s += "]";
	return s;
    }

    public static void main(String [] args) {
	MyLinkedList l = new MyLinkedList();
	System.out.println(l);
	l.add(4);
	System.out.println(l);
	System.out.println(l);
    }

}
